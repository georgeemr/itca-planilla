/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class ProyectoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PROYECTO", nullable = false, length = 20)
    private String proyecto;
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;

    public ProyectoPK() {
    }

    public ProyectoPK(String proyecto, short codCia) {
        this.proyecto = proyecto;
        this.codCia = codCia;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyecto != null ? proyecto.hashCode() : 0);
        hash += (int) codCia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoPK)) {
            return false;
        }
        ProyectoPK other = (ProyectoPK) object;
        if ((this.proyecto == null && other.proyecto != null) || (this.proyecto != null && !this.proyecto.equals(other.proyecto))) {
            return false;
        }
        if (this.codCia != other.codCia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ProyectoPK[ proyecto=" + proyecto + ", codCia=" + codCia + " ]";
    }
    
}
