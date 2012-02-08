/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "CIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cias.findAll", query = "SELECT c FROM Cias c"),
    @NamedQuery(name = "Cias.findByCodCia", query = "SELECT c FROM Cias c WHERE c.codCia = :codCia"),
    @NamedQuery(name = "Cias.findByRazonSocial", query = "SELECT c FROM Cias c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "Cias.findByNomComercial", query = "SELECT c FROM Cias c WHERE c.nomComercial = :nomComercial"),
    @NamedQuery(name = "Cias.findByDirecEmpresa", query = "SELECT c FROM Cias c WHERE c.direcEmpresa = :direcEmpresa"),
    @NamedQuery(name = "Cias.findByTelefEmpresa", query = "SELECT c FROM Cias c WHERE c.telefEmpresa = :telefEmpresa"),
    @NamedQuery(name = "Cias.findByNitEmpresa", query = "SELECT c FROM Cias c WHERE c.nitEmpresa = :nitEmpresa"),
    @NamedQuery(name = "Cias.findByNumeroPatronal", query = "SELECT c FROM Cias c WHERE c.numeroPatronal = :numeroPatronal"),
    @NamedQuery(name = "Cias.findByMesCierre", query = "SELECT c FROM Cias c WHERE c.mesCierre = :mesCierre"),
    @NamedQuery(name = "Cias.findByMesProceso", query = "SELECT c FROM Cias c WHERE c.mesProceso = :mesProceso"),
    @NamedQuery(name = "Cias.findByCta1resulAct", query = "SELECT c FROM Cias c WHERE c.cta1resulAct = :cta1resulAct"),
    @NamedQuery(name = "Cias.findByCta2resulAct", query = "SELECT c FROM Cias c WHERE c.cta2resulAct = :cta2resulAct"),
    @NamedQuery(name = "Cias.findByCta3resulAct", query = "SELECT c FROM Cias c WHERE c.cta3resulAct = :cta3resulAct"),
    @NamedQuery(name = "Cias.findByCta4resulAct", query = "SELECT c FROM Cias c WHERE c.cta4resulAct = :cta4resulAct"),
    @NamedQuery(name = "Cias.findByCta5resulAct", query = "SELECT c FROM Cias c WHERE c.cta5resulAct = :cta5resulAct"),
    @NamedQuery(name = "Cias.findByCta1resulAnt", query = "SELECT c FROM Cias c WHERE c.cta1resulAnt = :cta1resulAnt"),
    @NamedQuery(name = "Cias.findByCta2resulAnt", query = "SELECT c FROM Cias c WHERE c.cta2resulAnt = :cta2resulAnt"),
    @NamedQuery(name = "Cias.findByCta3resulAnt", query = "SELECT c FROM Cias c WHERE c.cta3resulAnt = :cta3resulAnt"),
    @NamedQuery(name = "Cias.findByCta4resulAnt", query = "SELECT c FROM Cias c WHERE c.cta4resulAnt = :cta4resulAnt"),
    @NamedQuery(name = "Cias.findByCta5resulAnt", query = "SELECT c FROM Cias c WHERE c.cta5resulAnt = :cta5resulAnt"),
    @NamedQuery(name = "Cias.findByCta1perGan", query = "SELECT c FROM Cias c WHERE c.cta1perGan = :cta1perGan"),
    @NamedQuery(name = "Cias.findByCta2perGan", query = "SELECT c FROM Cias c WHERE c.cta2perGan = :cta2perGan"),
    @NamedQuery(name = "Cias.findByCta3perGan", query = "SELECT c FROM Cias c WHERE c.cta3perGan = :cta3perGan"),
    @NamedQuery(name = "Cias.findByCta4perGan", query = "SELECT c FROM Cias c WHERE c.cta4perGan = :cta4perGan"),
    @NamedQuery(name = "Cias.findByCta5perGan", query = "SELECT c FROM Cias c WHERE c.cta5perGan = :cta5perGan"),
    @NamedQuery(name = "Cias.findByFechUlt", query = "SELECT c FROM Cias c WHERE c.fechUlt = :fechUlt"),
    @NamedQuery(name = "Cias.findByFecUltCie", query = "SELECT c FROM Cias c WHERE c.fecUltCie = :fecUltCie"),
    @NamedQuery(name = "Cias.findByTasaIva", query = "SELECT c FROM Cias c WHERE c.tasaIva = :tasaIva"),
    @NamedQuery(name = "Cias.findByTipoNumeracion", query = "SELECT c FROM Cias c WHERE c.tipoNumeracion = :tipoNumeracion"),
    @NamedQuery(name = "Cias.findBySiReferencia", query = "SELECT c FROM Cias c WHERE c.siReferencia = :siReferencia"),
    @NamedQuery(name = "Cias.findByRegistoIva", query = "SELECT c FROM Cias c WHERE c.registoIva = :registoIva"),
    @NamedQuery(name = "Cias.findByGiro", query = "SELECT c FROM Cias c WHERE c.giro = :giro"),
    @NamedQuery(name = "Cias.findByUtilizaProyecto", query = "SELECT c FROM Cias c WHERE c.utilizaProyecto = :utilizaProyecto"),
    @NamedQuery(name = "Cias.findByEnCierre", query = "SELECT c FROM Cias c WHERE c.enCierre = :enCierre"),
    @NamedQuery(name = "Cias.findByAnoProceso", query = "SELECT c FROM Cias c WHERE c.anoProceso = :anoProceso"),
    @NamedQuery(name = "Cias.findByCodPais", query = "SELECT c FROM Cias c WHERE c.codPais = :codPais"),
    @NamedQuery(name = "Cias.findByMonedaBase", query = "SELECT c FROM Cias c WHERE c.monedaBase = :monedaBase"),
    @NamedQuery(name = "Cias.findByCodAuto", query = "SELECT c FROM Cias c WHERE c.codAuto = :codAuto"),
    @NamedQuery(name = "Cias.findByIvaDl", query = "SELECT c FROM Cias c WHERE c.ivaDl = :ivaDl"),
    @NamedQuery(name = "Cias.findByTasaPercep", query = "SELECT c FROM Cias c WHERE c.tasaPercep = :tasaPercep"),
    @NamedQuery(name = "Cias.findByCodigoSsf", query = "SELECT c FROM Cias c WHERE c.codigoSsf = :codigoSsf"),
    @NamedQuery(name = "Cias.findByInumeames", query = "SELECT c FROM Cias c WHERE c.inumeames = :inumeames"),
    @NamedQuery(name = "Cias.findByCta6resulAct", query = "SELECT c FROM Cias c WHERE c.cta6resulAct = :cta6resulAct"),
    @NamedQuery(name = "Cias.findByCta7resulAct", query = "SELECT c FROM Cias c WHERE c.cta7resulAct = :cta7resulAct"),
    @NamedQuery(name = "Cias.findByCta8resulAct", query = "SELECT c FROM Cias c WHERE c.cta8resulAct = :cta8resulAct"),
    @NamedQuery(name = "Cias.findByCta6resulAnt", query = "SELECT c FROM Cias c WHERE c.cta6resulAnt = :cta6resulAnt"),
    @NamedQuery(name = "Cias.findByCta7resulAnt", query = "SELECT c FROM Cias c WHERE c.cta7resulAnt = :cta7resulAnt"),
    @NamedQuery(name = "Cias.findByCta8resulAnt", query = "SELECT c FROM Cias c WHERE c.cta8resulAnt = :cta8resulAnt"),
    @NamedQuery(name = "Cias.findByCta6perGan", query = "SELECT c FROM Cias c WHERE c.cta6perGan = :cta6perGan"),
    @NamedQuery(name = "Cias.findByCta7perGan", query = "SELECT c FROM Cias c WHERE c.cta7perGan = :cta7perGan"),
    @NamedQuery(name = "Cias.findByCta8perGan", query = "SELECT c FROM Cias c WHERE c.cta8perGan = :cta8perGan"),
    @NamedQuery(name = "Cias.findByNumeames", query = "SELECT c FROM Cias c WHERE c.numeames = :numeames")})
public class Cias implements Serializable {
    @Column(name =     "FECH_ULT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechUlt;
    @Column(name =     "FEC_ULT_CIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecUltCie;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private Short codCia;
    @Column(name = "RAZON_SOCIAL", length = 60)
    private String razonSocial;
    @Column(name = "NOM_COMERCIAL", length = 60)
    private String nomComercial;
    @Column(name = "DIREC_EMPRESA", length = 100)
    private String direcEmpresa;
    @Column(name = "TELEF_EMPRESA", length = 30)
    private String telefEmpresa;
    @Column(name = "NIT_EMPRESA", length = 17)
    private String nitEmpresa;
    @Column(name = "NUMERO_PATRONAL", length = 15)
    private String numeroPatronal;
    @Column(name = "MES_CIERRE")
    private Short mesCierre;
    @Column(name = "MES_PROCESO")
    private Short mesProceso;
    @Column(name = "CTA_1RESUL_ACT", length = 2)
    private String cta1resulAct;
    @Column(name = "CTA_2RESUL_ACT", length = 3)
    private String cta2resulAct;
    @Column(name = "CTA_3RESUL_ACT", length = 4)
    private String cta3resulAct;
    @Column(name = "CTA_4RESUL_ACT", length = 4)
    private String cta4resulAct;
    @Column(name = "CTA_5RESUL_ACT", length = 5)
    private String cta5resulAct;
    @Column(name = "CTA_1RESUL_ANT", length = 2)
    private String cta1resulAnt;
    @Column(name = "CTA_2RESUL_ANT", length = 3)
    private String cta2resulAnt;
    @Column(name = "CTA_3RESUL_ANT", length = 4)
    private String cta3resulAnt;
    @Column(name = "CTA_4RESUL_ANT", length = 4)
    private String cta4resulAnt;
    @Column(name = "CTA_5RESUL_ANT", length = 5)
    private String cta5resulAnt;
    @Column(name = "CTA_1PER_GAN", length = 2)
    private String cta1perGan;
    @Column(name = "CTA_2PER_GAN", length = 3)
    private String cta2perGan;
    @Column(name = "CTA_3PER_GAN", length = 4)
    private String cta3perGan;
    @Column(name = "CTA_4PER_GAN", length = 4)
    private String cta4perGan;
    @Column(name = "CTA_5PER_GAN", length = 5)
    private String cta5perGan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TASA_IVA", precision = 5, scale = 3)
    private BigDecimal tasaIva;
    @Column(name = "TIPO_NUMERACION")
    private Short tipoNumeracion;
    @Column(name = "SI_REFERENCIA", length = 1)
    private String siReferencia;
    @Column(name = "REGISTO_IVA", length = 15)
    private String registoIva;
    @Column(name = "GIRO", length = 35)
    private String giro;
    @Column(name = "UTILIZA_PROYECTO", length = 1)
    private String utilizaProyecto;
    @Column(name = "EN_CIERRE", length = 1)
    private String enCierre;
    @Column(name = "ANO_PROCESO")
    private Short anoProceso;
    @Column(name = "COD_PAIS")
    private Short codPais;
    @Column(name = "MONEDA_BASE")
    private Short monedaBase;
    @Column(name = "COD_AUTO", length = 1)
    private String codAuto;
    @Column(name = "IVA_DL", length = 5)
    private String ivaDl;
    @Column(name = "TASA_PERCEP", precision = 5, scale = 3)
    private BigDecimal tasaPercep;
    @Column(name = "CODIGO_SSF", length = 4)
    private String codigoSsf;
    @Column(name = "INUMEAMES")
    private Integer inumeames;
    @Column(name = "CTA_6RESUL_ACT", length = 5)
    private String cta6resulAct;
    @Column(name = "CTA_7RESUL_ACT", length = 5)
    private String cta7resulAct;
    @Column(name = "CTA_8RESUL_ACT", length = 5)
    private String cta8resulAct;
    @Column(name = "CTA_6RESUL_ANT", length = 5)
    private String cta6resulAnt;
    @Column(name = "CTA_7RESUL_ANT", length = 5)
    private String cta7resulAnt;
    @Column(name = "CTA_8RESUL_ANT", length = 5)
    private String cta8resulAnt;
    @Column(name = "CTA_6PER_GAN", length = 5)
    private String cta6perGan;
    @Column(name = "CTA_7PER_GAN", length = 5)
    private String cta7perGan;
    @Column(name = "CTA_8PER_GAN", length = 5)
    private String cta8perGan;
    @Column(name = "NUMEAMES")
    private Long numeames;
    @OneToMany(mappedBy = "codCiaMatriz")
    private List<Cias> ciasList;
    @JoinColumn(name = "COD_CIA_MATRIZ", referencedColumnName = "COD_CIA")
    @ManyToOne
    private Cias codCiaMatriz;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<TipoTransaccion> tipoTransaccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<TipoRespuesta> tipoRespuestaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<Rol> rolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<TiposPlanilla> tiposPlanillaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<Gerencia> gerenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<EstadoConcurso> estadoConcursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<Dmgcuentas> dmgcuentasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<TipoCriterio> tipoCriterioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<Bancos> bancosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<EstadoContrato> estadoContratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<NivelAcademico> nivelAcademicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<DeducPresta> deducPrestaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<TipoCuenta> tipoCuentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<Campania> campaniaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<CausasRenuncia> causasRenunciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<Indicador> indicadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<TipoPuesto> tipoPuestoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<TipoEvaluacion> tipoEvaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<Candidato> candidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<Instituciones> institucionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<Factor> factorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<TipoAccion> tipoAccionList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cias")
    private ParamPlan paramPlan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<TipoContrato> tipoContratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<Modulo> moduloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<RhOutsorcing> rhOutsorcingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cias")
    private List<FrecuenciaFuncion> frecuenciaFuncionList;

    public Cias() {
    }

    public Cias(Short codCia) {
        this.codCia = codCia;
    }

    public Short getCodCia() {
        return codCia;
    }

    public void setCodCia(Short codCia) {
        this.codCia = codCia;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNomComercial() {
        return nomComercial;
    }

    public void setNomComercial(String nomComercial) {
        this.nomComercial = nomComercial;
    }

    public String getDirecEmpresa() {
        return direcEmpresa;
    }

    public void setDirecEmpresa(String direcEmpresa) {
        this.direcEmpresa = direcEmpresa;
    }

    public String getTelefEmpresa() {
        return telefEmpresa;
    }

    public void setTelefEmpresa(String telefEmpresa) {
        this.telefEmpresa = telefEmpresa;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNumeroPatronal() {
        return numeroPatronal;
    }

    public void setNumeroPatronal(String numeroPatronal) {
        this.numeroPatronal = numeroPatronal;
    }

    public Short getMesCierre() {
        return mesCierre;
    }

    public void setMesCierre(Short mesCierre) {
        this.mesCierre = mesCierre;
    }

    public Short getMesProceso() {
        return mesProceso;
    }

    public void setMesProceso(Short mesProceso) {
        this.mesProceso = mesProceso;
    }

    public String getCta1resulAct() {
        return cta1resulAct;
    }

    public void setCta1resulAct(String cta1resulAct) {
        this.cta1resulAct = cta1resulAct;
    }

    public String getCta2resulAct() {
        return cta2resulAct;
    }

    public void setCta2resulAct(String cta2resulAct) {
        this.cta2resulAct = cta2resulAct;
    }

    public String getCta3resulAct() {
        return cta3resulAct;
    }

    public void setCta3resulAct(String cta3resulAct) {
        this.cta3resulAct = cta3resulAct;
    }

    public String getCta4resulAct() {
        return cta4resulAct;
    }

    public void setCta4resulAct(String cta4resulAct) {
        this.cta4resulAct = cta4resulAct;
    }

    public String getCta5resulAct() {
        return cta5resulAct;
    }

    public void setCta5resulAct(String cta5resulAct) {
        this.cta5resulAct = cta5resulAct;
    }

    public String getCta1resulAnt() {
        return cta1resulAnt;
    }

    public void setCta1resulAnt(String cta1resulAnt) {
        this.cta1resulAnt = cta1resulAnt;
    }

    public String getCta2resulAnt() {
        return cta2resulAnt;
    }

    public void setCta2resulAnt(String cta2resulAnt) {
        this.cta2resulAnt = cta2resulAnt;
    }

    public String getCta3resulAnt() {
        return cta3resulAnt;
    }

    public void setCta3resulAnt(String cta3resulAnt) {
        this.cta3resulAnt = cta3resulAnt;
    }

    public String getCta4resulAnt() {
        return cta4resulAnt;
    }

    public void setCta4resulAnt(String cta4resulAnt) {
        this.cta4resulAnt = cta4resulAnt;
    }

    public String getCta5resulAnt() {
        return cta5resulAnt;
    }

    public void setCta5resulAnt(String cta5resulAnt) {
        this.cta5resulAnt = cta5resulAnt;
    }

    public String getCta1perGan() {
        return cta1perGan;
    }

    public void setCta1perGan(String cta1perGan) {
        this.cta1perGan = cta1perGan;
    }

    public String getCta2perGan() {
        return cta2perGan;
    }

    public void setCta2perGan(String cta2perGan) {
        this.cta2perGan = cta2perGan;
    }

    public String getCta3perGan() {
        return cta3perGan;
    }

    public void setCta3perGan(String cta3perGan) {
        this.cta3perGan = cta3perGan;
    }

    public String getCta4perGan() {
        return cta4perGan;
    }

    public void setCta4perGan(String cta4perGan) {
        this.cta4perGan = cta4perGan;
    }

    public String getCta5perGan() {
        return cta5perGan;
    }

    public void setCta5perGan(String cta5perGan) {
        this.cta5perGan = cta5perGan;
    }

    public Date getFechUlt() {
        return fechUlt;
    }

    public void setFechUlt(Date fechUlt) {
        this.fechUlt = fechUlt;
    }

    public Date getFecUltCie() {
        return fecUltCie;
    }

    public void setFecUltCie(Date fecUltCie) {
        this.fecUltCie = fecUltCie;
    }

    public BigDecimal getTasaIva() {
        return tasaIva;
    }

    public void setTasaIva(BigDecimal tasaIva) {
        this.tasaIva = tasaIva;
    }

    public Short getTipoNumeracion() {
        return tipoNumeracion;
    }

    public void setTipoNumeracion(Short tipoNumeracion) {
        this.tipoNumeracion = tipoNumeracion;
    }

    public String getSiReferencia() {
        return siReferencia;
    }

    public void setSiReferencia(String siReferencia) {
        this.siReferencia = siReferencia;
    }

    public String getRegistoIva() {
        return registoIva;
    }

    public void setRegistoIva(String registoIva) {
        this.registoIva = registoIva;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getUtilizaProyecto() {
        return utilizaProyecto;
    }

    public void setUtilizaProyecto(String utilizaProyecto) {
        this.utilizaProyecto = utilizaProyecto;
    }

    public String getEnCierre() {
        return enCierre;
    }

    public void setEnCierre(String enCierre) {
        this.enCierre = enCierre;
    }

    public Short getAnoProceso() {
        return anoProceso;
    }

    public void setAnoProceso(Short anoProceso) {
        this.anoProceso = anoProceso;
    }

    public Short getCodPais() {
        return codPais;
    }

    public void setCodPais(Short codPais) {
        this.codPais = codPais;
    }

    public Short getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(Short monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getCodAuto() {
        return codAuto;
    }

    public void setCodAuto(String codAuto) {
        this.codAuto = codAuto;
    }

    public String getIvaDl() {
        return ivaDl;
    }

    public void setIvaDl(String ivaDl) {
        this.ivaDl = ivaDl;
    }

    public BigDecimal getTasaPercep() {
        return tasaPercep;
    }

    public void setTasaPercep(BigDecimal tasaPercep) {
        this.tasaPercep = tasaPercep;
    }

    public String getCodigoSsf() {
        return codigoSsf;
    }

    public void setCodigoSsf(String codigoSsf) {
        this.codigoSsf = codigoSsf;
    }

    public Integer getInumeames() {
        return inumeames;
    }

    public void setInumeames(Integer inumeames) {
        this.inumeames = inumeames;
    }

    public String getCta6resulAct() {
        return cta6resulAct;
    }

    public void setCta6resulAct(String cta6resulAct) {
        this.cta6resulAct = cta6resulAct;
    }

    public String getCta7resulAct() {
        return cta7resulAct;
    }

    public void setCta7resulAct(String cta7resulAct) {
        this.cta7resulAct = cta7resulAct;
    }

    public String getCta8resulAct() {
        return cta8resulAct;
    }

    public void setCta8resulAct(String cta8resulAct) {
        this.cta8resulAct = cta8resulAct;
    }

    public String getCta6resulAnt() {
        return cta6resulAnt;
    }

    public void setCta6resulAnt(String cta6resulAnt) {
        this.cta6resulAnt = cta6resulAnt;
    }

    public String getCta7resulAnt() {
        return cta7resulAnt;
    }

    public void setCta7resulAnt(String cta7resulAnt) {
        this.cta7resulAnt = cta7resulAnt;
    }

    public String getCta8resulAnt() {
        return cta8resulAnt;
    }

    public void setCta8resulAnt(String cta8resulAnt) {
        this.cta8resulAnt = cta8resulAnt;
    }

    public String getCta6perGan() {
        return cta6perGan;
    }

    public void setCta6perGan(String cta6perGan) {
        this.cta6perGan = cta6perGan;
    }

    public String getCta7perGan() {
        return cta7perGan;
    }

    public void setCta7perGan(String cta7perGan) {
        this.cta7perGan = cta7perGan;
    }

    public String getCta8perGan() {
        return cta8perGan;
    }

    public void setCta8perGan(String cta8perGan) {
        this.cta8perGan = cta8perGan;
    }

    public Long getNumeames() {
        return numeames;
    }

    public void setNumeames(Long numeames) {
        this.numeames = numeames;
    }

    @XmlTransient
    public List<Cias> getCiasList() {
        return ciasList;
    }

    public void setCiasList(List<Cias> ciasList) {
        this.ciasList = ciasList;
    }

    public Cias getCodCiaMatriz() {
        return codCiaMatriz;
    }

    public void setCodCiaMatriz(Cias codCiaMatriz) {
        this.codCiaMatriz = codCiaMatriz;
    }

    @XmlTransient
    public List<TipoTransaccion> getTipoTransaccionList() {
        return tipoTransaccionList;
    }

    public void setTipoTransaccionList(List<TipoTransaccion> tipoTransaccionList) {
        this.tipoTransaccionList = tipoTransaccionList;
    }

    @XmlTransient
    public List<TipoRespuesta> getTipoRespuestaList() {
        return tipoRespuestaList;
    }

    public void setTipoRespuestaList(List<TipoRespuesta> tipoRespuestaList) {
        this.tipoRespuestaList = tipoRespuestaList;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<TiposPlanilla> getTiposPlanillaList() {
        return tiposPlanillaList;
    }

    public void setTiposPlanillaList(List<TiposPlanilla> tiposPlanillaList) {
        this.tiposPlanillaList = tiposPlanillaList;
    }

    @XmlTransient
    public List<Gerencia> getGerenciaList() {
        return gerenciaList;
    }

    public void setGerenciaList(List<Gerencia> gerenciaList) {
        this.gerenciaList = gerenciaList;
    }

    @XmlTransient
    public List<EstadoConcurso> getEstadoConcursoList() {
        return estadoConcursoList;
    }

    public void setEstadoConcursoList(List<EstadoConcurso> estadoConcursoList) {
        this.estadoConcursoList = estadoConcursoList;
    }

    @XmlTransient
    public List<Dmgcuentas> getDmgcuentasList() {
        return dmgcuentasList;
    }

    public void setDmgcuentasList(List<Dmgcuentas> dmgcuentasList) {
        this.dmgcuentasList = dmgcuentasList;
    }

    @XmlTransient
    public List<TipoCriterio> getTipoCriterioList() {
        return tipoCriterioList;
    }

    public void setTipoCriterioList(List<TipoCriterio> tipoCriterioList) {
        this.tipoCriterioList = tipoCriterioList;
    }

    @XmlTransient
    public List<Bancos> getBancosList() {
        return bancosList;
    }

    public void setBancosList(List<Bancos> bancosList) {
        this.bancosList = bancosList;
    }

    @XmlTransient
    public List<EstadoContrato> getEstadoContratoList() {
        return estadoContratoList;
    }

    public void setEstadoContratoList(List<EstadoContrato> estadoContratoList) {
        this.estadoContratoList = estadoContratoList;
    }

    @XmlTransient
    public List<NivelAcademico> getNivelAcademicoList() {
        return nivelAcademicoList;
    }

    public void setNivelAcademicoList(List<NivelAcademico> nivelAcademicoList) {
        this.nivelAcademicoList = nivelAcademicoList;
    }

    @XmlTransient
    public List<DeducPresta> getDeducPrestaList() {
        return deducPrestaList;
    }

    public void setDeducPrestaList(List<DeducPresta> deducPrestaList) {
        this.deducPrestaList = deducPrestaList;
    }

    @XmlTransient
    public List<TipoCuenta> getTipoCuentaList() {
        return tipoCuentaList;
    }

    public void setTipoCuentaList(List<TipoCuenta> tipoCuentaList) {
        this.tipoCuentaList = tipoCuentaList;
    }

    @XmlTransient
    public List<Campania> getCampaniaList() {
        return campaniaList;
    }

    public void setCampaniaList(List<Campania> campaniaList) {
        this.campaniaList = campaniaList;
    }

    @XmlTransient
    public List<CausasRenuncia> getCausasRenunciaList() {
        return causasRenunciaList;
    }

    public void setCausasRenunciaList(List<CausasRenuncia> causasRenunciaList) {
        this.causasRenunciaList = causasRenunciaList;
    }

    @XmlTransient
    public List<Indicador> getIndicadorList() {
        return indicadorList;
    }

    public void setIndicadorList(List<Indicador> indicadorList) {
        this.indicadorList = indicadorList;
    }

    @XmlTransient
    public List<TipoPuesto> getTipoPuestoList() {
        return tipoPuestoList;
    }

    public void setTipoPuestoList(List<TipoPuesto> tipoPuestoList) {
        this.tipoPuestoList = tipoPuestoList;
    }

    @XmlTransient
    public List<TipoEvaluacion> getTipoEvaluacionList() {
        return tipoEvaluacionList;
    }

    public void setTipoEvaluacionList(List<TipoEvaluacion> tipoEvaluacionList) {
        this.tipoEvaluacionList = tipoEvaluacionList;
    }

    @XmlTransient
    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }

    public void setCandidatoList(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }

    @XmlTransient
    public List<Instituciones> getInstitucionesList() {
        return institucionesList;
    }

    public void setInstitucionesList(List<Instituciones> institucionesList) {
        this.institucionesList = institucionesList;
    }

    @XmlTransient
    public List<Factor> getFactorList() {
        return factorList;
    }

    public void setFactorList(List<Factor> factorList) {
        this.factorList = factorList;
    }

    @XmlTransient
    public List<TipoAccion> getTipoAccionList() {
        return tipoAccionList;
    }

    public void setTipoAccionList(List<TipoAccion> tipoAccionList) {
        this.tipoAccionList = tipoAccionList;
    }

    public ParamPlan getParamPlan() {
        return paramPlan;
    }

    public void setParamPlan(ParamPlan paramPlan) {
        this.paramPlan = paramPlan;
    }

    @XmlTransient
    public List<TipoContrato> getTipoContratoList() {
        return tipoContratoList;
    }

    public void setTipoContratoList(List<TipoContrato> tipoContratoList) {
        this.tipoContratoList = tipoContratoList;
    }

    @XmlTransient
    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
    }

    @XmlTransient
    public List<RhOutsorcing> getRhOutsorcingList() {
        return rhOutsorcingList;
    }

    public void setRhOutsorcingList(List<RhOutsorcing> rhOutsorcingList) {
        this.rhOutsorcingList = rhOutsorcingList;
    }

    @XmlTransient
    public List<FrecuenciaFuncion> getFrecuenciaFuncionList() {
        return frecuenciaFuncionList;
    }

    public void setFrecuenciaFuncionList(List<FrecuenciaFuncion> frecuenciaFuncionList) {
        this.frecuenciaFuncionList = frecuenciaFuncionList;
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
        if (!(object instanceof Cias)) {
            return false;
        }
        Cias other = (Cias) object;
        if ((this.codCia == null && other.codCia != null) || (this.codCia != null && !this.codCia.equals(other.codCia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Cias[ codCia=" + codCia + " ]";
    }

}