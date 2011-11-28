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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Soporte
 */
@Entity
@Table(name = "indicador")
@NamedQueries({
    @NamedQuery(name = "Indicador.findAll", query = "SELECT i FROM Indicador i"),
    @NamedQuery(name = "Indicador.findByCodCia", query = "SELECT i FROM Indicador i WHERE i.indicadorPK.codCia = :codCia"),
    @NamedQuery(name = "Indicador.findByModulo", query = "SELECT i FROM Indicador i WHERE i.indicadorPK.modulo = :modulo"),
    @NamedQuery(name = "Indicador.findByNombreModulo", query = "SELECT i FROM Indicador i WHERE i.nombreModulo = :nombreModulo"),
    @NamedQuery(name = "Indicador.findByIndicador", query = "SELECT i FROM Indicador i WHERE i.indicadorPK.indicador = :indicador"),
    @NamedQuery(name = "Indicador.findByNombreIndicador", query = "SELECT i FROM Indicador i WHERE i.nombreIndicador = :nombreIndicador"),
    @NamedQuery(name = "Indicador.findByValorIndicador", query = "SELECT i FROM Indicador i WHERE i.valorIndicador = :valorIndicador"),
    @NamedQuery(name = "Indicador.findByOrden", query = "SELECT i FROM Indicador i WHERE i.orden = :orden")})
public class Indicador implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IndicadorPK indicadorPK;
    @Size(max = 2147483647)
    @Column(name = "nombre_modulo", length = 2147483647)
    private String nombreModulo;
    @Size(max = 2147483647)
    @Column(name = "nombre_indicador", length = 2147483647)
    private String nombreIndicador;
    @Size(max = 2147483647)
    @Column(name = "valor_indicador", length = 2147483647)
    private String valorIndicador;
    @Column(name = "orden")
    private Integer orden;
    @JoinColumn(name = "cod_cia", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compania compania;

    public Indicador() {
    }

    public Indicador(IndicadorPK indicadorPK) {
        this.indicadorPK = indicadorPK;
    }

    public Indicador(int codCia, int modulo, int indicador) {
        this.indicadorPK = new IndicadorPK(codCia, modulo, indicador);
    }

    public IndicadorPK getIndicadorPK() {
        return indicadorPK;
    }

    public void setIndicadorPK(IndicadorPK indicadorPK) {
        this.indicadorPK = indicadorPK;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public String getNombreIndicador() {
        return nombreIndicador;
    }

    public void setNombreIndicador(String nombreIndicador) {
        this.nombreIndicador = nombreIndicador;
    }

    public String getValorIndicador() {
        return valorIndicador;
    }

    public void setValorIndicador(String valorIndicador) {
        this.valorIndicador = valorIndicador;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indicadorPK != null ? indicadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicador)) {
            return false;
        }
        Indicador other = (Indicador) object;
        if ((this.indicadorPK == null && other.indicadorPK != null) || (this.indicadorPK != null && !this.indicadorPK.equals(other.indicadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Indicador[ indicadorPK=" + indicadorPK + " ]";
    }
    
}
