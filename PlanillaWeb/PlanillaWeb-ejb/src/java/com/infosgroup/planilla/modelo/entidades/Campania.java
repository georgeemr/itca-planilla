/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**

 @author root
 */
@Entity
@Table(name = "CAMPANIA", catalog = "", schema = "PLANILLA", uniqueConstraints =
    {
    @UniqueConstraint(columnNames =
        {
        "COD_CIA", "COD_CAMPANIA"
        })
    })
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Campania.findAll", query = "SELECT c FROM Campania c"),
    @NamedQuery(name = "Campania.findByCodCia", query = "SELECT c FROM Campania c WHERE c.campaniaPK.codCia = :codCia"),
    @NamedQuery(name = "Campania.findByCodCampania", query = "SELECT c FROM Campania c WHERE c.campaniaPK.codCampania = :codCampania"),
    @NamedQuery(name = "Campania.findByNomCampania", query = "SELECT c FROM Campania c WHERE c.nomCampania = :nomCampania"),
    @NamedQuery(name = "Campania.findByFechaInicial", query = "SELECT c FROM Campania c WHERE c.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "Campania.findByFechaFinal", query = "SELECT c FROM Campania c WHERE c.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "Campania.findByEstado", query = "SELECT c FROM Campania c WHERE c.estado = :estado"),
    @NamedQuery(name = "Campania.findByPeriodo", query = "SELECT c FROM Campania c WHERE c.campaniaPK.periodo = :periodo"),
    @NamedQuery(name = "Campania.findByCodArea", query = "SELECT c FROM Campania c WHERE c.codArea = :codArea"),
    @NamedQuery(name = "Campania.findByNota", query = "SELECT c FROM Campania c WHERE c.nota = :nota")
    })
public class Campania implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected CampaniaPK campaniaPK;
@Basic(optional = false)
@Column(name = "NOM_CAMPANIA", nullable = false, length = 60)
private String nomCampania;
@Basic(optional = false)
@Column(name = "FECHA_INICIAL", nullable = false)
@Temporal(TemporalType.TIMESTAMP)
private Date fechaInicial;
@Basic(optional = false)
@Column(name = "FECHA_FINAL", nullable = false)
@Temporal(TemporalType.TIMESTAMP)
private Date fechaFinal;
@Basic(optional = false)
@Column(name = "ESTADO", nullable = false, length = 1)
private String estado;
@Column(name = "COD_AREA")
private Long codArea;
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
@Column(name = "NOTA", precision = 10, scale = 2)
private BigDecimal nota;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "campania")
private List<Evaluacion> evaluacionList;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "campania")
private List<PreEvaluacion> preEvaluacionList;
@Transient
private String descripcionEstado;
@Transient
private Integer empleadosEvaluados;

public Campania()
{
}

public Campania(CampaniaPK campaniaPK)
{
    this.campaniaPK = campaniaPK;
}

public Campania(CampaniaPK campaniaPK, String nomCampania, Date fechaInicial, Date fechaFinal, String estado)
{
    this.campaniaPK = campaniaPK;
    this.nomCampania = nomCampania;
    this.fechaInicial = fechaInicial;
    this.fechaFinal = fechaFinal;
    this.estado = estado;
}

public Campania(short codCia, short codCampania, int periodo)
{
    this.campaniaPK = new CampaniaPK(codCia, codCampania, periodo);
}

public CampaniaPK getCampaniaPK()
{
    return campaniaPK;
}

public void setCampaniaPK(CampaniaPK campaniaPK)
{
    this.campaniaPK = campaniaPK;
}

public String getNomCampania()
{
    return nomCampania;
}

public void setNomCampania(String nomCampania)
{
    this.nomCampania = nomCampania;
}

public Date getFechaInicial()
{
    return fechaInicial;
}

public void setFechaInicial(Date fechaInicial)
{
    this.fechaInicial = fechaInicial;
}

public Date getFechaFinal()
{
    return fechaFinal;
}

public void setFechaFinal(Date fechaFinal)
{
    this.fechaFinal = fechaFinal;
}

public String getEstado()
{
    return estado;
}

public void setEstado(String estado)
{
    this.estado = estado;
}

public Long getCodArea()
{
    return codArea;
}

public void setCodArea(Long codArea)
{
    this.codArea = codArea;
}

public BigDecimal getNota()
{
    return nota;
}

public void setNota(BigDecimal nota)
{
    this.nota = nota;
}

@XmlTransient
public List<Evaluacion> getEvaluacionList()
{
    return evaluacionList;
}

public void setEvaluacionList(List<Evaluacion> evaluacionList)
{
    this.evaluacionList = evaluacionList;
}

@XmlTransient
public List<PreEvaluacion> getPreEvaluacionList()
{
    return preEvaluacionList;
}

public void setPreEvaluacionList(List<PreEvaluacion> preEvaluacionList)
{
    this.preEvaluacionList = preEvaluacionList;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (campaniaPK != null ? campaniaPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Campania))
        {
        return false;
        }
    Campania other = (Campania) object;
    if ((this.campaniaPK == null && other.campaniaPK != null) || (this.campaniaPK != null && !this.campaniaPK.equals(other.campaniaPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.planilla.Campania[ campaniaPK=" + campaniaPK + " ]";
}

public String getDescripcionEstado()
{
    if (estado.equals("C"))
        {
        descripcionEstado = "Cerrada";
        }
    else if (estado.equals("G"))
        {
        descripcionEstado = "Abierta";
        }
    return descripcionEstado;
}

public void setDescripcionEstado(String descripcionEstado)
{
    this.descripcionEstado = descripcionEstado;
}

public Integer getEmpleadosEvaluados()
{
    return empleadosEvaluados;
}

public void setEmpleadosEvaluados(Integer empleadosEvaluados)
{
    this.empleadosEvaluados = empleadosEvaluados;
}
}
