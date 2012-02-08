/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "FUNCIONARIOS_SSF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionariosSsf.findAll", query = "SELECT f FROM FuncionariosSsf f"),
    @NamedQuery(name = "FuncionariosSsf.findByCodInst", query = "SELECT f FROM FuncionariosSsf f WHERE f.codInst = :codInst"),
    @NamedQuery(name = "FuncionariosSsf.findByNit", query = "SELECT f FROM FuncionariosSsf f WHERE f.nit = :nit"),
    @NamedQuery(name = "FuncionariosSsf.findByPriNomb", query = "SELECT f FROM FuncionariosSsf f WHERE f.priNomb = :priNomb"),
    @NamedQuery(name = "FuncionariosSsf.findBySegNomb", query = "SELECT f FROM FuncionariosSsf f WHERE f.segNomb = :segNomb"),
    @NamedQuery(name = "FuncionariosSsf.findByPriApel", query = "SELECT f FROM FuncionariosSsf f WHERE f.priApel = :priApel"),
    @NamedQuery(name = "FuncionariosSsf.findBySegApel", query = "SELECT f FROM FuncionariosSsf f WHERE f.segApel = :segApel"),
    @NamedQuery(name = "FuncionariosSsf.findByApeCasada", query = "SELECT f FROM FuncionariosSsf f WHERE f.apeCasada = :apeCasada"),
    @NamedQuery(name = "FuncionariosSsf.findByFecIngre", query = "SELECT f FROM FuncionariosSsf f WHERE f.fecIngre = :fecIngre"),
    @NamedQuery(name = "FuncionariosSsf.findByCargo", query = "SELECT f FROM FuncionariosSsf f WHERE f.cargo = :cargo"),
    @NamedQuery(name = "FuncionariosSsf.findByNiu", query = "SELECT f FROM FuncionariosSsf f WHERE f.funcionariosSsfPK.niu = :niu"),
    @NamedQuery(name = "FuncionariosSsf.findByCodDocId", query = "SELECT f FROM FuncionariosSsf f WHERE f.codDocId = :codDocId"),
    @NamedQuery(name = "FuncionariosSsf.findByNumDoc", query = "SELECT f FROM FuncionariosSsf f WHERE f.numDoc = :numDoc"),
    @NamedQuery(name = "FuncionariosSsf.findByTelef", query = "SELECT f FROM FuncionariosSsf f WHERE f.telef = :telef"),
    @NamedQuery(name = "FuncionariosSsf.findByDepto", query = "SELECT f FROM FuncionariosSsf f WHERE f.depto = :depto"),
    @NamedQuery(name = "FuncionariosSsf.findByCodCia", query = "SELECT f FROM FuncionariosSsf f WHERE f.funcionariosSsfPK.codCia = :codCia"),
    @NamedQuery(name = "FuncionariosSsf.findByAnio", query = "SELECT f FROM FuncionariosSsf f WHERE f.funcionariosSsfPK.anio = :anio"),
    @NamedQuery(name = "FuncionariosSsf.findByMes", query = "SELECT f FROM FuncionariosSsf f WHERE f.funcionariosSsfPK.mes = :mes")})
public class FuncionariosSsf implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FuncionariosSsfPK funcionariosSsfPK;
    @Column(name = "COD_INST", length = 4)
    private String codInst;
    @Column(name = "NIT", length = 25)
    private String nit;
    @Column(name = "PRI_NOMB", length = 20)
    private String priNomb;
    @Column(name = "SEG_NOMB", length = 20)
    private String segNomb;
    @Column(name = "PRI_APEL", length = 20)
    private String priApel;
    @Column(name = "SEG_APEL", length = 20)
    private String segApel;
    @Column(name = "APE_CASADA", length = 20)
    private String apeCasada;
    @Column(name = "FEC_INGRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngre;
    @Column(name = "CARGO", length = 50)
    private String cargo;
    @Column(name = "COD_DOC_ID", length = 3)
    private String codDocId;
    @Column(name = "NUM_DOC", length = 25)
    private String numDoc;
    @Column(name = "TELEF", length = 10)
    private String telef;
    @Column(name = "DEPTO", length = 25)
    private String depto;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "NIU", referencedColumnName = "COD_EMP", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public FuncionariosSsf() {
    }

    public FuncionariosSsf(FuncionariosSsfPK funcionariosSsfPK) {
        this.funcionariosSsfPK = funcionariosSsfPK;
    }

    public FuncionariosSsf(BigInteger niu, short codCia, short anio, short mes) {
        this.funcionariosSsfPK = new FuncionariosSsfPK(niu, codCia, anio, mes);
    }

    public FuncionariosSsfPK getFuncionariosSsfPK() {
        return funcionariosSsfPK;
    }

    public void setFuncionariosSsfPK(FuncionariosSsfPK funcionariosSsfPK) {
        this.funcionariosSsfPK = funcionariosSsfPK;
    }

    public String getCodInst() {
        return codInst;
    }

    public void setCodInst(String codInst) {
        this.codInst = codInst;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getPriNomb() {
        return priNomb;
    }

    public void setPriNomb(String priNomb) {
        this.priNomb = priNomb;
    }

    public String getSegNomb() {
        return segNomb;
    }

    public void setSegNomb(String segNomb) {
        this.segNomb = segNomb;
    }

    public String getPriApel() {
        return priApel;
    }

    public void setPriApel(String priApel) {
        this.priApel = priApel;
    }

    public String getSegApel() {
        return segApel;
    }

    public void setSegApel(String segApel) {
        this.segApel = segApel;
    }

    public String getApeCasada() {
        return apeCasada;
    }

    public void setApeCasada(String apeCasada) {
        this.apeCasada = apeCasada;
    }

    public Date getFecIngre() {
        return fecIngre;
    }

    public void setFecIngre(Date fecIngre) {
        this.fecIngre = fecIngre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCodDocId() {
        return codDocId;
    }

    public void setCodDocId(String codDocId) {
        this.codDocId = codDocId;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionariosSsfPK != null ? funcionariosSsfPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionariosSsf)) {
            return false;
        }
        FuncionariosSsf other = (FuncionariosSsf) object;
        if ((this.funcionariosSsfPK == null && other.funcionariosSsfPK != null) || (this.funcionariosSsfPK != null && !this.funcionariosSsfPK.equals(other.funcionariosSsfPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.FuncionariosSsf[ funcionariosSsfPK=" + funcionariosSsfPK + " ]";
    }
    
}
