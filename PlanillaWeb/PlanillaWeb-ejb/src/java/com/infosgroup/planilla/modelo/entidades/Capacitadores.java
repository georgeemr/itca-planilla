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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CAPACITADORES", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitadores.findAll", query = "SELECT c FROM Capacitadores c"),
    @NamedQuery(name = "Capacitadores.findByCodCia", query = "SELECT c FROM Capacitadores c WHERE c.capacitadoresPK.codCia = :codCia"),
    @NamedQuery(name = "Capacitadores.findByCodCapacitador", query = "SELECT c FROM Capacitadores c WHERE c.capacitadoresPK.codCapacitador = :codCapacitador"),
    @NamedQuery(name = "Capacitadores.findByTipo", query = "SELECT c FROM Capacitadores c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Capacitadores.findByNombre", query = "SELECT c FROM Capacitadores c WHERE c.nombre = :nombre")})
public class Capacitadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapacitadoresPK capacitadoresPK;
    @Size(max = 1)
    @Column(name = "TIPO", length = 1)
    private String tipo;
    @Size(max = 200)
    @Column(name = "NOMBRE", length = 200)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitadores")
    private List<PrograCampania> prograCampaniaList;

    public Capacitadores() {
    }

    public Capacitadores(CapacitadoresPK capacitadoresPK) {
        this.capacitadoresPK = capacitadoresPK;
    }

    public Capacitadores(short codCia, long codCapacitador) {
        this.capacitadoresPK = new CapacitadoresPK(codCia, codCapacitador);
    }

    public CapacitadoresPK getCapacitadoresPK() {
        return capacitadoresPK;
    }

    public void setCapacitadoresPK(CapacitadoresPK capacitadoresPK) {
        this.capacitadoresPK = capacitadoresPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<PrograCampania> getPrograCampaniaList() {
        return prograCampaniaList;
    }

    public void setPrograCampaniaList(List<PrograCampania> prograCampaniaList) {
        this.prograCampaniaList = prograCampaniaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capacitadoresPK != null ? capacitadoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacitadores)) {
            return false;
        }
        Capacitadores other = (Capacitadores) object;
        if ((this.capacitadoresPK == null && other.capacitadoresPK != null) || (this.capacitadoresPK != null && !this.capacitadoresPK.equals(other.capacitadoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Capacitadores[ capacitadoresPK=" + capacitadoresPK + " ]";
    }
    
}
