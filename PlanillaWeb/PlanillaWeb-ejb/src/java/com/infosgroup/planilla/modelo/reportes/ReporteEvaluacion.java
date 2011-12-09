/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
    package com.infosgroup.planilla.modelo.reportes;

import java.io.Serializable;

/**
*
* @author root
*/
public class ReporteEvaluacion implements Serializable
{

private String compania;

private String empleado;

private String puesto;

private String tipoEvaluacion;

private String departamento;

public ReporteEvaluacion()
{
}

public String getCompania()
{
return compania;
}

public void setCompania(String compania)
{
this.compania = compania;
}

public String getDepartamento()
{
return departamento;
}

public void setDepartamento(String departamento)
{
this.departamento = departamento;
}

public String getEmpleado()
{
return empleado;
}

public void setEmpleado(String empleado)
{
this.empleado = empleado;
}

public String getPuesto()
{
return puesto;
}

public void setPuesto(String puesto)
{
this.puesto = puesto;
}

public String getTipoEvaluacion()
{
return tipoEvaluacion;
}

public void setTipoEvaluacion(String tipoEvaluacion)
{
this.tipoEvaluacion = tipoEvaluacion;
}
}
