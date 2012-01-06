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
private String nombreTipoEvaluacion;
private Integer idEmpleado;
private String nombreEmpleado;
private Integer idPuesto;
private String nombrePuesto;
private Date fechaInicioCampania;
private Date FechaFinCampania;
private Integer idDepartamento;
private String nombreDepartamento;
private Integer idFactor;
private String idPregunta;
private String pregunta;
private String respuesta;
private String calificacionFinal;
private List<DetalleReporteEvaluacion> detalleEvaluacion;

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

public String getNombreTipoEvaluacion()
{
return nombreTipoEvaluacion;
}

public void setNombreTipoEvaluacion(String nombreTipoEvaluacion)
{
this.nombreTipoEvaluacion = nombreTipoEvaluacion;
}

public Date getFechaFinCampania()
{
return FechaFinCampania;
}

public void setFechaFinCampania(Date FechaFinCampania)
{
this.FechaFinCampania = FechaFinCampania;
}

public Date getFechaInicioCampania()
{
return fechaInicioCampania;
}

public void setFechaInicioCampania(Date fechaInicioCampania)
{
this.fechaInicioCampania = fechaInicioCampania;
}

public Integer getIdDepartamento()
{
return idDepartamento;
}

public void setIdDepartamento(Integer idDepartamento)
{
this.idDepartamento = idDepartamento;
}

public String getNombreDepartamento()
{
return nombreDepartamento;
}

public void setNombreDepartamento(String nombreDepartamento)
{
this.nombreDepartamento = nombreDepartamento;
}

public Integer getIdFactor()
{
return idFactor;
}

public void setIdFactor(Integer idFactor)
{
this.idFactor = idFactor;
}

public String getIdPregunta()
{
return idPregunta;
}

public void setIdPregunta(String idPregunta)
{
this.idPregunta = idPregunta;
}

public String getPregunta()
{
return pregunta;
}

public void setPregunta(String pregunta)
{
this.pregunta = pregunta;
}

public String getRespuesta()
{
return respuesta;
}

public void setRespuesta(String respuesta)
{
this.respuesta = respuesta;
}
}
