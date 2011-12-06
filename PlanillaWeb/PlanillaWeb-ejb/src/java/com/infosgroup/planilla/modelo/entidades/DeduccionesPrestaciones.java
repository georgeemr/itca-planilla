/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "deducciones_prestaciones")
@NamedQueries({
    @NamedQuery(name = "DeduccionesPrestaciones.findAll", query = "SELECT d FROM DeduccionesPrestaciones d"),
    @NamedQuery(name = "DeduccionesPrestaciones.findByIdCompania", query = "SELECT d FROM DeduccionesPrestaciones d WHERE d.deduccionesPrestacionesPK.idCompania = :idCompania"),
    @NamedQuery(name = "DeduccionesPrestaciones.findByIdPrestacion", query = "SELECT d FROM DeduccionesPrestaciones d WHERE d.deduccionesPrestacionesPK.idPrestacion = :idPrestacion"),
    @NamedQuery(name = "DeduccionesPrestaciones.findByNomPrestacion", query = "SELECT d FROM DeduccionesPrestaciones d WHERE d.nomPrestacion = :nomPrestacion"),
    @NamedQuery(name = "DeduccionesPrestaciones.findByTipo", query = "SELECT d FROM DeduccionesPrestaciones d WHERE d.tipo = :tipo")})
public class DeduccionesPrestaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeduccionesPrestacionesPK deduccionesPrestacionesPK;
    @Size(max = 2147483647)
    @Column(name = "nom_prestacion", length = 2147483647)
    private String nomPrestacion;
    @Size(max = 2147483647)
    @Column(name = "tipo", length = 2147483647)
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deduccionesPrestaciones")
    private List<DetPlanilla> detPlanillaList;

    public DeduccionesPrestaciones() {
    }

    public DeduccionesPrestaciones(DeduccionesPrestacionesPK deduccionesPrestacionesPK) {
        this.deduccionesPrestacionesPK = deduccionesPrestacionesPK;
    }

    public DeduccionesPrestaciones(int idCompania, int idPrestacion) {
        this.deduccionesPrestacionesPK = new DeduccionesPrestacionesPK(idCompania, idPrestacion);
    }

    public DeduccionesPrestacionesPK getDeduccionesPrestacionesPK() {
        return deduccionesPrestacionesPK;
    }

    public void setDeduccionesPrestacionesPK(DeduccionesPrestacionesPK deduccionesPrestacionesPK) {
        this.deduccionesPrestacionesPK = deduccionesPrestacionesPK;
    }

    public String getNomPrestacion() {
        return nomPrestacion;
    }

    public void setNomPrestacion(String nomPrestacion) {
        this.nomPrestacion = nomPrestacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<DetPlanilla> getDetPlanillaList() {
        return detPlanillaList;
    }

    public void setDetPlanillaList(List<DetPlanilla> detPlanillaList) {
        this.detPlanillaList = detPlanillaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deduccionesPrestacionesPK != null ? deduccionesPrestacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeduccionesPrestaciones)) {
            return false;
        }
        DeduccionesPrestaciones other = (DeduccionesPrestaciones) object;
        if ((this.deduccionesPrestacionesPK == null && other.deduccionesPrestacionesPK != null) || (this.deduccionesPrestacionesPK != null && !this.deduccionesPrestacionesPK.equals(other.deduccionesPrestacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DeduccionesPrestaciones[ deduccionesPrestacionesPK=" + deduccionesPrestacionesPK + " ]";
    }
    
}
