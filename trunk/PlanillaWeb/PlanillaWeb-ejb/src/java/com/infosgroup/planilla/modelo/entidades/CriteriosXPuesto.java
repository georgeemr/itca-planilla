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

/**
 *
 * @author root
 */
@Entity
@Table(name = "criterios_x_puesto")
@NamedQueries({
    @NamedQuery(name = "CriteriosXPuesto.findAll", query = "SELECT c FROM CriteriosXPuesto c"),
    @NamedQuery(name = "CriteriosXPuesto.findByCodCia", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "CriteriosXPuesto.findByPuesto", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.puesto = :puesto"),
    @NamedQuery(name = "CriteriosXPuesto.findByCriterio", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.criterio = :criterio"),
    @NamedQuery(name = "CriteriosXPuesto.findByCorrelativo", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.correlativo = :correlativo"),
    @NamedQuery(name = "CriteriosXPuesto.findByNivel", query = "SELECT c FROM CriteriosXPuesto c WHERE c.nivel = :nivel"),
    @NamedQuery(name = "CriteriosXPuesto.findByValor1", query = "SELECT c FROM CriteriosXPuesto c WHERE c.valor1 = :valor1"),
    @NamedQuery(name = "CriteriosXPuesto.findByValor2", query = "SELECT c FROM CriteriosXPuesto c WHERE c.valor2 = :valor2")})
public class CriteriosXPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriteriosXPuestoPK criteriosXPuestoPK;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "valor1")
    private Integer valor1;
    @Column(name = "valor2")
    private Integer valor2;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "puesto", referencedColumnName = "cod_puesto", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Puesto puesto1;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "criterio", referencedColumnName = "cod_criterio", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Criterio criterio1;

    public CriteriosXPuesto() {
    }

    public CriteriosXPuesto(CriteriosXPuestoPK criteriosXPuestoPK) {
        this.criteriosXPuestoPK = criteriosXPuestoPK;
    }

    public CriteriosXPuesto(int codCia, int puesto, int criterio, int correlativo) {
        this.criteriosXPuestoPK = new CriteriosXPuestoPK(codCia, puesto, criterio, correlativo);
    }

    public CriteriosXPuestoPK getCriteriosXPuestoPK() {
        return criteriosXPuestoPK;
    }

    public void setCriteriosXPuestoPK(CriteriosXPuestoPK criteriosXPuestoPK) {
        this.criteriosXPuestoPK = criteriosXPuestoPK;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getValor1() {
        return valor1;
    }

    public void setValor1(Integer valor1) {
        this.valor1 = valor1;
    }

    public Integer getValor2() {
        return valor2;
    }

    public void setValor2(Integer valor2) {
        this.valor2 = valor2;
    }

    public Puesto getPuesto1() {
        return puesto1;
    }

    public void setPuesto1(Puesto puesto1) {
        this.puesto1 = puesto1;
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
        return "com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto[ criteriosXPuestoPK=" + criteriosXPuestoPK + " ]";
    }
    
}
