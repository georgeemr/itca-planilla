/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**

 @author root
 */
@Entity
@Table(name = "REFERENCIA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Referencia.findAll", query = "SELECT r FROM Referencia r"),
    @NamedQuery(name = "Referencia.findByCodCia", query = "SELECT r FROM Referencia r WHERE r.referenciaPK.codCia = :codCia"),
    @NamedQuery(name = "Referencia.findByCodCandidato", query = "SELECT r FROM Referencia r WHERE r.referenciaPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "Referencia.findByCodReferencia", query = "SELECT r FROM Referencia r WHERE r.referenciaPK.codReferencia = :codReferencia"),
    @NamedQuery(name = "Referencia.findByNomReferencia", query = "SELECT r FROM Referencia r WHERE r.nomReferencia = :nomReferencia"),
    @NamedQuery(name = "Referencia.findByTiempo", query = "SELECT r FROM Referencia r WHERE r.tiempo = :tiempo"),
    @NamedQuery(name = "Referencia.findByTelefono", query = "SELECT r FROM Referencia r WHERE r.telefono = :telefono"),
    @NamedQuery(name = "Referencia.findBySueldo", query = "SELECT r FROM Referencia r WHERE r.sueldo = :sueldo"),
    @NamedQuery(name = "Referencia.findByMotivoRetiro", query = "SELECT r FROM Referencia r WHERE r.motivoRetiro = :motivoRetiro"),
    @NamedQuery(name = "Referencia.findByTipoReferencia", query = "SELECT r FROM Referencia r WHERE r.tipoReferencia = :tipoReferencia"),
    @NamedQuery(name = "Referencia.findByLugar", query = "SELECT r FROM Referencia r WHERE r.lugar = :lugar")
    })
public class Referencia implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected ReferenciaPK referenciaPK;
@Basic(optional = false)
@NotNull
@Size(min = 1, max = 100)
@Column(name = "NOM_REFERENCIA", nullable = false, length = 100)
private String nomReferencia;
@Size(max = 50)
@Column(name = "TIEMPO", length = 50)
private String tiempo;
@Size(max = 10)
@Column(name = "TELEFONO", length = 10)
private String telefono;
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
@Column(name = "SUELDO", precision = 6, scale = 2)
private BigDecimal sueldo;
@Size(max = 100)
@Column(name = "MOTIVO_RETIRO", length = 100)
private String motivoRetiro;
@Basic(optional = false)
@NotNull
@Column(name = "TIPO_REFERENCIA", nullable = false)
private char tipoReferencia;
@Size(max = 100)
@Column(name = "LUGAR", length = 100)
private String lugar;
@Size(max = 50)
@Column(name = "EMAIL", length = 50)
private String email;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Candidato candidato;

public Referencia()
{
}

public Referencia(ReferenciaPK referenciaPK)
{
    this.referenciaPK = referenciaPK;
}

public Referencia(ReferenciaPK referenciaPK, String nomReferencia, char tipoReferencia)
{
    this.referenciaPK = referenciaPK;
    this.nomReferencia = nomReferencia;
    this.tipoReferencia = tipoReferencia;
}

public Referencia(short codCia, int codCandidato, int codReferencia)
{
    this.referenciaPK = new ReferenciaPK(codCia, codCandidato, codReferencia);
}

public ReferenciaPK getReferenciaPK()
{
    return referenciaPK;
}

public void setReferenciaPK(ReferenciaPK referenciaPK)
{
    this.referenciaPK = referenciaPK;
}

public String getNomReferencia()
{
    return nomReferencia;
}

public void setNomReferencia(String nomReferencia)
{
    this.nomReferencia = nomReferencia;
}

public String getTiempo()
{
    return tiempo;
}

public void setTiempo(String tiempo)
{
    this.tiempo = tiempo;
}

public String getTelefono()
{
    return telefono;
}

public void setTelefono(String telefono)
{
    this.telefono = telefono;
}

public BigDecimal getSueldo()
{
    return sueldo;
}

public void setSueldo(BigDecimal sueldo)
{
    this.sueldo = sueldo;
}

public String getMotivoRetiro()
{
    return motivoRetiro;
}

public void setMotivoRetiro(String motivoRetiro)
{
    this.motivoRetiro = motivoRetiro;
}

public char getTipoReferencia()
{
    return tipoReferencia;
}

public void setTipoReferencia(char tipoReferencia)
{
    this.tipoReferencia = tipoReferencia;
}

public String getLugar()
{
    return lugar;
}

public void setLugar(String lugar)
{
    this.lugar = lugar;
}

public String getEmail()
{
    return email;
}

public void setEmail(String email)
{
    this.email = email;
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
    hash += (referenciaPK != null ? referenciaPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Referencia))
        {
        return false;
        }
    Referencia other = (Referencia) object;
    if ((this.referenciaPK == null && other.referenciaPK != null) || (this.referenciaPK != null && !this.referenciaPK.equals(other.referenciaPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.Referencia[ referenciaPK=" + referenciaPK + " ]";
}
}
