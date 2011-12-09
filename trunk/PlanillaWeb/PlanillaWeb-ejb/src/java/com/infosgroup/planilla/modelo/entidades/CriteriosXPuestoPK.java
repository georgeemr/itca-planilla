/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class CriteriosXPuestoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cia", nullable = false)
    private int codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puesto", nullable = false)
    private int puesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "criterio", nullable = false)
    private int criterio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correlativo", nullable = false)
    private int correlativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_criterio", nullable = false)
    private int tipoCriterio;
    @Transient
    private String pkAsString;

    public CriteriosXPuestoPK() {
    }

    public CriteriosXPuestoPK(int codCia, int puesto, int criterio, int correlativo, int tipoCriterio) {
        this.codCia = codCia;
        this.puesto = puesto;
        this.criterio = criterio;
        this.correlativo = correlativo;
        this.tipoCriterio = tipoCriterio;
    }

    public int getCodCia() {
        return codCia;
    }

    public void setCodCia(int codCia) {
        this.codCia = codCia;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public int getCriterio() {
        return criterio;
    }

    public void setCriterio(int criterio) {
        this.criterio = criterio;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public int getTipoCriterio() {
        return tipoCriterio;
    }

    public void setTipoCriterio(int tipoCriterio) {
        this.tipoCriterio = tipoCriterio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) puesto;
        hash += (int) criterio;
        hash += (int) correlativo;
        hash += (int) tipoCriterio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosXPuestoPK)) {
            return false;
        }
        CriteriosXPuestoPK other = (CriteriosXPuestoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.puesto != other.puesto) {
            return false;
        }
        if (this.criterio != other.criterio) {
            return false;
        }
        if (this.correlativo != other.correlativo) {
            return false;
        }
        if (this.tipoCriterio != other.tipoCriterio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.CriteriosXPuestoPK[ codCia=" + codCia + ", puesto=" + puesto + ", criterio=" + criterio + ", correlativo=" + correlativo + ", tipoCriterio=" + tipoCriterio + " ]";
    }

    public String getPkAsString() {
        pkAsString = "" + codCia + ":" + puesto + ":" + criterio + ":" + correlativo + ":" + tipoCriterio;
        return pkAsString;
    }

    public void setPkAsString(String pkAsString) {
        this.pkAsString = pkAsString;
    }
}
