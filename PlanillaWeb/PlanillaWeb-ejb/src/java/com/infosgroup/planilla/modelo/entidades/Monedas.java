/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "MONEDAS", catalog = "", schema = "PARAMETROS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monedas.findAll", query = "SELECT m FROM Monedas m"),
    @NamedQuery(name = "Monedas.findByCodMoneda", query = "SELECT m FROM Monedas m WHERE m.codMoneda = :codMoneda"),
    @NamedQuery(name = "Monedas.findByNomMoneda", query = "SELECT m FROM Monedas m WHERE m.nomMoneda = :nomMoneda"),
    @NamedQuery(name = "Monedas.findByNomCorto", query = "SELECT m FROM Monedas m WHERE m.nomCorto = :nomCorto"),
    @NamedQuery(name = "Monedas.findBySigno", query = "SELECT m FROM Monedas m WHERE m.signo = :signo")})
public class Monedas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_MONEDA", nullable = false)
    private Short codMoneda;
    @Column(name = "NOM_MONEDA", length = 60)
    private String nomMoneda;
    @Column(name = "NOM_CORTO", length = 10)
    private String nomCorto;
    @Column(name = "SIGNO", length = 3)
    private String signo;

    public Monedas() {
    }

    public Monedas(Short codMoneda) {
        this.codMoneda = codMoneda;
    }

    public Short getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(Short codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getNomMoneda() {
        return nomMoneda;
    }

    public void setNomMoneda(String nomMoneda) {
        this.nomMoneda = nomMoneda;
    }

    public String getNomCorto() {
        return nomCorto;
    }

    public void setNomCorto(String nomCorto) {
        this.nomCorto = nomCorto;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMoneda != null ? codMoneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monedas)) {
            return false;
        }
        Monedas other = (Monedas) object;
        if ((this.codMoneda == null && other.codMoneda != null) || (this.codMoneda != null && !this.codMoneda.equals(other.codMoneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.parametros.Monedas[ codMoneda=" + codMoneda + " ]";
    }
    
}
