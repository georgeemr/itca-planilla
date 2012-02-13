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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table( schema="PARAMETROS", name = "PAISES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p"),
    @NamedQuery(name = "Paises.findByCodPais", query = "SELECT p FROM Paises p WHERE p.codPais = :codPais"),
    @NamedQuery(name = "Paises.findByNombPais", query = "SELECT p FROM Paises p WHERE p.nombPais = :nombPais"),
    @NamedQuery(name = "Paises.findByNacionalidad", query = "SELECT p FROM Paises p WHERE p.nacionalidad = :nacionalidad")})
public class Paises implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_PAIS", nullable = false)
    private Short codPais;
    @Column(name = "NOMB_PAIS", length = 30)
    private String nombPais;
    @Column(name = "NACIONALIDAD", length = 25)
    private String nacionalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paises")
    private List<Deptos> deptosList;

    public Paises() {
    }

    public Paises(Short codPais) {
        this.codPais = codPais;
    }

    public Short getCodPais() {
        return codPais;
    }

    public void setCodPais(Short codPais) {
        this.codPais = codPais;
    }

    public String getNombPais() {
        return nombPais;
    }

    public void setNombPais(String nombPais) {
        this.nombPais = nombPais;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @XmlTransient
    public List<Deptos> getDeptosList() {
        return deptosList;
    }

    public void setDeptosList(List<Deptos> deptosList) {
        this.deptosList = deptosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.parametros.Paises[ codPais=" + codPais + " ]";
    }
    
}
