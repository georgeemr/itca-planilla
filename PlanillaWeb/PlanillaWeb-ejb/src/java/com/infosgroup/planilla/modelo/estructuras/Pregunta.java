/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.entidades.PreguntaPK;
import com.infosgroup.planilla.modelo.entidades.Respuesta;
import java.io.Serializable;
import java.util.List;

/**

 @author root
 */
public class Pregunta implements Serializable
{

private PreguntaPK preguntaPK;
private String descripcion;
private List<Respuesta> respuestaList;
private Factor factor;

//public Pregunta()
//{
//}
//
//public Pregunta(PreguntaPK preguntaPK)
//{
//    this.preguntaPK = preguntaPK;
//}
//
//public Pregunta(PreguntaPK preguntaPK, String descripcion)
//{
//    this.preguntaPK = preguntaPK;
//    this.descripcion = descripcion;
//}
//
//public Pregunta(long codCia, long codFactor, String codPregunta)
//{
//    this.preguntaPK = new PreguntaPK(codCia, codFactor, codPregunta);
//}

public PreguntaPK getPreguntaPK()
{
    return preguntaPK;
}

public void setPreguntaPK(PreguntaPK preguntaPK)
{
    this.preguntaPK = preguntaPK;
}

public String getDescripcion()
{
    return descripcion;
}

public void setDescripcion(String descripcion)
{
    this.descripcion = descripcion;
}

public List<Respuesta> getRespuestaList()
{
    return respuestaList;
}

public void setRespuestaList(List<Respuesta> respuestaList)
{
    this.respuestaList = respuestaList;
}

public Factor getFactor()
{
    return factor;
}

public void setFactor(Factor factor)
{
    this.factor = factor;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.estructuras.Pregunta[ preguntaPK=" + preguntaPK + " ]";
}
// =====================
private String respuesta;

public String getRespuesta()
{
    return respuesta;
}

public void setRespuesta(String respuesta)
{
    this.respuesta = respuesta;
}
// =====================
}
