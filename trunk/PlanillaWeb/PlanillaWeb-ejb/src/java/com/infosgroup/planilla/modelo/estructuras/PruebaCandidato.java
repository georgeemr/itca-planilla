/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.TipoPrueba;
import java.io.Serializable;
import java.util.Date;

/**

 @author root
 */
public class PruebaCandidato implements Serializable
{

private TipoPrueba tipoPrueba;
private String resultado;
private Double nota;
private Double costo;
private Date fecha;

public TipoPrueba getTipoPrueba()
{
    return tipoPrueba;
}

public void setTipoPrueba(TipoPrueba tipoPrueba)
{
    this.tipoPrueba = tipoPrueba;
}

public String getResultado()
{
    return resultado;
}

public void setResultado(String resultado)
{
    this.resultado = resultado;
}

public Double getNota()
{
    return nota;
}

public void setNota(Double nota)
{
    this.nota = nota;
}

public Double getCosto()
{
    return costo;
}

public void setCosto(Double costo)
{
    this.costo = costo;
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
