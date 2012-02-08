/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DMGCUENTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dmgcuentas.findAll", query = "SELECT d FROM Dmgcuentas d"),
    @NamedQuery(name = "Dmgcuentas.findByCodCia", query = "SELECT d FROM Dmgcuentas d WHERE d.dmgcuentasPK.codCia = :codCia"),
    @NamedQuery(name = "Dmgcuentas.findByCta1", query = "SELECT d FROM Dmgcuentas d WHERE d.dmgcuentasPK.cta1 = :cta1"),
    @NamedQuery(name = "Dmgcuentas.findByCta2", query = "SELECT d FROM Dmgcuentas d WHERE d.dmgcuentasPK.cta2 = :cta2"),
    @NamedQuery(name = "Dmgcuentas.findByCta3", query = "SELECT d FROM Dmgcuentas d WHERE d.dmgcuentasPK.cta3 = :cta3"),
    @NamedQuery(name = "Dmgcuentas.findByCta4", query = "SELECT d FROM Dmgcuentas d WHERE d.dmgcuentasPK.cta4 = :cta4"),
    @NamedQuery(name = "Dmgcuentas.findByCta5", query = "SELECT d FROM Dmgcuentas d WHERE d.dmgcuentasPK.cta5 = :cta5"),
    @NamedQuery(name = "Dmgcuentas.findByCta6", query = "SELECT d FROM Dmgcuentas d WHERE d.dmgcuentasPK.cta6 = :cta6"),
    @NamedQuery(name = "Dmgcuentas.findByCta7", query = "SELECT d FROM Dmgcuentas d WHERE d.dmgcuentasPK.cta7 = :cta7"),
    @NamedQuery(name = "Dmgcuentas.findByCta8", query = "SELECT d FROM Dmgcuentas d WHERE d.dmgcuentasPK.cta8 = :cta8"),
    @NamedQuery(name = "Dmgcuentas.findByDescripEsp", query = "SELECT d FROM Dmgcuentas d WHERE d.descripEsp = :descripEsp"),
    @NamedQuery(name = "Dmgcuentas.findByDescripIng", query = "SELECT d FROM Dmgcuentas d WHERE d.descripIng = :descripIng"),
    @NamedQuery(name = "Dmgcuentas.findByAcepMov", query = "SELECT d FROM Dmgcuentas d WHERE d.acepMov = :acepMov"),
    @NamedQuery(name = "Dmgcuentas.findByAcepPresup", query = "SELECT d FROM Dmgcuentas d WHERE d.acepPresup = :acepPresup"),
    @NamedQuery(name = "Dmgcuentas.findByAcepActiv", query = "SELECT d FROM Dmgcuentas d WHERE d.acepActiv = :acepActiv"),
    @NamedQuery(name = "Dmgcuentas.findByGrupoCta", query = "SELECT d FROM Dmgcuentas d WHERE d.grupoCta = :grupoCta"),
    @NamedQuery(name = "Dmgcuentas.findByClaseSaldo", query = "SELECT d FROM Dmgcuentas d WHERE d.claseSaldo = :claseSaldo"),
    @NamedQuery(name = "Dmgcuentas.findByCta1p", query = "SELECT d FROM Dmgcuentas d WHERE d.cta1p = :cta1p"),
    @NamedQuery(name = "Dmgcuentas.findByCta2p", query = "SELECT d FROM Dmgcuentas d WHERE d.cta2p = :cta2p"),
    @NamedQuery(name = "Dmgcuentas.findByCta3p", query = "SELECT d FROM Dmgcuentas d WHERE d.cta3p = :cta3p"),
    @NamedQuery(name = "Dmgcuentas.findByCta4p", query = "SELECT d FROM Dmgcuentas d WHERE d.cta4p = :cta4p"),
    @NamedQuery(name = "Dmgcuentas.findByCta5p", query = "SELECT d FROM Dmgcuentas d WHERE d.cta5p = :cta5p"),
    @NamedQuery(name = "Dmgcuentas.findByCta6p", query = "SELECT d FROM Dmgcuentas d WHERE d.cta6p = :cta6p"),
    @NamedQuery(name = "Dmgcuentas.findByCta7p", query = "SELECT d FROM Dmgcuentas d WHERE d.cta7p = :cta7p"),
    @NamedQuery(name = "Dmgcuentas.findByCta8p", query = "SELECT d FROM Dmgcuentas d WHERE d.cta8p = :cta8p"),
    @NamedQuery(name = "Dmgcuentas.findByCtaFlujo", query = "SELECT d FROM Dmgcuentas d WHERE d.ctaFlujo = :ctaFlujo"),
    @NamedQuery(name = "Dmgcuentas.findByUtilCta", query = "SELECT d FROM Dmgcuentas d WHERE d.utilCta = :utilCta"),
    @NamedQuery(name = "Dmgcuentas.findByNivel", query = "SELECT d FROM Dmgcuentas d WHERE d.nivel = :nivel"),
    @NamedQuery(name = "Dmgcuentas.findByCta1c", query = "SELECT d FROM Dmgcuentas d WHERE d.cta1c = :cta1c"),
    @NamedQuery(name = "Dmgcuentas.findByCta2c", query = "SELECT d FROM Dmgcuentas d WHERE d.cta2c = :cta2c"),
    @NamedQuery(name = "Dmgcuentas.findByCta3c", query = "SELECT d FROM Dmgcuentas d WHERE d.cta3c = :cta3c"),
    @NamedQuery(name = "Dmgcuentas.findByCta4c", query = "SELECT d FROM Dmgcuentas d WHERE d.cta4c = :cta4c"),
    @NamedQuery(name = "Dmgcuentas.findByCta5c", query = "SELECT d FROM Dmgcuentas d WHERE d.cta5c = :cta5c"),
    @NamedQuery(name = "Dmgcuentas.findByCta6c", query = "SELECT d FROM Dmgcuentas d WHERE d.cta6c = :cta6c"),
    @NamedQuery(name = "Dmgcuentas.findByCta7c", query = "SELECT d FROM Dmgcuentas d WHERE d.cta7c = :cta7c"),
    @NamedQuery(name = "Dmgcuentas.findByCta8c", query = "SELECT d FROM Dmgcuentas d WHERE d.cta8c = :cta8c"),
    @NamedQuery(name = "Dmgcuentas.findByCodCiaMatriz", query = "SELECT d FROM Dmgcuentas d WHERE d.codCiaMatriz = :codCiaMatriz"),
    @NamedQuery(name = "Dmgcuentas.findByCuentaAuxiliar", query = "SELECT d FROM Dmgcuentas d WHERE d.cuentaAuxiliar = :cuentaAuxiliar"),
    @NamedQuery(name = "Dmgcuentas.findByEstadoCuenta", query = "SELECT d FROM Dmgcuentas d WHERE d.estadoCuenta = :estadoCuenta"),
    @NamedQuery(name = "Dmgcuentas.findByCtaConta", query = "SELECT d FROM Dmgcuentas d WHERE d.ctaConta = :ctaConta"),
    @NamedQuery(name = "Dmgcuentas.findByProyecto", query = "SELECT d FROM Dmgcuentas d WHERE d.proyecto = :proyecto"),
    @NamedQuery(name = "Dmgcuentas.findByCtaReferencia", query = "SELECT d FROM Dmgcuentas d WHERE d.ctaReferencia = :ctaReferencia"),
    @NamedQuery(name = "Dmgcuentas.findByAdicionadoPor", query = "SELECT d FROM Dmgcuentas d WHERE d.adicionadoPor = :adicionadoPor"),
    @NamedQuery(name = "Dmgcuentas.findByFechaAdicion", query = "SELECT d FROM Dmgcuentas d WHERE d.fechaAdicion = :fechaAdicion"),
    @NamedQuery(name = "Dmgcuentas.findByModificadoPor", query = "SELECT d FROM Dmgcuentas d WHERE d.modificadoPor = :modificadoPor"),
    @NamedQuery(name = "Dmgcuentas.findByFechaModificacion", query = "SELECT d FROM Dmgcuentas d WHERE d.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Dmgcuentas.findByCdgoramo", query = "SELECT d FROM Dmgcuentas d WHERE d.cdgoramo = :cdgoramo"),
    @NamedQuery(name = "Dmgcuentas.findByTipoReaseguro", query = "SELECT d FROM Dmgcuentas d WHERE d.tipoReaseguro = :tipoReaseguro"),
    @NamedQuery(name = "Dmgcuentas.findByPagoXl", query = "SELECT d FROM Dmgcuentas d WHERE d.pagoXl = :pagoXl"),
    @NamedQuery(name = "Dmgcuentas.findByCodRubro", query = "SELECT d FROM Dmgcuentas d WHERE d.codRubro = :codRubro"),
    @NamedQuery(name = "Dmgcuentas.findByCodSubtipo", query = "SELECT d FROM Dmgcuentas d WHERE d.codSubtipo = :codSubtipo"),
    @NamedQuery(name = "Dmgcuentas.findByResumenBalance", query = "SELECT d FROM Dmgcuentas d WHERE d.resumenBalance = :resumenBalance")})
public class Dmgcuentas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DmgcuentasPK dmgcuentasPK;
    @Column(name = "DESCRIP_ESP", length = 100)
    private String descripEsp;
    @Column(name = "DESCRIP_ING", length = 100)
    private String descripIng;
    @Column(name = "ACEP_MOV", length = 1)
    private String acepMov;
    @Column(name = "ACEP_PRESUP", length = 1)
    private String acepPresup;
    @Column(name = "ACEP_ACTIV", length = 1)
    private String acepActiv;
    @Column(name = "GRUPO_CTA", length = 1)
    private String grupoCta;
    @Column(name = "CLASE_SALDO", length = 1)
    private String claseSaldo;
    @Column(name = "CTA_1P", length = 2)
    private String cta1p;
    @Column(name = "CTA_2P", length = 3)
    private String cta2p;
    @Column(name = "CTA_3P", length = 4)
    private String cta3p;
    @Column(name = "CTA_4P", length = 4)
    private String cta4p;
    @Column(name = "CTA_5P", length = 5)
    private String cta5p;
    @Column(name = "CTA_6P", length = 5)
    private String cta6p;
    @Column(name = "CTA_7P", length = 5)
    private String cta7p;
    @Column(name = "CTA_8P", length = 5)
    private String cta8p;
    @Column(name = "CTA_FLUJO", length = 1)
    private String ctaFlujo;
    @Column(name = "UTIL_CTA", length = 250)
    private String utilCta;
    @Column(name = "NIVEL")
    private Short nivel;
    @Column(name = "CTA_1C", length = 2)
    private String cta1c;
    @Column(name = "CTA_2C", length = 3)
    private String cta2c;
    @Column(name = "CTA_3C", length = 4)
    private String cta3c;
    @Column(name = "CTA_4C", length = 4)
    private String cta4c;
    @Column(name = "CTA_5C", length = 5)
    private String cta5c;
    @Column(name = "CTA_6C", length = 5)
    private String cta6c;
    @Column(name = "CTA_7C", length = 5)
    private String cta7c;
    @Column(name = "CTA_8C", length = 5)
    private String cta8c;
    @Column(name = "COD_CIA_MATRIZ")
    private Short codCiaMatriz;
    @Column(name = "CUENTA_AUXILIAR", length = 1)
    private String cuentaAuxiliar;
    @Column(name = "ESTADO_CUENTA", length = 1)
    private String estadoCuenta;
    @Column(name = "CTA_CONTA", length = 25)
    private String ctaConta;
    @Column(name = "PROYECTO", length = 1)
    private String proyecto;
    @Column(name = "CTA_REFERENCIA", length = 20)
    private String ctaReferencia;
    @Column(name = "ADICIONADO_POR", length = 20)
    private String adicionadoPor;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @Column(name = "MODIFICADO_POR", length = 20)
    private String modificadoPor;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "CDGORAMO")
    private Integer cdgoramo;
    @Column(name = "TIPO_REASEGURO", length = 1)
    private String tipoReaseguro;
    @Column(name = "PAGO_XL", length = 1)
    private String pagoXl;
    @Column(name = "COD_RUBRO")
    private Integer codRubro;
    @Column(name = "COD_SUBTIPO")
    private Integer codSubtipo;
    @Column(name = "RESUMEN_BALANCE", length = 1)
    private String resumenBalance;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cias cias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dmgcuentas")
    private List<InstitucionDepto> institucionDeptoList;

    public Dmgcuentas() {
    }

    public Dmgcuentas(DmgcuentasPK dmgcuentasPK) {
        this.dmgcuentasPK = dmgcuentasPK;
    }

    public Dmgcuentas(short codCia, String cta1, String cta2, String cta3, String cta4, String cta5, String cta6, String cta7, String cta8) {
        this.dmgcuentasPK = new DmgcuentasPK(codCia, cta1, cta2, cta3, cta4, cta5, cta6, cta7, cta8);
    }

    public DmgcuentasPK getDmgcuentasPK() {
        return dmgcuentasPK;
    }

    public void setDmgcuentasPK(DmgcuentasPK dmgcuentasPK) {
        this.dmgcuentasPK = dmgcuentasPK;
    }

    public String getDescripEsp() {
        return descripEsp;
    }

    public void setDescripEsp(String descripEsp) {
        this.descripEsp = descripEsp;
    }

    public String getDescripIng() {
        return descripIng;
    }

    public void setDescripIng(String descripIng) {
        this.descripIng = descripIng;
    }

    public String getAcepMov() {
        return acepMov;
    }

    public void setAcepMov(String acepMov) {
        this.acepMov = acepMov;
    }

    public String getAcepPresup() {
        return acepPresup;
    }

    public void setAcepPresup(String acepPresup) {
        this.acepPresup = acepPresup;
    }

    public String getAcepActiv() {
        return acepActiv;
    }

    public void setAcepActiv(String acepActiv) {
        this.acepActiv = acepActiv;
    }

    public String getGrupoCta() {
        return grupoCta;
    }

    public void setGrupoCta(String grupoCta) {
        this.grupoCta = grupoCta;
    }

    public String getClaseSaldo() {
        return claseSaldo;
    }

    public void setClaseSaldo(String claseSaldo) {
        this.claseSaldo = claseSaldo;
    }

    public String getCta1p() {
        return cta1p;
    }

    public void setCta1p(String cta1p) {
        this.cta1p = cta1p;
    }

    public String getCta2p() {
        return cta2p;
    }

    public void setCta2p(String cta2p) {
        this.cta2p = cta2p;
    }

    public String getCta3p() {
        return cta3p;
    }

    public void setCta3p(String cta3p) {
        this.cta3p = cta3p;
    }

    public String getCta4p() {
        return cta4p;
    }

    public void setCta4p(String cta4p) {
        this.cta4p = cta4p;
    }

    public String getCta5p() {
        return cta5p;
    }

    public void setCta5p(String cta5p) {
        this.cta5p = cta5p;
    }

    public String getCta6p() {
        return cta6p;
    }

    public void setCta6p(String cta6p) {
        this.cta6p = cta6p;
    }

    public String getCta7p() {
        return cta7p;
    }

    public void setCta7p(String cta7p) {
        this.cta7p = cta7p;
    }

    public String getCta8p() {
        return cta8p;
    }

    public void setCta8p(String cta8p) {
        this.cta8p = cta8p;
    }

    public String getCtaFlujo() {
        return ctaFlujo;
    }

    public void setCtaFlujo(String ctaFlujo) {
        this.ctaFlujo = ctaFlujo;
    }

    public String getUtilCta() {
        return utilCta;
    }

    public void setUtilCta(String utilCta) {
        this.utilCta = utilCta;
    }

    public Short getNivel() {
        return nivel;
    }

    public void setNivel(Short nivel) {
        this.nivel = nivel;
    }

    public String getCta1c() {
        return cta1c;
    }

    public void setCta1c(String cta1c) {
        this.cta1c = cta1c;
    }

    public String getCta2c() {
        return cta2c;
    }

    public void setCta2c(String cta2c) {
        this.cta2c = cta2c;
    }

    public String getCta3c() {
        return cta3c;
    }

    public void setCta3c(String cta3c) {
        this.cta3c = cta3c;
    }

    public String getCta4c() {
        return cta4c;
    }

    public void setCta4c(String cta4c) {
        this.cta4c = cta4c;
    }

    public String getCta5c() {
        return cta5c;
    }

    public void setCta5c(String cta5c) {
        this.cta5c = cta5c;
    }

    public String getCta6c() {
        return cta6c;
    }

    public void setCta6c(String cta6c) {
        this.cta6c = cta6c;
    }

    public String getCta7c() {
        return cta7c;
    }

    public void setCta7c(String cta7c) {
        this.cta7c = cta7c;
    }

    public String getCta8c() {
        return cta8c;
    }

    public void setCta8c(String cta8c) {
        this.cta8c = cta8c;
    }

    public Short getCodCiaMatriz() {
        return codCiaMatriz;
    }

    public void setCodCiaMatriz(Short codCiaMatriz) {
        this.codCiaMatriz = codCiaMatriz;
    }

    public String getCuentaAuxiliar() {
        return cuentaAuxiliar;
    }

    public void setCuentaAuxiliar(String cuentaAuxiliar) {
        this.cuentaAuxiliar = cuentaAuxiliar;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public String getCtaConta() {
        return ctaConta;
    }

    public void setCtaConta(String ctaConta) {
        this.ctaConta = ctaConta;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getCtaReferencia() {
        return ctaReferencia;
    }

    public void setCtaReferencia(String ctaReferencia) {
        this.ctaReferencia = ctaReferencia;
    }

    public String getAdicionadoPor() {
        return adicionadoPor;
    }

    public void setAdicionadoPor(String adicionadoPor) {
        this.adicionadoPor = adicionadoPor;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(Date fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getCdgoramo() {
        return cdgoramo;
    }

    public void setCdgoramo(Integer cdgoramo) {
        this.cdgoramo = cdgoramo;
    }

    public String getTipoReaseguro() {
        return tipoReaseguro;
    }

    public void setTipoReaseguro(String tipoReaseguro) {
        this.tipoReaseguro = tipoReaseguro;
    }

    public String getPagoXl() {
        return pagoXl;
    }

    public void setPagoXl(String pagoXl) {
        this.pagoXl = pagoXl;
    }

    public Integer getCodRubro() {
        return codRubro;
    }

    public void setCodRubro(Integer codRubro) {
        this.codRubro = codRubro;
    }

    public Integer getCodSubtipo() {
        return codSubtipo;
    }

    public void setCodSubtipo(Integer codSubtipo) {
        this.codSubtipo = codSubtipo;
    }

    public String getResumenBalance() {
        return resumenBalance;
    }

    public void setResumenBalance(String resumenBalance) {
        this.resumenBalance = resumenBalance;
    }

    public Cias getCias() {
        return cias;
    }

    public void setCias(Cias cias) {
        this.cias = cias;
    }

    @XmlTransient
    public List<InstitucionDepto> getInstitucionDeptoList() {
        return institucionDeptoList;
    }

    public void setInstitucionDeptoList(List<InstitucionDepto> institucionDeptoList) {
        this.institucionDeptoList = institucionDeptoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dmgcuentasPK != null ? dmgcuentasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dmgcuentas)) {
            return false;
        }
        Dmgcuentas other = (Dmgcuentas) object;
        if ((this.dmgcuentasPK == null && other.dmgcuentasPK != null) || (this.dmgcuentasPK != null && !this.dmgcuentasPK.equals(other.dmgcuentasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Dmgcuentas[ dmgcuentasPK=" + dmgcuentasPK + " ]";
    }
    
}
