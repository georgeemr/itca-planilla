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
@Table(name = "PERFIL_X_PUESTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilXPuesto.findAll", query = "SELECT p FROM PerfilXPuesto p"),
    @NamedQuery(name = "PerfilXPuesto.findByCodCia", query = "SELECT p FROM PerfilXPuesto p WHERE p.perfilXPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "PerfilXPuesto.findByCodPuesto", query = "SELECT p FROM PerfilXPuesto p WHERE p.perfilXPuestoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "PerfilXPuesto.findByCodPerfil", query = "SELECT p FROM PerfilXPuesto p WHERE p.perfilXPuestoPK.codPerfil = :codPerfil"),
    @NamedQuery(name = "PerfilXPuesto.findByTipo", query = "SELECT p FROM PerfilXPuesto p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "PerfilXPuesto.findByCodTipoPuesto", query = "SELECT p FROM PerfilXPuesto p WHERE p.codTipoPuesto = :codTipoPuesto")})
public class PerfilXPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilXPuestoPK perfilXPuestoPK;
    @Column(name = "TIPO", length = 1)
    private String tipo;
    @Column(name = "COD_TIPO_PUESTO")
    private Short codTipoPuesto;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Puestos puestos;

    public PerfilXPuesto() {
    }

    public PerfilXPuesto(PerfilXPuestoPK perfilXPuestoPK) {
        this.perfilXPuestoPK = perfilXPuestoPK;
    }

    public PerfilXPuesto(short codCia, short codPuesto, int codPerfil) {
        this.perfilXPuestoPK = new PerfilXPuestoPK(codCia, codPuesto, codPerfil);
    }

    public PerfilXPuestoPK getPerfilXPuestoPK() {
        return perfilXPuestoPK;
    }

    public void setPerfilXPuestoPK(PerfilXPuestoPK perfilXPuestoPK) {
        this.perfilXPuestoPK = perfilXPuestoPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Short getCodTipoPuesto() {
        return codTipoPuesto;
    }

    public void setCodTipoPuesto(Short codTipoPuesto) {
        this.codTipoPuesto = codTipoPuesto;
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
        hash += (perfilXPuestoPK != null ? perfilXPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilXPuesto)) {
            return false;
        }
        PerfilXPuesto other = (PerfilXPuesto) object;
        if ((this.perfilXPuestoPK == null && other.perfilXPuestoPK != null) || (this.perfilXPuestoPK != null && !this.perfilXPuestoPK.equals(other.perfilXPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PerfilXPuesto[ perfilXPuestoPK=" + perfilXPuestoPK + " ]";
    }
    
}
