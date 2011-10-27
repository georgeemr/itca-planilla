/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.facades.UsuarioFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author root
 */
@Stateless(name="SeguridadSessionBean")
@LocalBean
public class SeguridadSessionBean {

    @EJB
    private UsuarioFacade usuariosFacade;

    public Boolean validarUsuario(String usuario, String password) {
        return (usuariosFacade.findByUsuarioPassword(usuario, password) > 0);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
