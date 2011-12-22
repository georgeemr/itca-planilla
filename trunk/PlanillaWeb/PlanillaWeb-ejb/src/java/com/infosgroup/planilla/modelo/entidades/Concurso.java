/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CONCURSO")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Concurso.findAll", query = "SELECT c FROM Concurso c"),
    @NamedQuery(name = "Concurso.findByCodCia", query = "SELECT c FROM Concurso c WHERE c.concursoPK.codCia = :codCia"),
    @NamedQuery(name = "Concurso.findByNombre", query = "SELECT c FROM Concurso c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Concurso.findByFechaInicial", query = "SELECT c FROM Concurso c WHERE c.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "Concurso.findByFechaFinal", query = "SELECT c FROM Concurso c WHERE c.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "Concurso.findByNumeroPlazas", query = "SELECT c FROM Concurso c WHERE c.numeroPlazas = :numeroPlazas"),
    @NamedQuery(name = "Concurso.findByCodConcurso", query = "SELECT c FROM Concurso c WHERE c.concursoPK.codConcurso = :codConcurso"),
    @NamedQuery(name = "Concurso.findByComentarioFinal", query = "SELECT c FROM Concurso c WHERE c.comentarioFinal = :comentarioFinal")
    })
public class Concurso implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ConcursoPK concursoPK;

    @Size(max = 200)
    @Column(name = "NOMBRE", length = 200)
    private String nombre;

    @Column(name = "FECHA_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;

    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;

    @Column(name = "NUMERO_PLAZAS")
    private Long numeroPlazas;

    @Size(max = 200)
    @Column(name = "COMENTARIO_FINAL", length = 200)
    private String comentarioFinal;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PUESTO", referencedColumnName = "COD_PUESTO")
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Puesto puesto;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ESTADO", referencedColumnName = "CODIGO", nullable = false)
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EstadoConcurso estadoConcurso;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "concurso1", fetch = FetchType.EAGER)
    private List<CandidatoConcurso> candidatoConcursoList;

    public Concurso()
    {
    }

    public Concurso(ConcursoPK concursoPK)
    {
        this.concursoPK = concursoPK;
    }

    public Concurso(long codCia, long codConcurso)
    {
        this.concursoPK = new ConcursoPK(codCia, codConcurso);
    }

    public ConcursoPK getConcursoPK()
    {
        return concursoPK;
    }

    public void setConcursoPK(ConcursoPK concursoPK)
    {
        this.concursoPK = concursoPK;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
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

    public Long getNumeroPlazas()
    {
        return numeroPlazas;
    }

    public void setNumeroPlazas(Long numeroPlazas)
    {
        this.numeroPlazas = numeroPlazas;
    }

    public String getComentarioFinal()
    {
        return comentarioFinal;
    }

    public void setComentarioFinal(String comentarioFinal)
    {
        this.comentarioFinal = comentarioFinal;
    }

    public Puesto getPuesto()
    {
        return puesto;
    }

    public void setPuesto(Puesto puesto)
    {
        this.puesto = puesto;
    }

    public EstadoConcurso getEstadoConcurso()
    {
        return estadoConcurso;
    }

    public void setEstadoConcurso(EstadoConcurso estadoConcurso)
    {
        this.estadoConcurso = estadoConcurso;
    }

    @XmlTransient
    public List<CandidatoConcurso> getCandidatoConcursoList()
    {
        return candidatoConcursoList;
    }

    public void setCandidatoConcursoList(List<CandidatoConcurso> candidatoConcursoList)
    {
        this.candidatoConcursoList = candidatoConcursoList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (concursoPK != null ? concursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concurso))
            {
            return false;
            }
        Concurso other = (Concurso) object;
        if ((this.concursoPK == null && other.concursoPK != null) || (this.concursoPK != null && !this.concursoPK.equals(other.concursoPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Concurso[ concursoPK=" + concursoPK + " ]";
    }
    
}
