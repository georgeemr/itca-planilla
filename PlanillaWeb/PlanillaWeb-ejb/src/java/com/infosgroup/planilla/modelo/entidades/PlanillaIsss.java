/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PLANILLA_ISSS", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanillaIsss.findAll", query = "SELECT p FROM PlanillaIsss p"),
    @NamedQuery(name = "PlanillaIsss.findByCodCia", query = "SELECT p FROM PlanillaIsss p WHERE p.planillaIsssPK.codCia = :codCia"),
    @NamedQuery(name = "PlanillaIsss.findByAnio", query = "SELECT p FROM PlanillaIsss p WHERE p.planillaIsssPK.anio = :anio"),
    @NamedQuery(name = "PlanillaIsss.findByMes", query = "SELECT p FROM PlanillaIsss p WHERE p.planillaIsssPK.mes = :mes"),
    @NamedQuery(name = "PlanillaIsss.findByCodEmp", query = "SELECT p FROM PlanillaIsss p WHERE p.planillaIsssPK.codEmp = :codEmp"),
    @NamedQuery(name = "PlanillaIsss.findByNoPatronal", query = "SELECT p FROM PlanillaIsss p WHERE p.noPatronal = :noPatronal"),
    @NamedQuery(name = "PlanillaIsss.findByNoAfilacion", query = "SELECT p FROM PlanillaIsss p WHERE p.noAfilacion = :noAfilacion"),
    @NamedQuery(name = "PlanillaIsss.findByTipoDocto", query = "SELECT p FROM PlanillaIsss p WHERE p.tipoDocto = :tipoDocto"),
    @NamedQuery(name = "PlanillaIsss.findById", query = "SELECT p FROM PlanillaIsss p WHERE p.id = :id"),
    @NamedQuery(name = "PlanillaIsss.findByNombre", query = "SELECT p FROM PlanillaIsss p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PlanillaIsss.findBySalDebengado", query = "SELECT p FROM PlanillaIsss p WHERE p.salDebengado = :salDebengado"),
    @NamedQuery(name = "PlanillaIsss.findByDiasRemunerados", query = "SELECT p FROM PlanillaIsss p WHERE p.diasRemunerados = :diasRemunerados"),
    @NamedQuery(name = "PlanillaIsss.findByHorasJornada", query = "SELECT p FROM PlanillaIsss p WHERE p.horasJornada = :horasJornada"),
    @NamedQuery(name = "PlanillaIsss.findByCodObserva", query = "SELECT p FROM PlanillaIsss p WHERE p.codObserva = :codObserva"),
    @NamedQuery(name = "PlanillaIsss.findByCodTipopla", query = "SELECT p FROM PlanillaIsss p WHERE p.codTipopla = :codTipopla"),
    @NamedQuery(name = "PlanillaIsss.findByDiasVacacion", query = "SELECT p FROM PlanillaIsss p WHERE p.diasVacacion = :diasVacacion"),
    @NamedQuery(name = "PlanillaIsss.findByCodDepto", query = "SELECT p FROM PlanillaIsss p WHERE p.codDepto = :codDepto"),
    @NamedQuery(name = "PlanillaIsss.findByCodMuni", query = "SELECT p FROM PlanillaIsss p WHERE p.codMuni = :codMuni"),
    @NamedQuery(name = "PlanillaIsss.findByCodPais", query = "SELECT p FROM PlanillaIsss p WHERE p.codPais = :codPais")})
public class PlanillaIsss implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanillaIsssPK planillaIsssPK;
    @Column(name = "NO_PATRONAL", length = 9)
    private String noPatronal;
    @Column(name = "NO_AFILACION", length = 9)
    private String noAfilacion;
    @Column(name = "TIPO_DOCTO", length = 1)
    private String tipoDocto;
    @Column(name = "ID", length = 18)
    private String id;
    @Column(name = "NOMBRE", length = 150)
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SAL_DEBENGADO", precision = 12, scale = 2)
    private BigDecimal salDebengado;
    @Column(name = "DIAS_REMUNERADOS")
    private Short diasRemunerados;
    @Column(name = "HORAS_JORNADA", length = 2)
    private String horasJornada;
    @Column(name = "COD_OBSERVA", length = 2)
    private String codObserva;
    @Column(name = "COD_TIPOPLA")
    private Short codTipopla;
    @Column(name = "DIAS_VACACION")
    private Short diasVacacion;
    @Column(name = "COD_DEPTO")
    private Short codDepto;
    @Column(name = "COD_MUNI")
    private Short codMuni;
    @Column(name = "COD_PAIS")
    private Short codPais;

    public PlanillaIsss() {
    }

    public PlanillaIsss(PlanillaIsssPK planillaIsssPK) {
        this.planillaIsssPK = planillaIsssPK;
    }

    public PlanillaIsss(short codCia, short anio, short mes, int codEmp) {
        this.planillaIsssPK = new PlanillaIsssPK(codCia, anio, mes, codEmp);
    }

    public PlanillaIsssPK getPlanillaIsssPK() {
        return planillaIsssPK;
    }

    public void setPlanillaIsssPK(PlanillaIsssPK planillaIsssPK) {
        this.planillaIsssPK = planillaIsssPK;
    }

    public String getNoPatronal() {
        return noPatronal;
    }

    public void setNoPatronal(String noPatronal) {
        this.noPatronal = noPatronal;
    }

    public String getNoAfilacion() {
        return noAfilacion;
    }

    public void setNoAfilacion(String noAfilacion) {
        this.noAfilacion = noAfilacion;
    }

    public String getTipoDocto() {
        return tipoDocto;
    }

    public void setTipoDocto(String tipoDocto) {
        this.tipoDocto = tipoDocto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSalDebengado() {
        return salDebengado;
    }

    public void setSalDebengado(BigDecimal salDebengado) {
        this.salDebengado = salDebengado;
    }

    public Short getDiasRemunerados() {
        return diasRemunerados;
    }

    public void setDiasRemunerados(Short diasRemunerados) {
        this.diasRemunerados = diasRemunerados;
    }

    public String getHorasJornada() {
        return horasJornada;
    }

    public void setHorasJornada(String horasJornada) {
        this.horasJornada = horasJornada;
    }

    public String getCodObserva() {
        return codObserva;
    }

    public void setCodObserva(String codObserva) {
        this.codObserva = codObserva;
    }

    public Short getCodTipopla() {
        return codTipopla;
    }

    public void setCodTipopla(Short codTipopla) {
        this.codTipopla = codTipopla;
    }

    public Short getDiasVacacion() {
        return diasVacacion;
    }

    public void setDiasVacacion(Short diasVacacion) {
        this.diasVacacion = diasVacacion;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public Short getCodMuni() {
        return codMuni;
    }

    public void setCodMuni(Short codMuni) {
        this.codMuni = codMuni;
    }

    public Short getCodPais() {
        return codPais;
    }

    public void setCodPais(Short codPais) {
        this.codPais = codPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planillaIsssPK != null ? planillaIsssPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanillaIsss)) {
            return false;
        }
        PlanillaIsss other = (PlanillaIsss) object;
        if ((this.planillaIsssPK == null && other.planillaIsssPK != null) || (this.planillaIsssPK != null && !this.planillaIsssPK.equals(other.planillaIsssPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.PlanillaIsss[ planillaIsssPK=" + planillaIsssPK + " ]";
    }
    
}
