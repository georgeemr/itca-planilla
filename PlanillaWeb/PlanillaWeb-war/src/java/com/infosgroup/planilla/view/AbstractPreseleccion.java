/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.view;

import com.infosgroup.planilla.modelo.procesos.usuarios.LDAPManager;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

/**
 *
 * @author root
 */
public abstract class AbstractPreseleccion extends AbstractJSFPage implements java.io.Serializable {

    LDAPManager lDAPManager;

    public LDAPManager getLDAPManager() throws NamingException {
        String servidor=FacesContext.getCurrentInstance().getExternalContext().getInitParameter("ConfiguracionLDAP");
        lDAPManager = LDAPManager.getInstance(servidor.split(":")[0] , Integer.valueOf( servidor.split(":")[1] ), servidor.split(":")[2],servidor.split(":")[3]);
        return lDAPManager;
    }
}
