/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.modulos.reportes;

import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
*
* @author Vinicio Mercado
*/
@ManagedBean(name = "reportes$detalleIngresos")
@ViewScoped
public class DetalleIngresosBackendBean extends AbstractJSFPage implements Serializable
{

@EJB
private ReportesStatelessBean reportesBean;

@PostConstruct
public void init()
{
anio = Calendar.getInstance().get(Calendar.YEAR);
}
private Integer anio;

public Integer getAnio()
{
return anio;
}

public void setAnio(Integer anio)
{
this.anio = anio;
}

public String mostrarReporte$action()
{
HashMap<String, Object> parametros = new HashMap<String, Object>();
parametros.put("anio", anio.toString());
parametros.put("empresa", "1");
parametros.put("codDpAguinaldo", "6");
reportesBean.generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "repDetPagosEmpleado");
return null;
}

@Override
protected void limpiarCampos()
{
throw new UnsupportedOperationException("Not supported yet.");
}
}
