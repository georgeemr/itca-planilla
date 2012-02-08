/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "RECALCULO_RETENCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecalculoRetencion.findAll", query = "SELECT r FROM RecalculoRetencion r"),
    @NamedQuery(name = "RecalculoRetencion.findByCodCia", query = "SELECT r FROM RecalculoRetencion r WHERE r.recalculoRetencionPK.codCia = :codCia"),
    @NamedQuery(name = "RecalculoRetencion.findByCodEmp", query = "SELECT r FROM RecalculoRetencion r WHERE r.recalculoRetencionPK.codEmp = :codEmp"),
    @NamedQuery(name = "RecalculoRetencion.findByAnio", query = "SELECT r FROM RecalculoRetencion r WHERE r.recalculoRetencionPK.anio = :anio"),
    @NamedQuery(name = "RecalculoRetencion.findByMes", query = "SELECT r FROM RecalculoRetencion r WHERE r.recalculoRetencionPK.mes = :mes"),
    @NamedQuery(name = "RecalculoRetencion.findByTipoRecalculo", query = "SELECT r FROM RecalculoRetencion r WHERE r.tipoRecalculo = :tipoRecalculo"),
    @NamedQuery(name = "RecalculoRetencion.findByValIngresos", query = "SELECT r FROM RecalculoRetencion r WHERE r.valIngresos = :valIngresos"),
    @NamedQuery(name = "RecalculoRetencion.findByValRetenido", query = "SELECT r FROM RecalculoRetencion r WHERE r.valRetenido = :valRetenido"),
    @NamedQuery(name = "RecalculoRetencion.findByValRecalculo", query = "SELECT r FROM RecalculoRetencion r WHERE r.valRecalculo = :valRecalculo"),
    @NamedQuery(name = "RecalculoRetencion.findByDifRetenido", query = "SELECT r FROM RecalculoRetencion r WHERE r.difRetenido = :difRetenido"),
    @NamedQuery(name = "RecalculoRetencion.findByStatus", query = "SELECT r FROM RecalculoRetencion r WHERE r.status = :status"),
    @NamedQuery(name = "RecalculoRetencion.findByFecStatus", query = "SELECT r FROM RecalculoRetencion r WHERE r.fecStatus = :fecStatus"),
    @NamedQuery(name = "RecalculoRetencion.findByUsuario", query = "SELECT r FROM RecalculoRetencion r WHERE r.usuario = :usuario"),
    @NamedQuery(name = "RecalculoRetencion.findByOtrosIngresos", query = "SELECT r FROM RecalculoRetencion r WHERE r.otrosIngresos = :otrosIngresos"),
    @NamedQuery(name = "RecalculoRetencion.findByOtrasRetenciones", query = "SELECT r FROM RecalculoRetencion r WHERE r.otrasRetenciones = :otrasRetenciones"),
    @NamedQuery(name = "RecalculoRetencion.findByValAfp", query = "SELECT r FROM RecalculoRetencion r WHERE r.valAfp = :valAfp")})
public class RecalculoRetencion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecalculoRetencionPK recalculoRetencionPK;
    @Column(name = "TIPO_RECALCULO")
    private Short tipoRecalculo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VAL_INGRESOS", precision = 16, scale = 2)
    private BigDecimal valIngresos;
    @Column(name = "VAL_RETENIDO", precision = 16, scale = 2)
    private BigDecimal valRetenido;
    @Column(name = "VAL_RECALCULO", precision = 16, scale = 2)
    private BigDecimal valRecalculo;
    @Column(name = "DIF_RETENIDO", precision = 16, scale = 2)
    private BigDecimal difRetenido;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "FEC_STATUS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecStatus;
    @Column(name = "USUARIO", length = 30)
    private String usuario;
    @Column(name = "OTROS_INGRESOS", precision = 16, scale = 2)
    private BigDecimal otrosIngresos;
    @Column(name = "OTRAS_RETENCIONES", precision = 16, scale = 2)
    private BigDecimal otrasRetenciones;
    @Column(name = "VAL_AFP", precision = 16, scale = 2)
    private BigDecimal valAfp;

    public RecalculoRetencion() {
    }

    public RecalculoRetencion(RecalculoRetencionPK recalculoRetencionPK) {
        this.recalculoRetencionPK = recalculoRetencionPK;
    }

    public RecalculoRetencion(short codCia, int codEmp, short anio, short mes) {
        this.recalculoRetencionPK = new RecalculoRetencionPK(codCia, codEmp, anio, mes);
    }

    public RecalculoRetencionPK getRecalculoRetencionPK() {
        return recalculoRetencionPK;
    }

    public void setRecalculoRetencionPK(RecalculoRetencionPK recalculoRetencionPK) {
        this.recalculoRetencionPK = recalculoRetencionPK;
    }

    public Short getTipoRecalculo() {
        return tipoRecalculo;
    }

    public void setTipoRecalculo(Short tipoRecalculo) {
        this.tipoRecalculo = tipoRecalculo;
    }

    public BigDecimal getValIngresos() {
        return valIngresos;
    }

    public void setValIngresos(BigDecimal valIngresos) {
        this.valIngresos = valIngresos;
    }

    public BigDecimal getValRetenido() {
        return valRetenido;
    }

    public void setValRetenido(BigDecimal valRetenido) {
        this.valRetenido = valRetenido;
    }

    public BigDecimal getValRecalculo() {
        return valRecalculo;
    }

    public void setValRecalculo(BigDecimal valRecalculo) {
        this.valRecalculo = valRecalculo;
    }

    public BigDecimal getDifRetenido() {
        return difRetenido;
    }

    public void setDifRetenido(BigDecimal difRetenido) {
        this.difRetenido = difRetenido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFecStatus() {
        return fecStatus;
    }

    public void setFecStatus(Date fecStatus) {
        this.fecStatus = fecStatus;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getOtrosIngresos() {
        return otrosIngresos;
    }

    public void setOtrosIngresos(BigDecimal otrosIngresos) {
        this.otrosIngresos = otrosIngresos;
    }

    public BigDecimal getOtrasRetenciones() {
        return otrasRetenciones;
    }

    public void setOtrasRetenciones(BigDecimal otrasRetenciones) {
        this.otrasRetenciones = otrasRetenciones;
    }

    public BigDecimal getValAfp() {
        return valAfp;
    }

    public void setValAfp(BigDecimal valAfp) {
        this.valAfp = valAfp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recalculoRetencionPK != null ? recalculoRetencionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecalculoRetencion)) {
            return false;
        }
        RecalculoRetencion other = (RecalculoRetencion) object;
        if ((this.recalculoRetencionPK == null && other.recalculoRetencionPK != null) || (this.recalculoRetencionPK != null && !this.recalculoRetencionPK.equals(other.recalculoRetencionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.RecalculoRetencion[ recalculoRetencionPK=" + recalculoRetencionPK + " ]";
    }
    
}
