/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "TIPO_SANGRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSangre.findAll", query = "SELECT t FROM TipoSangre t"),
    @NamedQuery(name = "TipoSangre.findByTipoSangre", query = "SELECT t FROM TipoSangre t WHERE t.tipoSangre = :tipoSangre"),
    @NamedQuery(name = "TipoSangre.findByNomTipoSangre", query = "SELECT t FROM TipoSangre t WHERE t.nomTipoSangre = :nomTipoSangre")})
public class TipoSangre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TIPO_SANGRE", nullable = false, length = 5)
    private String tipoSangre;
    @Basic(optional = false)
    @Column(name = "NOM_TIPO_SANGRE", nullable = false, length = 100)
    private String nomTipoSangre;
    @OneToMany(mappedBy = "tipoSangre")
    private List<Empleados> empleadosList;

    public TipoSangre() {
    }

    public TipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public TipoSangre(String tipoSangre, String nomTipoSangre) {
        this.tipoSangre = tipoSangre;
        this.nomTipoSangre = nomTipoSangre;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getNomTipoSangre() {
        return nomTipoSangre;
    }

    public void setNomTipoSangre(String nomTipoSangre) {
        this.nomTipoSangre = nomTipoSangre;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoSangre != null ? tipoSangre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSangre)) {
            return false;
        }
        TipoSangre other = (TipoSangre) object;
        if ((this.tipoSangre == null && other.tipoSangre != null) || (this.tipoSangre != null && !this.tipoSangre.equals(other.tipoSangre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoSangre[ tipoSangre=" + tipoSangre + " ]";
    }
    
}
