/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "UNIVERSIDADES", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Universidades.findAll", query = "SELECT u FROM Universidades u"),
    @NamedQuery(name = "Universidades.findByCodCia", query = "SELECT u FROM Universidades u WHERE u.universidadesPK.codCia = :codCia"),
    @NamedQuery(name = "Universidades.findByCodUniversidad", query = "SELECT u FROM Universidades u WHERE u.universidadesPK.codUniversidad = :codUniversidad"),
    @NamedQuery(name = "Universidades.findByNomUniversidad", query = "SELECT u FROM Universidades u WHERE u.nomUniversidad = :nomUniversidad")})
public class Universidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UniversidadesPK universidadesPK;
    @Column(name = "NOM_UNIVERSIDAD", length = 200)
    private String nomUniversidad;

    public Universidades() {
    }

    public Universidades(UniversidadesPK universidadesPK) {
        this.universidadesPK = universidadesPK;
    }

    public Universidades(short codCia, short codUniversidad) {
        this.universidadesPK = new UniversidadesPK(codCia, codUniversidad);
    }

    public UniversidadesPK getUniversidadesPK() {
        return universidadesPK;
    }

    public void setUniversidadesPK(UniversidadesPK universidadesPK) {
        this.universidadesPK = universidadesPK;
    }

    public String getNomUniversidad() {
        return nomUniversidad;
    }

    public void setNomUniversidad(String nomUniversidad) {
        this.nomUniversidad = nomUniversidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (universidadesPK != null ? universidadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Universidades)) {
            return false;
        }
        Universidades other = (Universidades) object;
        if ((this.universidadesPK == null && other.universidadesPK != null) || (this.universidadesPK != null && !this.universidadesPK.equals(other.universidadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Universidades[ universidadesPK=" + universidadesPK + " ]";
    }
    
}
