/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Equipo;
import java.io.Serializable;

/**

 @author root
 */
public class EquipoCandidato implements Serializable
{

private Equipo equipo;
private Integer estado;

public Equipo getEquipo()
{
    return equipo;
}

public void setEquipo(Equipo equipo)
{
    this.equipo = equipo;
}

public Integer getEstado()
{
    return estado;
}

public void setEstado(Integer estado)
{
    this.estado = estado;
}
}
