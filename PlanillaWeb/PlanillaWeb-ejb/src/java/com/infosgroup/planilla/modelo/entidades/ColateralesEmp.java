/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "COLATERALES_EMP", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColateralesEmp.findAll", query = "SELECT c FROM ColateralesEmp c"),
    @NamedQuery(name = "ColateralesEmp.findByCodCia", query = "SELECT c FROM ColateralesEmp c WHERE c.colateralesEmpPK.codCia = :codCia"),
    @NamedQuery(name = "ColateralesEmp.findByCodEmp", query = "SELECT c FROM ColateralesEmp c WHERE c.colateralesEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "ColateralesEmp.findByNivelAcademico", query = "SELECT c FROM ColateralesEmp c WHERE c.nivelAcademico = :nivelAcademico"),
    @NamedQuery(name = "ColateralesEmp.findByMeritosProf", query = "SELECT c FROM ColateralesEmp c WHERE c.meritosProf = :meritosProf"),
    @NamedQuery(name = "ColateralesEmp.findByAniosServicio", query = "SELECT c FROM ColateralesEmp c WHERE c.aniosServicio = :aniosServicio"),
    @NamedQuery(name = "ColateralesEmp.findByValorCarrera", query = "SELECT c FROM ColateralesEmp c WHERE c.valorCarrera = :valorCarrera"),
    @NamedQuery(name = "ColateralesEmp.findByColectivo", query = "SELECT c FROM ColateralesEmp c WHERE c.colectivo = :colectivo"),
    @NamedQuery(name = "ColateralesEmp.findByDerechosAdquiridos", query = "SELECT c FROM ColateralesEmp c WHERE c.derechosAdquiridos = :derechosAdquiridos")})
public class ColateralesEmp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ColateralesEmpPK colateralesEmpPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NIVEL_ACADEMICO", precision = 16, scale = 2)
    private BigDecimal nivelAcademico;
    @Column(name = "MERITOS_PROF", precision = 16, scale = 2)
    private BigDecimal meritosProf;
    @Column(name = "ANIOS_SERVICIO", precision = 16, scale = 2)
    private BigDecimal aniosServicio;
    @Column(name = "VALOR_CARRERA", precision = 16, scale = 2)
    private BigDecimal valorCarrera;
    @Column(name = "COLECTIVO", precision = 16, scale = 2)
    private BigDecimal colectivo;
    @Column(name = "DERECHOS_ADQUIRIDOS", precision = 16, scale = 2)
    private BigDecimal derechosAdquiridos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Empleados empleados;

    public ColateralesEmp() {
    }

    public ColateralesEmp(ColateralesEmpPK colateralesEmpPK) {
        this.colateralesEmpPK = colateralesEmpPK;
    }

    public ColateralesEmp(short codCia, int codEmp) {
        this.colateralesEmpPK = new ColateralesEmpPK(codCia, codEmp);
    }

    public ColateralesEmpPK getColateralesEmpPK() {
        return colateralesEmpPK;
    }

    public void setColateralesEmpPK(ColateralesEmpPK colateralesEmpPK) {
        this.colateralesEmpPK = colateralesEmpPK;
    }

    public BigDecimal getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(BigDecimal nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public BigDecimal getMeritosProf() {
        return meritosProf;
    }

    public void setMeritosProf(BigDecimal meritosProf) {
        this.meritosProf = meritosProf;
    }

    public BigDecimal getAniosServicio() {
        return aniosServicio;
    }

    public void setAniosServicio(BigDecimal aniosServicio) {
        this.aniosServicio = aniosServicio;
    }

    public BigDecimal getValorCarrera() {
        return valorCarrera;
    }

    public void setValorCarrera(BigDecimal valorCarrera) {
        this.valorCarrera = valorCarrera;
    }

    public BigDecimal getColectivo() {
        return colectivo;
    }

    public void setColectivo(BigDecimal colectivo) {
        this.colectivo = colectivo;
    }

    public BigDecimal getDerechosAdquiridos() {
        return derechosAdquiridos;
    }

    public void setDerechosAdquiridos(BigDecimal derechosAdquiridos) {
        this.derechosAdquiridos = derechosAdquiridos;
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
        hash += (colateralesEmpPK != null ? colateralesEmpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColateralesEmp)) {
            return false;
        }
        ColateralesEmp other = (ColateralesEmp) object;
        if ((this.colateralesEmpPK == null && other.colateralesEmpPK != null) || (this.colateralesEmpPK != null && !this.colateralesEmpPK.equals(other.colateralesEmpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ColateralesEmp[ colateralesEmpPK=" + colateralesEmpPK + " ]";
    }
    
}
