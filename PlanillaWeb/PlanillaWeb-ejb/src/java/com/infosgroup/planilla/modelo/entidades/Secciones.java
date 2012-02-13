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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "SECCIONES", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secciones.findAll", query = "SELECT s FROM Secciones s"),
    @NamedQuery(name = "Secciones.findByCodCia", query = "SELECT s FROM Secciones s WHERE s.seccionesPK.codCia = :codCia"),
    @NamedQuery(name = "Secciones.findByCodDepto", query = "SELECT s FROM Secciones s WHERE s.seccionesPK.codDepto = :codDepto"),
    @NamedQuery(name = "Secciones.findByCodSeccion", query = "SELECT s FROM Secciones s WHERE s.seccionesPK.codSeccion = :codSeccion"),
    @NamedQuery(name = "Secciones.findByNomSeccion", query = "SELECT s FROM Secciones s WHERE s.nomSeccion = :nomSeccion"),
    @NamedQuery(name = "Secciones.findByProyecto", query = "SELECT s FROM Secciones s WHERE s.proyecto = :proyecto")})
public class Secciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeccionesPK seccionesPK;
    @Column(name = "NOM_SECCION", length = 100)
    private String nomSeccion;
    @Column(name = "PROYECTO", length = 20)
    private String proyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "secciones")
    private List<Posicion> posicionList;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_DEPTO", referencedColumnName = "COD_DEPTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Departamentos departamentos;

    public Secciones() {
    }

    public Secciones(SeccionesPK seccionesPK) {
        this.seccionesPK = seccionesPK;
    }

    public Secciones(short codCia, short codDepto, short codSeccion) {
        this.seccionesPK = new SeccionesPK(codCia, codDepto, codSeccion);
    }

    public SeccionesPK getSeccionesPK() {
        return seccionesPK;
    }

    public void setSeccionesPK(SeccionesPK seccionesPK) {
        this.seccionesPK = seccionesPK;
    }

    public String getNomSeccion() {
        return nomSeccion;
    }

    public void setNomSeccion(String nomSeccion) {
        this.nomSeccion = nomSeccion;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    @XmlTransient
    public List<Posicion> getPosicionList() {
        return posicionList;
    }

    public void setPosicionList(List<Posicion> posicionList) {
        this.posicionList = posicionList;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seccionesPK != null ? seccionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secciones)) {
            return false;
        }
        Secciones other = (Secciones) object;
        if ((this.seccionesPK == null && other.seccionesPK != null) || (this.seccionesPK != null && !this.seccionesPK.equals(other.seccionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Secciones[ seccionesPK=" + seccionesPK + " ]";
    }
    
}
