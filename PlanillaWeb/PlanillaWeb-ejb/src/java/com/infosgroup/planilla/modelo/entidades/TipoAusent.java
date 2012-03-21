/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_AUSENT", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAusent.findAll", query = "SELECT t FROM TipoAusent t"),
    @NamedQuery(name = "TipoAusent.findByCodAusen", query = "SELECT t FROM TipoAusent t WHERE t.codAusen = :codAusen"),
    @NamedQuery(name = "TipoAusent.findByDescripAusen", query = "SELECT t FROM TipoAusent t WHERE t.descripAusen = :descripAusen")})
public class TipoAusent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_AUSEN", nullable = false, length = 1)
    private String codAusen;
    @Column(name = "DESCRIP_AUSEN", length = 100)
    private String descripAusen;
    @OneToMany(mappedBy = "estado")
    private List<ResumenAsistencia> resumenAsistenciaList;

    public TipoAusent() {
    }

    public TipoAusent(String codAusen) {
        this.codAusen = codAusen;
    }

    public String getCodAusen() {
        return codAusen;
    }

    public void setCodAusen(String codAusen) {
        this.codAusen = codAusen;
    }

    public String getDescripAusen() {
        return descripAusen;
    }

    public void setDescripAusen(String descripAusen) {
        this.descripAusen = descripAusen;
    }

    @XmlTransient
    public List<ResumenAsistencia> getResumenAsistenciaList() {
        return resumenAsistenciaList;
    }

    public void setResumenAsistenciaList(List<ResumenAsistencia> resumenAsistenciaList) {
        this.resumenAsistenciaList = resumenAsistenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAusen != null ? codAusen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAusent)) {
            return false;
        }
        TipoAusent other = (TipoAusent) object;
        if ((this.codAusen == null && other.codAusen != null) || (this.codAusen != null && !this.codAusen.equals(other.codAusen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.TipoAusent[ codAusen=" + codAusen + " ]";
    }
    
}
