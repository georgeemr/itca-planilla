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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ESTADO_CONCURSO", catalog = "", schema = "PLANILLA", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NOMBRE"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoConcurso.findAll", query = "SELECT e FROM EstadoConcurso e"),
    @NamedQuery(name = "EstadoConcurso.findByCodCia", query = "SELECT e FROM EstadoConcurso e WHERE e.estadoConcursoPK.codCia = :codCia"),
    @NamedQuery(name = "EstadoConcurso.findByCodigo", query = "SELECT e FROM EstadoConcurso e WHERE e.estadoConcursoPK.codigo = :codigo"),
    @NamedQuery(name = "EstadoConcurso.findByNombre", query = "SELECT e FROM EstadoConcurso e WHERE e.nombre = :nombre")})
public class EstadoConcurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadoConcursoPK estadoConcursoPK;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoConcurso")
    private List<Concurso> concursoList;

    public EstadoConcurso() {
    }

    public EstadoConcurso(EstadoConcursoPK estadoConcursoPK) {
        this.estadoConcursoPK = estadoConcursoPK;
    }

    public EstadoConcurso(EstadoConcursoPK estadoConcursoPK, String nombre) {
        this.estadoConcursoPK = estadoConcursoPK;
        this.nombre = nombre;
    }

    public EstadoConcurso(short codCia, String codigo) {
        this.estadoConcursoPK = new EstadoConcursoPK(codCia, codigo);
    }

    public EstadoConcursoPK getEstadoConcursoPK() {
        return estadoConcursoPK;
    }

    public void setEstadoConcursoPK(EstadoConcursoPK estadoConcursoPK) {
        this.estadoConcursoPK = estadoConcursoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Concurso> getConcursoList() {
        return concursoList;
    }

    public void setConcursoList(List<Concurso> concursoList) {
        this.concursoList = concursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoConcursoPK != null ? estadoConcursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoConcurso)) {
            return false;
        }
        EstadoConcurso other = (EstadoConcurso) object;
        if ((this.estadoConcursoPK == null && other.estadoConcursoPK != null) || (this.estadoConcursoPK != null && !this.estadoConcursoPK.equals(other.estadoConcursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.EstadoConcurso[ estadoConcursoPK=" + estadoConcursoPK + " ]";
    }
    
}
