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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "nivel_academico")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "NivelAcademico.findAll", query = "SELECT n FROM NivelAcademico n"),
    @NamedQuery(name = "NivelAcademico.findByIdNivelAcademico", query = "SELECT n FROM NivelAcademico n WHERE n.idNivelAcademico = :idNivelAcademico"),
    @NamedQuery(name = "NivelAcademico.findByNomNivelAcademico", query = "SELECT n FROM NivelAcademico n WHERE n.nomNivelAcademico = :nomNivelAcademico"),
    @NamedQuery(name = "NivelAcademico.findByDetNivelAcademico", query = "SELECT n FROM NivelAcademico n WHERE n.detNivelAcademico = :detNivelAcademico")
    })
public class NivelAcademico implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel_academico", nullable = false)
    private Integer idNivelAcademico;

    @Size(max = 100)
    @Column(name = "nom_nivel_academico", length = 100)
    private String nomNivelAcademico;

    @Size(max = 200)
    @Column(name = "det_nivel_academico", length = 200)
    private String detNivelAcademico;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelAcademico")
    private List<EmpleadoNivelAcademico> empleadoNivelAcademicoList;

    public NivelAcademico()
    {
    }

    public NivelAcademico(Integer idNivelAcademico)
    {
        this.idNivelAcademico = idNivelAcademico;
    }

    public Integer getIdNivelAcademico()
    {
        return idNivelAcademico;
    }

    public void setIdNivelAcademico(Integer idNivelAcademico)
    {
        this.idNivelAcademico = idNivelAcademico;
    }

    public String getNomNivelAcademico()
    {
        return nomNivelAcademico;
    }

    public void setNomNivelAcademico(String nomNivelAcademico)
    {
        this.nomNivelAcademico = nomNivelAcademico;
    }

    public String getDetNivelAcademico()
    {
        return detNivelAcademico;
    }

    public void setDetNivelAcademico(String detNivelAcademico)
    {
        this.detNivelAcademico = detNivelAcademico;
    }

    @XmlTransient
    public List<EmpleadoNivelAcademico> getEmpleadoNivelAcademicoList()
    {
        return empleadoNivelAcademicoList;
    }

    public void setEmpleadoNivelAcademicoList(List<EmpleadoNivelAcademico> empleadoNivelAcademicoList)
    {
        this.empleadoNivelAcademicoList = empleadoNivelAcademicoList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idNivelAcademico != null ? idNivelAcademico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcademico))
            {
            return false;
            }
        NivelAcademico other = (NivelAcademico) object;
        if ((this.idNivelAcademico == null && other.idNivelAcademico != null) || (this.idNivelAcademico != null && !this.idNivelAcademico.equals(other.idNivelAcademico)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.NivelAcademico[ idNivelAcademico=" + idNivelAcademico + " ]";
    }
    
}
