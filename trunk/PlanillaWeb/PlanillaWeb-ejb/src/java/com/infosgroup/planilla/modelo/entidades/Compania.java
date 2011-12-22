/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "COMPANIA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Compania.findAll", query = "SELECT c FROM Compania c"),
    @NamedQuery(name = "Compania.findByIdCompania", query = "SELECT c FROM Compania c WHERE c.idCompania = :idCompania"),
    @NamedQuery(name = "Compania.findByNomCompania", query = "SELECT c FROM Compania c WHERE c.nomCompania = :nomCompania"),
    @NamedQuery(name = "Compania.findByDetCompania", query = "SELECT c FROM Compania c WHERE c.detCompania = :detCompania"),
    @NamedQuery(name = "Compania.findByRazonSocial", query = "SELECT c FROM Compania c WHERE c.razonSocial = :razonSocial")
    })
public class Compania implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPANIA", nullable = false)
    private Long idCompania;

    @Size(max = 200)
    @Column(name = "NOM_COMPANIA", length = 200)
    private String nomCompania;

    @Size(max = 200)
    @Column(name = "DET_COMPANIA", length = 200)
    private String detCompania;

    @Size(max = 200)
    @Column(name = "RAZON_SOCIAL", length = 200)
    private String razonSocial;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<Sucursal> sucursalList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<Indicador> indicadorList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<TipoPuesto> tipoPuestoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<TipoEvaluacion> tipoEvaluacionList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<Candidato> candidatoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<TipoTransaccion> tipoTransaccionList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<TipoRespuesta> tipoRespuestaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<Rol> rolList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<Departamento> departamentoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<Factor> factorList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<TipoContrato> tipoContratoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<Gerencia> gerenciaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<Modulo> moduloList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<Empleado> empleadoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<TipoPlanilla> tipoPlanillaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<EstadoConcurso> estadoConcursoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<Planilla> planillaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<TipoCriterio> tipoCriterioList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<FestivosProvincia> festivosProvinciaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<EstadoContrato> estadoContratoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<TipoCuenta> tipoCuentaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania", fetch = FetchType.EAGER)
    private List<Campania> campaniaList;

    public Compania()
    {
    }

    public Compania(Long idCompania)
    {
        this.idCompania = idCompania;
    }

    public Long getIdCompania()
    {
        return idCompania;
    }

    public void setIdCompania(Long idCompania)
    {
        this.idCompania = idCompania;
    }

    public String getNomCompania()
    {
        return nomCompania;
    }

    public void setNomCompania(String nomCompania)
    {
        this.nomCompania = nomCompania;
    }

    public String getDetCompania()
    {
        return detCompania;
    }

    public void setDetCompania(String detCompania)
    {
        this.detCompania = detCompania;
    }

    public String getRazonSocial()
    {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial)
    {
        this.razonSocial = razonSocial;
    }

    @XmlTransient
    public List<Sucursal> getSucursalList()
    {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList)
    {
        this.sucursalList = sucursalList;
    }

    @XmlTransient
    public List<Indicador> getIndicadorList()
    {
        return indicadorList;
    }

    public void setIndicadorList(List<Indicador> indicadorList)
    {
        this.indicadorList = indicadorList;
    }

    @XmlTransient
    public List<TipoPuesto> getTipoPuestoList()
    {
        return tipoPuestoList;
    }

    public void setTipoPuestoList(List<TipoPuesto> tipoPuestoList)
    {
        this.tipoPuestoList = tipoPuestoList;
    }

    @XmlTransient
    public List<TipoEvaluacion> getTipoEvaluacionList()
    {
        return tipoEvaluacionList;
    }

    public void setTipoEvaluacionList(List<TipoEvaluacion> tipoEvaluacionList)
    {
        this.tipoEvaluacionList = tipoEvaluacionList;
    }

    @XmlTransient
    public List<Candidato> getCandidatoList()
    {
        return candidatoList;
    }

    public void setCandidatoList(List<Candidato> candidatoList)
    {
        this.candidatoList = candidatoList;
    }

    @XmlTransient
    public List<TipoTransaccion> getTipoTransaccionList()
    {
        return tipoTransaccionList;
    }

    public void setTipoTransaccionList(List<TipoTransaccion> tipoTransaccionList)
    {
        this.tipoTransaccionList = tipoTransaccionList;
    }

    @XmlTransient
    public List<TipoRespuesta> getTipoRespuestaList()
    {
        return tipoRespuestaList;
    }

    public void setTipoRespuestaList(List<TipoRespuesta> tipoRespuestaList)
    {
        this.tipoRespuestaList = tipoRespuestaList;
    }

    @XmlTransient
    public List<Rol> getRolList()
    {
        return rolList;
    }

    public void setRolList(List<Rol> rolList)
    {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Departamento> getDepartamentoList()
    {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList)
    {
        this.departamentoList = departamentoList;
    }

    @XmlTransient
    public List<Factor> getFactorList()
    {
        return factorList;
    }

    public void setFactorList(List<Factor> factorList)
    {
        this.factorList = factorList;
    }

    @XmlTransient
    public List<TipoContrato> getTipoContratoList()
    {
        return tipoContratoList;
    }

    public void setTipoContratoList(List<TipoContrato> tipoContratoList)
    {
        this.tipoContratoList = tipoContratoList;
    }

    @XmlTransient
    public List<Gerencia> getGerenciaList()
    {
        return gerenciaList;
    }

    public void setGerenciaList(List<Gerencia> gerenciaList)
    {
        this.gerenciaList = gerenciaList;
    }

    @XmlTransient
    public List<Modulo> getModuloList()
    {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList)
    {
        this.moduloList = moduloList;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList()
    {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList)
    {
        this.empleadoList = empleadoList;
    }

    @XmlTransient
    public List<TipoPlanilla> getTipoPlanillaList()
    {
        return tipoPlanillaList;
    }

    public void setTipoPlanillaList(List<TipoPlanilla> tipoPlanillaList)
    {
        this.tipoPlanillaList = tipoPlanillaList;
    }

    @XmlTransient
    public List<EstadoConcurso> getEstadoConcursoList()
    {
        return estadoConcursoList;
    }

    public void setEstadoConcursoList(List<EstadoConcurso> estadoConcursoList)
    {
        this.estadoConcursoList = estadoConcursoList;
    }

    @XmlTransient
    public List<Planilla> getPlanillaList()
    {
        return planillaList;
    }

    public void setPlanillaList(List<Planilla> planillaList)
    {
        this.planillaList = planillaList;
    }

    @XmlTransient
    public List<TipoCriterio> getTipoCriterioList()
    {
        return tipoCriterioList;
    }

    public void setTipoCriterioList(List<TipoCriterio> tipoCriterioList)
    {
        this.tipoCriterioList = tipoCriterioList;
    }

    @XmlTransient
    public List<FestivosProvincia> getFestivosProvinciaList()
    {
        return festivosProvinciaList;
    }

    public void setFestivosProvinciaList(List<FestivosProvincia> festivosProvinciaList)
    {
        this.festivosProvinciaList = festivosProvinciaList;
    }

    @XmlTransient
    public List<EstadoContrato> getEstadoContratoList()
    {
        return estadoContratoList;
    }

    public void setEstadoContratoList(List<EstadoContrato> estadoContratoList)
    {
        this.estadoContratoList = estadoContratoList;
    }

    @XmlTransient
    public List<TipoCuenta> getTipoCuentaList()
    {
        return tipoCuentaList;
    }

    public void setTipoCuentaList(List<TipoCuenta> tipoCuentaList)
    {
        this.tipoCuentaList = tipoCuentaList;
    }

    @XmlTransient
    public List<Campania> getCampaniaList()
    {
        return campaniaList;
    }

    public void setCampaniaList(List<Campania> campaniaList)
    {
        this.campaniaList = campaniaList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idCompania != null ? idCompania.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compania))
            {
            return false;
            }
        Compania other = (Compania) object;
        if ((this.idCompania == null && other.idCompania != null) || (this.idCompania != null && !this.idCompania.equals(other.idCompania))) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Compania[ idCompania=" + idCompania + " ]";
    }
       
}
