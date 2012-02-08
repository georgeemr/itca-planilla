/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "BASES_CALCULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BasesCalculo.findAll", query = "SELECT b FROM BasesCalculo b"),
    @NamedQuery(name = "BasesCalculo.findByCodBase", query = "SELECT b FROM BasesCalculo b WHERE b.codBase = :codBase"),
    @NamedQuery(name = "BasesCalculo.findByDesBase", query = "SELECT b FROM BasesCalculo b WHERE b.desBase = :desBase"),
    @NamedQuery(name = "BasesCalculo.findByTabla", query = "SELECT b FROM BasesCalculo b WHERE b.tabla = :tabla"),
    @NamedQuery(name = "BasesCalculo.findByCampo", query = "SELECT b FROM BasesCalculo b WHERE b.campo = :campo")})
public class BasesCalculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_BASE", nullable = false)
    private Short codBase;
    @Column(name = "DES_BASE", length = 60)
    private String desBase;
    @Column(name = "TABLA", length = 30)
    private String tabla;
    @Column(name = "CAMPO", length = 30)
    private String campo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codBase")
    private List<DeducPresta> deducPrestaList;

    public BasesCalculo() {
    }

    public BasesCalculo(Short codBase) {
        this.codBase = codBase;
    }

    public Short getCodBase() {
        return codBase;
    }

    public void setCodBase(Short codBase) {
        this.codBase = codBase;
    }

    public String getDesBase() {
        return desBase;
    }

    public void setDesBase(String desBase) {
        this.desBase = desBase;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    @XmlTransient
    public List<DeducPresta> getDeducPrestaList() {
        return deducPrestaList;
    }

    public void setDeducPrestaList(List<DeducPresta> deducPrestaList) {
        this.deducPrestaList = deducPrestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBase != null ? codBase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BasesCalculo)) {
            return false;
        }
        BasesCalculo other = (BasesCalculo) object;
        if ((this.codBase == null && other.codBase != null) || (this.codBase != null && !this.codBase.equals(other.codBase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.BasesCalculo[ codBase=" + codBase + " ]";
    }
    
}
