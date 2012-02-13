/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "INFO_PLANILLA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoPlanilla.findAll", query = "SELECT i FROM InfoPlanilla i"),
    @NamedQuery(name = "InfoPlanilla.findByCodCia", query = "SELECT i FROM InfoPlanilla i WHERE i.infoPlanillaPK.codCia = :codCia"),
    @NamedQuery(name = "InfoPlanilla.findByAnio", query = "SELECT i FROM InfoPlanilla i WHERE i.infoPlanillaPK.anio = :anio"),
    @NamedQuery(name = "InfoPlanilla.findByMes", query = "SELECT i FROM InfoPlanilla i WHERE i.infoPlanillaPK.mes = :mes"),
    @NamedQuery(name = "InfoPlanilla.findByCodEmp", query = "SELECT i FROM InfoPlanilla i WHERE i.infoPlanillaPK.codEmp = :codEmp"),
    @NamedQuery(name = "InfoPlanilla.findByCodDepto", query = "SELECT i FROM InfoPlanilla i WHERE i.codDepto = :codDepto"),
    @NamedQuery(name = "InfoPlanilla.findByNombre", query = "SELECT i FROM InfoPlanilla i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "InfoPlanilla.findByDLaborados", query = "SELECT i FROM InfoPlanilla i WHERE i.dLaborados = :dLaborados"),
    @NamedQuery(name = "InfoPlanilla.findBySueldoBase", query = "SELECT i FROM InfoPlanilla i WHERE i.sueldoBase = :sueldoBase"),
    @NamedQuery(name = "InfoPlanilla.findBySueldo", query = "SELECT i FROM InfoPlanilla i WHERE i.sueldo = :sueldo"),
    @NamedQuery(name = "InfoPlanilla.findByIsss", query = "SELECT i FROM InfoPlanilla i WHERE i.isss = :isss"),
    @NamedQuery(name = "InfoPlanilla.findByRenta", query = "SELECT i FROM InfoPlanilla i WHERE i.renta = :renta"),
    @NamedQuery(name = "InfoPlanilla.findByAfp", query = "SELECT i FROM InfoPlanilla i WHERE i.afp = :afp"),
    @NamedQuery(name = "InfoPlanilla.findByVextra", query = "SELECT i FROM InfoPlanilla i WHERE i.vextra = :vextra"),
    @NamedQuery(name = "InfoPlanilla.findByVacacion", query = "SELECT i FROM InfoPlanilla i WHERE i.vacacion = :vacacion"),
    @NamedQuery(name = "InfoPlanilla.findByViatico", query = "SELECT i FROM InfoPlanilla i WHERE i.viatico = :viatico"),
    @NamedQuery(name = "InfoPlanilla.findByComision", query = "SELECT i FROM InfoPlanilla i WHERE i.comision = :comision"),
    @NamedQuery(name = "InfoPlanilla.findByAguinaldo", query = "SELECT i FROM InfoPlanilla i WHERE i.aguinaldo = :aguinaldo"),
    @NamedQuery(name = "InfoPlanilla.findByExcindem", query = "SELECT i FROM InfoPlanilla i WHERE i.excindem = :excindem"),
    @NamedQuery(name = "InfoPlanilla.findByBonificacion", query = "SELECT i FROM InfoPlanilla i WHERE i.bonificacion = :bonificacion"),
    @NamedQuery(name = "InfoPlanilla.findByIndemnizacion", query = "SELECT i FROM InfoPlanilla i WHERE i.indemnizacion = :indemnizacion")})
public class InfoPlanilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InfoPlanillaPK infoPlanillaPK;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Column(name = "NOMBRE", length = 60)
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "D_LABORADOS", precision = 16, scale = 2)
    private BigDecimal dLaborados;
    @Column(name = "SUELDO_BASE", precision = 16, scale = 2)
    private BigDecimal sueldoBase;
    @Column(name = "SUELDO", precision = 16, scale = 2)
    private BigDecimal sueldo;
    @Column(name = "ISSS", precision = 16, scale = 2)
    private BigDecimal isss;
    @Column(name = "RENTA", precision = 16, scale = 2)
    private BigDecimal renta;
    @Column(name = "AFP", precision = 16, scale = 2)
    private BigDecimal afp;
    @Column(name = "VEXTRA", precision = 16, scale = 2)
    private BigDecimal vextra;
    @Column(name = "VACACION", precision = 16, scale = 2)
    private BigDecimal vacacion;
    @Column(name = "VIATICO")
    private BigInteger viatico;
    @Column(name = "COMISION")
    private BigInteger comision;
    @Column(name = "AGUINALDO", precision = 16, scale = 2)
    private BigDecimal aguinaldo;
    @Column(name = "EXCINDEM")
    private BigInteger excindem;
    @Column(name = "BONIFICACION")
    private BigInteger bonificacion;
    @Column(name = "INDEMNIZACION", precision = 16, scale = 2)
    private BigDecimal indemnizacion;

    public InfoPlanilla() {
    }

    public InfoPlanilla(InfoPlanillaPK infoPlanillaPK) {
        this.infoPlanillaPK = infoPlanillaPK;
    }

    public InfoPlanilla(short codCia, short anio, short mes, int codEmp) {
        this.infoPlanillaPK = new InfoPlanillaPK(codCia, anio, mes, codEmp);
    }

    public InfoPlanillaPK getInfoPlanillaPK() {
        return infoPlanillaPK;
    }

    public void setInfoPlanillaPK(InfoPlanillaPK infoPlanillaPK) {
        this.infoPlanillaPK = infoPlanillaPK;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getDLaborados() {
        return dLaborados;
    }

    public void setDLaborados(BigDecimal dLaborados) {
        this.dLaborados = dLaborados;
    }

    public BigDecimal getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(BigDecimal sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public BigDecimal getIsss() {
        return isss;
    }

    public void setIsss(BigDecimal isss) {
        this.isss = isss;
    }

    public BigDecimal getRenta() {
        return renta;
    }

    public void setRenta(BigDecimal renta) {
        this.renta = renta;
    }

    public BigDecimal getAfp() {
        return afp;
    }

    public void setAfp(BigDecimal afp) {
        this.afp = afp;
    }

    public BigDecimal getVextra() {
        return vextra;
    }

    public void setVextra(BigDecimal vextra) {
        this.vextra = vextra;
    }

    public BigDecimal getVacacion() {
        return vacacion;
    }

    public void setVacacion(BigDecimal vacacion) {
        this.vacacion = vacacion;
    }

    public BigInteger getViatico() {
        return viatico;
    }

    public void setViatico(BigInteger viatico) {
        this.viatico = viatico;
    }

    public BigInteger getComision() {
        return comision;
    }

    public void setComision(BigInteger comision) {
        this.comision = comision;
    }

    public BigDecimal getAguinaldo() {
        return aguinaldo;
    }

    public void setAguinaldo(BigDecimal aguinaldo) {
        this.aguinaldo = aguinaldo;
    }

    public BigInteger getExcindem() {
        return excindem;
    }

    public void setExcindem(BigInteger excindem) {
        this.excindem = excindem;
    }

    public BigInteger getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(BigInteger bonificacion) {
        this.bonificacion = bonificacion;
    }

    public BigDecimal getIndemnizacion() {
        return indemnizacion;
    }

    public void setIndemnizacion(BigDecimal indemnizacion) {
        this.indemnizacion = indemnizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infoPlanillaPK != null ? infoPlanillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoPlanilla)) {
            return false;
        }
        InfoPlanilla other = (InfoPlanilla) object;
        if ((this.infoPlanillaPK == null && other.infoPlanillaPK != null) || (this.infoPlanillaPK != null && !this.infoPlanillaPK.equals(other.infoPlanillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.InfoPlanilla[ infoPlanillaPK=" + infoPlanillaPK + " ]";
    }
    
}
