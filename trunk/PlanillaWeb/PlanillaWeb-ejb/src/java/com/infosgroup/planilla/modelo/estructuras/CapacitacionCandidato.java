/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import java.io.Serializable;

public class CapacitacionCandidato implements Serializable
{

private String tipo;
private String institucion;
private String descripcion;
private String periodo;

public String getTipo()
{
    return tipo;
}

public void setTipo(String tipo)
{
    this.tipo = tipo;
}

public String getInstitucion()
{
    return institucion;
}

public void setInstitucion(String institucion)
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

public String getPeriodo()
{
    return periodo;
}

public void setPeriodo(String periodo)
{
    this.periodo = periodo;
}
}
