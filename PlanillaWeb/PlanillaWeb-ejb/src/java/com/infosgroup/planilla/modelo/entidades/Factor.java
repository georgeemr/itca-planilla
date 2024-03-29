/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**

 @author root
 */
@Entity
@Table(name = "FACTOR", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Factor.findAll", query = "SELECT f FROM Factor f"),
    @NamedQuery(name = "Factor.findByCodCia", query = "SELECT f FROM Factor f WHERE f.factorPK.codCia = :codCia"),
    @NamedQuery(name = "Factor.findByCodFactor", query = "SELECT f FROM Factor f WHERE f.factorPK.codFactor = :codFactor"),
    @NamedQuery(name = "Factor.findByNomFactor", query = "SELECT f FROM Factor f WHERE f.nomFactor = :nomFactor")
    })
public class Factor implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected FactorPK factorPK;
@Basic(optional = false)
@NotNull
@Size(min = 1, max = 100)
@Column(name = "NOM_FACTOR", nullable = false, length = 100)
private String nomFactor;

public Factor()
{
}

public Factor(FactorPK factorPK)
{
    this.factorPK = factorPK;
}

public Factor(FactorPK factorPK, String nomFactor)
{
    this.factorPK = factorPK;
    this.nomFactor = nomFactor;
}

public Factor(short codCia, short codFactor)
{
    this.factorPK = new FactorPK(codCia, codFactor);
}

public FactorPK getFactorPK()
{
    return factorPK;
}

public void setFactorPK(FactorPK factorPK)
{
    this.factorPK = factorPK;
}

public String getNomFactor()
{
    return nomFactor;
}

public void setNomFactor(String nomFactor)
{
    this.nomFactor = nomFactor;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (factorPK != null ? factorPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Factor))
        {
        return false;
        }
    Factor other = (Factor) object;
    if ((this.factorPK == null && other.factorPK != null) || (this.factorPK != null && !this.factorPK.equals(other.factorPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.Factor[ factorPK=" + factorPK + " ]";
}
// ===========================================
//@Column(name = "PONDERACION")
//private Integer ponderacion;
//
//public Integer getPonderacion()
//{
//    return ponderacion;
//}
//
//public void setPonderacion(Integer ponderacion)
//{
//    this.ponderacion = ponderacion;
//}
// ===========================================
}
