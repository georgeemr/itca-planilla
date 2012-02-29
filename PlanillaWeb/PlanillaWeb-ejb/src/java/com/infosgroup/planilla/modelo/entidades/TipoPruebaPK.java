/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**

 @author root
 */
@Embeddable
public class TipoPruebaPK implements Serializable
{

@Basic(optional = false)
@NotNull
@Column(name = "COD_CIA", nullable = false)
private short codCia;
@Basic(optional = false)
@NotNull
@Column(name = "COD_TIPO_PRUEBA", nullable = false)
private short codTipoPrueba;

public TipoPruebaPK()
{
}

public TipoPruebaPK(short codCia, short codTipoPrueba)
{
    this.codCia = codCia;
    this.codTipoPrueba = codTipoPrueba;
}

public short getCodCia()
{
    return codCia;
}

public void setCodCia(short codCia)
{
    this.codCia = codCia;
}

public short getCodTipoPrueba()
{
    return codTipoPrueba;
}

public void setCodTipoPrueba(short codTipoPrueba)
{
    this.codTipoPrueba = codTipoPrueba;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (int) codCia;
    hash += (int) codTipoPrueba;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TipoPruebaPK))
        {
        return false;
        }
    TipoPruebaPK other = (TipoPruebaPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codTipoPrueba != other.codTipoPrueba)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.TipoPruebaPK[ codCia=" + codCia + ", codTipoPrueba=" + codTipoPrueba + " ]";
}
}
