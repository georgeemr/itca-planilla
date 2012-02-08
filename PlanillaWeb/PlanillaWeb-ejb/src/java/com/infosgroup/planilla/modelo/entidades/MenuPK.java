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
public class MenuPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_MODULO", nullable = false)
    private long codModulo;
    @Basic(optional = false)
    @Column(name = "COD_MENU", nullable = false)
    private long codMenu;

    public MenuPK() {
    }

    public MenuPK(long codCia, long codModulo, long codMenu) {
        this.codCia = codCia;
        this.codModulo = codModulo;
        this.codMenu = codMenu;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(long codModulo) {
        this.codModulo = codModulo;
    }

    public long getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(long codMenu) {
        this.codMenu = codMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codModulo;
        hash += (int) codMenu;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuPK)) {
            return false;
        }
        MenuPK other = (MenuPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codModulo != other.codModulo) {
            return false;
        }
        if (this.codMenu != other.codMenu) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.MenuPK[ codCia=" + codCia + ", codModulo=" + codModulo + ", codMenu=" + codMenu + " ]";
    }
    
}
