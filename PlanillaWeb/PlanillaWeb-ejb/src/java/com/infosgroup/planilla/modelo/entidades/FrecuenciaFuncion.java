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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "FRECUENCIA_FUNCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrecuenciaFuncion.findAll", query = "SELECT f FROM FrecuenciaFuncion f"),
    @NamedQuery(name = "FrecuenciaFuncion.findByCodCia", query = "SELECT f FROM FrecuenciaFuncion f WHERE f.frecuenciaFuncionPK.codCia = :codCia"),
    @NamedQuery(name = "FrecuenciaFuncion.findByCodFrecuencia", query = "SELECT f FROM FrecuenciaFuncion f WHERE f.frecuenciaFuncionPK.codFrecuencia = :codFrecuencia"),
    @NamedQuery(name = "FrecuenciaFuncion.findByNomFrecuencia", query = "SELECT f FROM FrecuenciaFuncion f WHERE f.nomFrecuencia = :nomFrecuencia")})
public class FrecuenciaFuncion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FrecuenciaFuncionPK frecuenciaFuncionPK;
    @Basic(optional = false)
    @Column(name = "NOM_FRECUENCIA", nullable = false, length = 200)
    private String nomFrecuencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "frecuenciaFuncion")
    private List<FuncionPuesto> funcionPuestoList;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cias cias;

    public FrecuenciaFuncion() {
    }

    public FrecuenciaFuncion(FrecuenciaFuncionPK frecuenciaFuncionPK) {
        this.frecuenciaFuncionPK = frecuenciaFuncionPK;
    }

    public FrecuenciaFuncion(FrecuenciaFuncionPK frecuenciaFuncionPK, String nomFrecuencia) {
        this.frecuenciaFuncionPK = frecuenciaFuncionPK;
        this.nomFrecuencia = nomFrecuencia;
    }

    public FrecuenciaFuncion(short codCia, short codFrecuencia) {
        this.frecuenciaFuncionPK = new FrecuenciaFuncionPK(codCia, codFrecuencia);
    }

    public FrecuenciaFuncionPK getFrecuenciaFuncionPK() {
        return frecuenciaFuncionPK;
    }

    public void setFrecuenciaFuncionPK(FrecuenciaFuncionPK frecuenciaFuncionPK) {
        this.frecuenciaFuncionPK = frecuenciaFuncionPK;
    }

    public String getNomFrecuencia() {
        return nomFrecuencia;
    }

    public void setNomFrecuencia(String nomFrecuencia) {
        this.nomFrecuencia = nomFrecuencia;
    }

    @XmlTransient
    public List<FuncionPuesto> getFuncionPuestoList() {
        return funcionPuestoList;
    }

    public void setFuncionPuestoList(List<FuncionPuesto> funcionPuestoList) {
        this.funcionPuestoList = funcionPuestoList;
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
        hash += (frecuenciaFuncionPK != null ? frecuenciaFuncionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrecuenciaFuncion)) {
            return false;
        }
        FrecuenciaFuncion other = (FrecuenciaFuncion) object;
        if ((this.frecuenciaFuncionPK == null && other.frecuenciaFuncionPK != null) || (this.frecuenciaFuncionPK != null && !this.frecuenciaFuncionPK.equals(other.frecuenciaFuncionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.FrecuenciaFuncion[ frecuenciaFuncionPK=" + frecuenciaFuncionPK + " ]";
    }
    
}
