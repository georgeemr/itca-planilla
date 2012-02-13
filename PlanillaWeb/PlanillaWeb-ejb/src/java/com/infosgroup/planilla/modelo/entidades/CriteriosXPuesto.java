/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CRITERIOS_X_PUESTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriteriosXPuesto.findAll", query = "SELECT c FROM CriteriosXPuesto c"),
    @NamedQuery(name = "CriteriosXPuesto.findByCodCia", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "CriteriosXPuesto.findByPuesto", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.puesto = :puesto"),
    @NamedQuery(name = "CriteriosXPuesto.findByTipoCriterio", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.tipoCriterio = :tipoCriterio"),
    @NamedQuery(name = "CriteriosXPuesto.findByCriterio", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.criterio = :criterio"),
    @NamedQuery(name = "CriteriosXPuesto.findByCorrelativo", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.correlativo = :correlativo"),
    @NamedQuery(name = "CriteriosXPuesto.findByValor", query = "SELECT c FROM CriteriosXPuesto c WHERE c.valor = :valor"),
    @NamedQuery(name = "CriteriosXPuesto.findByValorInicialRango", query = "SELECT c FROM CriteriosXPuesto c WHERE c.valorInicialRango = :valorInicialRango"),
    @NamedQuery(name = "CriteriosXPuesto.findByValorFinalRango", query = "SELECT c FROM CriteriosXPuesto c WHERE c.valorFinalRango = :valorFinalRango")})
public class CriteriosXPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriteriosXPuestoPK criteriosXPuestoPK;
    @Column(name = "VALOR", length = 200)
    private String valor;
    @Column(name = "VALOR_INICIAL_RANGO", length = 200)
    private String valorInicialRango;
    @Column(name = "VALOR_FINAL_RANGO", length = 200)
    private String valorFinalRango;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PUESTO", referencedColumnName = "COD_PUESTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Puestos puestos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CRITERIO", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_CRITERIO", referencedColumnName = "TIPO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Criterio criterio1;

    public CriteriosXPuesto() {
    }

    public CriteriosXPuesto(CriteriosXPuestoPK criteriosXPuestoPK) {
        this.criteriosXPuestoPK = criteriosXPuestoPK;
    }

    public CriteriosXPuesto(short codCia, long puesto, long tipoCriterio, long criterio, long correlativo) {
        this.criteriosXPuestoPK = new CriteriosXPuestoPK(codCia, puesto, tipoCriterio, criterio, correlativo);
    }

    public CriteriosXPuestoPK getCriteriosXPuestoPK() {
        return criteriosXPuestoPK;
    }

    public void setCriteriosXPuestoPK(CriteriosXPuestoPK criteriosXPuestoPK) {
        this.criteriosXPuestoPK = criteriosXPuestoPK;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValorInicialRango() {
        return valorInicialRango;
    }

    public void setValorInicialRango(String valorInicialRango) {
        this.valorInicialRango = valorInicialRango;
    }

    public String getValorFinalRango() {
        return valorFinalRango;
    }

    public void setValorFinalRango(String valorFinalRango) {
        this.valorFinalRango = valorFinalRango;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    public Criterio getCriterio1() {
        return criterio1;
    }

    public void setCriterio1(Criterio criterio1) {
        this.criterio1 = criterio1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criteriosXPuestoPK != null ? criteriosXPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosXPuesto)) {
            return false;
        }
        CriteriosXPuesto other = (CriteriosXPuesto) object;
        if ((this.criteriosXPuestoPK == null && other.criteriosXPuestoPK != null) || (this.criteriosXPuestoPK != null && !this.criteriosXPuestoPK.equals(other.criteriosXPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.CriteriosXPuesto[ criteriosXPuestoPK=" + criteriosXPuestoPK + " ]";
    }
    
}
