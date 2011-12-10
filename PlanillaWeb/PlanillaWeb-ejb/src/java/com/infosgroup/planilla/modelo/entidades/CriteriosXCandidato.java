<<<<<<< .mine
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
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CRITERIOS_X_CANDIDATO")
@NamedQueries(
    {
    @NamedQuery(name = "CriteriosXCandidato.findAll", query = "SELECT c FROM CriteriosXCandidato c"),
    @NamedQuery(name = "CriteriosXCandidato.findByCodCia", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "CriteriosXCandidato.findByCandidato", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.candidato = :candidato"),
    @NamedQuery(name = "CriteriosXCandidato.findByCriterio", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.criterio = :criterio"),
    @NamedQuery(name = "CriteriosXCandidato.findByTipoCriterio", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.tipoCriterio = :tipoCriterio"),
    @NamedQuery(name = "CriteriosXCandidato.findByCorrelativo", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.correlativo = :correlativo"),
    @NamedQuery(name = "CriteriosXCandidato.findByValor", query = "SELECT c FROM CriteriosXCandidato c WHERE c.valor = :valor"),
    @NamedQuery(name = "CriteriosXCandidato.findByValorInicialRango", query = "SELECT c FROM CriteriosXCandidato c WHERE c.valorInicialRango = :valorInicialRango"),
    @NamedQuery(name = "CriteriosXCandidato.findByValorFinalRango", query = "SELECT c FROM CriteriosXCandidato c WHERE c.valorFinalRango = :valorFinalRango"),
    @NamedQuery(name = "CriteriosXCandidato.findByCampo", query = "SELECT c FROM CriteriosXCandidato c WHERE c.campo = :campo"),
    @NamedQuery(name = "CriteriosXCandidato.findByEntidad", query = "SELECT c FROM CriteriosXCandidato c WHERE c.entidad = :entidad")
    })
public class CriteriosXCandidato implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected CriteriosXCandidatoPK criteriosXCandidatoPK;

    @Size(max = 200)
    @Column(name = "VALOR", length = 200)
    private String valor;

    @Size(max = 200)
    @Column(name = "VALOR_INICIAL_RANGO", length = 200)
    private String valorInicialRango;

    @Size(max = 200)
    @Column(name = "VALOR_FINAL_RANGO", length = 200)
    private String valorFinalRango;

    @Size(max = 200)
    @Column(name = "CAMPO", length = 200)
    private String campo;

    @Size(max = 200)
    @Column(name = "ENTIDAD", length = 200)
    private String entidad;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_CRITERIO", referencedColumnName = "TIPO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CRITERIO", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Criterio criterio1;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CANDIDATO", referencedColumnName = "COD_CANDIDATO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Candidato candidato1;

    public CriteriosXCandidato()
    {
    }

    public CriteriosXCandidato(CriteriosXCandidatoPK criteriosXCandidatoPK)
    {
        this.criteriosXCandidatoPK = criteriosXCandidatoPK;
    }

    public CriteriosXCandidato(long codCia, long candidato, long criterio, long tipoCriterio, long correlativo)
    {
        this.criteriosXCandidatoPK = new CriteriosXCandidatoPK(codCia, candidato, criterio, tipoCriterio, correlativo);
    }

    public CriteriosXCandidatoPK getCriteriosXCandidatoPK()
    {
        return criteriosXCandidatoPK;
    }

    public void setCriteriosXCandidatoPK(CriteriosXCandidatoPK criteriosXCandidatoPK)
    {
        this.criteriosXCandidatoPK = criteriosXCandidatoPK;
    }

    public String getValor()
    {
        return valor;
    }

    public void setValor(String valor)
    {
        this.valor = valor;
    }

    public String getValorInicialRango()
    {
        return valorInicialRango;
    }

    public void setValorInicialRango(String valorInicialRango)
    {
        this.valorInicialRango = valorInicialRango;
    }

    public String getValorFinalRango()
    {
        return valorFinalRango;
    }

    public void setValorFinalRango(String valorFinalRango)
    {
        this.valorFinalRango = valorFinalRango;
    }

    public String getCampo()
    {
        return campo;
    }

    public void setCampo(String campo)
    {
        this.campo = campo;
    }

    public String getEntidad()
    {
        return entidad;
    }

    public void setEntidad(String entidad)
    {
        this.entidad = entidad;
    }

    public Criterio getCriterio1()
    {
        return criterio1;
    }

    public void setCriterio1(Criterio criterio1)
    {
        this.criterio1 = criterio1;
    }

    public Candidato getCandidato1()
    {
        return candidato1;
    }

    public void setCandidato1(Candidato candidato1)
    {
        this.candidato1 = candidato1;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (criteriosXCandidatoPK != null ? criteriosXCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosXCandidato))
            {
            return false;
            }
        CriteriosXCandidato other = (CriteriosXCandidato) object;
        if ((this.criteriosXCandidatoPK == null && other.criteriosXCandidatoPK != null) || (this.criteriosXCandidatoPK != null && !this.criteriosXCandidatoPK.equals(other.criteriosXCandidatoPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.CriteriosXCandidato[ criteriosXCandidatoPK=" + criteriosXCandidatoPK + " ]";
    }
    
}
=======
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

/**
 *
 * @author root
 */
@Entity
@Table(name = "criterios_x_candidato")
@NamedQueries({
    @NamedQuery(name = "CriteriosXCandidato.findAll", query = "SELECT c FROM CriteriosXCandidato c"),
    @NamedQuery(name = "CriteriosXCandidato.findByCodCia", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.codCia = :codCia"),
    @NamedQuery(name = "CriteriosXCandidato.findByCandidato", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.candidato = :candidato"),
    @NamedQuery(name = "CriteriosXCandidato.findByCriterio", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.criterio = :criterio"),
    @NamedQuery(name = "CriteriosXCandidato.findByCorrelativo", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.correlativo = :correlativo"),
    @NamedQuery(name = "CriteriosXCandidato.findByValor", query = "SELECT c FROM CriteriosXCandidato c WHERE c.valor = :valor"),
    @NamedQuery(name = "CriteriosXCandidato.findByTipoCriterio", query = "SELECT c FROM CriteriosXCandidato c WHERE c.criteriosXCandidatoPK.tipoCriterio = :tipoCriterio")})
public class CriteriosXCandidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriteriosXCandidatoPK criteriosXCandidatoPK;
    @Column(name = "valor", length = 2147483647)
    private String valor;
    @Column(name = "entidad", length = 2147483647)
    private String entidad;
    @Column(name = "campo", length = 2147483647)
    private String campo;
    @Column(name = "entidadPK", length = 2147483647)
    private String entidadPK;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "criterio", referencedColumnName = "codigo", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "tipo_criterio", referencedColumnName = "tipo", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Criterio criterio1;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "candidato", referencedColumnName = "cod_candidato", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Candidato candidato1;

    public CriteriosXCandidato() {
    }

    public CriteriosXCandidato(CriteriosXCandidatoPK criteriosXCandidatoPK) {
        this.criteriosXCandidatoPK = criteriosXCandidatoPK;
    }

    public CriteriosXCandidato(int codCia, int candidato, int criterio, int correlativo, int tipoCriterio) {
        this.criteriosXCandidatoPK = new CriteriosXCandidatoPK(codCia, candidato, criterio, correlativo, tipoCriterio);
    }

    public CriteriosXCandidatoPK getCriteriosXCandidatoPK() {
        return criteriosXCandidatoPK;
    }

    public void setCriteriosXCandidatoPK(CriteriosXCandidatoPK criteriosXCandidatoPK) {
        this.criteriosXCandidatoPK = criteriosXCandidatoPK;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public Criterio getCriterio1() {
        return criterio1;
    }

    public void setCriterio1(Criterio criterio1) {
        this.criterio1 = criterio1;
    }

    public Candidato getCandidato1() {
        return candidato1;
    }

    public void setCandidato1(Candidato candidato1) {
        this.candidato1 = candidato1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criteriosXCandidatoPK != null ? criteriosXCandidatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosXCandidato)) {
            return false;
        }
        CriteriosXCandidato other = (CriteriosXCandidato) object;
        if ((this.criteriosXCandidatoPK == null && other.criteriosXCandidatoPK != null) || (this.criteriosXCandidatoPK != null && !this.criteriosXCandidatoPK.equals(other.criteriosXCandidatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testjqpl.modelo.entidades.CriteriosXCandidato[ criteriosXCandidatoPK=" + criteriosXCandidatoPK + " ]";
    }

    public String getEntidadPK() {
        return entidadPK;
    }

    public void setEntidadPK(String entidadPK) {
        this.entidadPK = entidadPK;
    }
    
}>>>>>>> .r287
