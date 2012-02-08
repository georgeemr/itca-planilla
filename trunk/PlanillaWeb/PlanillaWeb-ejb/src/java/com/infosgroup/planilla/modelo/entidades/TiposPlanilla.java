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
@Table(name = "TIPOS_PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposPlanilla.findAll", query = "SELECT t FROM TiposPlanilla t"),
    @NamedQuery(name = "TiposPlanilla.findByCodCia", query = "SELECT t FROM TiposPlanilla t WHERE t.tiposPlanillaPK.codCia = :codCia"),
    @NamedQuery(name = "TiposPlanilla.findByCodTipopla", query = "SELECT t FROM TiposPlanilla t WHERE t.tiposPlanillaPK.codTipopla = :codTipopla"),
    @NamedQuery(name = "TiposPlanilla.findByNomTipopla", query = "SELECT t FROM TiposPlanilla t WHERE t.nomTipopla = :nomTipopla"),
    @NamedQuery(name = "TiposPlanilla.findByStatus", query = "SELECT t FROM TiposPlanilla t WHERE t.status = :status"),
    @NamedQuery(name = "TiposPlanilla.findByDiasLab", query = "SELECT t FROM TiposPlanilla t WHERE t.diasLab = :diasLab")})
public class TiposPlanilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TiposPlanillaPK tiposPlanillaPK;
    @Basic(optional = false)
    @Column(name = "NOM_TIPOPLA", nullable = false, length = 40)
    private String nomTipopla;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "DIAS_LAB")
    private Long diasLab;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposPlanilla")
    private List<Empleados> empleadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposPlanilla")
    private List<Contrato> contratoList;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cias cias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposPlanilla")
    private List<RelUsuarioTipopla> relUsuarioTipoplaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposPlanilla")
    private List<ResumenAsistencia> resumenAsistenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposPlanilla")
    private List<Departamentos> departamentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposPlanilla")
    private List<Prestamos> prestamosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposPlanilla")
    private List<ProgramacionPla> programacionPlaList;

    public TiposPlanilla() {
    }

    public TiposPlanilla(TiposPlanillaPK tiposPlanillaPK) {
        this.tiposPlanillaPK = tiposPlanillaPK;
    }

    public TiposPlanilla(TiposPlanillaPK tiposPlanillaPK, String nomTipopla) {
        this.tiposPlanillaPK = tiposPlanillaPK;
        this.nomTipopla = nomTipopla;
    }

    public TiposPlanilla(short codCia, short codTipopla) {
        this.tiposPlanillaPK = new TiposPlanillaPK(codCia, codTipopla);
    }

    public TiposPlanillaPK getTiposPlanillaPK() {
        return tiposPlanillaPK;
    }

    public void setTiposPlanillaPK(TiposPlanillaPK tiposPlanillaPK) {
        this.tiposPlanillaPK = tiposPlanillaPK;
    }

    public String getNomTipopla() {
        return nomTipopla;
    }

    public void setNomTipopla(String nomTipopla) {
        this.nomTipopla = nomTipopla;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDiasLab() {
        return diasLab;
    }

    public void setDiasLab(Long diasLab) {
        this.diasLab = diasLab;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public Cias getCias() {
        return cias;
    }

    public void setCias(Cias cias) {
        this.cias = cias;
    }

    @XmlTransient
    public List<RelUsuarioTipopla> getRelUsuarioTipoplaList() {
        return relUsuarioTipoplaList;
    }

    public void setRelUsuarioTipoplaList(List<RelUsuarioTipopla> relUsuarioTipoplaList) {
        this.relUsuarioTipoplaList = relUsuarioTipoplaList;
    }

    @XmlTransient
    public List<ResumenAsistencia> getResumenAsistenciaList() {
        return resumenAsistenciaList;
    }

    public void setResumenAsistenciaList(List<ResumenAsistencia> resumenAsistenciaList) {
        this.resumenAsistenciaList = resumenAsistenciaList;
    }

    @XmlTransient
    public List<Departamentos> getDepartamentosList() {
        return departamentosList;
    }

    public void setDepartamentosList(List<Departamentos> departamentosList) {
        this.departamentosList = departamentosList;
    }

    @XmlTransient
    public List<Prestamos> getPrestamosList() {
        return prestamosList;
    }

    public void setPrestamosList(List<Prestamos> prestamosList) {
        this.prestamosList = prestamosList;
    }

    @XmlTransient
    public List<ProgramacionPla> getProgramacionPlaList() {
        return programacionPlaList;
    }

    public void setProgramacionPlaList(List<ProgramacionPla> programacionPlaList) {
        this.programacionPlaList = programacionPlaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiposPlanillaPK != null ? tiposPlanillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposPlanilla)) {
            return false;
        }
        TiposPlanilla other = (TiposPlanilla) object;
        if ((this.tiposPlanillaPK == null && other.tiposPlanillaPK != null) || (this.tiposPlanillaPK != null && !this.tiposPlanillaPK.equals(other.tiposPlanillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TiposPlanilla[ tiposPlanillaPK=" + tiposPlanillaPK + " ]";
    }
    
}
