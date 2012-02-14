/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "PROCESO_SELECCION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoSeleccion.findAll", query = "SELECT p FROM ProcesoSeleccion p"),
    @NamedQuery(name = "ProcesoSeleccion.findByCodCia", query = "SELECT p FROM ProcesoSeleccion p WHERE p.procesoSeleccionPK.codCia = :codCia"),
    @NamedQuery(name = "ProcesoSeleccion.findByCodActividad", query = "SELECT p FROM ProcesoSeleccion p WHERE p.procesoSeleccionPK.codActividad = :codActividad"),
    @NamedQuery(name = "ProcesoSeleccion.findByNomActividad", query = "SELECT p FROM ProcesoSeleccion p WHERE p.nomActividad = :nomActividad"),
    @NamedQuery(name = "ProcesoSeleccion.findByOrden", query = "SELECT p FROM ProcesoSeleccion p WHERE p.orden = :orden")})
public class ProcesoSeleccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesoSeleccionPK procesoSeleccionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOM_ACTIVIDAD", nullable = false, length = 200)
    private String nomActividad;
    @Column(name = "ORDEN")
    private Short orden;

    public ProcesoSeleccion() {
    }

    public ProcesoSeleccion(ProcesoSeleccionPK procesoSeleccionPK) {
        this.procesoSeleccionPK = procesoSeleccionPK;
    }

    public ProcesoSeleccion(ProcesoSeleccionPK procesoSeleccionPK, String nomActividad) {
        this.procesoSeleccionPK = procesoSeleccionPK;
        this.nomActividad = nomActividad;
    }

    public ProcesoSeleccion(short codCia, int codActividad) {
        this.procesoSeleccionPK = new ProcesoSeleccionPK(codCia, codActividad);
    }

    public ProcesoSeleccionPK getProcesoSeleccionPK() {
        return procesoSeleccionPK;
    }

    public void setProcesoSeleccionPK(ProcesoSeleccionPK procesoSeleccionPK) {
        this.procesoSeleccionPK = procesoSeleccionPK;
    }

    public String getNomActividad() {
        return nomActividad;
    }

    public void setNomActividad(String nomActividad) {
        this.nomActividad = nomActividad;
    }

    public Short getOrden() {
        return orden;
    }

    public void setOrden(Short orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesoSeleccionPK != null ? procesoSeleccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoSeleccion)) {
            return false;
        }
        ProcesoSeleccion other = (ProcesoSeleccion) object;
        if ((this.procesoSeleccionPK == null && other.procesoSeleccionPK != null) || (this.procesoSeleccionPK != null && !this.procesoSeleccionPK.equals(other.procesoSeleccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ProcesoSeleccion[ procesoSeleccionPK=" + procesoSeleccionPK + " ]";
    }
    
}
