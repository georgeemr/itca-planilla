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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "RESPUESTA")
@NamedQueries(
    {
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByCodCia", query = "SELECT r FROM Respuesta r WHERE r.respuestaPK.codCia = :codCia"),
    @NamedQuery(name = "Respuesta.findByCodTipoRespuesta", query = "SELECT r FROM Respuesta r WHERE r.respuestaPK.codTipoRespuesta = :codTipoRespuesta"),
    @NamedQuery(name = "Respuesta.findByGrupoRespuesta", query = "SELECT r FROM Respuesta r WHERE r.respuestaPK.grupoRespuesta = :grupoRespuesta"),
    @NamedQuery(name = "Respuesta.findByCodRespuesta", query = "SELECT r FROM Respuesta r WHERE r.respuestaPK.codRespuesta = :codRespuesta"),
    @NamedQuery(name = "Respuesta.findByTexto", query = "SELECT r FROM Respuesta r WHERE r.texto = :texto"),
    @NamedQuery(name = "Respuesta.findByNivel", query = "SELECT r FROM Respuesta r WHERE r.nivel = :nivel"),
    @NamedQuery(name = "Respuesta.findByValor", query = "SELECT r FROM Respuesta r WHERE r.valor = :valor")
    })
public class Respuesta implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected RespuestaPK respuestaPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TEXTO", nullable = false, length = 200)
    private String texto;

    @Size(max = 200)
    @Column(name = "NIVEL", length = 200)
    private String nivel;

    @Column(name = "VALOR")
    private Long valor;

    @ManyToMany(mappedBy = "respuestaList")
    private List<Pregunta> preguntaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respuesta")
    private List<DetEvaluacion> detEvaluacionList;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_RESPUESTA", referencedColumnName = "COD_TIPO_RESPUESTA", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private TipoRespuesta tipoRespuesta;

    public Respuesta()
    {
    }

    public Respuesta(RespuestaPK respuestaPK)
    {
        this.respuestaPK = respuestaPK;
    }

    public Respuesta(RespuestaPK respuestaPK, String texto)
    {
        this.respuestaPK = respuestaPK;
        this.texto = texto;
    }

    public Respuesta(long codCia, long codTipoRespuesta, long grupoRespuesta, long codRespuesta)
    {
        this.respuestaPK = new RespuestaPK(codCia, codTipoRespuesta, grupoRespuesta, codRespuesta);
    }

    public RespuestaPK getRespuestaPK()
    {
        return respuestaPK;
    }

    public void setRespuestaPK(RespuestaPK respuestaPK)
    {
        this.respuestaPK = respuestaPK;
    }

    public String getTexto()
    {
        return texto;
    }

    public void setTexto(String texto)
    {
        this.texto = texto;
    }

    public String getNivel()
    {
        return nivel;
    }

    public void setNivel(String nivel)
    {
        this.nivel = nivel;
    }

    public Long getValor()
    {
        return valor;
    }

    public void setValor(Long valor)
    {
        this.valor = valor;
    }

    public List<Pregunta> getPreguntaList()
    {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList)
    {
        this.preguntaList = preguntaList;
    }

    public List<DetEvaluacion> getDetEvaluacionList()
    {
        return detEvaluacionList;
    }

    public void setDetEvaluacionList(List<DetEvaluacion> detEvaluacionList)
    {
        this.detEvaluacionList = detEvaluacionList;
    }

    public TipoRespuesta getTipoRespuesta()
    {
        return tipoRespuesta;
    }

    public void setTipoRespuesta(TipoRespuesta tipoRespuesta)
    {
        this.tipoRespuesta = tipoRespuesta;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (respuestaPK != null ? respuestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta))
            {
            return false;
            }
        Respuesta other = (Respuesta) object;
        if ((this.respuestaPK == null && other.respuestaPK != null) || (this.respuestaPK != null && !this.respuestaPK.equals(other.respuestaPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Respuesta[ respuestaPK=" + respuestaPK + " ]";
    }
    
}
