/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Parentesco;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**

 @author root
 */
public class DependienteCandidato implements Serializable
{

private String nombre;
private Date fechaNacimiento;
private Parentesco parentesco;

public String getNombre()
{
    return nombre;
}

public void setNombre(String nombre)
{
    this.nombre = nombre;
}

public Date getFechaNacimiento()
{
    return fechaNacimiento;
}

public void setFechaNacimiento(Date fechaNacimiento)
{
    this.fechaNacimiento = fechaNacimiento;
}

public Parentesco getParentesco()
{
    return parentesco;
}

public void setParentesco(Parentesco parentesco)
{
    this.parentesco = parentesco;
}

public Integer getEdad()
{
    Integer anios ;
    GregorianCalendar calendarioHoy = (GregorianCalendar) GregorianCalendar.getInstance();
    GregorianCalendar calendarioNacimiento = (GregorianCalendar) GregorianCalendar.getInstance();
    if (fechaNacimiento != null)
        calendarioNacimiento.setTime(fechaNacimiento);
    anios = calendarioHoy.get(GregorianCalendar.YEAR) - calendarioNacimiento.get(GregorianCalendar.YEAR);
    return anios;
}
}
