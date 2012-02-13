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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ITEM_PERFIL", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemPerfil.findAll", query = "SELECT i FROM ItemPerfil i"),
    @NamedQuery(name = "ItemPerfil.findByCodCia", query = "SELECT i FROM ItemPerfil i WHERE i.itemPerfilPK.codCia = :codCia"),
    @NamedQuery(name = "ItemPerfil.findByCodItemPerfil", query = "SELECT i FROM ItemPerfil i WHERE i.itemPerfilPK.codItemPerfil = :codItemPerfil"),
    @NamedQuery(name = "ItemPerfil.findByDescripcionItemPerfil", query = "SELECT i FROM ItemPerfil i WHERE i.descripcionItemPerfil = :descripcionItemPerfil"),
    @NamedQuery(name = "ItemPerfil.findByClase", query = "SELECT i FROM ItemPerfil i WHERE i.clase = :clase")})
public class ItemPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemPerfilPK itemPerfilPK;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_ITEM_PERFIL", nullable = false, length = 500)
    private String descripcionItemPerfil;
    @Column(name = "CLASE", length = 1)
    private String clase;

    public ItemPerfil() {
    }

    public ItemPerfil(ItemPerfilPK itemPerfilPK) {
        this.itemPerfilPK = itemPerfilPK;
    }

    public ItemPerfil(ItemPerfilPK itemPerfilPK, String descripcionItemPerfil) {
        this.itemPerfilPK = itemPerfilPK;
        this.descripcionItemPerfil = descripcionItemPerfil;
    }

    public ItemPerfil(short codCia, int codItemPerfil) {
        this.itemPerfilPK = new ItemPerfilPK(codCia, codItemPerfil);
    }

    public ItemPerfilPK getItemPerfilPK() {
        return itemPerfilPK;
    }

    public void setItemPerfilPK(ItemPerfilPK itemPerfilPK) {
        this.itemPerfilPK = itemPerfilPK;
    }

    public String getDescripcionItemPerfil() {
        return descripcionItemPerfil;
    }

    public void setDescripcionItemPerfil(String descripcionItemPerfil) {
        this.descripcionItemPerfil = descripcionItemPerfil;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemPerfilPK != null ? itemPerfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPerfil)) {
            return false;
        }
        ItemPerfil other = (ItemPerfil) object;
        if ((this.itemPerfilPK == null && other.itemPerfilPK != null) || (this.itemPerfilPK != null && !this.itemPerfilPK.equals(other.itemPerfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ItemPerfil[ itemPerfilPK=" + itemPerfilPK + " ]";
    }
    
}
