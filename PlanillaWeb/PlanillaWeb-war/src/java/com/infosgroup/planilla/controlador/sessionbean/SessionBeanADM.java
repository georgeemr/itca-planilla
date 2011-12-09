/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.facades.CompaniaFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "SessionBeanADM")
@SessionScoped
public class SessionBeanADM implements Serializable {

    @EJB
    private CompaniaFacade companiaFacade;
    private Integer estadoAccion;
    
    /** Creates a new instance of SessionBeanADM */
    public SessionBeanADM() {
    }

    public Compania getCompania() {
        return companiaFacade.find(1L);
    }

    public Integer getEstadoAccion() {
        return estadoAccion;
    }
    /**
     * 
     * @param estadoAccion 
     *  0 - crear
     *  1 - editar
     *  2 - consultar
     */
    public void setEstadoAccion(Integer estadoAccion) {
        this.estadoAccion = estadoAccion;
    }
}
