/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "RH_OUTSORCING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhOutsorcing.findAll", query = "SELECT r FROM RhOutsorcing r"),
    @NamedQuery(name = "RhOutsorcing.findByCodCia", query = "SELECT r FROM RhOutsorcing r WHERE r.rhOutsorcingPK.codCia = :codCia"),
    @NamedQuery(name = "RhOutsorcing.findByCodigo", query = "SELECT r FROM RhOutsorcing r WHERE r.rhOutsorcingPK.codigo = :codigo"),
    @NamedQuery(name = "RhOutsorcing.findByApellidos", query = "SELECT r FROM RhOutsorcing r WHERE r.apellidos = :apellidos"),
    @NamedQuery(name = "RhOutsorcing.findByNombres", query = "SELECT r FROM RhOutsorcing r WHERE r.nombres = :nombres"),
    @NamedQuery(name = "RhOutsorcing.findByStatus", query = "SELECT r FROM RhOutsorcing r WHERE r.status = :status"),
    @NamedQuery(name = "RhOutsorcing.findByFecIngreso", query = "SELECT r FROM RhOutsorcing r WHERE r.fecIngreso = :fecIngreso"),
    @NamedQuery(name = "RhOutsorcing.findByFecSalida", query = "SELECT r FROM RhOutsorcing r WHERE r.fecSalida = :fecSalida")})
public class RhOutsorcing implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RhOutsorcingPK rhOutsorcingPK;
    @Column(name = "APELLIDOS", length = 60)
    private String apellidos;
    @Column(name = "NOMBRES", length = 100)
    private String nombres;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "FEC_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngreso;
    @Column(name = "FEC_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecSalida;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO")})
    @ManyToOne(optional = false)
    private Puestos puestos;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cias cias;

    public RhOutsorcing() {
    }

    public RhOutsorcing(RhOutsorcingPK rhOutsorcingPK) {
        this.rhOutsorcingPK = rhOutsorcingPK;
    }

    public RhOutsorcing(short codCia, int codigo) {
        this.rhOutsorcingPK = new RhOutsorcingPK(codCia, codigo);
    }

    public RhOutsorcingPK getRhOutsorcingPK() {
        return rhOutsorcingPK;
    }

    public void setRhOutsorcingPK(RhOutsorcingPK rhOutsorcingPK) {
        this.rhOutsorcingPK = rhOutsorcingPK;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public Date getFecSalida() {
        return fecSalida;
    }

    public void setFecSalida(Date fecSalida) {
        this.fecSalida = fecSalida;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    public Cias getCias() {
        return cias;
    }

    public void setCias(Cias cias) {
        this.cias = cias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rhOutsorcingPK != null ? rhOutsorcingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhOutsorcing)) {
            return false;
        }
        RhOutsorcing other = (RhOutsorcing) object;
        if ((this.rhOutsorcingPK == null && other.rhOutsorcingPK != null) || (this.rhOutsorcingPK != null && !this.rhOutsorcingPK.equals(other.rhOutsorcingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.RhOutsorcing[ rhOutsorcingPK=" + rhOutsorcingPK + " ]";
    }
    
}
