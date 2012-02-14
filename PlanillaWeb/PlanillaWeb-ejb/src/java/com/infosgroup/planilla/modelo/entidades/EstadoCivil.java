/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "ESTADO_CIVIL", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e"),
    @NamedQuery(name = "EstadoCivil.findByCodEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.codEstadoCivil = :codEstadoCivil"),
    @NamedQuery(name = "EstadoCivil.findByNomEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.nomEstadoCivil = :nomEstadoCivil")})
public class EstadoCivil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ESTADO_CIVIL", nullable = false)
    private Long codEstadoCivil;
    @Size(max = 200)
    @Column(name = "NOM_ESTADO_CIVIL", length = 200)
    private String nomEstadoCivil;

    public EstadoCivil() {
    }

    public EstadoCivil(Long codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public Long getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(Long codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public String getNomEstadoCivil() {
        return nomEstadoCivil;
    }

    public void setNomEstadoCivil(String nomEstadoCivil) {
        this.nomEstadoCivil = nomEstadoCivil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstadoCivil != null ? codEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.codEstadoCivil == null && other.codEstadoCivil != null) || (this.codEstadoCivil != null && !this.codEstadoCivil.equals(other.codEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EstadoCivil[ codEstadoCivil=" + codEstadoCivil + " ]";
    }
    
}
