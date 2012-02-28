/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import java.io.Serializable;

/**

 @author root
 */
public class ReferenciaPersonalCandidato implements Serializable
{

private String nombre;
private String lugarTrabajo;
private Integer tiempoConocerle;
private String telefono;
private String correoElectronico;

public String getNombre()
{
    return nombre;
}

public void setNombre(String nombre)
{
    this.nombre = nombre;
}

public String getLugarTrabajo()
{
    return lugarTrabajo;
}

public void setLugarTrabajo(String lugarTrabajo)
{
    this.lugarTrabajo = lugarTrabajo;
}

public Integer getTiempoConocerle()
{
    return tiempoConocerle;
}

public void setTiempoConocerle(Integer tiempoConocerle)
{
    this.tiempoConocerle = tiempoConocerle;
}

public String getTelefono()
{
    return telefono;
}

public void setTelefono(String telefono)
{
    this.telefono = telefono;
}

public String getCorreoElectronico()
{
    return correoElectronico;
}

public void setCorreoElectronico(String correoElectronico)
{
    this.correoElectronico = correoElectronico;
}
}
