/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**

 @author root
 */
@Entity
@Table(name = "NIVELES_X_CANDIDATO")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "NivelesXCandidato.findAll", query = "SELECT n FROM NivelesXCandidato n"),
    @NamedQuery(name = "NivelesXCandidato.findByCodCia", query = "SELECT n FROM NivelesXCandidato n WHERE n.nivelesXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "NivelesXCandidato.findByCodCandidato", query = "SELECT n FROM NivelesXCandidato n WHERE n.nivelesXCandidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "NivelesXCandidato.findByCodNivel", query = "SELECT n FROM NivelesXCandidato n WHERE n.nivelesXCandidatoPK.codNivel = :codNivel"),
    @NamedQuery(name = "NivelesXCandidato.findByEstadoNivel", query = "SELECT n FROM NivelesXCandidato n WHERE n.estadoNivel = :estadoNivel"),
    @NamedQuery(name = "NivelesXCandidato.findByFecEstado", query = "SELECT n FROM NivelesXCandidato n WHERE n.fecEstado = :fecEstado"),
    @NamedQuery(name = "NivelesXCandidato.findBySubNivel", query = "SELECT n FROM NivelesXCandidato n WHERE n.subNivel = :subNivel"),
    @NamedQuery(name = "NivelesXCandidato.findByNomInstitucion", query = "SELECT n FROM NivelesXCandidato n WHERE n.nomInstitucion = :nomInstitucion"),
    @NamedQuery(name = "NivelesXCandidato.findByAnioIngreso", query = "SELECT n FROM NivelesXCandidato n WHERE n.anioIngreso = :anioIngreso"),
    @NamedQuery(name = "NivelesXCandidato.findByAnioEgreso", query = "SELECT n FROM NivelesXCandidato n WHERE n.anioEgreso = :anioEgreso"),
    @NamedQuery(name = "NivelesXCandidato.findByCodPais", query = "SELECT n FROM NivelesXCandidato n WHERE n.codPais = :codPais"),
    @NamedQuery(name = "NivelesXCandidato.findByCodDepto", query = "SELECT n FROM NivelesXCandidato n WHERE n.codDepto = :codDepto")
    })
public class NivelesXCandidato implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NivelesXCandidatoPK nivelesXCandidatoPK;
    @Size(max = 1)
    @Column(name = "ESTADO_NIVEL", length = 1)
    private String estadoNivel;
    @Column(name = "FEC_ESTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEstado;
    @Column(name = "SUB_NIVEL")
    private Short subNivel;
    @Size(max = 100)
    @Column(name = "NOM_INSTITUCION", length = 100)
    private String nomInstitucion;
    @Column(name = "ANIO_INGRESO")
    private Short anioIngreso;
    @Column(name = "ANIO_EGRESO")
    private Short anioEgreso;
    @Column(name = "COD_PAIS")
    private Short codPais;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Candidato candidato;

    public NivelesXCandidato()
    {
    }

    public NivelesXCandidato(NivelesXCandidatoPK nivelesXCandidatoPK)
    {
        this.nivelesXCandidatoPK = nivelesXCandidatoPK;
    }

    public NivelesXCandidato(Short codCia, Integer codCandidato, Short codNivel)
    {
        this.nivelesXCandidatoPK = new NivelesXCandidatoPK(codCia, codCandidato, codNivel);
    }

    public NivelesXCandidatoPK getNivelesXCandidatoPK()
    {
        return nivelesXCandidatoPK;
    }

    public void setNivelesXCandidatoPK(NivelesXCandidatoPK nivelesXCandidatoPK)
    {
        this.nivelesXCandidatoPK = nivelesXCandidatoPK;
    }

    public String getEstadoNivel()
    {
        return estadoNivel;
    }

    public void setEstadoNivel(String estadoNivel)
    {
        this.estadoNivel = estadoNivel;
    }

    public Date getFecEstado()
    {
        return fecEstado;
    }

    public void setFecEstado(Date fecEstado)
    {
        this.fecEstado = fecEstado;
    }

    public Short getSubNivel()
    {
        return subNivel;
    }

    public void setSubNivel(Short subNivel)
    {
        this.subNivel = subNivel;
    }

    public String getNomInstitucion()
    {
        return nomInstitucion;
    }

    public void setNomInstitucion(String nomInstitucion)
    {
        this.nomInstitucion = nomInstitucion;
    }

    public Short getAnioIngreso()
    {
        return anioIngreso;
    }

    public void setAnioIngreso(Short anioIngreso)
    {
        this.anioIngreso = anioIngreso;
    }

    public Short getAnioEgreso()
    {
        return anioEgreso;
    }

    public void setAnioEgreso(Short anioEgreso)
    {
        this.anioEgreso = anioEgreso;
    }

    public Short getCodPais()
    {
        return codPais;
    }

    public void setCodPais(Short codPais)
    {
        this.codPais = codPais;
    }

    public Short getCodDepto()
    {
        return codDepto;
    }

    public void setCodDepto(Short codDepto)
    {
        this.codDepto = codDepto;
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
        hash += (nivelesXCandidatoPK != null ? nivelesXCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelesXCandidato))
            {
            return false;
            }
        NivelesXCandidato other = (NivelesXCandidato) object;
        if ((this.nivelesXCandidatoPK == null && other.nivelesXCandidatoPK != null) || (this.nivelesXCandidatoPK != null && !this.nivelesXCandidatoPK.equals(other.nivelesXCandidatoPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.NivelesXCandidato[ nivelesXCandidatoPK=" + nivelesXCandidatoPK + " ]";
    }
    
}
