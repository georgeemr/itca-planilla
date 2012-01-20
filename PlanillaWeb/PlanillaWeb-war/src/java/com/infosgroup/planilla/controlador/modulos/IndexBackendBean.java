/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos;

import com.infosgroup.planilla.modelo.procesos.SeguridadSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "index")
@ViewScoped
public class IndexBackendBean extends AbstractJSFPage implements Serializable {
    
   
    @EJB
    private SeguridadSessionBean seguridadBean;

    /** Creates a new instance of IndexBackendBean */
    public IndexBackendBean() {
    }
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private String password;

    public String iniciarSesion$action() {
        if (seguridadBean.validarUsuario(usuario, password)) {
            return "/inicio?faces-redirect=true";
        } else {
            mostrarMensaje(FacesMessage.SEVERITY_WARN, "El nombre de usuario o la contraseña no son validos");
            return null;
        }
    }

    @Override
    protected void limpiarCampos() {
    }
}
