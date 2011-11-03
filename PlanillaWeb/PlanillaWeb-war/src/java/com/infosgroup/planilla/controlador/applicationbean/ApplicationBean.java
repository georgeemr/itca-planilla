/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.applicationbean;

/*import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;*/
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */

@Named(value="ApplicationBean")
@ApplicationScoped

/*@ManagedBean(name="ApplicationBean", eager=true)
@ApplicationScoped*/
public class ApplicationBean {

    /** Creates a new instance of ApplicationBean */
    public ApplicationBean() {
    }
    
    
    
}
