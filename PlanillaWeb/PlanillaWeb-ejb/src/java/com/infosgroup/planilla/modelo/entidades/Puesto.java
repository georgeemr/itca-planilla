/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "puesto")
@XmlRootElement
@NamedQueries({
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
    @NamedQuery(name = "Puesto.findByJefatura", query = "SELECT p FROM Puesto p WHERE p.jefatura = :jefatura")})
public class Puesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PuestoPK puestoPK;
    @Size(max = 2147483647)
    @Column(name = "nombre", length = 2147483647)
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario_maximo", precision = 17, scale = 17)
    private Double salarioMaximo;
    @Column(name = "salario_minimo", precision = 17, scale = 17)
    private Double salarioMinimo;
    @Size(max = 2147483647)
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @Size(max = 1)
    @Column(name = "estado", length = 1)
    private String estado;
    @Size(max = 1)
    @Column(name = "genero", length = 1)
    private String genero;
    @Column(name = "nivel_academico")
    private Integer nivelAcademico;
    @Column(name = "condicion")
    private Integer condicion;
    @Size(max = 2)
    @Column(name = "jefatura", length = 2)
    private String jefatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puesto")
    private List<Concurso> concursoList;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "tipo", referencedColumnName = "cod_tipo_puesto")})
    @ManyToOne(optional = false)
    private TipoPuesto tipoPuesto;
    @JoinColumn(name = "rango_edad", referencedColumnName = "cod_rango_edad")
    @ManyToOne
    private RangoEdad rangoEdad;
    @JoinColumn(name = "rango_anios", referencedColumnName = "cod_rango_anios")
    @ManyToOne
    private RangoAniosExperiencia rangoAnios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puesto1")
    private List<CriteriosXPuesto> criteriosXPuestoList;

    public Puesto() {
    }

    public Puesto(PuestoPK puestoPK) {
        this.puestoPK = puestoPK;
    }

    public Puesto(int codCia, int codPuesto) {
        this.puestoPK = new PuestoPK(codCia, codPuesto);
    }

    public PuestoPK getPuestoPK() {
        return puestoPK;
    }

    public void setPuestoPK(PuestoPK puestoPK) {
        this.puestoPK = puestoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(Double salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }

    public Double getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(Double salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(Integer nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public Integer getCondicion() {
        return condicion;
    }

    public void setCondicion(Integer condicion) {
        this.condicion = condicion;
    }

    public String getJefatura() {
        return jefatura;
    }

    public void setJefatura(String jefatura) {
        this.jefatura = jefatura;
    }

    @XmlTransient
    public List<Concurso> getConcursoList() {
        return concursoList;
    }

    public void setConcursoList(List<Concurso> concursoList) {
        this.concursoList = concursoList;
    }

    public TipoPuesto getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(TipoPuesto tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }

    public RangoEdad getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(RangoEdad rangoEdad) {
        this.rangoEdad = rangoEdad;
    }

    public RangoAniosExperiencia getRangoAnios() {
        return rangoAnios;
    }

    public void setRangoAnios(RangoAniosExperiencia rangoAnios) {
        this.rangoAnios = rangoAnios;
    }

    @XmlTransient
    public List<CriteriosXPuesto> getCriteriosXPuestoList() {
        return criteriosXPuestoList;
    }

    public void setCriteriosXPuestoList(List<CriteriosXPuesto> criteriosXPuestoList) {
        this.criteriosXPuestoList = criteriosXPuestoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puestoPK != null ? puestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puesto)) {
            return false;
        }
        Puesto other = (Puesto) object;
        if ((this.puestoPK == null && other.puestoPK != null) || (this.puestoPK != null && !this.puestoPK.equals(other.puestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Puesto[ puestoPK=" + puestoPK + " ]";
    }
    
}
