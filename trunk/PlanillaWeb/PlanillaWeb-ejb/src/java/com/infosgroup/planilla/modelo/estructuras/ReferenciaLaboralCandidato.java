/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import java.io.Serializable;

/**

 @author root
 */
public class ReferenciaLaboralCandidato implements Serializable
{

private String nombre;
private String lugarTrabajo;
private String puesto;
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

public String getPuesto()
{
    return puesto;
}

public void setPuesto(String puesto)
{
    this.puesto = puesto;
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
