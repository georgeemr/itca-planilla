/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "BANCOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bancos.findAll", query = "SELECT b FROM Bancos b"),
    @NamedQuery(name = "Bancos.findByCodCia", query = "SELECT b FROM Bancos b WHERE b.bancosPK.codCia = :codCia"),
    @NamedQuery(name = "Bancos.findByCodBanco", query = "SELECT b FROM Bancos b WHERE b.bancosPK.codBanco = :codBanco"),
    @NamedQuery(name = "Bancos.findByNomBanco", query = "SELECT b FROM Bancos b WHERE b.nomBanco = :nomBanco"),
    @NamedQuery(name = "Bancos.findByDireccion", query = "SELECT b FROM Bancos b WHERE b.direccion = :direccion"),
    @NamedQuery(name = "Bancos.findByTelefono1", query = "SELECT b FROM Bancos b WHERE b.telefono1 = :telefono1"),
    @NamedQuery(name = "Bancos.findByTelefono2", query = "SELECT b FROM Bancos b WHERE b.telefono2 = :telefono2"),
    @NamedQuery(name = "Bancos.findByContacto", query = "SELECT b FROM Bancos b WHERE b.contacto = :contacto"),
    @NamedQuery(name = "Bancos.findByObservaciones", query = "SELECT b FROM Bancos b WHERE b.observaciones = :observaciones"),
    @NamedQuery(name = "Bancos.findByDiasMaxNotas", query = "SELECT b FROM Bancos b WHERE b.diasMaxNotas = :diasMaxNotas"),
    @NamedQuery(name = "Bancos.findByDiasMaxCheques", query = "SELECT b FROM Bancos b WHERE b.diasMaxCheques = :diasMaxCheques")})
public class Bancos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BancosPK bancosPK;
    @Basic(optional = false)
    @Column(name = "NOM_BANCO", nullable = false, length = 100)
    private String nomBanco;
    @Column(name = "DIRECCION", length = 100)
    private String direccion;
    @Column(name = "TELEFONO1", length = 10)
    private String telefono1;
    @Column(name = "TELEFONO2", length = 10)
    private String telefono2;
    @Column(name = "CONTACTO", length = 100)
    private String contacto;
    @Column(name = "OBSERVACIONES", length = 60)
    private String observaciones;
    @Column(name = "DIAS_MAX_NOTAS")
    private BigInteger diasMaxNotas;
    @Column(name = "DIAS_MAX_CHEQUES")
    private BigInteger diasMaxCheques;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cias cias;

    public Bancos() {
    }

    public Bancos(BancosPK bancosPK) {
        this.bancosPK = bancosPK;
    }

    public Bancos(BancosPK bancosPK, String nomBanco) {
        this.bancosPK = bancosPK;
        this.nomBanco = nomBanco;
    }

    public Bancos(short codCia, String codBanco) {
        this.bancosPK = new BancosPK(codCia, codBanco);
    }

    public BancosPK getBancosPK() {
        return bancosPK;
    }

    public void setBancosPK(BancosPK bancosPK) {
        this.bancosPK = bancosPK;
    }

    public String getNomBanco() {
        return nomBanco;
    }

    public void setNomBanco(String nomBanco) {
        this.nomBanco = nomBanco;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigInteger getDiasMaxNotas() {
        return diasMaxNotas;
    }

    public void setDiasMaxNotas(BigInteger diasMaxNotas) {
        this.diasMaxNotas = diasMaxNotas;
    }

    public BigInteger getDiasMaxCheques() {
        return diasMaxCheques;
    }

    public void setDiasMaxCheques(BigInteger diasMaxCheques) {
        this.diasMaxCheques = diasMaxCheques;
    }

    public Cias getCias() {
        return cias;
    }

    public void setCias(Cias cias) {
        this.cias = cias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bancosPK != null ? bancosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bancos)) {
            return false;
        }
        Bancos other = (Bancos) object;
        if ((this.bancosPK == null && other.bancosPK != null) || (this.bancosPK != null && !this.bancosPK.equals(other.bancosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Bancos[ bancosPK=" + bancosPK + " ]";
    }
    
}
