/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "POSICION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posicion.findAll", query = "SELECT p FROM Posicion p"),
    @NamedQuery(name = "Posicion.findByCodCia", query = "SELECT p FROM Posicion p WHERE p.posicionPK.codCia = :codCia"),
    @NamedQuery(name = "Posicion.findByCodPosicion", query = "SELECT p FROM Posicion p WHERE p.posicionPK.codPosicion = :codPosicion"),
    @NamedQuery(name = "Posicion.findByStatus", query = "SELECT p FROM Posicion p WHERE p.status = :status"),
    @NamedQuery(name = "Posicion.findByCodEmp", query = "SELECT p FROM Posicion p WHERE p.codEmp = :codEmp")})
public class Posicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PosicionPK posicionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS", nullable = false, length = 1)
    private String status;
    @Column(name = "COD_EMP")
    private Integer codEmp;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_SECCION", referencedColumnName = "COD_SECCION"),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO")})
    @ManyToOne(optional = false)
    private Secciones secciones;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO")})
    @ManyToOne(optional = false)
    private Puestos puestos;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_GERENCIA", referencedColumnName = "COD_GERENCIA")})
    @ManyToOne(optional = false)
    private Gerencia gerencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "posicion")
    private List<HisPosicion> hisPosicionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "posicion")
    private List<AccionPersonal> accionPersonalList;

    public Posicion() {
    }

    public Posicion(PosicionPK posicionPK) {
        this.posicionPK = posicionPK;
    }

    public Posicion(PosicionPK posicionPK, String status) {
        this.posicionPK = posicionPK;
        this.status = status;
    }

    public Posicion(short codCia, short codPosicion) {
        this.posicionPK = new PosicionPK(codCia, codPosicion);
    }

    public PosicionPK getPosicionPK() {
        return posicionPK;
    }

    public void setPosicionPK(PosicionPK posicionPK) {
        this.posicionPK = posicionPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Integer codEmp) {
        this.codEmp = codEmp;
    }

    public Secciones getSecciones() {
        return secciones;
    }

    public void setSecciones(Secciones secciones) {
        this.secciones = secciones;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    public Gerencia getGerencia() {
        return gerencia;
    }

    public void setGerencia(Gerencia gerencia) {
        this.gerencia = gerencia;
    }

    @XmlTransient
    public List<HisPosicion> getHisPosicionList() {
        return hisPosicionList;
    }

    public void setHisPosicionList(List<HisPosicion> hisPosicionList) {
        this.hisPosicionList = hisPosicionList;
    }

    @XmlTransient
    public List<AccionPersonal> getAccionPersonalList() {
        return accionPersonalList;
    }

    public void setAccionPersonalList(List<AccionPersonal> accionPersonalList) {
        this.accionPersonalList = accionPersonalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (posicionPK != null ? posicionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posicion)) {
            return false;
        }
        Posicion other = (Posicion) object;
        if ((this.posicionPK == null && other.posicionPK != null) || (this.posicionPK != null && !this.posicionPK.equals(other.posicionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Posicion[ posicionPK=" + posicionPK + " ]";
    }
    
}
