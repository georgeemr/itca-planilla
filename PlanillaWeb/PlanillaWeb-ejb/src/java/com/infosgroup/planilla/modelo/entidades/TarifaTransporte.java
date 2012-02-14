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
@Table(name = "TARIFA_TRANSPORTE", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaTransporte.findAll", query = "SELECT t FROM TarifaTransporte t"),
    @NamedQuery(name = "TarifaTransporte.findByCodCia", query = "SELECT t FROM TarifaTransporte t WHERE t.tarifaTransportePK.codCia = :codCia"),
    @NamedQuery(name = "TarifaTransporte.findByCodTarifa", query = "SELECT t FROM TarifaTransporte t WHERE t.tarifaTransportePK.codTarifa = :codTarifa"),
    @NamedQuery(name = "TarifaTransporte.findByDestino", query = "SELECT t FROM TarifaTransporte t WHERE t.destino = :destino"),
    @NamedQuery(name = "TarifaTransporte.findByValPasaje", query = "SELECT t FROM TarifaTransporte t WHERE t.valPasaje = :valPasaje"),
    @NamedQuery(name = "TarifaTransporte.findByValTransporte", query = "SELECT t FROM TarifaTransporte t WHERE t.valTransporte = :valTransporte")})
public class TarifaTransporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TarifaTransportePK tarifaTransportePK;
    @Size(max = 200)
    @Column(name = "DESTINO", length = 200)
    private String destino;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VAL_PASAJE", precision = 8, scale = 2)
    private BigDecimal valPasaje;
    @Column(name = "VAL_TRANSPORTE", precision = 8, scale = 2)
    private BigDecimal valTransporte;

    public TarifaTransporte() {
    }

    public TarifaTransporte(TarifaTransportePK tarifaTransportePK) {
        this.tarifaTransportePK = tarifaTransportePK;
    }

    public TarifaTransporte(short codCia, short codTarifa) {
        this.tarifaTransportePK = new TarifaTransportePK(codCia, codTarifa);
    }

    public TarifaTransportePK getTarifaTransportePK() {
        return tarifaTransportePK;
    }

    public void setTarifaTransportePK(TarifaTransportePK tarifaTransportePK) {
        this.tarifaTransportePK = tarifaTransportePK;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public BigDecimal getValPasaje() {
        return valPasaje;
    }

    public void setValPasaje(BigDecimal valPasaje) {
        this.valPasaje = valPasaje;
    }

    public BigDecimal getValTransporte() {
        return valTransporte;
    }

    public void setValTransporte(BigDecimal valTransporte) {
        this.valTransporte = valTransporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tarifaTransportePK != null ? tarifaTransportePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaTransporte)) {
            return false;
        }
        TarifaTransporte other = (TarifaTransporte) object;
        if ((this.tarifaTransportePK == null && other.tarifaTransportePK != null) || (this.tarifaTransportePK != null && !this.tarifaTransportePK.equals(other.tarifaTransportePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TarifaTransporte[ tarifaTransportePK=" + tarifaTransportePK + " ]";
    }
    
}
