/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Puestos;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author root
 */
public class ExperienciaLaboralCandidato implements Serializable
{

private String lugar;
private Puestos puesto;
private Date fechaInicio;
private Date fechaFin;
private String motivoRetiro;

public String getLugar()
{
    return lugar;
}

public void setLugar(String lugar)
{
    this.lugar = lugar;
}

public Puestos getPuesto()
{
    return puesto;
}

public void setPuesto(Puestos puesto)
{
    this.puesto = puesto;
}

public Date getFechaInicio()
{
    return fechaInicio;
}

public void setFechaInicio(Date fechaInicio)
{
    this.fechaInicio = fechaInicio;
}

public Date getFechaFin()
{
    return fechaFin;
}

public void setFechaFin(Date fechaFin)
{
    this.fechaFin = fechaFin;
}

public String getMotivoRetiro()
{
    return motivoRetiro;
}

public void setMotivoRetiro(String motivoRetiro)
{
    this.motivoRetiro = motivoRetiro;
}
}
