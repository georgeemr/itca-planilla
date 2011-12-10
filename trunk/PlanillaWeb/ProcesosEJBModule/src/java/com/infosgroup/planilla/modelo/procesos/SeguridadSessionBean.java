/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.procesos;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
*
* @author root
*/
//@WebService
@Stateless(name = "SeguridadSessionBean")
@LocalBean
public class SeguridadSessionBean
{
//@WebMethod
public Boolean validarUsuario(/*@WebParam*/String usuario, /*@WebParam*/ String password)
{
//return (usuariosFacade.findByUsuarioPassword(usuario, password) > 0);
return Boolean.TRUE;
}
// Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")
}
