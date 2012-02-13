/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ITEM_X_PERFIL", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemXPerfil.findAll", query = "SELECT i FROM ItemXPerfil i"),
    @NamedQuery(name = "ItemXPerfil.findByCodCia", query = "SELECT i FROM ItemXPerfil i WHERE i.itemXPerfilPK.codCia = :codCia"),
    @NamedQuery(name = "ItemXPerfil.findByCodPerfil", query = "SELECT i FROM ItemXPerfil i WHERE i.itemXPerfilPK.codPerfil = :codPerfil"),
    @NamedQuery(name = "ItemXPerfil.findByCodItemPerfil", query = "SELECT i FROM ItemXPerfil i WHERE i.itemXPerfilPK.codItemPerfil = :codItemPerfil")})
public class ItemXPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemXPerfilPK itemXPerfilPK;
    @ManyToMany(mappedBy = "itemXPerfilList")
    private List<Candidato> candidatoList;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Perfil perfil;

    public ItemXPerfil() {
    }

    public ItemXPerfil(ItemXPerfilPK itemXPerfilPK) {
        this.itemXPerfilPK = itemXPerfilPK;
    }

    public ItemXPerfil(short codCia, int codPerfil, int codItemPerfil) {
        this.itemXPerfilPK = new ItemXPerfilPK(codCia, codPerfil, codItemPerfil);
    }

    public ItemXPerfilPK getItemXPerfilPK() {
        return itemXPerfilPK;
    }

    public void setItemXPerfilPK(ItemXPerfilPK itemXPerfilPK) {
        this.itemXPerfilPK = itemXPerfilPK;
    }

    @XmlTransient
    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }

    public void setCandidatoList(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemXPerfilPK != null ? itemXPerfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemXPerfil)) {
            return false;
        }
        ItemXPerfil other = (ItemXPerfil) object;
        if ((this.itemXPerfilPK == null && other.itemXPerfilPK != null) || (this.itemXPerfilPK != null && !this.itemXPerfilPK.equals(other.itemXPerfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ItemXPerfil[ itemXPerfilPK=" + itemXPerfilPK + " ]";
    }
    
}
