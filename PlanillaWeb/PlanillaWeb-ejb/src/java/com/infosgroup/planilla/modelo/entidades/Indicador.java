/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "INDICADOR", catalog = "", schema = "PLANILLA")
@XmlRootElement
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
    @Size(max = 200)
    @Column(name = "NOMBRE_MODULO", length = 200)
    private String nombreModulo;
    @Size(max = 200)
    @Column(name = "NOMBRE_INDICADOR", length = 200)
    private String nombreIndicador;
    @Size(max = 200)
    @Column(name = "VALOR_INDICADOR", length = 200)
    private String valorIndicador;
    @Column(name = "ORDEN")
    private Long orden;

    public Indicador() {
    }

    public Indicador(IndicadorPK indicadorPK) {
        this.indicadorPK = indicadorPK;
    }

    public Indicador(short codCia, long modulo, long indicador) {
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

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
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
