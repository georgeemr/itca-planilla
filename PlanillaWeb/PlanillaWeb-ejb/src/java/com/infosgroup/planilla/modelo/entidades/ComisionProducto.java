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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "COMISION_PRODUCTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComisionProducto.findAll", query = "SELECT c FROM ComisionProducto c"),
    @NamedQuery(name = "ComisionProducto.findByCodCia", query = "SELECT c FROM ComisionProducto c WHERE c.comisionProductoPK.codCia = :codCia"),
    @NamedQuery(name = "ComisionProducto.findByCodEmp", query = "SELECT c FROM ComisionProducto c WHERE c.comisionProductoPK.codEmp = :codEmp"),
    @NamedQuery(name = "ComisionProducto.findByCatProducto", query = "SELECT c FROM ComisionProducto c WHERE c.comisionProductoPK.catProducto = :catProducto"),
    @NamedQuery(name = "ComisionProducto.findByInicioGana", query = "SELECT c FROM ComisionProducto c WHERE c.inicioGana = :inicioGana")})
public class ComisionProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComisionProductoPK comisionProductoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INICIO_GANA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicioGana;

    public ComisionProducto() {
    }

    public ComisionProducto(ComisionProductoPK comisionProductoPK) {
        this.comisionProductoPK = comisionProductoPK;
    }

    public ComisionProducto(ComisionProductoPK comisionProductoPK, Date inicioGana) {
        this.comisionProductoPK = comisionProductoPK;
        this.inicioGana = inicioGana;
    }

    public ComisionProducto(short codCia, int codEmp, String catProducto) {
        this.comisionProductoPK = new ComisionProductoPK(codCia, codEmp, catProducto);
    }

    public ComisionProductoPK getComisionProductoPK() {
        return comisionProductoPK;
    }

    public void setComisionProductoPK(ComisionProductoPK comisionProductoPK) {
        this.comisionProductoPK = comisionProductoPK;
    }

    public Date getInicioGana() {
        return inicioGana;
    }

    public void setInicioGana(Date inicioGana) {
        this.inicioGana = inicioGana;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comisionProductoPK != null ? comisionProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionProducto)) {
            return false;
        }
        ComisionProducto other = (ComisionProducto) object;
        if ((this.comisionProductoPK == null && other.comisionProductoPK != null) || (this.comisionProductoPK != null && !this.comisionProductoPK.equals(other.comisionProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ComisionProducto[ comisionProductoPK=" + comisionProductoPK + " ]";
    }
    
}
