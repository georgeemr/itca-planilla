/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "FIRMAS_PLANILLA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FirmasPlanilla.findAll", query = "SELECT f FROM FirmasPlanilla f"),
    @NamedQuery(name = "FirmasPlanilla.findByCodCia", query = "SELECT f FROM FirmasPlanilla f WHERE f.firmasPlanillaPK.codCia = :codCia"),
    @NamedQuery(name = "FirmasPlanilla.findByCodFirma", query = "SELECT f FROM FirmasPlanilla f WHERE f.firmasPlanillaPK.codFirma = :codFirma"),
    @NamedQuery(name = "FirmasPlanilla.findByFechaDesde", query = "SELECT f FROM FirmasPlanilla f WHERE f.firmasPlanillaPK.fechaDesde = :fechaDesde"),
    @NamedQuery(name = "FirmasPlanilla.findByFechaHasta", query = "SELECT f FROM FirmasPlanilla f WHERE f.firmasPlanillaPK.fechaHasta = :fechaHasta"),
    @NamedQuery(name = "FirmasPlanilla.findByFirma", query = "SELECT f FROM FirmasPlanilla f WHERE f.firma = :firma"),
    @NamedQuery(name = "FirmasPlanilla.findByPuesto", query = "SELECT f FROM FirmasPlanilla f WHERE f.puesto = :puesto")})
public class FirmasPlanilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FirmasPlanillaPK firmasPlanillaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FIRMA", nullable = false, length = 100)
    private String firma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PUESTO", nullable = false, length = 100)
    private String puesto;

    public FirmasPlanilla() {
    }

    public FirmasPlanilla(FirmasPlanillaPK firmasPlanillaPK) {
        this.firmasPlanillaPK = firmasPlanillaPK;
    }

    public FirmasPlanilla(FirmasPlanillaPK firmasPlanillaPK, String firma, String puesto) {
        this.firmasPlanillaPK = firmasPlanillaPK;
        this.firma = firma;
        this.puesto = puesto;
    }

    public FirmasPlanilla(short codCia, short codFirma, Date fechaDesde, Date fechaHasta) {
        this.firmasPlanillaPK = new FirmasPlanillaPK(codCia, codFirma, fechaDesde, fechaHasta);
    }

    public FirmasPlanillaPK getFirmasPlanillaPK() {
        return firmasPlanillaPK;
    }

    public void setFirmasPlanillaPK(FirmasPlanillaPK firmasPlanillaPK) {
        this.firmasPlanillaPK = firmasPlanillaPK;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (firmasPlanillaPK != null ? firmasPlanillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FirmasPlanilla)) {
            return false;
        }
        FirmasPlanilla other = (FirmasPlanilla) object;
        if ((this.firmasPlanillaPK == null && other.firmasPlanillaPK != null) || (this.firmasPlanillaPK != null && !this.firmasPlanillaPK.equals(other.firmasPlanillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.FirmasPlanilla[ firmasPlanillaPK=" + firmasPlanillaPK + " ]";
    }
    
}
