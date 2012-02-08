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
@Table(name = "SUBSIDIO_ISSS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubsidioIsss.findAll", query = "SELECT s FROM SubsidioIsss s"),
    @NamedQuery(name = "SubsidioIsss.findByCodCia", query = "SELECT s FROM SubsidioIsss s WHERE s.subsidioIsssPK.codCia = :codCia"),
    @NamedQuery(name = "SubsidioIsss.findByCodTipopla", query = "SELECT s FROM SubsidioIsss s WHERE s.subsidioIsssPK.codTipopla = :codTipopla"),
    @NamedQuery(name = "SubsidioIsss.findByAnio", query = "SELECT s FROM SubsidioIsss s WHERE s.subsidioIsssPK.anio = :anio"),
    @NamedQuery(name = "SubsidioIsss.findByMes", query = "SELECT s FROM SubsidioIsss s WHERE s.subsidioIsssPK.mes = :mes"),
    @NamedQuery(name = "SubsidioIsss.findByNumPlanilla", query = "SELECT s FROM SubsidioIsss s WHERE s.subsidioIsssPK.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "SubsidioIsss.findByCodEmp", query = "SELECT s FROM SubsidioIsss s WHERE s.subsidioIsssPK.codEmp = :codEmp"),
    @NamedQuery(name = "SubsidioIsss.findByNumdias", query = "SELECT s FROM SubsidioIsss s WHERE s.numdias = :numdias"),
    @NamedQuery(name = "SubsidioIsss.findByValor", query = "SELECT s FROM SubsidioIsss s WHERE s.valor = :valor")})
public class SubsidioIsss implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubsidioIsssPK subsidioIsssPK;
    @Column(name = "NUMDIAS")
    private Short numdias;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR", precision = 16, scale = 2)
    private BigDecimal valor;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOPLA", referencedColumnName = "COD_TIPOPLA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ANIO", referencedColumnName = "ANIO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "MES", referencedColumnName = "MES", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "NUM_PLANILLA", referencedColumnName = "NUM_PLANILLA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private ResumenAsistencia resumenAsistencia;

    public SubsidioIsss() {
    }

    public SubsidioIsss(SubsidioIsssPK subsidioIsssPK) {
        this.subsidioIsssPK = subsidioIsssPK;
    }

    public SubsidioIsss(short codCia, short codTipopla, short anio, short mes, short numPlanilla, int codEmp) {
        this.subsidioIsssPK = new SubsidioIsssPK(codCia, codTipopla, anio, mes, numPlanilla, codEmp);
    }

    public SubsidioIsssPK getSubsidioIsssPK() {
        return subsidioIsssPK;
    }

    public void setSubsidioIsssPK(SubsidioIsssPK subsidioIsssPK) {
        this.subsidioIsssPK = subsidioIsssPK;
    }

    public Short getNumdias() {
        return numdias;
    }

    public void setNumdias(Short numdias) {
        this.numdias = numdias;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public ResumenAsistencia getResumenAsistencia() {
        return resumenAsistencia;
    }

    public void setResumenAsistencia(ResumenAsistencia resumenAsistencia) {
        this.resumenAsistencia = resumenAsistencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subsidioIsssPK != null ? subsidioIsssPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubsidioIsss)) {
            return false;
        }
        SubsidioIsss other = (SubsidioIsss) object;
        if ((this.subsidioIsssPK == null && other.subsidioIsssPK != null) || (this.subsidioIsssPK != null && !this.subsidioIsssPK.equals(other.subsidioIsssPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.SubsidioIsss[ subsidioIsssPK=" + subsidioIsssPK + " ]";
    }
    
}
