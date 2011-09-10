/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "index")
@ViewScoped
public class IndexBackendBean implements Serializable {

    /** Creates a new instance of IndexBackendBean */
    public IndexBackendBean() {
    }
    
   
    public String iniciarSesion_action()
    {
        return "/inicio?faces-redirect=true";
    }
    
}
