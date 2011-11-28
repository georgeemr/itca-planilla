/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Factor;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author root
 */
public class DetalleEvaluacion implements Serializable
{
private Factor factor;

public Factor getFactor()
{
    return factor;
}

public void setFactor(Factor factor)
{
    this.factor = factor;
}

private List<PreguntaRespuesta> respuestas;

public List<PreguntaRespuesta> getRespuestas()
{
    return respuestas;
}

public void setRespuestas(List<PreguntaRespuesta> respuestas)
{
    this.respuestas = respuestas;
}
/*private List<String> respuestas;

public List<String> getRespuestas()
{
return respuestas;
}

public void setRespuestas(List<String> respuestas)
{
this.respuestas = respuestas;
}*/
}
