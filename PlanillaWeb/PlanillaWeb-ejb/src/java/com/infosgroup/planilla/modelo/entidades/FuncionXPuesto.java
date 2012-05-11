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
@Table(name = "FUNCION_X_PUESTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionXPuesto.findAll", query = "SELECT f FROM FuncionXPuesto f"),
    @NamedQuery(name = "FuncionXPuesto.findByCodCia", query = "SELECT f FROM FuncionXPuesto f WHERE f.funcionXPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "FuncionXPuesto.findByCodPuesto", query = "SELECT f FROM FuncionXPuesto f WHERE f.funcionXPuestoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "FuncionXPuesto.findByCodFuncion", query = "SELECT f FROM FuncionXPuesto f WHERE f.funcionXPuestoPK.codFuncion = :codFuncion")})
public class FuncionXPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FuncionXPuestoPK funcionXPuestoPK;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Puestos puestos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_FUNCION", referencedColumnName = "COD_FUNCION", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private FuncionPuesto funcionPuesto;

    public FuncionXPuesto() {
    }

    public FuncionXPuesto(FuncionXPuestoPK funcionXPuestoPK) {
        this.funcionXPuestoPK = funcionXPuestoPK;
    }

    public FuncionXPuesto(short codCia, short codPuesto, int codFuncion) {
        this.funcionXPuestoPK = new FuncionXPuestoPK(codCia, codPuesto, codFuncion);
    }

    public FuncionXPuestoPK getFuncionXPuestoPK() {
        return funcionXPuestoPK;
    }

    public void setFuncionXPuestoPK(FuncionXPuestoPK funcionXPuestoPK) {
        this.funcionXPuestoPK = funcionXPuestoPK;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    public FuncionPuesto getFuncionPuesto() {
        return funcionPuesto;
    }

    public void setFuncionPuesto(FuncionPuesto funcionPuesto) {
        this.funcionPuesto = funcionPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionXPuestoPK != null ? funcionXPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionXPuesto)) {
            return false;
        }
        FuncionXPuesto other = (FuncionXPuesto) object;
        if ((this.funcionXPuestoPK == null && other.funcionXPuestoPK != null) || (this.funcionXPuestoPK != null && !this.funcionXPuestoPK.equals(other.funcionXPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.FuncionXPuesto[ funcionXPuestoPK=" + funcionXPuestoPK + " ]";
    }
    
}
