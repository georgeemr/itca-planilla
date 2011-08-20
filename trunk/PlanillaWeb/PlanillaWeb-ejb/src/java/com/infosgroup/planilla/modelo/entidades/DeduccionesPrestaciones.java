/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "deducciones_prestaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeduccionesPrestaciones.findAll", query = "SELECT d FROM DeduccionesPrestaciones d"),
    @NamedQuery(name = "DeduccionesPrestaciones.findByIdCompania", query = "SELECT d FROM DeduccionesPrestaciones d WHERE d.deduccionesPrestacionesPK.idCompania = :idCompania"),
    @NamedQuery(name = "DeduccionesPrestaciones.findByIdTipoCuenta", query = "SELECT d FROM DeduccionesPrestaciones d WHERE d.deduccionesPrestacionesPK.idTipoCuenta = :idTipoCuenta"),
    @NamedQuery(name = "DeduccionesPrestaciones.findByIdCuenta", query = "SELECT d FROM DeduccionesPrestaciones d WHERE d.deduccionesPrestacionesPK.idCuenta = :idCuenta"),
    @NamedQuery(name = "DeduccionesPrestaciones.findByIdPrestacion", query = "SELECT d FROM DeduccionesPrestaciones d WHERE d.deduccionesPrestacionesPK.idPrestacion = :idPrestacion"),
    @NamedQuery(name = "DeduccionesPrestaciones.findByNomPrestacion", query = "SELECT d FROM DeduccionesPrestaciones d WHERE d.nomPrestacion = :nomPrestacion")})
public class DeduccionesPrestaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeduccionesPrestacionesPK deduccionesPrestacionesPK;
    @Size(max = 100)
    @Column(name = "nom_prestacion", length = 100)
    private String nomPrestacion;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_tipo_cuenta", referencedColumnName = "id_tipo_cuenta", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cuenta cuenta;

    public DeduccionesPrestaciones() {
    }

    public DeduccionesPrestaciones(DeduccionesPrestacionesPK deduccionesPrestacionesPK) {
        this.deduccionesPrestacionesPK = deduccionesPrestacionesPK;
    }

    public DeduccionesPrestaciones(int idCompania, int idTipoCuenta, int idCuenta, int idPrestacion) {
        this.deduccionesPrestacionesPK = new DeduccionesPrestacionesPK(idCompania, idTipoCuenta, idCuenta, idPrestacion);
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

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
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
