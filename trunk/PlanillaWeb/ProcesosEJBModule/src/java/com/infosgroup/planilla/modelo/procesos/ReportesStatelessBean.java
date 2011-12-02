/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author root
 */
@Stateless(name = "ReportesStatelessBean")
@LocalBean
public class ReportesStatelessBean
{

public void generarReporte(FacesContext facesContext, HashMap<String, Object> parametros, String nombreReporte)
{
    //facesContext.getExternalContext()
}

}
