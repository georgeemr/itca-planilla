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
@Table(name = "VIATICOS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viaticos.findAll", query = "SELECT v FROM Viaticos v"),
    @NamedQuery(name = "Viaticos.findByCodCia", query = "SELECT v FROM Viaticos v WHERE v.viaticosPK.codCia = :codCia"),
    @NamedQuery(name = "Viaticos.findByCodViatico", query = "SELECT v FROM Viaticos v WHERE v.viaticosPK.codViatico = :codViatico"),
    @NamedQuery(name = "Viaticos.findByZona", query = "SELECT v FROM Viaticos v WHERE v.zona = :zona"),
    @NamedQuery(name = "Viaticos.findByCategoria", query = "SELECT v FROM Viaticos v WHERE v.categoria = :categoria"),
    @NamedQuery(name = "Viaticos.findByValHospedajeC", query = "SELECT v FROM Viaticos v WHERE v.valHospedajeC = :valHospedajeC"),
    @NamedQuery(name = "Viaticos.findByValViaticosC", query = "SELECT v FROM Viaticos v WHERE v.valViaticosC = :valViaticosC"),
    @NamedQuery(name = "Viaticos.findByValHospedajeL", query = "SELECT v FROM Viaticos v WHERE v.valHospedajeL = :valHospedajeL"),
    @NamedQuery(name = "Viaticos.findByValViaticosL", query = "SELECT v FROM Viaticos v WHERE v.valViaticosL = :valViaticosL")})
public class Viaticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ViaticosPK viaticosPK;
    @Column(name = "ZONA")
    private Short zona;
    @Size(max = 1)
    @Column(name = "CATEGORIA", length = 1)
    private String categoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VAL_HOSPEDAJE_C", precision = 8, scale = 2)
    private BigDecimal valHospedajeC;
    @Column(name = "VAL_VIATICOS_C", precision = 8, scale = 2)
    private BigDecimal valViaticosC;
    @Column(name = "VAL_HOSPEDAJE_L", precision = 8, scale = 2)
    private BigDecimal valHospedajeL;
    @Column(name = "VAL_VIATICOS_L", precision = 8, scale = 2)
    private BigDecimal valViaticosL;

    public Viaticos() {
    }

    public Viaticos(ViaticosPK viaticosPK) {
        this.viaticosPK = viaticosPK;
    }

    public Viaticos(short codCia, short codViatico) {
        this.viaticosPK = new ViaticosPK(codCia, codViatico);
    }

    public ViaticosPK getViaticosPK() {
        return viaticosPK;
    }

    public void setViaticosPK(ViaticosPK viaticosPK) {
        this.viaticosPK = viaticosPK;
    }

    public Short getZona() {
        return zona;
    }

    public void setZona(Short zona) {
        this.zona = zona;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValHospedajeC() {
        return valHospedajeC;
    }

    public void setValHospedajeC(BigDecimal valHospedajeC) {
        this.valHospedajeC = valHospedajeC;
    }

    public BigDecimal getValViaticosC() {
        return valViaticosC;
    }

    public void setValViaticosC(BigDecimal valViaticosC) {
        this.valViaticosC = valViaticosC;
    }

    public BigDecimal getValHospedajeL() {
        return valHospedajeL;
    }

    public void setValHospedajeL(BigDecimal valHospedajeL) {
        this.valHospedajeL = valHospedajeL;
    }

    public BigDecimal getValViaticosL() {
        return valViaticosL;
    }

    public void setValViaticosL(BigDecimal valViaticosL) {
        this.valViaticosL = valViaticosL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viaticosPK != null ? viaticosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaticos)) {
            return false;
        }
        Viaticos other = (Viaticos) object;
        if ((this.viaticosPK == null && other.viaticosPK != null) || (this.viaticosPK != null && !this.viaticosPK.equals(other.viaticosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Viaticos[ viaticosPK=" + viaticosPK + " ]";
    }
    
}
