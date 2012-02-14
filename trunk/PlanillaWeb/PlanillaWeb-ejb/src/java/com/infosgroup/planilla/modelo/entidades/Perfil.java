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
@Table(name = "PERFIL", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByCodCia", query = "SELECT p FROM Perfil p WHERE p.perfilPK.codCia = :codCia"),
    @NamedQuery(name = "Perfil.findByCodPerfil", query = "SELECT p FROM Perfil p WHERE p.perfilPK.codPerfil = :codPerfil"),
    @NamedQuery(name = "Perfil.findByNomPerfil", query = "SELECT p FROM Perfil p WHERE p.nomPerfil = :nomPerfil"),
    @NamedQuery(name = "Perfil.findByDescripcionPerfil", query = "SELECT p FROM Perfil p WHERE p.descripcionPerfil = :descripcionPerfil"),
    @NamedQuery(name = "Perfil.findByCodTipoPuesto", query = "SELECT p FROM Perfil p WHERE p.codTipoPuesto = :codTipoPuesto"),
    @NamedQuery(name = "Perfil.findByTipo", query = "SELECT p FROM Perfil p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Perfil.findByValor", query = "SELECT p FROM Perfil p WHERE p.valor = :valor")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilPK perfilPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOM_PERFIL", nullable = false, length = 200)
    private String nomPerfil;
    @Size(max = 250)
    @Column(name = "DESCRIPCION_PERFIL", length = 250)
    private String descripcionPerfil;
    @Column(name = "COD_TIPO_PUESTO")
    private Short codTipoPuesto;
    @Size(max = 1)
    @Column(name = "TIPO", length = 1)
    private String tipo;
    @Column(name = "VALOR")
    private Long valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<ItemXPerfil> itemXPerfilList;

    public Perfil() {
    }

    public Perfil(PerfilPK perfilPK) {
        this.perfilPK = perfilPK;
    }

    public Perfil(PerfilPK perfilPK, String nomPerfil) {
        this.perfilPK = perfilPK;
        this.nomPerfil = nomPerfil;
    }

    public Perfil(short codCia, int codPerfil) {
        this.perfilPK = new PerfilPK(codCia, codPerfil);
    }

    public PerfilPK getPerfilPK() {
        return perfilPK;
    }

    public void setPerfilPK(PerfilPK perfilPK) {
        this.perfilPK = perfilPK;
    }

    public String getNomPerfil() {
        return nomPerfil;
    }

    public void setNomPerfil(String nomPerfil) {
        this.nomPerfil = nomPerfil;
    }

    public String getDescripcionPerfil() {
        return descripcionPerfil;
    }

    public void setDescripcionPerfil(String descripcionPerfil) {
        this.descripcionPerfil = descripcionPerfil;
    }

    public Short getCodTipoPuesto() {
        return codTipoPuesto;
    }

    public void setCodTipoPuesto(Short codTipoPuesto) {
        this.codTipoPuesto = codTipoPuesto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<ItemXPerfil> getItemXPerfilList() {
        return itemXPerfilList;
    }

    public void setItemXPerfilList(List<ItemXPerfil> itemXPerfilList) {
        this.itemXPerfilList = itemXPerfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilPK != null ? perfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.perfilPK == null && other.perfilPK != null) || (this.perfilPK != null && !this.perfilPK.equals(other.perfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Perfil[ perfilPK=" + perfilPK + " ]";
    }
    
}
