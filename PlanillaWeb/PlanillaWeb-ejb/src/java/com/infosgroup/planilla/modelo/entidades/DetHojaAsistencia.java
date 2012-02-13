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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DET_HOJA_ASISTENCIA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetHojaAsistencia.findAll", query = "SELECT d FROM DetHojaAsistencia d"),
    @NamedQuery(name = "DetHojaAsistencia.findByCodCia", query = "SELECT d FROM DetHojaAsistencia d WHERE d.detHojaAsistenciaPK.codCia = :codCia"),
    @NamedQuery(name = "DetHojaAsistencia.findByNoHoja", query = "SELECT d FROM DetHojaAsistencia d WHERE d.detHojaAsistenciaPK.noHoja = :noHoja"),
    @NamedQuery(name = "DetHojaAsistencia.findByCodEmp", query = "SELECT d FROM DetHojaAsistencia d WHERE d.detHojaAsistenciaPK.codEmp = :codEmp"),
    @NamedQuery(name = "DetHojaAsistencia.findByLunes", query = "SELECT d FROM DetHojaAsistencia d WHERE d.lunes = :lunes"),
    @NamedQuery(name = "DetHojaAsistencia.findByMartes", query = "SELECT d FROM DetHojaAsistencia d WHERE d.martes = :martes"),
    @NamedQuery(name = "DetHojaAsistencia.findByMiercoles", query = "SELECT d FROM DetHojaAsistencia d WHERE d.miercoles = :miercoles"),
    @NamedQuery(name = "DetHojaAsistencia.findByJueves", query = "SELECT d FROM DetHojaAsistencia d WHERE d.jueves = :jueves"),
    @NamedQuery(name = "DetHojaAsistencia.findByViernes", query = "SELECT d FROM DetHojaAsistencia d WHERE d.viernes = :viernes"),
    @NamedQuery(name = "DetHojaAsistencia.findBySabado", query = "SELECT d FROM DetHojaAsistencia d WHERE d.sabado = :sabado"),
    @NamedQuery(name = "DetHojaAsistencia.findByDomingo", query = "SELECT d FROM DetHojaAsistencia d WHERE d.domingo = :domingo"),
    @NamedQuery(name = "DetHojaAsistencia.findByOhXdobles", query = "SELECT d FROM DetHojaAsistencia d WHERE d.ohXdobles = :ohXdobles"),
    @NamedQuery(name = "DetHojaAsistencia.findByHXsencillas", query = "SELECT d FROM DetHojaAsistencia d WHERE d.hXsencillas = :hXsencillas"),
    @NamedQuery(name = "DetHojaAsistencia.findByHDobles", query = "SELECT d FROM DetHojaAsistencia d WHERE d.hDobles = :hDobles"),
    @NamedQuery(name = "DetHojaAsistencia.findByViaticos", query = "SELECT d FROM DetHojaAsistencia d WHERE d.viaticos = :viaticos"),
    @NamedQuery(name = "DetHojaAsistencia.findByObservacion", query = "SELECT d FROM DetHojaAsistencia d WHERE d.observacion = :observacion"),
    @NamedQuery(name = "DetHojaAsistencia.findByNoSerie", query = "SELECT d FROM DetHojaAsistencia d WHERE d.detHojaAsistenciaPK.noSerie = :noSerie"),
    @NamedQuery(name = "DetHojaAsistencia.findByCodRenglon", query = "SELECT d FROM DetHojaAsistencia d WHERE d.codRenglon = :codRenglon")})
public class DetHojaAsistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetHojaAsistenciaPK detHojaAsistenciaPK;
    @Column(name = "LUNES")
    private Short lunes;
    @Column(name = "MARTES")
    private Short martes;
    @Column(name = "MIERCOLES")
    private Short miercoles;
    @Column(name = "JUEVES")
    private Short jueves;
    @Column(name = "VIERNES")
    private Short viernes;
    @Column(name = "SABADO")
    private Short sabado;
    @Column(name = "DOMINGO")
    private Short domingo;
    @Column(name = "OH_XDOBLES")
    private Short ohXdobles;
    @Column(name = "H_XSENCILLAS")
    private Short hXsencillas;
    @Column(name = "H_DOBLES")
    private Short hDobles;
    @Column(name = "VIATICOS")
    private Integer viaticos;
    @Column(name = "OBSERVACION", length = 250)
    private String observacion;
    @Column(name = "COD_RENGLON")
    private Short codRenglon;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "NO_HOJA", referencedColumnName = "NO_HOJA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "NO_SERIE", referencedColumnName = "NO_SERIE", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private HojaAsistencia hojaAsistencia;

    public DetHojaAsistencia() {
    }

    public DetHojaAsistencia(DetHojaAsistenciaPK detHojaAsistenciaPK) {
        this.detHojaAsistenciaPK = detHojaAsistenciaPK;
    }

    public DetHojaAsistencia(short codCia, short noHoja, int codEmp, short noSerie) {
        this.detHojaAsistenciaPK = new DetHojaAsistenciaPK(codCia, noHoja, codEmp, noSerie);
    }

    public DetHojaAsistenciaPK getDetHojaAsistenciaPK() {
        return detHojaAsistenciaPK;
    }

    public void setDetHojaAsistenciaPK(DetHojaAsistenciaPK detHojaAsistenciaPK) {
        this.detHojaAsistenciaPK = detHojaAsistenciaPK;
    }

    public Short getLunes() {
        return lunes;
    }

    public void setLunes(Short lunes) {
        this.lunes = lunes;
    }

    public Short getMartes() {
        return martes;
    }

    public void setMartes(Short martes) {
        this.martes = martes;
    }

    public Short getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(Short miercoles) {
        this.miercoles = miercoles;
    }

    public Short getJueves() {
        return jueves;
    }

    public void setJueves(Short jueves) {
        this.jueves = jueves;
    }

    public Short getViernes() {
        return viernes;
    }

    public void setViernes(Short viernes) {
        this.viernes = viernes;
    }

    public Short getSabado() {
        return sabado;
    }

    public void setSabado(Short sabado) {
        this.sabado = sabado;
    }

    public Short getDomingo() {
        return domingo;
    }

    public void setDomingo(Short domingo) {
        this.domingo = domingo;
    }

    public Short getOhXdobles() {
        return ohXdobles;
    }

    public void setOhXdobles(Short ohXdobles) {
        this.ohXdobles = ohXdobles;
    }

    public Short getHXsencillas() {
        return hXsencillas;
    }

    public void setHXsencillas(Short hXsencillas) {
        this.hXsencillas = hXsencillas;
    }

    public Short getHDobles() {
        return hDobles;
    }

    public void setHDobles(Short hDobles) {
        this.hDobles = hDobles;
    }

    public Integer getViaticos() {
        return viaticos;
    }

    public void setViaticos(Integer viaticos) {
        this.viaticos = viaticos;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Short getCodRenglon() {
        return codRenglon;
    }

    public void setCodRenglon(Short codRenglon) {
        this.codRenglon = codRenglon;
    }

    public HojaAsistencia getHojaAsistencia() {
        return hojaAsistencia;
    }

    public void setHojaAsistencia(HojaAsistencia hojaAsistencia) {
        this.hojaAsistencia = hojaAsistencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detHojaAsistenciaPK != null ? detHojaAsistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetHojaAsistencia)) {
            return false;
        }
        DetHojaAsistencia other = (DetHojaAsistencia) object;
        if ((this.detHojaAsistenciaPK == null && other.detHojaAsistenciaPK != null) || (this.detHojaAsistenciaPK != null && !this.detHojaAsistenciaPK.equals(other.detHojaAsistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.DetHojaAsistencia[ detHojaAsistenciaPK=" + detHojaAsistenciaPK + " ]";
    }
    
}
