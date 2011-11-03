/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos;

import java.io.FileOutputStream;
import java.util.Hashtable;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author root
 */
@ManagedBean(name = "configuracion")
@ViewScoped
public class ConfiguracionBackendBean {

    /** Creates a new instance of ConfiguracionBackendBean */
    public ConfiguracionBackendBean() {
    }
    // ===========================================================================================
    private String nombreEmpresa;
    private String NITEmpresa;
    private String logotipo;

    public String getNITEmpresa() {
        return NITEmpresa;
    }

    public void setNITEmpresa(String NITEmpresa) {
        this.NITEmpresa = NITEmpresa;
    }

    public String getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(String logotipo) {
        this.logotipo = logotipo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    // ===========================================================================================
    private String urlLDAP;

    public String getDnBaseLDAP() {
        return dnBaseLDAP;
    }

    public void setDnBaseLDAP(String dnBaseLDAP) {
        this.dnBaseLDAP = dnBaseLDAP;
    }

    public Boolean getLdapSeguro() {
        return ldapSeguro;
    }

    public void setLdapSeguro(Boolean ldapSeguro) {
        this.ldapSeguro = ldapSeguro;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPuertoLDAP() {
        return puertoLDAP;
    }

    public void setPuertoLDAP(Integer puertoLDAP) {
        this.puertoLDAP = puertoLDAP;
    }

    public String getUrlLDAP() {
        return urlLDAP;
    }

    public void setUrlLDAP(String urlLDAP) {
        this.urlLDAP = urlLDAP;
    }
    private Integer puertoLDAP;
    private Boolean ldapSeguro;
    private String dnBaseLDAP;
    private String password;
    // ======================================================================================
    private Object tema;
    // ======================================================================================
    
    private Properties opciones;
    

    public Object getTema() {
        return tema;
    }

    public void setTema(Object tema) {
        this.tema = tema;
    }

    // ======================================================================================
    /*public String verificarConfiguracionLDAP() {
        try {
            Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, com.sun.jndi.ldap.LdapCtxFactory.class.getCanonicalName());
            //env.put("java.naming.ldap.factory.socket", "org.opends.server.protocols.internal.InternalLDAPSocketFactory");
            env.put(Context.PROVIDER_URL, "ldap://" + urlLDAP + ":" + puertoLDAP + "/");
            //env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, dnBaseLDAP);
            env.put(Context.SECURITY_CREDENTIALS, password);
            DirContext contexto = new InitialDirContext(env);
            // Do whatever you want with the connection here
            //contexto.bind(null, env);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Configuracion: Autentificacion", "OK"));
        } catch (Exception excpt) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Configuracion: Autentificacion ", "Error: " +  excpt.toString()));
        }
        return null;
    }*/
    
    public String guardarOpciones()
    {
        opciones = new Properties();
        try{
        opciones.storeToXML(new FileOutputStream("opciones.xml"), "Opciones");
        }
        catch(Exception excpt)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Configuracion: Opciones", "Error: " +  excpt.toString()));
        }
        return null;
    }
}
