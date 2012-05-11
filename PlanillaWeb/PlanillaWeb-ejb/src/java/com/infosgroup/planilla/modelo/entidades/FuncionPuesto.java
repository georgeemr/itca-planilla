/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "FUNCION_PUESTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionPuesto.findAll", query = "SELECT f FROM FuncionPuesto f"),
    @NamedQuery(name = "FuncionPuesto.findByCodCia", query = "SELECT f FROM FuncionPuesto f WHERE f.funcionPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "FuncionPuesto.findByCodFuncion", query = "SELECT f FROM FuncionPuesto f WHERE f.funcionPuestoPK.codFuncion = :codFuncion"),
    @NamedQuery(name = "FuncionPuesto.findByNomFuncion", query = "SELECT f FROM FuncionPuesto f WHERE f.nomFuncion = :nomFuncion"),
    @NamedQuery(name = "FuncionPuesto.findByDescFuncion", query = "SELECT f FROM FuncionPuesto f WHERE f.descFuncion = :descFuncion"),
    @NamedQuery(name = "FuncionPuesto.findByCodTipoPuesto", query = "SELECT f FROM FuncionPuesto f WHERE f.codTipoPuesto = :codTipoPuesto")})
public class FuncionPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FuncionPuestoPK funcionPuestoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOM_FUNCION", nullable = false, length = 200)
    private String nomFuncion;
    @Size(max = 250)
    @Column(name = "DESC_FUNCION", length = 250)
    private String descFuncion;
    @Column(name = "COD_TIPO_PUESTO")
    private Short codTipoPuesto;
    @JoinTable(name = "FUNCION_X_PUESTO", 
    joinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_FUNCION", referencedColumnName = "COD_FUNCION", nullable = false)}, 
    inverseJoinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_PUESTO", referencedColumnName = "COD_PUESTO", nullable = false)})
    @ManyToMany
    private List<Puestos> puestosList;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_FRECUENCIA", referencedColumnName = "COD_FRECUENCIA")})
    @ManyToOne(optional = false)
    private FrecuenciaFuncion frecuenciaFuncion;

    public FuncionPuesto() {
    }

    public FuncionPuesto(FuncionPuestoPK funcionPuestoPK) {
        this.funcionPuestoPK = funcionPuestoPK;
    }

    public FuncionPuesto(FuncionPuestoPK funcionPuestoPK, String nomFuncion) {
        this.funcionPuestoPK = funcionPuestoPK;
        this.nomFuncion = nomFuncion;
    }

    public FuncionPuesto(short codCia, int codFuncion) {
        this.funcionPuestoPK = new FuncionPuestoPK(codCia, codFuncion);
    }

    public FuncionPuestoPK getFuncionPuestoPK() {
        return funcionPuestoPK;
    }

    public void setFuncionPuestoPK(FuncionPuestoPK funcionPuestoPK) {
        this.funcionPuestoPK = funcionPuestoPK;
    }

    public String getNomFuncion() {
        return nomFuncion;
    }

    public void setNomFuncion(String nomFuncion) {
        this.nomFuncion = nomFuncion;
    }

    public String getDescFuncion() {
        return descFuncion;
    }

    public void setDescFuncion(String descFuncion) {
        this.descFuncion = descFuncion;
    }

    public Short getCodTipoPuesto() {
        return codTipoPuesto;
    }

    public void setCodTipoPuesto(Short codTipoPuesto) {
        this.codTipoPuesto = codTipoPuesto;
    }

    @XmlTransient
    public List<Puestos> getPuestosList() {
        return puestosList;
    }

    public void setPuestosList(List<Puestos> puestosList) {
        this.puestosList = puestosList;
    }

    public FrecuenciaFuncion getFrecuenciaFuncion() {
        return frecuenciaFuncion;
    }

    public void setFrecuenciaFuncion(FrecuenciaFuncion frecuenciaFuncion) {
        this.frecuenciaFuncion = frecuenciaFuncion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionPuestoPK != null ? funcionPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionPuesto)) {
            return false;
        }
        FuncionPuesto other = (FuncionPuesto) object;
        if ((this.funcionPuestoPK == null && other.funcionPuestoPK != null) || (this.funcionPuestoPK != null && !this.funcionPuestoPK.equals(other.funcionPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.FuncionPuesto[ funcionPuestoPK=" + funcionPuestoPK + " ]";
    }
    
}
