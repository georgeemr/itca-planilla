/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class ItemPerfilPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "COD_ITEM_PERFIL", nullable = false)
    private int codItemPerfil;

    public ItemPerfilPK() {
    }

    public ItemPerfilPK(short codCia, int codItemPerfil) {
        this.codCia = codCia;
        this.codItemPerfil = codItemPerfil;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public int getCodItemPerfil() {
        return codItemPerfil;
    }

    public void setCodItemPerfil(int codItemPerfil) {
        this.codItemPerfil = codItemPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codItemPerfil;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPerfilPK)) {
            return false;
        }
        ItemPerfilPK other = (ItemPerfilPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codItemPerfil != other.codItemPerfil) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ItemPerfilPK[ codCia=" + codCia + ", codItemPerfil=" + codItemPerfil + " ]";
    }
    
}
