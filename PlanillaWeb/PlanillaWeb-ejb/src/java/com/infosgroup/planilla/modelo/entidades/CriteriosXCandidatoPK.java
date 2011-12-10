<<<<<<< .mine
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class CriteriosXCandidatoPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CANDIDATO", nullable = false)
    private long candidato;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CRITERIO", nullable = false)
    private long criterio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_CRITERIO", nullable = false)
    private long tipoCriterio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRELATIVO", nullable = false)
    private long correlativo;

    public CriteriosXCandidatoPK()
    {
    }

    public CriteriosXCandidatoPK(long codCia, long candidato, long criterio, long tipoCriterio, long correlativo)
    {
        this.codCia = codCia;
        this.candidato = candidato;
        this.criterio = criterio;
        this.tipoCriterio = tipoCriterio;
        this.correlativo = correlativo;
    }

    public long getCodCia()
    {
        return codCia;
    }

    public void setCodCia(long codCia)
    {
        this.codCia = codCia;
    }

    public long getCandidato()
    {
        return candidato;
    }

    public void setCandidato(long candidato)
    {
        this.candidato = candidato;
    }

    public long getCriterio()
    {
        return criterio;
    }

    public void setCriterio(long criterio)
    {
        this.criterio = criterio;
    }

    public long getTipoCriterio()
    {
        return tipoCriterio;
    }

    public void setTipoCriterio(long tipoCriterio)
    {
        this.tipoCriterio = tipoCriterio;
    }

    public long getCorrelativo()
    {
        return correlativo;
    }

    public void setCorrelativo(long correlativo)
    {
        this.correlativo = correlativo;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) candidato;
        hash += (int) criterio;
        hash += (int) tipoCriterio;
        hash += (int) correlativo;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosXCandidatoPK))
            {
            return false;
            }
        CriteriosXCandidatoPK other = (CriteriosXCandidatoPK) object;
        if (this.codCia != other.codCia)
            {
            return false;
            }
        if (this.candidato != other.candidato)
            {
            return false;
            }
        if (this.criterio != other.criterio)
            {
            return false;
            }
        if (this.tipoCriterio != other.tipoCriterio)
            {
            return false;
            }
        if (this.correlativo != other.correlativo)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.CriteriosXCandidatoPK[ codCia=" + codCia + ", candidato=" + candidato + ", criterio=" + criterio + ", tipoCriterio=" + tipoCriterio + ", correlativo=" + correlativo + " ]";
    }
    
}
=======
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class CriteriosXCandidatoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cod_cia", nullable = false)
    private int codCia;
    @Basic(optional = false)
    @Column(name = "candidato", nullable = false)
    private int candidato;
    @Basic(optional = false)
    @Column(name = "criterio", nullable = false)
    private int criterio;
    @Basic(optional = false)
    @Column(name = "correlativo", nullable = false)
    private int correlativo;
    @Basic(optional = false)
    @Column(name = "tipo_criterio", nullable = false)
    private int tipoCriterio;

    public CriteriosXCandidatoPK() {
    }

    public CriteriosXCandidatoPK(int codCia, int candidato, int criterio, int correlativo, int tipoCriterio) {
        this.codCia = codCia;
        this.candidato = candidato;
        this.criterio = criterio;
        this.correlativo = correlativo;
        this.tipoCriterio = tipoCriterio;
    }

    public int getCodCia() {
        return codCia;
    }

    public void setCodCia(int codCia) {
        this.codCia = codCia;
    }

    public int getCandidato() {
        return candidato;
    }

    public void setCandidato(int candidato) {
        this.candidato = candidato;
    }

    public int getCriterio() {
        return criterio;
    }

    public void setCriterio(int criterio) {
        this.criterio = criterio;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public int getTipoCriterio() {
        return tipoCriterio;
    }

    public void setTipoCriterio(int tipoCriterio) {
        this.tipoCriterio = tipoCriterio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) candidato;
        hash += (int) criterio;
        hash += (int) correlativo;
        hash += (int) tipoCriterio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosXCandidatoPK)) {
            return false;
        }
        CriteriosXCandidatoPK other = (CriteriosXCandidatoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.candidato != other.candidato) {
            return false;
        }
        if (this.criterio != other.criterio) {
            return false;
        }
        if (this.correlativo != other.correlativo) {
            return false;
        }
        if (this.tipoCriterio != other.tipoCriterio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testjqpl.modelo.entidades.CriteriosXCandidatoPK[ codCia=" + codCia + ", candidato=" + candidato + ", criterio=" + criterio + ", correlativo=" + correlativo + ", tipoCriterio=" + tipoCriterio + " ]";
    }
    
}
>>>>>>> .r287
