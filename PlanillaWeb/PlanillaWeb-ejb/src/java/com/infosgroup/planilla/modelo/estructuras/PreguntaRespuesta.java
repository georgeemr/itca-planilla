/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Respuesta;
import java.io.Serializable;

/**
 *
 * @author root
 */
public class PreguntaRespuesta implements Serializable
{
private Pregunta pregunta;

private Respuesta respuesta;

public Pregunta getPregunta()
{
    return pregunta;
}

public void setPregunta(Pregunta pregunta)
{
    this.pregunta = pregunta;
}

public Respuesta getRespuesta()
{
    return respuesta;
}

public void setRespuesta(Respuesta respuesta)
{
    this.respuesta = respuesta;
}
}
