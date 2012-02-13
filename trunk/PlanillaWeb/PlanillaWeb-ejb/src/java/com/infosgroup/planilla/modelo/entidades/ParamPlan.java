/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PARAM_PLAN", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParamPlan.findAll", query = "SELECT p FROM ParamPlan p"),
    @NamedQuery(name = "ParamPlan.findByCodCia", query = "SELECT p FROM ParamPlan p WHERE p.codCia = :codCia"),
    @NamedQuery(name = "ParamPlan.findByDiasLabor", query = "SELECT p FROM ParamPlan p WHERE p.diasLabor = :diasLabor"),
    @NamedQuery(name = "ParamPlan.findByDiasMes", query = "SELECT p FROM ParamPlan p WHERE p.diasMes = :diasMes"),
    @NamedQuery(name = "ParamPlan.findByHorasDia", query = "SELECT p FROM ParamPlan p WHERE p.horasDia = :horasDia"),
    @NamedQuery(name = "ParamPlan.findByFacHxsen", query = "SELECT p FROM ParamPlan p WHERE p.facHxsen = :facHxsen"),
    @NamedQuery(name = "ParamPlan.findByFacHxdob", query = "SELECT p FROM ParamPlan p WHERE p.facHxdob = :facHxdob"),
    @NamedQuery(name = "ParamPlan.findByComisiones", query = "SELECT p FROM ParamPlan p WHERE p.comisiones = :comisiones"),
    @NamedQuery(name = "ParamPlan.findByFactuIng", query = "SELECT p FROM ParamPlan p WHERE p.factuIng = :factuIng"),
    @NamedQuery(name = "ParamPlan.findByCta1", query = "SELECT p FROM ParamPlan p WHERE p.cta1 = :cta1"),
    @NamedQuery(name = "ParamPlan.findByCta2", query = "SELECT p FROM ParamPlan p WHERE p.cta2 = :cta2"),
    @NamedQuery(name = "ParamPlan.findByCta3", query = "SELECT p FROM ParamPlan p WHERE p.cta3 = :cta3"),
    @NamedQuery(name = "ParamPlan.findByCta4", query = "SELECT p FROM ParamPlan p WHERE p.cta4 = :cta4"),
    @NamedQuery(name = "ParamPlan.findByCta5", query = "SELECT p FROM ParamPlan p WHERE p.cta5 = :cta5"),
    @NamedQuery(name = "ParamPlan.findByCta1Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta1Ad = :cta1Ad"),
    @NamedQuery(name = "ParamPlan.findByCta2Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta2Ad = :cta2Ad"),
    @NamedQuery(name = "ParamPlan.findByCta3Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta3Ad = :cta3Ad"),
    @NamedQuery(name = "ParamPlan.findByCta4Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta4Ad = :cta4Ad"),
    @NamedQuery(name = "ParamPlan.findByCta5Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta5Ad = :cta5Ad"),
    @NamedQuery(name = "ParamPlan.findByCta1Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta1Ve = :cta1Ve"),
    @NamedQuery(name = "ParamPlan.findByCta2Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta2Ve = :cta2Ve"),
    @NamedQuery(name = "ParamPlan.findByCta3Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta3Ve = :cta3Ve"),
    @NamedQuery(name = "ParamPlan.findByCta4Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta4Ve = :cta4Ve"),
    @NamedQuery(name = "ParamPlan.findByCta5Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta5Ve = :cta5Ve"),
    @NamedQuery(name = "ParamPlan.findByIncapacidad", query = "SELECT p FROM ParamPlan p WHERE p.incapacidad = :incapacidad"),
    @NamedQuery(name = "ParamPlan.findBySalarioMin", query = "SELECT p FROM ParamPlan p WHERE p.salarioMin = :salarioMin"),
    @NamedQuery(name = "ParamPlan.findByFacHx250", query = "SELECT p FROM ParamPlan p WHERE p.facHx250 = :facHx250"),
    @NamedQuery(name = "ParamPlan.findByFVacaciones", query = "SELECT p FROM ParamPlan p WHERE p.fVacaciones = :fVacaciones"),
    @NamedQuery(name = "ParamPlan.findByCta1Op", query = "SELECT p FROM ParamPlan p WHERE p.cta1Op = :cta1Op"),
    @NamedQuery(name = "ParamPlan.findByCta2Op", query = "SELECT p FROM ParamPlan p WHERE p.cta2Op = :cta2Op"),
    @NamedQuery(name = "ParamPlan.findByCta3Op", query = "SELECT p FROM ParamPlan p WHERE p.cta3Op = :cta3Op"),
    @NamedQuery(name = "ParamPlan.findByCta4Op", query = "SELECT p FROM ParamPlan p WHERE p.cta4Op = :cta4Op"),
    @NamedQuery(name = "ParamPlan.findByCta5Op", query = "SELECT p FROM ParamPlan p WHERE p.cta5Op = :cta5Op"),
    @NamedQuery(name = "ParamPlan.findByDiasHistoria", query = "SELECT p FROM ParamPlan p WHERE p.diasHistoria = :diasHistoria"),
    @NamedQuery(name = "ParamPlan.findByMinimoMercaderia", query = "SELECT p FROM ParamPlan p WHERE p.minimoMercaderia = :minimoMercaderia"),
    @NamedQuery(name = "ParamPlan.findByFacHxdf", query = "SELECT p FROM ParamPlan p WHERE p.facHxdf = :facHxdf"),
    @NamedQuery(name = "ParamPlan.findByFacHxnf", query = "SELECT p FROM ParamPlan p WHERE p.facHxnf = :facHxnf"),
    @NamedQuery(name = "ParamPlan.findBySalMinFab", query = "SELECT p FROM ParamPlan p WHERE p.salMinFab = :salMinFab"),
    @NamedQuery(name = "ParamPlan.findByMaxAfp", query = "SELECT p FROM ParamPlan p WHERE p.maxAfp = :maxAfp"),
    @NamedQuery(name = "ParamPlan.findByMaxIsss", query = "SELECT p FROM ParamPlan p WHERE p.maxIsss = :maxIsss"),
    @NamedQuery(name = "ParamPlan.findByFirma1", query = "SELECT p FROM ParamPlan p WHERE p.firma1 = :firma1"),
    @NamedQuery(name = "ParamPlan.findByPuesto1", query = "SELECT p FROM ParamPlan p WHERE p.puesto1 = :puesto1"),
    @NamedQuery(name = "ParamPlan.findByFirma2", query = "SELECT p FROM ParamPlan p WHERE p.firma2 = :firma2"),
    @NamedQuery(name = "ParamPlan.findByPuesto2", query = "SELECT p FROM ParamPlan p WHERE p.puesto2 = :puesto2"),
    @NamedQuery(name = "ParamPlan.findByFirma3", query = "SELECT p FROM ParamPlan p WHERE p.firma3 = :firma3"),
    @NamedQuery(name = "ParamPlan.findByPuesto3", query = "SELECT p FROM ParamPlan p WHERE p.puesto3 = :puesto3")})
public class ParamPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private Short codCia;
    @Basic(optional = false)
    @Column(name = "DIAS_LABOR", nullable = false)
    private short diasLabor;
    @Basic(optional = false)
    @Column(name = "DIAS_MES", nullable = false)
    private short diasMes;
    @Basic(optional = false)
    @Column(name = "HORAS_DIA", nullable = false)
    private short horasDia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "FAC_HXSEN", nullable = false, precision = 8, scale = 4)
    private BigDecimal facHxsen;
    @Basic(optional = false)
    @Column(name = "FAC_HXDOB", nullable = false, precision = 9, scale = 4)
    private BigDecimal facHxdob;
    @Basic(optional = false)
    @Column(name = "COMISIONES", nullable = false, length = 1)
    private String comisiones;
    @Basic(optional = false)
    @Column(name = "FACTU_ING", nullable = false, length = 1)
    private String factuIng;
    @Column(name = "CTA_1")
    private Short cta1;
    @Column(name = "CTA_2")
    private Short cta2;
    @Column(name = "CTA_3")
    private Short cta3;
    @Column(name = "CTA_4")
    private Short cta4;
    @Column(name = "CTA_5")
    private Integer cta5;
    @Column(name = "CTA_1_AD")
    private Short cta1Ad;
    @Column(name = "CTA_2_AD")
    private Short cta2Ad;
    @Column(name = "CTA_3_AD")
    private Short cta3Ad;
    @Column(name = "CTA_4_AD")
    private Short cta4Ad;
    @Column(name = "CTA_5_AD")
    private Integer cta5Ad;
    @Column(name = "CTA_1_VE")
    private Short cta1Ve;
    @Column(name = "CTA_2_VE")
    private Short cta2Ve;
    @Column(name = "CTA_3_VE")
    private Short cta3Ve;
    @Column(name = "CTA_4_VE")
    private Short cta4Ve;
    @Column(name = "CTA_5_VE")
    private Integer cta5Ve;
    @Column(name = "INCAPACIDAD")
    private Integer incapacidad;
    @Column(name = "SALARIO_MIN", precision = 16, scale = 2)
    private BigDecimal salarioMin;
    @Column(name = "FAC_HX250", precision = 9, scale = 4)
    private BigDecimal facHx250;
    @Column(name = "F_VACACIONES", precision = 9, scale = 4)
    private BigDecimal fVacaciones;
    @Column(name = "CTA_1_OP")
    private Short cta1Op;
    @Column(name = "CTA_2_OP")
    private Short cta2Op;
    @Column(name = "CTA_3_OP")
    private Short cta3Op;
    @Column(name = "CTA_4_OP")
    private Short cta4Op;
    @Column(name = "CTA_5_OP")
    private Integer cta5Op;
    @Column(name = "DIAS_HISTORIA")
    private Integer diasHistoria;
    @Column(name = "MINIMO_MERCADERIA", precision = 16, scale = 2)
    private BigDecimal minimoMercaderia;
    @Column(name = "FAC_HXDF", precision = 9, scale = 4)
    private BigDecimal facHxdf;
    @Column(name = "FAC_HXNF", precision = 9, scale = 4)
    private BigDecimal facHxnf;
    @Column(name = "SAL_MIN_FAB", precision = 16, scale = 2)
    private BigDecimal salMinFab;
    @Column(name = "MAX_AFP", precision = 12, scale = 2)
    private BigDecimal maxAfp;
    @Column(name = "MAX_ISSS", precision = 12, scale = 2)
    private BigDecimal maxIsss;
    @Column(name = "FIRMA1", length = 100)
    private String firma1;
    @Column(name = "PUESTO1", length = 100)
    private String puesto1;
    @Column(name = "FIRMA2", length = 100)
    private String firma2;
    @Column(name = "PUESTO2", length = 100)
    private String puesto2;
    @Column(name = "FIRMA3", length = 100)
    private String firma3;
    @Column(name = "PUESTO3", length = 100)
    private String puesto3;

    public ParamPlan() {
    }

    public ParamPlan(Short codCia) {
        this.codCia = codCia;
    }

    public ParamPlan(Short codCia, short diasLabor, short diasMes, short horasDia, BigDecimal facHxsen, BigDecimal facHxdob, String comisiones, String factuIng) {
        this.codCia = codCia;
        this.diasLabor = diasLabor;
        this.diasMes = diasMes;
        this.horasDia = horasDia;
        this.facHxsen = facHxsen;
        this.facHxdob = facHxdob;
        this.comisiones = comisiones;
        this.factuIng = factuIng;
    }

    public Short getCodCia() {
        return codCia;
    }

    public void setCodCia(Short codCia) {
        this.codCia = codCia;
    }

    public short getDiasLabor() {
        return diasLabor;
    }

    public void setDiasLabor(short diasLabor) {
        this.diasLabor = diasLabor;
    }

    public short getDiasMes() {
        return diasMes;
    }

    public void setDiasMes(short diasMes) {
        this.diasMes = diasMes;
    }

    public short getHorasDia() {
        return horasDia;
    }

    public void setHorasDia(short horasDia) {
        this.horasDia = horasDia;
    }

    public BigDecimal getFacHxsen() {
        return facHxsen;
    }

    public void setFacHxsen(BigDecimal facHxsen) {
        this.facHxsen = facHxsen;
    }

    public BigDecimal getFacHxdob() {
        return facHxdob;
    }

    public void setFacHxdob(BigDecimal facHxdob) {
        this.facHxdob = facHxdob;
    }

    public String getComisiones() {
        return comisiones;
    }

    public void setComisiones(String comisiones) {
        this.comisiones = comisiones;
    }

    public String getFactuIng() {
        return factuIng;
    }

    public void setFactuIng(String factuIng) {
        this.factuIng = factuIng;
    }

    public Short getCta1() {
        return cta1;
    }

    public void setCta1(Short cta1) {
        this.cta1 = cta1;
    }

    public Short getCta2() {
        return cta2;
    }

    public void setCta2(Short cta2) {
        this.cta2 = cta2;
    }

    public Short getCta3() {
        return cta3;
    }

    public void setCta3(Short cta3) {
        this.cta3 = cta3;
    }

    public Short getCta4() {
        return cta4;
    }

    public void setCta4(Short cta4) {
        this.cta4 = cta4;
    }

    public Integer getCta5() {
        return cta5;
    }

    public void setCta5(Integer cta5) {
        this.cta5 = cta5;
    }

    public Short getCta1Ad() {
        return cta1Ad;
    }

    public void setCta1Ad(Short cta1Ad) {
        this.cta1Ad = cta1Ad;
    }

    public Short getCta2Ad() {
        return cta2Ad;
    }

    public void setCta2Ad(Short cta2Ad) {
        this.cta2Ad = cta2Ad;
    }

    public Short getCta3Ad() {
        return cta3Ad;
    }

    public void setCta3Ad(Short cta3Ad) {
        this.cta3Ad = cta3Ad;
    }

    public Short getCta4Ad() {
        return cta4Ad;
    }

    public void setCta4Ad(Short cta4Ad) {
        this.cta4Ad = cta4Ad;
    }

    public Integer getCta5Ad() {
        return cta5Ad;
    }

    public void setCta5Ad(Integer cta5Ad) {
        this.cta5Ad = cta5Ad;
    }

    public Short getCta1Ve() {
        return cta1Ve;
    }

    public void setCta1Ve(Short cta1Ve) {
        this.cta1Ve = cta1Ve;
    }

    public Short getCta2Ve() {
        return cta2Ve;
    }

    public void setCta2Ve(Short cta2Ve) {
        this.cta2Ve = cta2Ve;
    }

    public Short getCta3Ve() {
        return cta3Ve;
    }

    public void setCta3Ve(Short cta3Ve) {
        this.cta3Ve = cta3Ve;
    }

    public Short getCta4Ve() {
        return cta4Ve;
    }

    public void setCta4Ve(Short cta4Ve) {
        this.cta4Ve = cta4Ve;
    }

    public Integer getCta5Ve() {
        return cta5Ve;
    }

    public void setCta5Ve(Integer cta5Ve) {
        this.cta5Ve = cta5Ve;
    }

    public Integer getIncapacidad() {
        return incapacidad;
    }

    public void setIncapacidad(Integer incapacidad) {
        this.incapacidad = incapacidad;
    }

    public BigDecimal getSalarioMin() {
        return salarioMin;
    }

    public void setSalarioMin(BigDecimal salarioMin) {
        this.salarioMin = salarioMin;
    }

    public BigDecimal getFacHx250() {
        return facHx250;
    }

    public void setFacHx250(BigDecimal facHx250) {
        this.facHx250 = facHx250;
    }

    public BigDecimal getFVacaciones() {
        return fVacaciones;
    }

    public void setFVacaciones(BigDecimal fVacaciones) {
        this.fVacaciones = fVacaciones;
    }

    public Short getCta1Op() {
        return cta1Op;
    }

    public void setCta1Op(Short cta1Op) {
        this.cta1Op = cta1Op;
    }

    public Short getCta2Op() {
        return cta2Op;
    }

    public void setCta2Op(Short cta2Op) {
        this.cta2Op = cta2Op;
    }

    public Short getCta3Op() {
        return cta3Op;
    }

    public void setCta3Op(Short cta3Op) {
        this.cta3Op = cta3Op;
    }

    public Short getCta4Op() {
        return cta4Op;
    }

    public void setCta4Op(Short cta4Op) {
        this.cta4Op = cta4Op;
    }

    public Integer getCta5Op() {
        return cta5Op;
    }

    public void setCta5Op(Integer cta5Op) {
        this.cta5Op = cta5Op;
    }

    public Integer getDiasHistoria() {
        return diasHistoria;
    }

    public void setDiasHistoria(Integer diasHistoria) {
        this.diasHistoria = diasHistoria;
    }

    public BigDecimal getMinimoMercaderia() {
        return minimoMercaderia;
    }

    public void setMinimoMercaderia(BigDecimal minimoMercaderia) {
        this.minimoMercaderia = minimoMercaderia;
    }

    public BigDecimal getFacHxdf() {
        return facHxdf;
    }

    public void setFacHxdf(BigDecimal facHxdf) {
        this.facHxdf = facHxdf;
    }

    public BigDecimal getFacHxnf() {
        return facHxnf;
    }

    public void setFacHxnf(BigDecimal facHxnf) {
        this.facHxnf = facHxnf;
    }

    public BigDecimal getSalMinFab() {
        return salMinFab;
    }

    public void setSalMinFab(BigDecimal salMinFab) {
        this.salMinFab = salMinFab;
    }

    public BigDecimal getMaxAfp() {
        return maxAfp;
    }

    public void setMaxAfp(BigDecimal maxAfp) {
        this.maxAfp = maxAfp;
    }

    public BigDecimal getMaxIsss() {
        return maxIsss;
    }

    public void setMaxIsss(BigDecimal maxIsss) {
        this.maxIsss = maxIsss;
    }

    public String getFirma1() {
        return firma1;
    }

    public void setFirma1(String firma1) {
        this.firma1 = firma1;
    }

    public String getPuesto1() {
        return puesto1;
    }

    public void setPuesto1(String puesto1) {
        this.puesto1 = puesto1;
    }

    public String getFirma2() {
        return firma2;
    }

    public void setFirma2(String firma2) {
        this.firma2 = firma2;
    }

    public String getPuesto2() {
        return puesto2;
    }

    public void setPuesto2(String puesto2) {
        this.puesto2 = puesto2;
    }

    public String getFirma3() {
        return firma3;
    }

    public void setFirma3(String firma3) {
        this.firma3 = firma3;
    }

    public String getPuesto3() {
        return puesto3;
    }

    public void setPuesto3(String puesto3) {
        this.puesto3 = puesto3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCia != null ? codCia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParamPlan)) {
            return false;
        }
        ParamPlan other = (ParamPlan) object;
        if ((this.codCia == null && other.codCia != null) || (this.codCia != null && !this.codCia.equals(other.codCia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.ParamPlan[ codCia=" + codCia + " ]";
    }
    
}
