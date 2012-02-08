/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PARENTESCO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parentesco.findAll", query = "SELECT p FROM Parentesco p"),
    @NamedQuery(name = "Parentesco.findByCodigo", query = "SELECT p FROM Parentesco p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Parentesco.findByNombreParentesco", query = "SELECT p FROM Parentesco p WHERE p.nombreParentesco = :nombreParentesco")})
public class Parentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;
    @Basic(optional = false)
    @Column(name = "NOMBRE_PARENTESCO", nullable = false, length = 200)
    private String nombreParentesco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentesco")
    private List<BeneficiarioPorCandidato> beneficiarioPorCandidatoList;

    public Parentesco() {
    }

    public Parentesco(Long codigo) {
        this.codigo = codigo;
    }

    public Parentesco(Long codigo, String nombreParentesco) {
        this.codigo = codigo;
        this.nombreParentesco = nombreParentesco;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombreParentesco() {
        return nombreParentesco;
    }

    public void setNombreParentesco(String nombreParentesco) {
        this.nombreParentesco = nombreParentesco;
    }

    @XmlTransient
    public List<BeneficiarioPorCandidato> getBeneficiarioPorCandidatoList() {
        return beneficiarioPorCandidatoList;
    }

    public void setBeneficiarioPorCandidatoList(List<BeneficiarioPorCandidato> beneficiarioPorCandidatoList) {
        this.beneficiarioPorCandidatoList = beneficiarioPorCandidatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parentesco)) {
            return false;
        }
        Parentesco other = (Parentesco) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Parentesco[ codigo=" + codigo + " ]";
    }
    
}
