/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "EVALUADOR", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluador.findAll", query = "SELECT e FROM Evaluador e"),
    @NamedQuery(name = "Evaluador.findByCodCia", query = "SELECT e FROM Evaluador e WHERE e.evaluadorPK.codCia = :codCia"),
    @NamedQuery(name = "Evaluador.findByCodEmp", query = "SELECT e FROM Evaluador e WHERE e.evaluadorPK.codEmp = :codEmp"),
    @NamedQuery(name = "Evaluador.findByPeriodo", query = "SELECT e FROM Evaluador e WHERE e.evaluadorPK.periodo = :periodo"),
    @NamedQuery(name = "Evaluador.findByCampania", query = "SELECT e FROM Evaluador e WHERE e.evaluadorPK.campania = :campania"),
    @NamedQuery(name = "Evaluador.findByTipoEvaluacion", query = "SELECT e FROM Evaluador e WHERE e.evaluadorPK.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "Evaluador.findByPlantilla", query = "SELECT e FROM Evaluador e WHERE e.evaluadorPK.plantilla = :plantilla")})
public class Evaluador implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluadorPK evaluadorPK;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CAMPANIA", referencedColumnName = "COD_CAMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_EVALUACION", referencedColumnName = "TIPO_EVALUACION", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PLANTILLA", referencedColumnName = "PLANTILLA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PreEvaluacion preEvaluacion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @Column(name = "CRITERIO_EVALUACION", length = 1)
    private String criterioEvaluacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluador1")
    private List<Evaluado> evaluadoList;
    @Transient
    private Integer cantidad;
    @Column(name = "DEPARTAMENTO", length = 1)
    private Short departamento;
    
    public Evaluador() {
    }
    
    public Integer getCantidad() {
        if ( evaluadoList==null ){
            return 0;
        }
        cantidad = evaluadoList.size();
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public Evaluador(EvaluadorPK evaluadorPK) {
        this.evaluadorPK = evaluadorPK;
    }

    public Evaluador(PreEvaluacion preEvaluacion, Empleados e) {
        this.evaluadorPK = new EvaluadorPK(preEvaluacion, e);
        this.empleados = e;
        this.preEvaluacion = preEvaluacion;
    }

    public Evaluador(long codCia, long codEmp, long periodo, long campania, long tipoEvaluacion, long plantilla) {
        this.evaluadorPK = new EvaluadorPK(codCia, codEmp, periodo, campania, tipoEvaluacion, plantilla);
    }

    public EvaluadorPK getEvaluadorPK() {
        return evaluadorPK;
    }

    public void setEvaluadorPK(EvaluadorPK evaluadorPK) {
        this.evaluadorPK = evaluadorPK;
    }

    public PreEvaluacion getPreEvaluacion() {
        return preEvaluacion;
    }

    public void setPreEvaluacion(PreEvaluacion preEvaluacion) {
        this.preEvaluacion = preEvaluacion;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCriterioEvaluacion() {
        return criterioEvaluacion;
    }

    public void setCriterioEvaluacion(String criterioEvaluacion) {
        this.criterioEvaluacion = criterioEvaluacion;
    }

    public List<Evaluado> getEvaluadoList() {
        return evaluadoList;
    }

    public void setEvaluadoList(List<Evaluado> evaluadoList) {
        this.evaluadoList = evaluadoList;
    }

    public Short getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Short departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluadorPK != null ? evaluadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluador)) {
            return false;
        }
        Evaluador other = (Evaluador) object;
        if ((this.evaluadorPK == null && other.evaluadorPK != null) || (this.evaluadorPK != null && !this.evaluadorPK.equals(other.evaluadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Evaluador[ evaluadorPK=" + evaluadorPK + " ]";
    }
}
