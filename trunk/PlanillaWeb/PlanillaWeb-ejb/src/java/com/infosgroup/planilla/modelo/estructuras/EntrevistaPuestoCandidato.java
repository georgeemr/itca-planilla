/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import java.io.Serializable;
import java.util.Date;

/**

 @author root
 */
public class EntrevistaPuestoCandidato implements Serializable
{

private Date fecha;
private String descripcion;
private Empleados empleado;
private String resultado;

public Date getFecha()
{
    return fecha;
}

public void setFecha(Date fecha)
{
    this.fecha = fecha;
}

public String getDescripcion()
{
    return descripcion;
}

public void setDescripcion(String descripcion)
{
    this.descripcion = descripcion;
}

public Empleados getEmpleado()
{
    return empleado;
}

public void setEmpleado(Empleados empleado)
{
    this.empleado = empleado;
}

public String getResultado()
{
    return resultado;
}

public void setResultado(String resultado)
{
    this.resultado = resultado;
}
}
