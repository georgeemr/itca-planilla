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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "GASTO_X_CAPACITACION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GastoXCapacitacion.findAll", query = "SELECT g FROM GastoXCapacitacion g"),
    @NamedQuery(name = "GastoXCapacitacion.findByCodCia", query = "SELECT g FROM GastoXCapacitacion g WHERE g.gastoXCapacitacionPK.codCia = :codCia"),
    @NamedQuery(name = "GastoXCapacitacion.findByCodCapacitacion", query = "SELECT g FROM GastoXCapacitacion g WHERE g.gastoXCapacitacionPK.codCapacitacion = :codCapacitacion"),
    @NamedQuery(name = "GastoXCapacitacion.findByCorrelativo", query = "SELECT g FROM GastoXCapacitacion g WHERE g.gastoXCapacitacionPK.correlativo = :correlativo"),
    @NamedQuery(name = "GastoXCapacitacion.findByDesGasto", query = "SELECT g FROM GastoXCapacitacion g WHERE g.desGasto = :desGasto"),
    @NamedQuery(name = "GastoXCapacitacion.findByGasto", query = "SELECT g FROM GastoXCapacitacion g WHERE g.gasto = :gasto")})
public class GastoXCapacitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GastoXCapacitacionPK gastoXCapacitacionPK;
    @Size(max = 100)
    @Column(name = "DES_GASTO", length = 100)
    private String desGasto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GASTO", precision = 6, scale = 2)
    private BigDecimal gasto;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CAPACITACION", referencedColumnName = "COD_CAPACITACION", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Capacitacion capacitacion;

    public GastoXCapacitacion() {
    }

    public GastoXCapacitacion(GastoXCapacitacionPK gastoXCapacitacionPK) {
        this.gastoXCapacitacionPK = gastoXCapacitacionPK;
    }

    public GastoXCapacitacion(short codCia, int codCapacitacion, int correlativo) {
        this.gastoXCapacitacionPK = new GastoXCapacitacionPK(codCia, codCapacitacion, correlativo);
    }

    public GastoXCapacitacionPK getGastoXCapacitacionPK() {
        return gastoXCapacitacionPK;
    }

    public void setGastoXCapacitacionPK(GastoXCapacitacionPK gastoXCapacitacionPK) {
        this.gastoXCapacitacionPK = gastoXCapacitacionPK;
    }

    public String getDesGasto() {
        return desGasto;
    }

    public void setDesGasto(String desGasto) {
        this.desGasto = desGasto;
    }

    public BigDecimal getGasto() {
        return gasto;
    }

    public void setGasto(BigDecimal gasto) {
        this.gasto = gasto;
    }

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gastoXCapacitacionPK != null ? gastoXCapacitacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastoXCapacitacion)) {
            return false;
        }
        GastoXCapacitacion other = (GastoXCapacitacion) object;
        if ((this.gastoXCapacitacionPK == null && other.gastoXCapacitacionPK != null) || (this.gastoXCapacitacionPK != null && !this.gastoXCapacitacionPK.equals(other.gastoXCapacitacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.GastoXCapacitacion[ gastoXCapacitacionPK=" + gastoXCapacitacionPK + " ]";
    }
    
}
