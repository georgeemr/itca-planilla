/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "SUPERVISION_OBRA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupervisionObra.findAll", query = "SELECT s FROM SupervisionObra s"),
    @NamedQuery(name = "SupervisionObra.findByCodCia", query = "SELECT s FROM SupervisionObra s WHERE s.supervisionObraPK.codCia = :codCia"),
    @NamedQuery(name = "SupervisionObra.findByAnio", query = "SELECT s FROM SupervisionObra s WHERE s.supervisionObraPK.anio = :anio"),
    @NamedQuery(name = "SupervisionObra.findByTipoObra", query = "SELECT s FROM SupervisionObra s WHERE s.supervisionObraPK.tipoObra = :tipoObra"),
    @NamedQuery(name = "SupervisionObra.findByCodObra", query = "SELECT s FROM SupervisionObra s WHERE s.supervisionObraPK.codObra = :codObra"),
    @NamedQuery(name = "SupervisionObra.findBySubProy", query = "SELECT s FROM SupervisionObra s WHERE s.supervisionObraPK.subProy = :subProy"),
    @NamedQuery(name = "SupervisionObra.findByCodSupervi", query = "SELECT s FROM SupervisionObra s WHERE s.supervisionObraPK.codSupervi = :codSupervi"),
    @NamedQuery(name = "SupervisionObra.findByDiasProgra", query = "SELECT s FROM SupervisionObra s WHERE s.diasProgra = :diasProgra"),
    @NamedQuery(name = "SupervisionObra.findByFechaInicio", query = "SELECT s FROM SupervisionObra s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "SupervisionObra.findByDiasTrans", query = "SELECT s FROM SupervisionObra s WHERE s.diasTrans = :diasTrans")})
public class SupervisionObra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SupervisionObraPK supervisionObraPK;
    @Basic(optional = false)
    @Column(name = "DIAS_PROGRA", nullable = false)
    private short diasProgra;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "DIAS_TRANS")
    private Short diasTrans;

    public SupervisionObra() {
    }

    public SupervisionObra(SupervisionObraPK supervisionObraPK) {
        this.supervisionObraPK = supervisionObraPK;
    }

    public SupervisionObra(SupervisionObraPK supervisionObraPK, short diasProgra, Date fechaInicio) {
        this.supervisionObraPK = supervisionObraPK;
        this.diasProgra = diasProgra;
        this.fechaInicio = fechaInicio;
    }

    public SupervisionObra(short codCia, short anio, String tipoObra, int codObra, short subProy, int codSupervi) {
        this.supervisionObraPK = new SupervisionObraPK(codCia, anio, tipoObra, codObra, subProy, codSupervi);
    }

    public SupervisionObraPK getSupervisionObraPK() {
        return supervisionObraPK;
    }

    public void setSupervisionObraPK(SupervisionObraPK supervisionObraPK) {
        this.supervisionObraPK = supervisionObraPK;
    }

    public short getDiasProgra() {
        return diasProgra;
    }

    public void setDiasProgra(short diasProgra) {
        this.diasProgra = diasProgra;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Short getDiasTrans() {
        return diasTrans;
    }

    public void setDiasTrans(Short diasTrans) {
        this.diasTrans = diasTrans;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supervisionObraPK != null ? supervisionObraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupervisionObra)) {
            return false;
        }
        SupervisionObra other = (SupervisionObra) object;
        if ((this.supervisionObraPK == null && other.supervisionObraPK != null) || (this.supervisionObraPK != null && !this.supervisionObraPK.equals(other.supervisionObraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.SupervisionObra[ supervisionObraPK=" + supervisionObraPK + " ]";
    }
    
}
