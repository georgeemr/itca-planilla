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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DEDUC_PRESTA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeducPresta.findAll", query = "SELECT d FROM DeducPresta d"),
    @NamedQuery(name = "DeducPresta.findByCodDp", query = "SELECT d FROM DeducPresta d WHERE d.deducPrestaPK.codDp = :codDp"),
    @NamedQuery(name = "DeducPresta.findByDesDp", query = "SELECT d FROM DeducPresta d WHERE d.desDp = :desDp"),
    @NamedQuery(name = "DeducPresta.findByVpr", query = "SELECT d FROM DeducPresta d WHERE d.vpr = :vpr"),
    @NamedQuery(name = "DeducPresta.findByFactor", query = "SELECT d FROM DeducPresta d WHERE d.factor = :factor"),
    @NamedQuery(name = "DeducPresta.findByValRef", query = "SELECT d FROM DeducPresta d WHERE d.valRef = :valRef"),
    @NamedQuery(name = "DeducPresta.findByFrecuencia", query = "SELECT d FROM DeducPresta d WHERE d.frecuencia = :frecuencia"),
    @NamedQuery(name = "DeducPresta.findByPosicion", query = "SELECT d FROM DeducPresta d WHERE d.posicion = :posicion"),
    @NamedQuery(name = "DeducPresta.findByAplicar", query = "SELECT d FROM DeducPresta d WHERE d.aplicar = :aplicar"),
    @NamedQuery(name = "DeducPresta.findBySumaResta", query = "SELECT d FROM DeducPresta d WHERE d.sumaResta = :sumaResta"),
    @NamedQuery(name = "DeducPresta.findByCta1", query = "SELECT d FROM DeducPresta d WHERE d.cta1 = :cta1"),
    @NamedQuery(name = "DeducPresta.findByCta2", query = "SELECT d FROM DeducPresta d WHERE d.cta2 = :cta2"),
    @NamedQuery(name = "DeducPresta.findByCta3", query = "SELECT d FROM DeducPresta d WHERE d.cta3 = :cta3"),
    @NamedQuery(name = "DeducPresta.findByCta4", query = "SELECT d FROM DeducPresta d WHERE d.cta4 = :cta4"),
    @NamedQuery(name = "DeducPresta.findByCta5", query = "SELECT d FROM DeducPresta d WHERE d.cta5 = :cta5"),
    @NamedQuery(name = "DeducPresta.findByCodCia", query = "SELECT d FROM DeducPresta d WHERE d.deducPrestaPK.codCia = :codCia"),
    @NamedQuery(name = "DeducPresta.findByDesCorta", query = "SELECT d FROM DeducPresta d WHERE d.desCorta = :desCorta"),
    @NamedQuery(name = "DeducPresta.findByAfp", query = "SELECT d FROM DeducPresta d WHERE d.afp = :afp"),
    @NamedQuery(name = "DeducPresta.findByProgramado", query = "SELECT d FROM DeducPresta d WHERE d.programado = :programado"),
    @NamedQuery(name = "DeducPresta.findByTipo", query = "SELECT d FROM DeducPresta d WHERE d.tipo = :tipo"),
    @NamedQuery(name = "DeducPresta.findByDAfp", query = "SELECT d FROM DeducPresta d WHERE d.dAfp = :dAfp"),
    @NamedQuery(name = "DeducPresta.findByDIsr", query = "SELECT d FROM DeducPresta d WHERE d.dIsr = :dIsr"),
    @NamedQuery(name = "DeducPresta.findByDIsss", query = "SELECT d FROM DeducPresta d WHERE d.dIsss = :dIsss"),
    @NamedQuery(name = "DeducPresta.findBySeContabiliza", query = "SELECT d FROM DeducPresta d WHERE d.seContabiliza = :seContabiliza"),
    @NamedQuery(name = "DeducPresta.findByConstancia", query = "SELECT d FROM DeducPresta d WHERE d.constancia = :constancia")})
public class DeducPresta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeducPrestaPK deducPrestaPK;
    @Size(max = 150)
    @Column(name = "DES_DP", length = 150)
    private String desDp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "VPR", nullable = false, length = 1)
    private String vpr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FACTOR", precision = 8, scale = 4)
    private BigDecimal factor;
    @Column(name = "VAL_REF", precision = 16, scale = 2)
    private BigDecimal valRef;
    @Size(max = 1)
    @Column(name = "FRECUENCIA", length = 1)
    private String frecuencia;
    @Column(name = "POSICION")
    private Short posicion;
    @Size(max = 1)
    @Column(name = "APLICAR", length = 1)
    private String aplicar;
    @Size(max = 1)
    @Column(name = "SUMA_RESTA", length = 1)
    private String sumaResta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTA_1", nullable = false)
    private short cta1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTA_2", nullable = false)
    private short cta2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTA_3", nullable = false)
    private short cta3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTA_4", nullable = false)
    private short cta4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTA_5", nullable = false)
    private int cta5;
    @Size(max = 10)
    @Column(name = "DES_CORTA", length = 10)
    private String desCorta;
    @Size(max = 1)
    @Column(name = "AFP", length = 1)
    private String afp;
    @Size(max = 1)
    @Column(name = "PROGRAMADO", length = 1)
    private String programado;
    @Size(max = 1)
    @Column(name = "TIPO", length = 1)
    private String tipo;
    @Size(max = 1)
    @Column(name = "D_AFP", length = 1)
    private String dAfp;
    @Size(max = 1)
    @Column(name = "D_ISR", length = 1)
    private String dIsr;
    @Size(max = 1)
    @Column(name = "D_ISSS", length = 1)
    private String dIsss;
    @Column(name = "SE_CONTABILIZA")
    private Short seContabiliza;
    @Size(max = 1)
    @Column(name = "CONSTANCIA", length = 1)
    private String constancia;
    @JoinTable(name = "REL_DEDUC_PATRONO", joinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_DP_EMPLEADO", referencedColumnName = "COD_DP", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_DP_PATRONO", referencedColumnName = "COD_DP", nullable = false)})
    @ManyToMany
    private List<DeducPresta> deducPrestaList;
    @ManyToMany(mappedBy = "deducPrestaList")
    private List<DeducPresta> deducPrestaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deducPresta")
    private List<PorRangos> porRangosList;
    @JoinColumn(name = "COD_BASE", referencedColumnName = "COD_BASE", nullable = false)
    @ManyToOne(optional = false)
    private BasesCalculo codBase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deducPresta")
    private List<CtasXDepto> ctasXDeptoList;

    public DeducPresta() {
    }

    public DeducPresta(DeducPrestaPK deducPrestaPK) {
        this.deducPrestaPK = deducPrestaPK;
    }

    public DeducPresta(DeducPrestaPK deducPrestaPK, String vpr, short cta1, short cta2, short cta3, short cta4, int cta5) {
        this.deducPrestaPK = deducPrestaPK;
        this.vpr = vpr;
        this.cta1 = cta1;
        this.cta2 = cta2;
        this.cta3 = cta3;
        this.cta4 = cta4;
        this.cta5 = cta5;
    }

    public DeducPresta(int codDp, short codCia) {
        this.deducPrestaPK = new DeducPrestaPK(codDp, codCia);
    }

    public DeducPrestaPK getDeducPrestaPK() {
        return deducPrestaPK;
    }

    public void setDeducPrestaPK(DeducPrestaPK deducPrestaPK) {
        this.deducPrestaPK = deducPrestaPK;
    }

    public String getDesDp() {
        return desDp;
    }

    public void setDesDp(String desDp) {
        this.desDp = desDp;
    }

    public String getVpr() {
        return vpr;
    }

    public void setVpr(String vpr) {
        this.vpr = vpr;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    public BigDecimal getValRef() {
        return valRef;
    }

    public void setValRef(BigDecimal valRef) {
        this.valRef = valRef;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Short getPosicion() {
        return posicion;
    }

    public void setPosicion(Short posicion) {
        this.posicion = posicion;
    }

    public String getAplicar() {
        return aplicar;
    }

    public void setAplicar(String aplicar) {
        this.aplicar = aplicar;
    }

    public String getSumaResta() {
        return sumaResta;
    }

    public void setSumaResta(String sumaResta) {
        this.sumaResta = sumaResta;
    }

    public short getCta1() {
        return cta1;
    }

    public void setCta1(short cta1) {
        this.cta1 = cta1;
    }

    public short getCta2() {
        return cta2;
    }

    public void setCta2(short cta2) {
        this.cta2 = cta2;
    }

    public short getCta3() {
        return cta3;
    }

    public void setCta3(short cta3) {
        this.cta3 = cta3;
    }

    public short getCta4() {
        return cta4;
    }

    public void setCta4(short cta4) {
        this.cta4 = cta4;
    }

    public int getCta5() {
        return cta5;
    }

    public void setCta5(int cta5) {
        this.cta5 = cta5;
    }

    public String getDesCorta() {
        return desCorta;
    }

    public void setDesCorta(String desCorta) {
        this.desCorta = desCorta;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getProgramado() {
        return programado;
    }

    public void setProgramado(String programado) {
        this.programado = programado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDAfp() {
        return dAfp;
    }

    public void setDAfp(String dAfp) {
        this.dAfp = dAfp;
    }

    public String getDIsr() {
        return dIsr;
    }

    public void setDIsr(String dIsr) {
        this.dIsr = dIsr;
    }

    public String getDIsss() {
        return dIsss;
    }

    public void setDIsss(String dIsss) {
        this.dIsss = dIsss;
    }

    public Short getSeContabiliza() {
        return seContabiliza;
    }

    public void setSeContabiliza(Short seContabiliza) {
        this.seContabiliza = seContabiliza;
    }

    public String getConstancia() {
        return constancia;
    }

    public void setConstancia(String constancia) {
        this.constancia = constancia;
    }

    @XmlTransient
    public List<DeducPresta> getDeducPrestaList() {
        return deducPrestaList;
    }

    public void setDeducPrestaList(List<DeducPresta> deducPrestaList) {
        this.deducPrestaList = deducPrestaList;
    }

    @XmlTransient
    public List<DeducPresta> getDeducPrestaList1() {
        return deducPrestaList1;
    }

    public void setDeducPrestaList1(List<DeducPresta> deducPrestaList1) {
        this.deducPrestaList1 = deducPrestaList1;
    }

    @XmlTransient
    public List<PorRangos> getPorRangosList() {
        return porRangosList;
    }

    public void setPorRangosList(List<PorRangos> porRangosList) {
        this.porRangosList = porRangosList;
    }

    public BasesCalculo getCodBase() {
        return codBase;
    }

    public void setCodBase(BasesCalculo codBase) {
        this.codBase = codBase;
    }

    @XmlTransient
    public List<CtasXDepto> getCtasXDeptoList() {
        return ctasXDeptoList;
    }

    public void setCtasXDeptoList(List<CtasXDepto> ctasXDeptoList) {
        this.ctasXDeptoList = ctasXDeptoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deducPrestaPK != null ? deducPrestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeducPresta)) {
            return false;
        }
        DeducPresta other = (DeducPresta) object;
        if ((this.deducPrestaPK == null && other.deducPrestaPK != null) || (this.deducPrestaPK != null && !this.deducPrestaPK.equals(other.deducPrestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DeducPresta[ deducPrestaPK=" + deducPrestaPK + " ]";
    }
    
}
