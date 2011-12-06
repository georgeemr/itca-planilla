/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.facades.UsuarioFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author root
 */

@WebService
@Stateless(name="SeguridadSessionBean")
@LocalBean
public class SeguridadSessionBean {

    @EJB
    private UsuarioFacade usuariosFacade;

    @WebMethod
    public Boolean validarUsuario(@WebParam String usuario, @WebParam String password) {
        return (usuariosFacade.findByUsuarioPassword(usuario, password) > 0);
    }

}
