/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.estructuras.reportes;

import java.util.Date;
import java.util.List;

/**
*
* @author root
*/
public class ReporteEvaluacion
{

private Integer idEmpresa;
private String nombreEmpresa;
private Integer idEmpleado;
private String nombreEmpleado;
private Integer idPuesto;
private String nombrePuesto;
private Date fechaInicio;
private Date FechaFin;
private String calificacionFinal;
private List<DetalleReporteEvaluacion> detalleEvaluacion;

public Date getFechaFin()
{
return FechaFin;
}

public void setFechaFin(Date FechaFin)
{
this.FechaFin = FechaFin;
}

public String getCalificacionFinal()
{
return calificacionFinal;
}

public void setCalificacionFinal(String calificacionFinal)
{
this.calificacionFinal = calificacionFinal;
}

public List<DetalleReporteEvaluacion> getDetalleEvaluacion()
{
return detalleEvaluacion;
}

public void setDetalleEvaluacion(List<DetalleReporteEvaluacion> detalleEvaluacion)
{
this.detalleEvaluacion = detalleEvaluacion;
}

public Date getFechaInicio()
{
return fechaInicio;
}

public void setFechaInicio(Date fechaInicio)
{
this.fechaInicio = fechaInicio;
}

public Integer getIdEmpleado()
{
return idEmpleado;
}

public void setIdEmpleado(Integer idEmpleado)
{
this.idEmpleado = idEmpleado;
}

public Integer getIdEmpresa()
{
return idEmpresa;
}

public void setIdEmpresa(Integer idEmpresa)
{
this.idEmpresa = idEmpresa;
}

public Integer getIdPuesto()
{
return idPuesto;
}

public void setIdPuesto(Integer idPuesto)
{
this.idPuesto = idPuesto;
}

public String getNombreEmpleado()
{
return nombreEmpleado;
}

public void setNombreEmpleado(String nombreEmpleado)
{
this.nombreEmpleado = nombreEmpleado;
}

public String getNombreEmpresa()
{
return nombreEmpresa;
}

public void setNombreEmpresa(String nombreEmpresa)
{
this.nombreEmpresa = nombreEmpresa;
}

public String getNombrePuesto()
{
return nombrePuesto;
}

public void setNombrePuesto(String nombrePuesto)
{
this.nombrePuesto = nombrePuesto;
}
}
