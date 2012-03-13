/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.TipoDocumento;
import java.io.Serializable;

/**

 @author root
 */
public class DocumentoCandidato implements Serializable
{

private TipoDocumento tipo;
private String numero;

public TipoDocumento getTipo()
{
    return tipo;
}

public void setTipo(TipoDocumento tipo)
{
    this.tipo = tipo;
}

public String getNumero()
{
    return numero;
}

public void setNumero(String numero)
{
    this.numero = numero;
}
}
