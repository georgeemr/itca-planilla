/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Parentesco;
import java.io.Serializable;

public class BeneficiarioCandidato implements Serializable
{

private String nombre;
private Parentesco parentesco;

public String getNombre()
{
    return nombre;
}

public void setNombre(String nombre)
{
    this.nombre = nombre;
}

public Parentesco getParentesco()
{
    return parentesco;
}

public void setParentesco(Parentesco parentesco)
{
    this.parentesco = parentesco;
}
}
