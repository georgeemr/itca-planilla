/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.Instituciones;
import java.io.Serializable;
import java.util.Date;

/**

 @author root
 */
public class CapacitacionCandidato implements Serializable
{

private Capacitacion capacitacion;
private Instituciones institucion;
private String descripcion;
private Date fecha;

public Capacitacion getCapacitacion()
{
    return capacitacion;
}

public void setCapacitacion(Capacitacion capacitacion)
{
    this.capacitacion = capacitacion;
}

public Instituciones getInstitucion()
{
    return institucion;
}

public void setInstitucion(Instituciones institucion)
{
    this.institucion = institucion;
}

public String getDescripcion()
{
    return descripcion;
}

public void setDescripcion(String descripcion)
{
    this.descripcion = descripcion;
}

public Date getFecha()
{
    return fecha;
}

public void setFecha(Date fecha)
{
    this.fecha = fecha;
}
}
