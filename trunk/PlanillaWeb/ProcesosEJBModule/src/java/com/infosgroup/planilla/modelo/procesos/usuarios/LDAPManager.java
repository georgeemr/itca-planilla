/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos.usuarios;


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

/**
 *
 * @author root
 */
public class LDAPManager implements java.io.Serializable {

    private static final Logger logger = Logger.getLogger(LDAPManager.class.getPackage().getName());
    private static final String USERS_OU = "ou=People,dc=infosgroup,dc=com";
    private static final String GROUPS_OU = "ou=Groups,dc=infosgroup,dc=com";
    private static final int DEFAULT_PORT = 389;
    private static Map instances = new HashMap();
    private DirContext context;
    private String hostname;
    private int port;

    protected LDAPManager(String hostname, int port, String username, String password) throws NamingException {
        context = getInitialContext(hostname, port, username, password);
        this.hostname = hostname;
        this.port = port;
    }

    public static LDAPManager getInstance(String hostname, int port, String username, String password) throws NamingException {

        String key = new StringBuffer().append(hostname).append(":").append(port).append("|").append((username == null ? "" : username)).append("|").append((password == null ? "" : password)).toString();

        if (!instances.containsKey(key)) {
            synchronized (LDAPManager.class) {
                if (!instances.containsKey(key)) {
                    LDAPManager instance = new LDAPManager(hostname, port, username, password);
                    instances.put(key, instance);
                    return instance;
                }
            }
        }

        return (LDAPManager) instances.get(key);
    }

    public static LDAPManager getInstance(String hostname, int port) throws NamingException {
        return getInstance(hostname, port, null, null);
    }

    public static LDAPManager getInstance(String hostname) throws NamingException {
        return getInstance(hostname, DEFAULT_PORT, null, null);
    }

    public void addUser(String username, String firstName, String lastName, String password) throws NamingException {

        Attributes container = new BasicAttributes();
        Attribute objClasses = new BasicAttribute("objectClass");
        objClasses.add("top");
        objClasses.add("person");
        objClasses.add("organizationalPerson");
        objClasses.add("inetOrgPerson");

        String cnValue = new StringBuffer(firstName).append(" ").append(lastName).toString();
        Attribute cn = new BasicAttribute("cn", cnValue);
        Attribute givenName = new BasicAttribute("givenName", firstName);
        Attribute sn = new BasicAttribute("sn", lastName);
        Attribute uid = new BasicAttribute("uid", username);

        Attribute userPassword = new BasicAttribute("userpassword", password);

        container.put(objClasses);
        container.put(cn);
        container.put(sn);
        container.put(givenName);
        container.put(uid);
        container.put(userPassword);
        try {
            context.createSubcontext(getUserDN(username), container);
        } catch (javax.naming.NameAlreadyBoundException e) {
            logger.log( Level.SEVERE, "El usuario que intenta crear ya existe.", e);
        }

    }

    public void deleteUser(String username) throws NamingException {
        try {
            context.destroySubcontext(getUserDN(username));
        } catch (NameNotFoundException e) {
            logger.log(Level.SEVERE, "El usuario que intenta eliminar no existe.", e);
        }
    }

    public boolean isValidUser(String username, String password) throws UserNotFoundException {
        try {
            DirContext contextIsValid = getInitialContext(this.hostname, this.port, getUserDN(username), password);
            return true;
        } catch (javax.naming.NameNotFoundException e) {
            throw new UserNotFoundException(username);
        } catch (NamingException e) {
            logger.log(Level.SEVERE, "El usuario no existe.", e);
            return false;
        }
    }

    public void addGroup(String name, String description) throws NamingException {
        Attributes container = new BasicAttributes();
        Attribute objClasses = new BasicAttribute("objectClass");
        objClasses.add("top");
        objClasses.add("groupOfUniqueNames");
        objClasses.add("groupOfForethoughtNames");
        Attribute cn = new BasicAttribute("cn", name);
        Attribute desc = new BasicAttribute("description", description);
        container.put(objClasses);
        container.put(cn);
        container.put(desc);
        context.createSubcontext(getGroupDN(name), container);
    }

    public void deleteGroup(String name) throws NamingException {
        try {
            context.destroySubcontext(getGroupDN(name));
        } catch (NameNotFoundException e) {
            logger.log(Level.SEVERE, "El grupo que intenta eliminar no existe.", e);
        }
    }

    public void assignUser(String username, String groupName) throws NamingException {

        try {
            ModificationItem[] mods = new ModificationItem[1];
            Attribute mod = new BasicAttribute("uniqueMember", getUserDN(username));
            mods[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE, mod);
            context.modifyAttributes(getGroupDN(groupName), mods);
        } catch (AttributeInUseException e) {
            // If user is already added, ignore exception
        }
    }

    public void removeUser(String username, String groupName) throws NamingException {
        try {
            ModificationItem[] mods = new ModificationItem[1];
            Attribute mod = new BasicAttribute("uniqueMember", getUserDN(username));
            mods[0] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, mod);
            context.modifyAttributes(getGroupDN(groupName), mods);
        } catch (NoSuchAttributeException e) {
            // If user is not assigned, ignore the error
        }
    }

    public boolean userInGroup(String username, String groupName) throws NamingException {
        String[] searchAttributes = new String[1];
        searchAttributes[0] = "uniqueMember";

        Attributes attributes = context.getAttributes(getGroupDN(groupName), searchAttributes);
        if (attributes != null) {
            Attribute memberAtts = attributes.get("uniqueMember");
            if (memberAtts != null) {
                for (NamingEnumeration vals = memberAtts.getAll();
                        vals.hasMoreElements();) {
                    if (username.equalsIgnoreCase(getUserUID((String) vals.nextElement()))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public List<String> getMembers(String groupName) throws NamingException {
        List members = new LinkedList();
        String[] searchAttributes = new String[1];
        searchAttributes[0] = "uniqueMember";
        Attributes attributes = context.getAttributes(getGroupDN(groupName), searchAttributes);
        if (attributes != null) {
            Attribute memberAtts = attributes.get("uniqueMember");
            if (memberAtts != null) {
                for (NamingEnumeration vals = memberAtts.getAll(); vals.hasMoreElements(); members.add(getUserUID((String) vals.nextElement())));
            }
        }
        return members;
    }

    public List getGroups(String username) throws NamingException {
        List groups = new LinkedList();
        String filter = new StringBuffer().append("(&").append("(objectClass=groupOfForethoughtNames)").append("(uniqueMember=").append(getUserDN(username)).append(")").append(")").toString();
        SearchControls cons = new SearchControls();
        cons.setSearchScope(SearchControls.ONELEVEL_SCOPE);

        NamingEnumeration results = context.search(GROUPS_OU, filter, cons);

        while (results.hasMore()) {
            SearchResult result = (SearchResult) results.next();
            groups.add(getGroupCN(result.getName()));
        }

        return groups;
    }

    private String getUserDN(String username) {
        return new StringBuffer().append("uid=").append(username).append(",").append(USERS_OU).toString();
    }

    private String getUserUID(String userDN) {
        int start = userDN.indexOf("=");
        int end = userDN.indexOf(",");

        if (end == -1) {
            end = userDN.length();
        }

        return userDN.substring(start + 1, end);
    }

    private String getGroupDN(String name) {
        return new StringBuffer().append("cn=").append(name).append(",").append(GROUPS_OU).toString();
    }

    private String getGroupCN(String groupDN) {
        int start = groupDN.indexOf("=");
        int end = groupDN.indexOf(",");

        if (end == -1) {
            end = groupDN.length();
        }

        return groupDN.substring(start + 1, end);
    }

    private DirContext getInitialContext(String hostname, int port, String username, String password) throws NamingException {

        String providerURL = new StringBuffer("ldap://").append(hostname).append(":").append(port).toString();
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, providerURL);

        if ((username != null) && (!username.equals(""))) {
            props.put(Context.SECURITY_AUTHENTICATION, "simple");
            props.put(Context.SECURITY_PRINCIPAL, username);
            props.put(Context.SECURITY_CREDENTIALS,
                    ((password == null) ? "" : password));
        }

        return new InitialDirContext(props);
    }
}
