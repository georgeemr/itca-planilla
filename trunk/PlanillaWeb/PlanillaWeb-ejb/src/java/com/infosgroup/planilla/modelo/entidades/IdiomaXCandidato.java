/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**

 @author root
 */
@Entity
@Table(name = "IDIOMA_X_CANDIDATO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "IdiomaXCandidato.findAll", query = "SELECT i FROM IdiomaXCandidato i"),
    @NamedQuery(name = "IdiomaXCandidato.findByCodCia", query = "SELECT i FROM IdiomaXCandidato i WHERE i.idiomaXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "IdiomaXCandidato.findByCodCandidato", query = "SELECT i FROM IdiomaXCandidato i WHERE i.idiomaXCandidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "IdiomaXCandidato.findByCodIdioma", query = "SELECT i FROM IdiomaXCandidato i WHERE i.idiomaXCandidatoPK.codIdioma = :codIdioma"),
    @NamedQuery(name = "IdiomaXCandidato.findByLee", query = "SELECT i FROM IdiomaXCandidato i WHERE i.lee = :lee"),
    @NamedQuery(name = "IdiomaXCandidato.findByEscribe", query = "SELECT i FROM IdiomaXCandidato i WHERE i.escribe = :escribe"),
    @NamedQuery(name = "IdiomaXCandidato.findByNivel", query = "SELECT i FROM IdiomaXCandidato i WHERE i.nivel = :nivel")
    })
public class IdiomaXCandidato implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected IdiomaXCandidatoPK idiomaXCandidatoPK;
@Size(max = 1)
@Column(name = "LEE", length = 1)
private String lee;
@Size(max = 1)
@Column(name = "ESCRIBE", length = 1)
private String escribe;
@Size(max = 1)
@Column(name = "NIVEL", length = 1)
private String nivel;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Candidato candidato;

public IdiomaXCandidato()
{
}

public IdiomaXCandidato(IdiomaXCandidatoPK idiomaXCandidatoPK)
{
    this.idiomaXCandidatoPK = idiomaXCandidatoPK;
}

public IdiomaXCandidato(short codCia, int codCandidato, int codIdioma)
{
    this.idiomaXCandidatoPK = new IdiomaXCandidatoPK(codCia, codCandidato, codIdioma);
}

public IdiomaXCandidatoPK getIdiomaXCandidatoPK()
{
    return idiomaXCandidatoPK;
}

public void setIdiomaXCandidatoPK(IdiomaXCandidatoPK idiomaXCandidatoPK)
{
    this.idiomaXCandidatoPK = idiomaXCandidatoPK;
}

public String getLee()
{
    return lee;
}

public void setLee(String lee)
{
    this.lee = lee;
}

public String getEscribe()
{
    return escribe;
}

public void setEscribe(String escribe)
{
    this.escribe = escribe;
}

public String getNivel()
{
    return nivel;
}

public void setNivel(String nivel)
{
    this.nivel = nivel;
}

public Candidato getCandidato()
{
    return candidato;
}

public void setCandidato(Candidato candidato)
{
    this.candidato = candidato;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (idiomaXCandidatoPK != null ? idiomaXCandidatoPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof IdiomaXCandidato))
        {
        return false;
        }
    IdiomaXCandidato other = (IdiomaXCandidato) object;
    if ((this.idiomaXCandidatoPK == null && other.idiomaXCandidatoPK != null) || (this.idiomaXCandidatoPK != null && !this.idiomaXCandidatoPK.equals(other.idiomaXCandidatoPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.IdiomaXCandidato[ idiomaXCandidatoPK=" + idiomaXCandidatoPK + " ]";
}
}
