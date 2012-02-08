/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CONTACTOS_X_PUESTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactosXPuesto.findAll", query = "SELECT c FROM ContactosXPuesto c"),
    @NamedQuery(name = "ContactosXPuesto.findByCodCia", query = "SELECT c FROM ContactosXPuesto c WHERE c.contactosXPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "ContactosXPuesto.findByCodContacto", query = "SELECT c FROM ContactosXPuesto c WHERE c.contactosXPuestoPK.codContacto = :codContacto"),
    @NamedQuery(name = "ContactosXPuesto.findByCodPuesto", query = "SELECT c FROM ContactosXPuesto c WHERE c.contactosXPuestoPK.codPuesto = :codPuesto"),
    @NamedQuery(name = "ContactosXPuesto.findByNomContacto", query = "SELECT c FROM ContactosXPuesto c WHERE c.nomContacto = :nomContacto"),
    @NamedQuery(name = "ContactosXPuesto.findByTipoContacto", query = "SELECT c FROM ContactosXPuesto c WHERE c.tipoContacto = :tipoContacto"),
    @NamedQuery(name = "ContactosXPuesto.findByDescRelacion", query = "SELECT c FROM ContactosXPuesto c WHERE c.descRelacion = :descRelacion")})
public class ContactosXPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContactosXPuestoPK contactosXPuestoPK;
    @Column(name = "NOM_CONTACTO", length = 150)
    private String nomContacto;
    @Column(name = "TIPO_CONTACTO", length = 1)
    private String tipoContacto;
    @Column(name = "DESC_RELACION", length = 400)
    private String descRelacion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Puestos puestos;

    public ContactosXPuesto() {
    }

    public ContactosXPuesto(ContactosXPuestoPK contactosXPuestoPK) {
        this.contactosXPuestoPK = contactosXPuestoPK;
    }

    public ContactosXPuesto(short codCia, short codContacto, short codPuesto) {
        this.contactosXPuestoPK = new ContactosXPuestoPK(codCia, codContacto, codPuesto);
    }

    public ContactosXPuestoPK getContactosXPuestoPK() {
        return contactosXPuestoPK;
    }

    public void setContactosXPuestoPK(ContactosXPuestoPK contactosXPuestoPK) {
        this.contactosXPuestoPK = contactosXPuestoPK;
    }

    public String getNomContacto() {
        return nomContacto;
    }

    public void setNomContacto(String nomContacto) {
        this.nomContacto = nomContacto;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public String getDescRelacion() {
        return descRelacion;
    }

    public void setDescRelacion(String descRelacion) {
        this.descRelacion = descRelacion;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactosXPuestoPK != null ? contactosXPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactosXPuesto)) {
            return false;
        }
        ContactosXPuesto other = (ContactosXPuesto) object;
        if ((this.contactosXPuestoPK == null && other.contactosXPuestoPK != null) || (this.contactosXPuestoPK != null && !this.contactosXPuestoPK.equals(other.contactosXPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.ContactosXPuesto[ contactosXPuestoPK=" + contactosXPuestoPK + " ]";
    }
    
}
