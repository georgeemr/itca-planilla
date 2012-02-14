/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "HOJA_ASISTENCIA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HojaAsistencia.findAll", query = "SELECT h FROM HojaAsistencia h"),
    @NamedQuery(name = "HojaAsistencia.findByCodCia", query = "SELECT h FROM HojaAsistencia h WHERE h.hojaAsistenciaPK.codCia = :codCia"),
    @NamedQuery(name = "HojaAsistencia.findByNoHoja", query = "SELECT h FROM HojaAsistencia h WHERE h.hojaAsistenciaPK.noHoja = :noHoja"),
    @NamedQuery(name = "HojaAsistencia.findByCodSupervi", query = "SELECT h FROM HojaAsistencia h WHERE h.codSupervi = :codSupervi"),
    @NamedQuery(name = "HojaAsistencia.findByAnio", query = "SELECT h FROM HojaAsistencia h WHERE h.anio = :anio"),
    @NamedQuery(name = "HojaAsistencia.findByTipoObra", query = "SELECT h FROM HojaAsistencia h WHERE h.tipoObra = :tipoObra"),
    @NamedQuery(name = "HojaAsistencia.findByCodObra", query = "SELECT h FROM HojaAsistencia h WHERE h.codObra = :codObra"),
    @NamedQuery(name = "HojaAsistencia.findBySubProy", query = "SELECT h FROM HojaAsistencia h WHERE h.subProy = :subProy"),
    @NamedQuery(name = "HojaAsistencia.findByPeriodoIni", query = "SELECT h FROM HojaAsistencia h WHERE h.periodoIni = :periodoIni"),
    @NamedQuery(name = "HojaAsistencia.findByPeriodoFin", query = "SELECT h FROM HojaAsistencia h WHERE h.periodoFin = :periodoFin"),
    @NamedQuery(name = "HojaAsistencia.findByNoSerie", query = "SELECT h FROM HojaAsistencia h WHERE h.hojaAsistenciaPK.noSerie = :noSerie"),
    @NamedQuery(name = "HojaAsistencia.findByCodDepto", query = "SELECT h FROM HojaAsistencia h WHERE h.codDepto = :codDepto"),
    @NamedQuery(name = "HojaAsistencia.findByCodSucursal", query = "SELECT h FROM HojaAsistencia h WHERE h.codSucursal = :codSucursal")})
public class HojaAsistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HojaAsistenciaPK hojaAsistenciaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SUPERVI", nullable = false)
    private int codSupervi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO", nullable = false)
    private short anio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TIPO_OBRA", nullable = false, length = 2)
    private String tipoObra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_OBRA", nullable = false)
    private int codObra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUB_PROY", nullable = false)
    private short subProy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERIODO_INI", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodoIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERIODO_FIN", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodoFin;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Size(max = 2)
    @Column(name = "COD_SUCURSAL", length = 2)
    private String codSucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hojaAsistencia")
    private List<DetHojaAsistencia> detHojaAsistenciaList;

    public HojaAsistencia() {
    }

    public HojaAsistencia(HojaAsistenciaPK hojaAsistenciaPK) {
        this.hojaAsistenciaPK = hojaAsistenciaPK;
    }

    public HojaAsistencia(HojaAsistenciaPK hojaAsistenciaPK, int codSupervi, short anio, String tipoObra, int codObra, short subProy, Date periodoIni, Date periodoFin) {
        this.hojaAsistenciaPK = hojaAsistenciaPK;
        this.codSupervi = codSupervi;
        this.anio = anio;
        this.tipoObra = tipoObra;
        this.codObra = codObra;
        this.subProy = subProy;
        this.periodoIni = periodoIni;
        this.periodoFin = periodoFin;
    }

    public HojaAsistencia(short codCia, short noHoja, short noSerie) {
        this.hojaAsistenciaPK = new HojaAsistenciaPK(codCia, noHoja, noSerie);
    }

    public HojaAsistenciaPK getHojaAsistenciaPK() {
        return hojaAsistenciaPK;
    }

    public void setHojaAsistenciaPK(HojaAsistenciaPK hojaAsistenciaPK) {
        this.hojaAsistenciaPK = hojaAsistenciaPK;
    }

    public int getCodSupervi() {
        return codSupervi;
    }

    public void setCodSupervi(int codSupervi) {
        this.codSupervi = codSupervi;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    public String getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
    }

    public int getCodObra() {
        return codObra;
    }

    public void setCodObra(int codObra) {
        this.codObra = codObra;
    }

    public short getSubProy() {
        return subProy;
    }

    public void setSubProy(short subProy) {
        this.subProy = subProy;
    }

    public Date getPeriodoIni() {
        return periodoIni;
    }

    public void setPeriodoIni(Date periodoIni) {
        this.periodoIni = periodoIni;
    }

    public Date getPeriodoFin() {
        return periodoFin;
    }

    public void setPeriodoFin(Date periodoFin) {
        this.periodoFin = periodoFin;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    @XmlTransient
    public List<DetHojaAsistencia> getDetHojaAsistenciaList() {
        return detHojaAsistenciaList;
    }

    public void setDetHojaAsistenciaList(List<DetHojaAsistencia> detHojaAsistenciaList) {
        this.detHojaAsistenciaList = detHojaAsistenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hojaAsistenciaPK != null ? hojaAsistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HojaAsistencia)) {
            return false;
        }
        HojaAsistencia other = (HojaAsistencia) object;
        if ((this.hojaAsistenciaPK == null && other.hojaAsistenciaPK != null) || (this.hojaAsistenciaPK != null && !this.hojaAsistenciaPK.equals(other.hojaAsistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.HojaAsistencia[ hojaAsistenciaPK=" + hojaAsistenciaPK + " ]";
    }
    
}
