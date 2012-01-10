/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.entity;

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

/**
 *
 * @author Soporte
 */
@Entity
@Table(name = "SERVIDOR", catalog = "", schema = "FROGS")
@NamedQueries({
    @NamedQuery(name = "Servidor.findAll", query = "SELECT s FROM Servidor s"),
    @NamedQuery(name = "Servidor.findByCodCia", query = "SELECT s FROM Servidor s WHERE s.servidorPK.codCia = :codCia"),
    @NamedQuery(name = "Servidor.findByCodAgencia", query = "SELECT s FROM Servidor s WHERE s.servidorPK.codAgencia = :codAgencia"),
    @NamedQuery(name = "Servidor.findByServidor", query = "SELECT s FROM Servidor s WHERE s.servidorPK.servidor = :servidor"),
    @NamedQuery(name = "Servidor.findByDescripcion", query = "SELECT s FROM Servidor s WHERE s.descripcion = :descripcion")})
public class Servidor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServidorPK servidorPK;
    @Column(name = "DESCRIPCION", length = 100)
    private String descripcion;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_AGENCIA", referencedColumnName = "COD_AGENCIA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Agencias agencias;

    public Servidor() {
    }

    public Servidor(ServidorPK servidorPK) {
        this.servidorPK = servidorPK;
    }

    public Servidor(short codCia, short codAgencia, String servidor) {
        this.servidorPK = new ServidorPK(codCia, codAgencia, servidor);
    }

    public ServidorPK getServidorPK() {
        return servidorPK;
    }

    public void setServidorPK(ServidorPK servidorPK) {
        this.servidorPK = servidorPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Agencias getAgencias() {
        return agencias;
    }

    public void setAgencias(Agencias agencias) {
        this.agencias = agencias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servidorPK != null ? servidorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servidor)) {
            return false;
        }
        Servidor other = (Servidor) object;
        if ((this.servidorPK == null && other.servidorPK != null) || (this.servidorPK != null && !this.servidorPK.equals(other.servidorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.entity.Servidor[servidorPK=" + servidorPK + "]";
    }

}
