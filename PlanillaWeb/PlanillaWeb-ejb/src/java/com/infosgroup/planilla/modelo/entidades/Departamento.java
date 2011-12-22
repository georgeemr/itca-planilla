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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "DEPARTAMENTO")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByIdCompania", query = "SELECT d FROM Departamento d WHERE d.departamentoPK.idCompania = :idCompania"),
    @NamedQuery(name = "Departamento.findByIdDepartamento", query = "SELECT d FROM Departamento d WHERE d.departamentoPK.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "Departamento.findByNomDepartamento", query = "SELECT d FROM Departamento d WHERE d.nomDepartamento = :nomDepartamento"),
    @NamedQuery(name = "Departamento.findByDetDepartamento", query = "SELECT d FROM Departamento d WHERE d.detDepartamento = :detDepartamento")
    })
public class Departamento implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected DepartamentoPK departamentoPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOM_DEPARTAMENTO", nullable = false, length = 100)
    private String nomDepartamento;

    @Size(max = 200)
    @Column(name = "DET_DEPARTAMENTO", length = 200)
    private String detDepartamento;

    @JoinColumns(
        {
        @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "GERENCIA", referencedColumnName = "COD_GERENCIA")
        })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Gerencia gerencia;

    @JoinColumn(name = "ID_COMPANIA", referencedColumnName = "ID_COMPANIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Compania compania;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento", fetch = FetchType.EAGER)
    private List<Empleado> empleadoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento", fetch = FetchType.EAGER)
    private List<Seccion> seccionList;

    public Departamento()
    {
    }

    public Departamento(DepartamentoPK departamentoPK)
    {
        this.departamentoPK = departamentoPK;
    }

    public Departamento(DepartamentoPK departamentoPK, String nomDepartamento)
    {
        this.departamentoPK = departamentoPK;
        this.nomDepartamento = nomDepartamento;
    }

    public Departamento(long idCompania, long idDepartamento)
    {
        this.departamentoPK = new DepartamentoPK(idCompania, idDepartamento);
    }

    public DepartamentoPK getDepartamentoPK()
    {
        return departamentoPK;
    }

    public void setDepartamentoPK(DepartamentoPK departamentoPK)
    {
        this.departamentoPK = departamentoPK;
    }

    public String getNomDepartamento()
    {
        return nomDepartamento;
    }

    public void setNomDepartamento(String nomDepartamento)
    {
        this.nomDepartamento = nomDepartamento;
    }

    public String getDetDepartamento()
    {
        return detDepartamento;
    }

    public void setDetDepartamento(String detDepartamento)
    {
        this.detDepartamento = detDepartamento;
    }

    public Gerencia getGerencia()
    {
        return gerencia;
    }

    public void setGerencia(Gerencia gerencia)
    {
        this.gerencia = gerencia;
    }

    public Compania getCompania()
    {
        return compania;
    }

    public void setCompania(Compania compania)
    {
        this.compania = compania;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList()
    {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList)
    {
        this.empleadoList = empleadoList;
    }

    @XmlTransient
    public List<Seccion> getSeccionList()
    {
        return seccionList;
    }

    public void setSeccionList(List<Seccion> seccionList)
    {
        this.seccionList = seccionList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (departamentoPK != null ? departamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento))
            {
            return false;
            }
        Departamento other = (Departamento) object;
        if ((this.departamentoPK == null && other.departamentoPK != null) || (this.departamentoPK != null && !this.departamentoPK.equals(other.departamentoPK))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Departamento[ departamentoPK=" + departamentoPK + " ]";
    }
    
}
