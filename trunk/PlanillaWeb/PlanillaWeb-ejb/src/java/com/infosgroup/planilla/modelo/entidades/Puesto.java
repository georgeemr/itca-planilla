/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PUESTO")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Puesto.findAll", query = "SELECT p FROM Puesto p"),
    @NamedQuery(name = "Puesto.findByCodCia", query = "SELECT p FROM Puesto p WHERE p.puestoPK.codCia = :codCia"),
    @NamedQuery(name = "Puesto.findByCodPuesto", query = "SELECT p FROM Puesto p WHERE p.puestoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "Puesto.findByNombre", query = "SELECT p FROM Puesto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Puesto.findBySalarioMaximo", query = "SELECT p FROM Puesto p WHERE p.salarioMaximo = :salarioMaximo"),
    @NamedQuery(name = "Puesto.findBySalarioMinimo", query = "SELECT p FROM Puesto p WHERE p.salarioMinimo = :salarioMinimo"),
    @NamedQuery(name = "Puesto.findByDescripcion", query = "SELECT p FROM Puesto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Puesto.findByEstado", query = "SELECT p FROM Puesto p WHERE p.estado = :estado"),
    @NamedQuery(name = "Puesto.findByGenero", query = "SELECT p FROM Puesto p WHERE p.genero = :genero"),
    @NamedQuery(name = "Puesto.findByNivelAcademico", query = "SELECT p FROM Puesto p WHERE p.nivelAcademico = :nivelAcademico"),
    @NamedQuery(name = "Puesto.findByCondicion", query = "SELECT p FROM Puesto p WHERE p.condicion = :condicion"),
    @NamedQuery(name = "Puesto.findByJefatura", query = "SELECT p FROM Puesto p WHERE p.jefatura = :jefatura")
    })
public class Puesto implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PuestoPK puestoPK;

    @Size(max = 200)
    @Column(name = "NOMBRE", length = 200)
    private String nombre;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARIO_MAXIMO", precision = 11, scale = 3)
    private BigDecimal salarioMaximo;

    @Column(name = "SALARIO_MINIMO", precision = 11, scale = 3)
    private BigDecimal salarioMinimo;

    @Size(max = 200)
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;

    @Size(max = 200)
    @Column(name = "ESTADO", length = 200)
    private String estado;

    @Size(max = 200)
    @Column(name = "GENERO", length = 200)
    private String genero;

    @Column(name = "NIVEL_ACADEMICO")
    private Long nivelAcademico;

    @Column(name = "CONDICION")
    private Long condicion;

    @Column(name = "JEFATURA")
    private Long jefatura;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puesto")
    private List<Concurso> concursoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puesto")
    private List<PuestoEmpleado> puestoEmpleadoList;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO", referencedColumnName = "COD_TIPO_PUESTO")
        })
    @ManyToOne(optional = false)
    private TipoPuesto tipoPuesto;

    @JoinColumn(name = "RANGO_EDAD", referencedColumnName = "COD_RANGO_EDAD")
    @ManyToOne
    private RangoEdad rangoEdad;

    @JoinColumn(name = "RANGO_ANIOS", referencedColumnName = "COD_RANGO_ANIOS")
    @ManyToOne
    private RangoAniosExperiencia rangoAnios;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puesto1")
    private List<CriteriosXPuesto> criteriosXPuestoList;

    public Puesto()
    {
    }

    public Puesto(PuestoPK puestoPK)
    {
        this.puestoPK = puestoPK;
    }

    public Puesto(long codCia, long codPuesto)
    {
        this.puestoPK = new PuestoPK(codCia, codPuesto);
    }

    public PuestoPK getPuestoPK()
    {
        return puestoPK;
    }

    public void setPuestoPK(PuestoPK puestoPK)
    {
        this.puestoPK = puestoPK;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public BigDecimal getSalarioMaximo()
    {
        return salarioMaximo;
    }

    public void setSalarioMaximo(BigDecimal salarioMaximo)
    {
        this.salarioMaximo = salarioMaximo;
    }

    public BigDecimal getSalarioMinimo()
    {
        return salarioMinimo;
    }

    public void setSalarioMinimo(BigDecimal salarioMinimo)
    {
        this.salarioMinimo = salarioMinimo;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public Long getNivelAcademico()
    {
        return nivelAcademico;
    }

    public void setNivelAcademico(Long nivelAcademico)
    {
        this.nivelAcademico = nivelAcademico;
    }

    public Long getCondicion()
    {
        return condicion;
    }

    public void setCondicion(Long condicion)
    {
        this.condicion = condicion;
    }

    public Long getJefatura()
    {
        return jefatura;
    }

    public void setJefatura(Long jefatura)
    {
        this.jefatura = jefatura;
    }

    @XmlTransient
    public List<Concurso> getConcursoList()
    {
        return concursoList;
    }

    public void setConcursoList(List<Concurso> concursoList)
    {
        this.concursoList = concursoList;
    }

    @XmlTransient
    public List<PuestoEmpleado> getPuestoEmpleadoList()
    {
        return puestoEmpleadoList;
    }

    public void setPuestoEmpleadoList(List<PuestoEmpleado> puestoEmpleadoList)
    {
        this.puestoEmpleadoList = puestoEmpleadoList;
    }

    public TipoPuesto getTipoPuesto()
    {
        return tipoPuesto;
    }

    public void setTipoPuesto(TipoPuesto tipoPuesto)
    {
        this.tipoPuesto = tipoPuesto;
    }

    public RangoEdad getRangoEdad()
    {
        return rangoEdad;
    }

    public void setRangoEdad(RangoEdad rangoEdad)
    {
        this.rangoEdad = rangoEdad;
    }

    public RangoAniosExperiencia getRangoAnios()
    {
        return rangoAnios;
    }

    public void setRangoAnios(RangoAniosExperiencia rangoAnios)
    {
        this.rangoAnios = rangoAnios;
    }

    @XmlTransient
    public List<CriteriosXPuesto> getCriteriosXPuestoList()
    {
        return criteriosXPuestoList;
    }

    public void setCriteriosXPuestoList(List<CriteriosXPuesto> criteriosXPuestoList)
    {
        this.criteriosXPuestoList = criteriosXPuestoList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (puestoPK != null ? puestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puesto))
            {
            return false;
            }
        Puesto other = (Puesto) object;
        if ((this.puestoPK == null && other.puestoPK != null) || (this.puestoPK != null && !this.puestoPK.equals(other.puestoPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Puesto[ puestoPK=" + puestoPK + " ]";
    }
    
}
