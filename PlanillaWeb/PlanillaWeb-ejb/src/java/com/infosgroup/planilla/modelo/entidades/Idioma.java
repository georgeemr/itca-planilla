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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "IDIOMA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idioma.findAll", query = "SELECT i FROM Idioma i"),
    @NamedQuery(name = "Idioma.findByCodCia", query = "SELECT i FROM Idioma i WHERE i.idiomaPK.codCia = :codCia"),
    @NamedQuery(name = "Idioma.findByCodIdioma", query = "SELECT i FROM Idioma i WHERE i.idiomaPK.codIdioma = :codIdioma"),
    @NamedQuery(name = "Idioma.findByNomIdioma", query = "SELECT i FROM Idioma i WHERE i.nomIdioma = :nomIdioma")})
public class Idioma implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IdiomaPK idiomaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOM_IDIOMA", nullable = false, length = 200)
    private String nomIdioma;

    public Idioma() {
    }

    public Idioma(IdiomaPK idiomaPK) {
        this.idiomaPK = idiomaPK;
    }

    public Idioma(IdiomaPK idiomaPK, String nomIdioma) {
        this.idiomaPK = idiomaPK;
        this.nomIdioma = nomIdioma;
    }

    public Idioma(short codCia, int codIdioma) {
        this.idiomaPK = new IdiomaPK(codCia, codIdioma);
    }

    public IdiomaPK getIdiomaPK() {
        return idiomaPK;
    }

    public void setIdiomaPK(IdiomaPK idiomaPK) {
        this.idiomaPK = idiomaPK;
    }

    public String getNomIdioma() {
        return nomIdioma;
    }

    public void setNomIdioma(String nomIdioma) {
        this.nomIdioma = nomIdioma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idiomaPK != null ? idiomaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idioma)) {
            return false;
        }
        Idioma other = (Idioma) object;
        if ((this.idiomaPK == null && other.idiomaPK != null) || (this.idiomaPK != null && !this.idiomaPK.equals(other.idiomaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Idioma[ idiomaPK=" + idiomaPK + " ]";
    }
    
}
