/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.sessionbean;

import com.pos.ejb.SegUsuarioFacade;
import com.pos.entity.SegUsuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Soporte
 */
@ManagedBean(name = "SessionBeanSEG")
@SessionScoped
public class SessionBeanSEG implements Serializable {

    @EJB
    SegUsuarioFacade segUsuarioFacade;
    private SegUsuario usuario;

    /** Creates a new instance of SessionBeanSEG */
    public SessionBeanSEG() {
    }

    public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }
    
    /* Temporal */
    private Integer codCia = 1;

    public Integer getCodCia() {
        return codCia;
    }

    public void setCodCia(Integer codCia) {
        this.codCia = codCia;
    }
}
