/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**

 @author root
 */
@Entity
@Table(name = "PREGUNTA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findByCodCia", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.codCia = :codCia"),
    @NamedQuery(name = "Pregunta.findByCodFactor", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.codFactor = :codFactor"),
    @NamedQuery(name = "Pregunta.findByCodPregunta", query = "SELECT p FROM Pregunta p WHERE p.preguntaPK.codPregunta = :codPregunta"),
    @NamedQuery(name = "Pregunta.findByDescripcion", query = "SELECT p FROM Pregunta p WHERE p.descripcion = :descripcion")
    })
public class Pregunta implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected PreguntaPK preguntaPK;
@Basic(optional = false)
@NotNull
@Size(min = 1, max = 300)
@Column(name = "DESCRIPCION", nullable = false, length = 300)
private String descripcion;
@JoinTable(name = "PREGUNTA_RESPUESTA", joinColumns =
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
    @JoinColumn(name = "COD_FACTOR", referencedColumnName = "COD_FACTOR", nullable = false),
    @JoinColumn(name = "COD_PREGUNTA", referencedColumnName = "COD_PREGUNTA", nullable = false)
    }, inverseJoinColumns = 
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
    @JoinColumn(name = "COD_TIPO_RESPUESTA", referencedColumnName = "COD_TIPO_RESPUESTA", nullable = false),
    @JoinColumn(name = "COD_RESPUESTA", referencedColumnName = "COD_RESPUESTA", nullable = false)
    })
@ManyToMany
private List<Respuesta> respuestaList;
@JoinColumns(
    {
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "COD_FACTOR", referencedColumnName = "COD_FACTOR", nullable = false, insertable = false, updatable = false)
    })
@ManyToOne(optional = false)
private Factor factor;

public Pregunta()
{
}

public Pregunta(PreguntaPK preguntaPK)
{
    this.preguntaPK = preguntaPK;
}

public Pregunta(PreguntaPK preguntaPK, String descripcion)
{
    this.preguntaPK = preguntaPK;
    this.descripcion = descripcion;
}

public Pregunta(long codCia, long codFactor, String codPregunta)
{
    this.preguntaPK = new PreguntaPK(codCia, codFactor, codPregunta);
}

public PreguntaPK getPreguntaPK()
{
    return preguntaPK;
}

public void setPreguntaPK(PreguntaPK preguntaPK)
{
    this.preguntaPK = preguntaPK;
}

public String getDescripcion()
{
    return descripcion;
}

public void setDescripcion(String descripcion)
{
    this.descripcion = descripcion;
}

@XmlTransient
public List<Respuesta> getRespuestaList()
{
    return respuestaList;
}

public void setRespuestaList(List<Respuesta> respuestaList)
{
    this.respuestaList = respuestaList;
}

public Factor getFactor()
{
    return factor;
}

public void setFactor(Factor factor)
{
    this.factor = factor;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (preguntaPK != null ? preguntaPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Pregunta))
        {
        return false;
        }
    Pregunta other = (Pregunta) object;
    if ((this.preguntaPK == null && other.preguntaPK != null) || (this.preguntaPK != null && !this.preguntaPK.equals(other.preguntaPK))) return false;
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.Pregunta[ preguntaPK=" + preguntaPK + " ]";
}
}
