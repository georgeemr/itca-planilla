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
@Table(name = "NOM_CHEQUE_EMP", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NomChequeEmp.findAll", query = "SELECT n FROM NomChequeEmp n"),
    @NamedQuery(name = "NomChequeEmp.findByCodCia", query = "SELECT n FROM NomChequeEmp n WHERE n.nomChequeEmpPK.codCia = :codCia"),
    @NamedQuery(name = "NomChequeEmp.findByCodEmp", query = "SELECT n FROM NomChequeEmp n WHERE n.nomChequeEmpPK.codEmp = :codEmp"),
    @NamedQuery(name = "NomChequeEmp.findByNombre", query = "SELECT n FROM NomChequeEmp n WHERE n.nombre = :nombre")})
public class NomChequeEmp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NomChequeEmpPK nomChequeEmpPK;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    public NomChequeEmp() {
    }

    public NomChequeEmp(NomChequeEmpPK nomChequeEmpPK) {
        this.nomChequeEmpPK = nomChequeEmpPK;
    }

    public NomChequeEmp(NomChequeEmpPK nomChequeEmpPK, String nombre) {
        this.nomChequeEmpPK = nomChequeEmpPK;
        this.nombre = nombre;
    }

    public NomChequeEmp(short codCia, int codEmp) {
        this.nomChequeEmpPK = new NomChequeEmpPK(codCia, codEmp);
    }

    public NomChequeEmpPK getNomChequeEmpPK() {
        return nomChequeEmpPK;
    }

    public void setNomChequeEmpPK(NomChequeEmpPK nomChequeEmpPK) {
        this.nomChequeEmpPK = nomChequeEmpPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomChequeEmpPK != null ? nomChequeEmpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NomChequeEmp)) {
            return false;
        }
        NomChequeEmp other = (NomChequeEmp) object;
        if ((this.nomChequeEmpPK == null && other.nomChequeEmpPK != null) || (this.nomChequeEmpPK != null && !this.nomChequeEmpPK.equals(other.nomChequeEmpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.NomChequeEmp[ nomChequeEmpPK=" + nomChequeEmpPK + " ]";
    }
    
}
