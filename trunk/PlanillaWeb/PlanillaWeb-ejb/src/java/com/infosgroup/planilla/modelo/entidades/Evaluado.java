/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "EVALUADO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluado.findAll", query = "SELECT e FROM Evaluado e"),
    @NamedQuery(name = "Evaluado.findByCodCia", query = "SELECT e FROM Evaluado e WHERE e.evaluadoPK.codCia = :codCia"),
    @NamedQuery(name = "Evaluado.findByEvaluador", query = "SELECT e FROM Evaluado e WHERE e.evaluadoPK.evaluador = :evaluador"),
    @NamedQuery(name = "Evaluado.findByPeriodo", query = "SELECT e FROM Evaluado e WHERE e.evaluadoPK.periodo = :periodo"),
    @NamedQuery(name = "Evaluado.findByCampania", query = "SELECT e FROM Evaluado e WHERE e.evaluadoPK.campania = :campania"),
    @NamedQuery(name = "Evaluado.findByTipoEvaluacion", query = "SELECT e FROM Evaluado e WHERE e.evaluadoPK.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "Evaluado.findByPlantilla", query = "SELECT e FROM Evaluado e WHERE e.evaluadoPK.plantilla = :plantilla"),
    @NamedQuery(name = "Evaluado.findByCodEmp", query = "SELECT e FROM Evaluado e WHERE e.evaluadoPK.codEmp = :codEmp")})
public class Evaluado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluadoPK evaluadoPK;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "EVALUADOR", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PERIODO", referencedColumnName = "PERIODO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CAMPANIA", referencedColumnName = "CAMPANIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_EVALUACION", referencedColumnName = "TIPO_EVALUACION", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PLANTILLA", referencedColumnName = "PLANTILLA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Evaluador evaluador1;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public Evaluado() {
    }

    public Evaluado(EvaluadoPK evaluadoPK) {
        this.evaluadoPK = evaluadoPK;
    }
    
    public Evaluado(Evaluador evaluador, Empleados evaluado){
        this.evaluador1 = evaluador;
        this.empleados = evaluado;
        this.evaluadoPK = 
            new EvaluadoPK(evaluador.getEmpleados().getEmpleadosPK().getCodCia(), 
                evaluador.getEvaluadorPK().getCodEmp(),
                evaluador.getEvaluadorPK().getPeriodo(), 
                evaluador.getEvaluadorPK().getCampania(), 
                evaluador.getEvaluadorPK().getTipoEvaluacion(), 
                evaluador.getEvaluadorPK().getPlantilla(), 
                evaluado.getEmpleadosPK().getCodEmp());
    }

    public Evaluado(long codCia, long evaluador, long periodo, long campania, long tipoEvaluacion, long plantilla, long codEmp) {
        this.evaluadoPK = new EvaluadoPK(codCia, evaluador, periodo, campania, tipoEvaluacion, plantilla, codEmp);
    }

    public EvaluadoPK getEvaluadoPK() {
        return evaluadoPK;
    }

    public void setEvaluadoPK(EvaluadoPK evaluadoPK) {
        this.evaluadoPK = evaluadoPK;
    }

    public Evaluador getEvaluador1() {
        return evaluador1;
    }

    public void setEvaluador1(Evaluador evaluador1) {
        this.evaluador1 = evaluador1;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluadoPK != null ? evaluadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluado)) {
            return false;
        }
        Evaluado other = (Evaluado) object;
        if ((this.evaluadoPK == null && other.evaluadoPK != null) || (this.evaluadoPK != null && !this.evaluadoPK.equals(other.evaluadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Evaluado[ evaluadoPK=" + evaluadoPK + " ]";
    }
    
}
