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
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Embeddable
public class ResultadoEvaluacionCandidatoPK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cia", nullable = false)
    private int codCia;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "concurso", nullable = false, length = 2147483647)
    private String concurso;

    @Basic(optional = false)
    @NotNull
    @Column(name = "candidato", nullable = false)
    private int candidato;

    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_evaluacion", nullable = false)
    private int tipoEvaluacion;

    public ResultadoEvaluacionCandidatoPK()
    {
    }

    public ResultadoEvaluacionCandidatoPK(int codCia, String concurso, int candidato, int tipoEvaluacion)
    {
        this.codCia = codCia;
        this.concurso = concurso;
        this.candidato = candidato;
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public int getCodCia()
    {
        return codCia;
    }

    public void setCodCia(int codCia)
    {
        this.codCia = codCia;
    }

    public String getConcurso()
    {
        return concurso;
    }

    public void setConcurso(String concurso)
    {
        this.concurso = concurso;
    }

    public int getCandidato()
    {
        return candidato;
    }

    public void setCandidato(int candidato)
    {
        this.candidato = candidato;
    }

    public int getTipoEvaluacion()
    {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(int tipoEvaluacion)
    {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) codCia;
        hash += (concurso != null ? concurso.hashCode() : 0);
        hash += (int) candidato;
        hash += (int) tipoEvaluacion;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoEvaluacionCandidatoPK))
            {
            return false;
            }
        ResultadoEvaluacionCandidatoPK other = (ResultadoEvaluacionCandidatoPK) object;
        if (this.codCia != other.codCia)
            {
            return false;
            }
        if ((this.concurso == null && other.concurso != null) || (this.concurso != null && !this.concurso.equals(other.concurso)))
            {
            return false;
            }
        if (this.candidato != other.candidato)
            {
            return false;
            }
        if (this.tipoEvaluacion != other.tipoEvaluacion)
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.ResultadoEvaluacionCandidatoPK[ codCia=" + codCia + ", concurso=" + concurso + ", candidato=" + candidato + ", tipoEvaluacion=" + tipoEvaluacion + " ]";
    }
    
}
