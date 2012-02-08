/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "PARAM_PLAN")
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
    @NamedQuery(name = "ParamPlan.findByCta6", query = "SELECT p FROM ParamPlan p WHERE p.cta6 = :cta6"),
    @NamedQuery(name = "ParamPlan.findByCta7", query = "SELECT p FROM ParamPlan p WHERE p.cta7 = :cta7"),
    @NamedQuery(name = "ParamPlan.findByCta8", query = "SELECT p FROM ParamPlan p WHERE p.cta8 = :cta8"),
    @NamedQuery(name = "ParamPlan.findByCta1Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta1Ad = :cta1Ad"),
    @NamedQuery(name = "ParamPlan.findByCta2Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta2Ad = :cta2Ad"),
    @NamedQuery(name = "ParamPlan.findByCta3Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta3Ad = :cta3Ad"),
    @NamedQuery(name = "ParamPlan.findByCta4Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta4Ad = :cta4Ad"),
    @NamedQuery(name = "ParamPlan.findByCta5Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta5Ad = :cta5Ad"),
    @NamedQuery(name = "ParamPlan.findByCta6Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta6Ad = :cta6Ad"),
    @NamedQuery(name = "ParamPlan.findByCta7Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta7Ad = :cta7Ad"),
    @NamedQuery(name = "ParamPlan.findByCta8Ad", query = "SELECT p FROM ParamPlan p WHERE p.cta8Ad = :cta8Ad"),
    @NamedQuery(name = "ParamPlan.findByCta1Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta1Ve = :cta1Ve"),
    @NamedQuery(name = "ParamPlan.findByCta2Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta2Ve = :cta2Ve"),
    @NamedQuery(name = "ParamPlan.findByCta3Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta3Ve = :cta3Ve"),
    @NamedQuery(name = "ParamPlan.findByCta4Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta4Ve = :cta4Ve"),
    @NamedQuery(name = "ParamPlan.findByCta5Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta5Ve = :cta5Ve"),
    @NamedQuery(name = "ParamPlan.findByCta6Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta6Ve = :cta6Ve"),
    @NamedQuery(name = "ParamPlan.findByCta7Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta7Ve = :cta7Ve"),
    @NamedQuery(name = "ParamPlan.findByCta8Ve", query = "SELECT p FROM ParamPlan p WHERE p.cta8Ve = :cta8Ve"),
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
    @NamedQuery(name = "ParamPlan.findByPuesto3", query = "SELECT p FROM ParamPlan p WHERE p.puesto3 = :puesto3"),
    @NamedQuery(name = "ParamPlan.findByCta6Op", query = "SELECT p FROM ParamPlan p WHERE p.cta6Op = :cta6Op"),
    @NamedQuery(name = "ParamPlan.findByCta7Op", query = "SELECT p FROM ParamPlan p WHERE p.cta7Op = :cta7Op"),
    @NamedQuery(name = "ParamPlan.findByCta8Op", query = "SELECT p FROM ParamPlan p WHERE p.cta8Op = :cta8Op"),
    @NamedQuery(name = "ParamPlan.findByHorasNocturno", query = "SELECT p FROM ParamPlan p WHERE p.horasNocturno = :horasNocturno"),
    @NamedQuery(name = "ParamPlan.findByNocturnidad", query = "SELECT p FROM ParamPlan p WHERE p.nocturnidad = :nocturnidad"),
    @NamedQuery(name = "ParamPlan.findByCodDeducIsss", query = "SELECT p FROM ParamPlan p WHERE p.codDeducIsss = :codDeducIsss")})
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
    @Column(name = "CTA_1", length = 2)
    private String cta1;
    @Column(name = "CTA_2", length = 3)
    private String cta2;
    @Column(name = "CTA_3", length = 4)
    private String cta3;
    @Column(name = "CTA_4", length = 4)
    private String cta4;
    @Column(name = "CTA_5", length = 5)
    private String cta5;
    @Column(name = "CTA_6", length = 5)
    private String cta6;
    @Column(name = "CTA_7", length = 5)
    private String cta7;
    @Column(name = "CTA_8", length = 5)
    private String cta8;
    @Column(name = "CTA_1_AD", length = 2)
    private String cta1Ad;
    @Column(name = "CTA_2_AD", length = 3)
    private String cta2Ad;
    @Column(name = "CTA_3_AD", length = 4)
    private String cta3Ad;
    @Column(name = "CTA_4_AD", length = 4)
    private String cta4Ad;
    @Column(name = "CTA_5_AD", length = 5)
    private String cta5Ad;
    @Column(name = "CTA_6_AD", length = 5)
    private String cta6Ad;
    @Column(name = "CTA_7_AD", length = 5)
    private String cta7Ad;
    @Column(name = "CTA_8_AD", length = 5)
    private String cta8Ad;
    @Column(name = "CTA_1_VE", length = 2)
    private String cta1Ve;
    @Column(name = "CTA_2_VE", length = 3)
    private String cta2Ve;
    @Column(name = "CTA_3_VE", length = 4)
    private String cta3Ve;
    @Column(name = "CTA_4_VE", length = 4)
    private String cta4Ve;
    @Column(name = "CTA_5_VE", length = 5)
    private String cta5Ve;
    @Column(name = "CTA_6_VE", length = 5)
    private String cta6Ve;
    @Column(name = "CTA_7_VE", length = 5)
    private String cta7Ve;
    @Column(name = "CTA_8_VE", length = 5)
    private String cta8Ve;
    @Column(name = "INCAPACIDAD")
    private Integer incapacidad;
    @Column(name = "SALARIO_MIN", precision = 16, scale = 2)
    private BigDecimal salarioMin;
    @Column(name = "FAC_HX250", precision = 9, scale = 4)
    private BigDecimal facHx250;
    @Column(name = "F_VACACIONES", precision = 9, scale = 4)
    private BigDecimal fVacaciones;
    @Column(name = "CTA_1_OP", length = 2)
    private String cta1Op;
    @Column(name = "CTA_2_OP", length = 3)
    private String cta2Op;
    @Column(name = "CTA_3_OP", length = 4)
    private String cta3Op;
    @Column(name = "CTA_4_OP", length = 4)
    private String cta4Op;
    @Column(name = "CTA_5_OP", length = 5)
    private String cta5Op;
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
    @Column(name = "CTA_6_OP", length = 5)
    private String cta6Op;
    @Column(name = "CTA_7_OP", length = 5)
    private String cta7Op;
    @Column(name = "CTA_8_OP", length = 5)
    private String cta8Op;
    @Column(name = "HORAS_NOCTURNO")
    private Short horasNocturno;
    @Column(name = "NOCTURNIDAD", precision = 5, scale = 2)
    private BigDecimal nocturnidad;
    @Column(name = "COD_DEDUC_ISSS")
    private Short codDeducIsss;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paramPlan")
    private List<Agencias> agenciasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paramPlan")
    private List<FestivosXDepto> festivosXDeptoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paramPlan")
    private List<PlanillaIsss> planillaIsssList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paramPlan")
    private List<FirmasPlanilla> firmasPlanillaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paramPlan")
    private List<Plnpoliza> plnpolizaList;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cias cias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paramPlan")
    private List<ProgramacionPla> programacionPlaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paramPlan")
    private List<RelUsuarioNivel> relUsuarioNivelList;

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

    public String getCta1() {
        return cta1;
    }

    public void setCta1(String cta1) {
        this.cta1 = cta1;
    }

    public String getCta2() {
        return cta2;
    }

    public void setCta2(String cta2) {
        this.cta2 = cta2;
    }

    public String getCta3() {
        return cta3;
    }

    public void setCta3(String cta3) {
        this.cta3 = cta3;
    }

    public String getCta4() {
        return cta4;
    }

    public void setCta4(String cta4) {
        this.cta4 = cta4;
    }

    public String getCta5() {
        return cta5;
    }

    public void setCta5(String cta5) {
        this.cta5 = cta5;
    }

    public String getCta6() {
        return cta6;
    }

    public void setCta6(String cta6) {
        this.cta6 = cta6;
    }

    public String getCta7() {
        return cta7;
    }

    public void setCta7(String cta7) {
        this.cta7 = cta7;
    }

    public String getCta8() {
        return cta8;
    }

    public void setCta8(String cta8) {
        this.cta8 = cta8;
    }

    public String getCta1Ad() {
        return cta1Ad;
    }

    public void setCta1Ad(String cta1Ad) {
        this.cta1Ad = cta1Ad;
    }

    public String getCta2Ad() {
        return cta2Ad;
    }

    public void setCta2Ad(String cta2Ad) {
        this.cta2Ad = cta2Ad;
    }

    public String getCta3Ad() {
        return cta3Ad;
    }

    public void setCta3Ad(String cta3Ad) {
        this.cta3Ad = cta3Ad;
    }

    public String getCta4Ad() {
        return cta4Ad;
    }

    public void setCta4Ad(String cta4Ad) {
        this.cta4Ad = cta4Ad;
    }

    public String getCta5Ad() {
        return cta5Ad;
    }

    public void setCta5Ad(String cta5Ad) {
        this.cta5Ad = cta5Ad;
    }

    public String getCta6Ad() {
        return cta6Ad;
    }

    public void setCta6Ad(String cta6Ad) {
        this.cta6Ad = cta6Ad;
    }

    public String getCta7Ad() {
        return cta7Ad;
    }

    public void setCta7Ad(String cta7Ad) {
        this.cta7Ad = cta7Ad;
    }

    public String getCta8Ad() {
        return cta8Ad;
    }

    public void setCta8Ad(String cta8Ad) {
        this.cta8Ad = cta8Ad;
    }

    public String getCta1Ve() {
        return cta1Ve;
    }

    public void setCta1Ve(String cta1Ve) {
        this.cta1Ve = cta1Ve;
    }

    public String getCta2Ve() {
        return cta2Ve;
    }

    public void setCta2Ve(String cta2Ve) {
        this.cta2Ve = cta2Ve;
    }

    public String getCta3Ve() {
        return cta3Ve;
    }

    public void setCta3Ve(String cta3Ve) {
        this.cta3Ve = cta3Ve;
    }

    public String getCta4Ve() {
        return cta4Ve;
    }

    public void setCta4Ve(String cta4Ve) {
        this.cta4Ve = cta4Ve;
    }

    public String getCta5Ve() {
        return cta5Ve;
    }

    public void setCta5Ve(String cta5Ve) {
        this.cta5Ve = cta5Ve;
    }

    public String getCta6Ve() {
        return cta6Ve;
    }

    public void setCta6Ve(String cta6Ve) {
        this.cta6Ve = cta6Ve;
    }

    public String getCta7Ve() {
        return cta7Ve;
    }

    public void setCta7Ve(String cta7Ve) {
        this.cta7Ve = cta7Ve;
    }

    public String getCta8Ve() {
        return cta8Ve;
    }

    public void setCta8Ve(String cta8Ve) {
        this.cta8Ve = cta8Ve;
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

    public String getCta1Op() {
        return cta1Op;
    }

    public void setCta1Op(String cta1Op) {
        this.cta1Op = cta1Op;
    }

    public String getCta2Op() {
        return cta2Op;
    }

    public void setCta2Op(String cta2Op) {
        this.cta2Op = cta2Op;
    }

    public String getCta3Op() {
        return cta3Op;
    }

    public void setCta3Op(String cta3Op) {
        this.cta3Op = cta3Op;
    }

    public String getCta4Op() {
        return cta4Op;
    }

    public void setCta4Op(String cta4Op) {
        this.cta4Op = cta4Op;
    }

    public String getCta5Op() {
        return cta5Op;
    }

    public void setCta5Op(String cta5Op) {
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

    public String getCta6Op() {
        return cta6Op;
    }

    public void setCta6Op(String cta6Op) {
        this.cta6Op = cta6Op;
    }

    public String getCta7Op() {
        return cta7Op;
    }

    public void setCta7Op(String cta7Op) {
        this.cta7Op = cta7Op;
    }

    public String getCta8Op() {
        return cta8Op;
    }

    public void setCta8Op(String cta8Op) {
        this.cta8Op = cta8Op;
    }

    public Short getHorasNocturno() {
        return horasNocturno;
    }

    public void setHorasNocturno(Short horasNocturno) {
        this.horasNocturno = horasNocturno;
    }

    public BigDecimal getNocturnidad() {
        return nocturnidad;
    }

    public void setNocturnidad(BigDecimal nocturnidad) {
        this.nocturnidad = nocturnidad;
    }

    public Short getCodDeducIsss() {
        return codDeducIsss;
    }

    public void setCodDeducIsss(Short codDeducIsss) {
        this.codDeducIsss = codDeducIsss;
    }

    @XmlTransient
    public List<Agencias> getAgenciasList() {
        return agenciasList;
    }

    public void setAgenciasList(List<Agencias> agenciasList) {
        this.agenciasList = agenciasList;
    }

    @XmlTransient
    public List<FestivosXDepto> getFestivosXDeptoList() {
        return festivosXDeptoList;
    }

    public void setFestivosXDeptoList(List<FestivosXDepto> festivosXDeptoList) {
        this.festivosXDeptoList = festivosXDeptoList;
    }

    @XmlTransient
    public List<PlanillaIsss> getPlanillaIsssList() {
        return planillaIsssList;
    }

    public void setPlanillaIsssList(List<PlanillaIsss> planillaIsssList) {
        this.planillaIsssList = planillaIsssList;
    }

    @XmlTransient
    public List<FirmasPlanilla> getFirmasPlanillaList() {
        return firmasPlanillaList;
    }

    public void setFirmasPlanillaList(List<FirmasPlanilla> firmasPlanillaList) {
        this.firmasPlanillaList = firmasPlanillaList;
    }

    @XmlTransient
    public List<Plnpoliza> getPlnpolizaList() {
        return plnpolizaList;
    }

    public void setPlnpolizaList(List<Plnpoliza> plnpolizaList) {
        this.plnpolizaList = plnpolizaList;
    }

    public Cias getCias() {
        return cias;
    }

    public void setCias(Cias cias) {
        this.cias = cias;
    }

    @XmlTransient
    public List<ProgramacionPla> getProgramacionPlaList() {
        return programacionPlaList;
    }

    public void setProgramacionPlaList(List<ProgramacionPla> programacionPlaList) {
        this.programacionPlaList = programacionPlaList;
    }

    @XmlTransient
    public List<RelUsuarioNivel> getRelUsuarioNivelList() {
        return relUsuarioNivelList;
    }

    public void setRelUsuarioNivelList(List<RelUsuarioNivel> relUsuarioNivelList) {
        this.relUsuarioNivelList = relUsuarioNivelList;
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
        return "com.infosgroup.planilla.modelo.entidades.ParamPlan[ codCia=" + codCia + " ]";
    }
    
}
