/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
*
* @author root
*/
@Entity
@Table(name = "pregunta")
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
@Size(min = 1, max = 2147483647)
@Column(name = "descripcion", nullable = false, length = 2147483647)
private String descripcion;

@ManyToMany(mappedBy = "preguntaList")
private List<Plantilla> plantillaList;

@JoinTable(name = "pregunta_respuesta", joinColumns =
{
@JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false),
@JoinColumn(name = "cod_factor", referencedColumnName = "cod_factor", nullable = false),
@JoinColumn(name = "cod_pregunta", referencedColumnName = "cod_pregunta", nullable = false)
}, inverseJoinColumns =
{
@JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false),
@JoinColumn(name = "cod_tipo_respuesta", referencedColumnName = "cod_tipo_respuesta", nullable = false),
@JoinColumn(name = "grupo_respuesta", referencedColumnName = "grupo_respuesta", nullable = false),
@JoinColumn(name = "cod_respuesta", referencedColumnName = "cod_respuesta", nullable = false)
})
@ManyToMany
private List<Respuesta> respuestaList;

@JoinColumns(
{
@JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
@JoinColumn(name = "cod_factor", referencedColumnName = "cod_factor", nullable = false, insertable = false, updatable = false)
})
@ManyToOne(optional = false)
private Factor factor;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "pregunta")
private List<DetEvaluacion> detEvaluacionList;

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

public Pregunta(int codCia, int codFactor, String codPregunta)
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
public List<Plantilla> getPlantillaList()
{
return plantillaList;
}

public void setPlantillaList(List<Plantilla> plantillaList)
{
this.plantillaList = plantillaList;
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

@XmlTransient
public List<DetEvaluacion> getDetEvaluacionList()
{
return detEvaluacionList;
}

public void setDetEvaluacionList(List<DetEvaluacion> detEvaluacionList)
{
this.detEvaluacionList = detEvaluacionList;
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
if ((this.preguntaPK == null && other.preguntaPK != null) || (this.preguntaPK != null && !this.preguntaPK.equals(other.preguntaPK)))
    {
    return false;
    }
return true;
}

@Override
public String toString()
{
return "com.infosgroup.planilla.modelo.entidades.Pregunta[ preguntaPK=" + preguntaPK + " ]";
}

// ==========================================================================================
@Transient
private String respuestaSeleccionada;

public String getRespuestaSeleccionada()
{
return respuestaSeleccionada;
}

public void setRespuestaSeleccionada(String respuestaSeleccionada)
{
this.respuestaSeleccionada = respuestaSeleccionada;
}
}
