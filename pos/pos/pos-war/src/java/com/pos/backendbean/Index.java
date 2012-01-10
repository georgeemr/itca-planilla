/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.backendbean;

import com.pos.ejb.SegUsuarioFacade;
import com.pos.entity.SegUsuario;
import com.pos.sessionbean.SessionBeanSEG;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Soporte
 */
@ManagedBean(name = "index")
@RequestScoped
public class Index extends JSFUtil implements Serializable {

    @NotNull(message = "Ingrese el usuario")
    private String usuario;
    @NotNull(message = "Ingrese el password")
    private String password;
    @EJB
    private SegUsuarioFacade segUsuarioFacade;

    public Index() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String validaUsuario() {
        SegUsuario u = new SegUsuario();
        u = segUsuarioFacade.validaUsuario(usuario, password);

        if (u != null) {
            getSessionBeanSEG().setUsuario(u);
            return "/consulta/venta.xhtml";
            /*return "/consulta/venta?faces-redirect=true";*/
        } else {
            getSesion().invalidate();
            return null;
        }
    }

    protected SessionBeanSEG getSessionBeanSEG() {
        return (SessionBeanSEG) getBean("SessionBeanSEG");
    }
}
