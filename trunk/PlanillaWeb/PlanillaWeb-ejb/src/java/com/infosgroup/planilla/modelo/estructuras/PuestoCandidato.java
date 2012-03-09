/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Puestos;
import java.io.Serializable;

/**

 @author root
 */
public class PuestoCandidato implements Serializable
{

private Puestos puesto;
private Double salarioAspirado;
//private List<EntrevistaCandidato> entrevistas;

public Puestos getPuesto()
{
    return puesto;
}

public void setPuesto(Puestos puesto)
{
    this.puesto = puesto;
}

public Double getSalarioAspirado()
{
    return salarioAspirado;
}

public void setSalarioAspirado(Double salarioAspirado)
{
    this.salarioAspirado = salarioAspirado;
}
//public List<EntrevistaCandidato> getEntrevistas()
//{
//    return entrevistas;
//}
//
//public void setEntrevistas(List<EntrevistaCandidato> entrevistas)
//{
//    this.entrevistas = entrevistas;
//}
}
