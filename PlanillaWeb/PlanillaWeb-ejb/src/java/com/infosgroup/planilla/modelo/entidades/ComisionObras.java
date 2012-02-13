/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "COMISION_OBRAS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComisionObras.findAll", query = "SELECT c FROM ComisionObras c"),
    @NamedQuery(name = "ComisionObras.findByCodCia", query = "SELECT c FROM ComisionObras c WHERE c.comisionObrasPK.codCia = :codCia"),
    @NamedQuery(name = "ComisionObras.findByCodEmp", query = "SELECT c FROM ComisionObras c WHERE c.comisionObrasPK.codEmp = :codEmp"),
    @NamedQuery(name = "ComisionObras.findByTipoObra", query = "SELECT c FROM ComisionObras c WHERE c.comisionObrasPK.tipoObra = :tipoObra")})
public class ComisionObras implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComisionObrasPK comisionObrasPK;

    public ComisionObras() {
    }

    public ComisionObras(ComisionObrasPK comisionObrasPK) {
        this.comisionObrasPK = comisionObrasPK;
    }

    public ComisionObras(short codCia, int codEmp, String tipoObra) {
        this.comisionObrasPK = new ComisionObrasPK(codCia, codEmp, tipoObra);
    }

    public ComisionObrasPK getComisionObrasPK() {
        return comisionObrasPK;
    }

    public void setComisionObrasPK(ComisionObrasPK comisionObrasPK) {
        this.comisionObrasPK = comisionObrasPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comisionObrasPK != null ? comisionObrasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionObras)) {
            return false;
        }
        ComisionObras other = (ComisionObras) object;
        if ((this.comisionObrasPK == null && other.comisionObrasPK != null) || (this.comisionObrasPK != null && !this.comisionObrasPK.equals(other.comisionObrasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ComisionObras[ comisionObrasPK=" + comisionObrasPK + " ]";
    }
    
}
