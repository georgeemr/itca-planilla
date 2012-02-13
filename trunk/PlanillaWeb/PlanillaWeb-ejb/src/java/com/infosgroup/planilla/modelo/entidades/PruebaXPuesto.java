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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PRUEBA_X_PUESTO", catalog = "", schema = "PLANILLA", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NOMBRE"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PruebaXPuesto.findAll", query = "SELECT p FROM PruebaXPuesto p"),
    @NamedQuery(name = "PruebaXPuesto.findByCodCia", query = "SELECT p FROM PruebaXPuesto p WHERE p.pruebaXPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "PruebaXPuesto.findByPuesto", query = "SELECT p FROM PruebaXPuesto p WHERE p.pruebaXPuestoPK.puesto = :puesto"),
    @NamedQuery(name = "PruebaXPuesto.findByCodigo", query = "SELECT p FROM PruebaXPuesto p WHERE p.pruebaXPuestoPK.codigo = :codigo"),
    @NamedQuery(name = "PruebaXPuesto.findByNombre", query = "SELECT p FROM PruebaXPuesto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PruebaXPuesto.findByEstado", query = "SELECT p FROM PruebaXPuesto p WHERE p.estado = :estado")})
public class PruebaXPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PruebaXPuestoPK pruebaXPuestoPK;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO", nullable = false, length = 1)
    private String estado;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PUESTO", referencedColumnName = "COD_PUESTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Puestos puestos;

    public PruebaXPuesto() {
    }

    public PruebaXPuesto(PruebaXPuestoPK pruebaXPuestoPK) {
        this.pruebaXPuestoPK = pruebaXPuestoPK;
    }

    public PruebaXPuesto(PruebaXPuestoPK pruebaXPuestoPK, String nombre, String estado) {
        this.pruebaXPuestoPK = pruebaXPuestoPK;
        this.nombre = nombre;
        this.estado = estado;
    }

    public PruebaXPuesto(short codCia, long puesto, long codigo) {
        this.pruebaXPuestoPK = new PruebaXPuestoPK(codCia, puesto, codigo);
    }

    public PruebaXPuestoPK getPruebaXPuestoPK() {
        return pruebaXPuestoPK;
    }

    public void setPruebaXPuestoPK(PruebaXPuestoPK pruebaXPuestoPK) {
        this.pruebaXPuestoPK = pruebaXPuestoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pruebaXPuestoPK != null ? pruebaXPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PruebaXPuesto)) {
            return false;
        }
        PruebaXPuesto other = (PruebaXPuesto) object;
        if ((this.pruebaXPuestoPK == null && other.pruebaXPuestoPK != null) || (this.pruebaXPuestoPK != null && !this.pruebaXPuestoPK.equals(other.pruebaXPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PruebaXPuesto[ pruebaXPuestoPK=" + pruebaXPuestoPK + " ]";
    }
    
}
