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
public class TipoPruebaXCandidatoPK implements Serializable
{

@Basic(optional = false)
@NotNull
@Column(name = "COD_CIA", nullable = false)
private short codCia;
@Basic(optional = false)
@NotNull
@Column(name = "COD_CANDIDATO", nullable = false)
private int codCandidato;
@Basic(optional = false)
@NotNull
@Column(name = "COD_TIPO_PRUEBA", nullable = false)
private short codTipoPrueba;

public TipoPruebaXCandidatoPK()
{
}

public TipoPruebaXCandidatoPK(short codCia, int codCandidato, short codTipoPrueba)
{
    this.codCia = codCia;
    this.codCandidato = codCandidato;
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

public int getCodCandidato()
{
    return codCandidato;
}

public void setCodCandidato(int codCandidato)
{
    this.codCandidato = codCandidato;
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
    hash += (int) codCandidato;
    hash += (int) codTipoPrueba;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TipoPruebaXCandidatoPK))
        {
        return false;
        }
    TipoPruebaXCandidatoPK other = (TipoPruebaXCandidatoPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codCandidato != other.codCandidato)
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
    return "com.infosgroup.planilla.modelo.entidades.TipoPruebaXCandidatoPK[ codCia=" + codCia + ", codCandidato=" + codCandidato + ", codTipoPrueba=" + codTipoPrueba + " ]";
}
}
