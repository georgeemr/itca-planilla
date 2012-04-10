/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CRITERIOS_X_PUESTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriteriosXPuesto.findAll", query = "SELECT c FROM CriteriosXPuesto c"),
    @NamedQuery(name = "CriteriosXPuesto.findByCodCia", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "CriteriosXPuesto.findByPuesto", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.codCia = :codCia AND c.criteriosXPuestoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "CriteriosXPuesto.findByCriterio", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.criterio = :criterio")})
public class CriteriosXPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriteriosXPuestoPK criteriosXPuestoPK;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CRITERIO", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Criterio criterio;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)  
    private Puestos puestos;
    
    public CriteriosXPuesto() {
    }

    public CriteriosXPuesto(CriteriosXPuestoPK criteriosXPuestoPK) {
        this.criteriosXPuestoPK = criteriosXPuestoPK;
    }

    public CriteriosXPuesto(short codCia, short codPuesto, int criterio) {
        this.criteriosXPuestoPK = new CriteriosXPuestoPK(codCia, codPuesto, criterio);
    }

    public CriteriosXPuestoPK getCriteriosXPuestoGbPK() {
        return criteriosXPuestoPK;
    }

    public void setCriteriosXPuestoPK(CriteriosXPuestoPK criteriosXPuestoPK) {
        this.criteriosXPuestoPK = criteriosXPuestoPK;
    }

    public Criterio getCriterio() {
        return criterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
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
        return "sv.com.infosgroup.modelocandidatojpa.entidades.CriteriosXPuesto[ criteriosXPuestoPK=" + criteriosXPuestoPK + " ]";
    }
    
}
