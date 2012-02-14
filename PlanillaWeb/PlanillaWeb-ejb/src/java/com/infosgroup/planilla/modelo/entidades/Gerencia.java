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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "GERENCIA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerencia.findAll", query = "SELECT g FROM Gerencia g"),
    @NamedQuery(name = "Gerencia.findByCodCia", query = "SELECT g FROM Gerencia g WHERE g.gerenciaPK.codCia = :codCia"),
    @NamedQuery(name = "Gerencia.findByCodGerencia", query = "SELECT g FROM Gerencia g WHERE g.gerenciaPK.codGerencia = :codGerencia"),
    @NamedQuery(name = "Gerencia.findByNomGerencia", query = "SELECT g FROM Gerencia g WHERE g.nomGerencia = :nomGerencia")})
public class Gerencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GerenciaPK gerenciaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOM_GERENCIA", nullable = false, length = 100)
    private String nomGerencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gerencia")
    private List<Posicion> posicionList;

    public Gerencia() {
    }

    public Gerencia(GerenciaPK gerenciaPK) {
        this.gerenciaPK = gerenciaPK;
    }

    public Gerencia(GerenciaPK gerenciaPK, String nomGerencia) {
        this.gerenciaPK = gerenciaPK;
        this.nomGerencia = nomGerencia;
    }

    public Gerencia(short codCia, short codGerencia) {
        this.gerenciaPK = new GerenciaPK(codCia, codGerencia);
    }

    public GerenciaPK getGerenciaPK() {
        return gerenciaPK;
    }

    public void setGerenciaPK(GerenciaPK gerenciaPK) {
        this.gerenciaPK = gerenciaPK;
    }

    public String getNomGerencia() {
        return nomGerencia;
    }

    public void setNomGerencia(String nomGerencia) {
        this.nomGerencia = nomGerencia;
    }

    @XmlTransient
    public List<Posicion> getPosicionList() {
        return posicionList;
    }

    public void setPosicionList(List<Posicion> posicionList) {
        this.posicionList = posicionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gerenciaPK != null ? gerenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerencia)) {
            return false;
        }
        Gerencia other = (Gerencia) object;
        if ((this.gerenciaPK == null && other.gerenciaPK != null) || (this.gerenciaPK != null && !this.gerenciaPK.equals(other.gerenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Gerencia[ gerenciaPK=" + gerenciaPK + " ]";
    }
    
}
