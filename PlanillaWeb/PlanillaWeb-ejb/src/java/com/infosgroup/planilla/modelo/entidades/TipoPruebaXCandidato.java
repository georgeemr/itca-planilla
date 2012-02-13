/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TIPO_PRUEBA_X_CANDIDATO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPruebaXCandidato.findAll", query = "SELECT t FROM TipoPruebaXCandidato t"),
    @NamedQuery(name = "TipoPruebaXCandidato.findByCodCia", query = "SELECT t FROM TipoPruebaXCandidato t WHERE t.tipoPruebaXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "TipoPruebaXCandidato.findByCodCandidato", query = "SELECT t FROM TipoPruebaXCandidato t WHERE t.tipoPruebaXCandidatoPK.codCandidato = :codCandidato"),
    @NamedQuery(name = "TipoPruebaXCandidato.findByCodTipoPrueba", query = "SELECT t FROM TipoPruebaXCandidato t WHERE t.tipoPruebaXCandidatoPK.codTipoPrueba = :codTipoPrueba"),
    @NamedQuery(name = "TipoPruebaXCandidato.findByResultado", query = "SELECT t FROM TipoPruebaXCandidato t WHERE t.resultado = :resultado"),
    @NamedQuery(name = "TipoPruebaXCandidato.findByNota", query = "SELECT t FROM TipoPruebaXCandidato t WHERE t.nota = :nota"),
    @NamedQuery(name = "TipoPruebaXCandidato.findByFecha", query = "SELECT t FROM TipoPruebaXCandidato t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TipoPruebaXCandidato.findByCosto", query = "SELECT t FROM TipoPruebaXCandidato t WHERE t.costo = :costo")})
public class TipoPruebaXCandidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoPruebaXCandidatoPK tipoPruebaXCandidatoPK;
    @Column(name = "RESULTADO", length = 200)
    private String resultado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTA", precision = 5, scale = 2)
    private BigDecimal nota;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "COSTO", precision = 12, scale = 2)
    private BigDecimal costo;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPO_PRUEBA", referencedColumnName = "COD_TIPO_PRUEBA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TipoPrueba tipoPrueba;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato;

    public TipoPruebaXCandidato() {
    }

    public TipoPruebaXCandidato(TipoPruebaXCandidatoPK tipoPruebaXCandidatoPK) {
        this.tipoPruebaXCandidatoPK = tipoPruebaXCandidatoPK;
    }

    public TipoPruebaXCandidato(short codCia, int codCandidato, short codTipoPrueba) {
        this.tipoPruebaXCandidatoPK = new TipoPruebaXCandidatoPK(codCia, codCandidato, codTipoPrueba);
    }

    public TipoPruebaXCandidatoPK getTipoPruebaXCandidatoPK() {
        return tipoPruebaXCandidatoPK;
    }

    public void setTipoPruebaXCandidatoPK(TipoPruebaXCandidatoPK tipoPruebaXCandidatoPK) {
        this.tipoPruebaXCandidatoPK = tipoPruebaXCandidatoPK;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public TipoPrueba getTipoPrueba() {
        return tipoPrueba;
    }

    public void setTipoPrueba(TipoPrueba tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPruebaXCandidatoPK != null ? tipoPruebaXCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPruebaXCandidato)) {
            return false;
        }
        TipoPruebaXCandidato other = (TipoPruebaXCandidato) object;
        if ((this.tipoPruebaXCandidatoPK == null && other.tipoPruebaXCandidatoPK != null) || (this.tipoPruebaXCandidatoPK != null && !this.tipoPruebaXCandidatoPK.equals(other.tipoPruebaXCandidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.TipoPruebaXCandidato[ tipoPruebaXCandidatoPK=" + tipoPruebaXCandidatoPK + " ]";
    }
    
}
