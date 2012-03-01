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
public class BeneficiarioXCandidatoPK implements Serializable
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
@Column(name = "COD_BENEFICIARIO", nullable = false)
private int codBeneficiario;

public BeneficiarioXCandidatoPK()
{
}

public BeneficiarioXCandidatoPK(short codCia, int codCandidato, int codBeneficiario)
{
    this.codCia = codCia;
    this.codCandidato = codCandidato;
    this.codBeneficiario = codBeneficiario;
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

public int getCodBeneficiario()
{
    return codBeneficiario;
}

public void setCodBeneficiario(int codBeneficiario)
{
    this.codBeneficiario = codBeneficiario;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (int) codCia;
    hash += (int) codCandidato;
    hash += (int) codBeneficiario;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BeneficiarioXCandidatoPK))
        {
        return false;
        }
    BeneficiarioXCandidatoPK other = (BeneficiarioXCandidatoPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codCandidato != other.codCandidato)
        {
        return false;
        }
    if (this.codBeneficiario != other.codBeneficiario)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.BeneficiarioXCandidatoPK[ codCia=" + codCia + ", codCandidato=" + codCandidato + ", codBeneficiario=" + codBeneficiario + " ]";
}
}
