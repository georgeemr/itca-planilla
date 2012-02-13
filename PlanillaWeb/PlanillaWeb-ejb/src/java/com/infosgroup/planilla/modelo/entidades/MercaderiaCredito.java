/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "MERCADERIA_CREDITO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MercaderiaCredito.findAll", query = "SELECT m FROM MercaderiaCredito m"),
    @NamedQuery(name = "MercaderiaCredito.findByCodCia", query = "SELECT m FROM MercaderiaCredito m WHERE m.mercaderiaCreditoPK.codCia = :codCia"),
    @NamedQuery(name = "MercaderiaCredito.findByAnio", query = "SELECT m FROM MercaderiaCredito m WHERE m.mercaderiaCreditoPK.anio = :anio"),
    @NamedQuery(name = "MercaderiaCredito.findByMes", query = "SELECT m FROM MercaderiaCredito m WHERE m.mercaderiaCreditoPK.mes = :mes"),
    @NamedQuery(name = "MercaderiaCredito.findByCredito", query = "SELECT m FROM MercaderiaCredito m WHERE m.mercaderiaCreditoPK.credito = :credito"),
    @NamedQuery(name = "MercaderiaCredito.findByFechaInicial", query = "SELECT m FROM MercaderiaCredito m WHERE m.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "MercaderiaCredito.findByFechaFinal", query = "SELECT m FROM MercaderiaCredito m WHERE m.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "MercaderiaCredito.findByNumPlanilla", query = "SELECT m FROM MercaderiaCredito m WHERE m.numPlanilla = :numPlanilla"),
    @NamedQuery(name = "MercaderiaCredito.findByCodTipopla", query = "SELECT m FROM MercaderiaCredito m WHERE m.codTipopla = :codTipopla"),
    @NamedQuery(name = "MercaderiaCredito.findByEstado", query = "SELECT m FROM MercaderiaCredito m WHERE m.estado = :estado")})
public class MercaderiaCredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MercaderiaCreditoPK mercaderiaCreditoPK;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicial;
    @Basic(optional = false)
    @Column(name = "FECHA_FINAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Column(name = "NUM_PLANILLA")
    private Short numPlanilla;
    @Column(name = "COD_TIPOPLA")
    private Short codTipopla;
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mercaderiaCredito")
    private List<DetMercaderiaCredito> detMercaderiaCreditoList;

    public MercaderiaCredito() {
    }

    public MercaderiaCredito(MercaderiaCreditoPK mercaderiaCreditoPK) {
        this.mercaderiaCreditoPK = mercaderiaCreditoPK;
    }

    public MercaderiaCredito(MercaderiaCreditoPK mercaderiaCreditoPK, Date fechaInicial, Date fechaFinal) {
        this.mercaderiaCreditoPK = mercaderiaCreditoPK;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public MercaderiaCredito(short codCia, short anio, short mes, int credito) {
        this.mercaderiaCreditoPK = new MercaderiaCreditoPK(codCia, anio, mes, credito);
    }

    public MercaderiaCreditoPK getMercaderiaCreditoPK() {
        return mercaderiaCreditoPK;
    }

    public void setMercaderiaCreditoPK(MercaderiaCreditoPK mercaderiaCreditoPK) {
        this.mercaderiaCreditoPK = mercaderiaCreditoPK;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Short getNumPlanilla() {
        return numPlanilla;
    }

    public void setNumPlanilla(Short numPlanilla) {
        this.numPlanilla = numPlanilla;
    }

    public Short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(Short codTipopla) {
        this.codTipopla = codTipopla;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<DetMercaderiaCredito> getDetMercaderiaCreditoList() {
        return detMercaderiaCreditoList;
    }

    public void setDetMercaderiaCreditoList(List<DetMercaderiaCredito> detMercaderiaCreditoList) {
        this.detMercaderiaCreditoList = detMercaderiaCreditoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mercaderiaCreditoPK != null ? mercaderiaCreditoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MercaderiaCredito)) {
            return false;
        }
        MercaderiaCredito other = (MercaderiaCredito) object;
        if ((this.mercaderiaCreditoPK == null && other.mercaderiaCreditoPK != null) || (this.mercaderiaCreditoPK != null && !this.mercaderiaCreditoPK.equals(other.mercaderiaCreditoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.MercaderiaCredito[ mercaderiaCreditoPK=" + mercaderiaCreditoPK + " ]";
    }
    
}
