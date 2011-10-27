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

/**
 *
 * @author root
 */
@Entity
@Table(name = "estado_civil", catalog = "planilla", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e"),
    @NamedQuery(name = "EstadoCivil.findByIdEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.idEstadoCivil = :idEstadoCivil"),
    @NamedQuery(name = "EstadoCivil.findByNomEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.nomEstadoCivil = :nomEstadoCivil")})
public class EstadoCivil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado_civil", nullable = false)
    private Integer idEstadoCivil;
    @Size(max = 100)
    @Column(name = "nom_estado_civil", length = 100)
    private String nomEstadoCivil;

    public EstadoCivil() {
    }

    public EstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
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
        hash += (idEstadoCivil != null ? idEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.idEstadoCivil == null && other.idEstadoCivil != null) || (this.idEstadoCivil != null && !this.idEstadoCivil.equals(other.idEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.EstadoCivil[ idEstadoCivil=" + idEstadoCivil + " ]";
    }
    
}
