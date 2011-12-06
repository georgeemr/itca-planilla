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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "compania")
@NamedQueries({
    @NamedQuery(name = "Compania.findAll", query = "SELECT c FROM Compania c"),
    @NamedQuery(name = "Compania.findByIdCompania", query = "SELECT c FROM Compania c WHERE c.idCompania = :idCompania"),
    @NamedQuery(name = "Compania.findByNomCompania", query = "SELECT c FROM Compania c WHERE c.nomCompania = :nomCompania"),
    @NamedQuery(name = "Compania.findByDetCompania", query = "SELECT c FROM Compania c WHERE c.detCompania = :detCompania"),
    @NamedQuery(name = "Compania.findByRazonSocial", query = "SELECT c FROM Compania c WHERE c.razonSocial = :razonSocial")})
public class Compania implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compania", nullable = false)
    private Integer idCompania;
    @Size(max = 100)
    @Column(name = "nom_compania", length = 100)
    private String nomCompania;
    @Size(max = 200)
    @Column(name = "det_compania", length = 200)
    private String detCompania;
    @Size(max = 200)
    @Column(name = "razon_social", length = 200)
    private String razonSocial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<TipoRespuesta> tipoRespuestaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<Candidato> candidatoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<Planilla> planillaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<Campania> campaniaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<Indicador> indicadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<Rol> rolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<TipoEvaluacion> tipoEvaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<Sucursal> sucursalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<Departamento> departamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<TipoCriterio> tipoCriterioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<Empleado> empleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<TipoTransaccion> tipoTransaccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<Factor> factorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<TipoPuesto> tipoPuestoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<EstadoConcurso> estadoConcursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<TipoCuenta> tipoCuentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<Modulo> moduloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<TipoPlanilla> tipoPlanillaList;

    public Compania() {
    }

    public Compania(Integer idCompania) {
        this.idCompania = idCompania;
    }

    public Integer getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(Integer idCompania) {
        this.idCompania = idCompania;
    }

    public String getNomCompania() {
        return nomCompania;
    }

    public void setNomCompania(String nomCompania) {
        this.nomCompania = nomCompania;
    }

    public String getDetCompania() {
        return detCompania;
    }

    public void setDetCompania(String detCompania) {
        this.detCompania = detCompania;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<TipoRespuesta> getTipoRespuestaList() {
        return tipoRespuestaList;
    }

    public void setTipoRespuestaList(List<TipoRespuesta> tipoRespuestaList) {
        this.tipoRespuestaList = tipoRespuestaList;
    }

    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }

    public void setCandidatoList(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }

    public List<Planilla> getPlanillaList() {
        return planillaList;
    }

    public void setPlanillaList(List<Planilla> planillaList) {
        this.planillaList = planillaList;
    }

    public List<Campania> getCampaniaList() {
        return campaniaList;
    }

    public void setCampaniaList(List<Campania> campaniaList) {
        this.campaniaList = campaniaList;
    }

    public List<Indicador> getIndicadorList() {
        return indicadorList;
    }

    public void setIndicadorList(List<Indicador> indicadorList) {
        this.indicadorList = indicadorList;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public List<TipoEvaluacion> getTipoEvaluacionList() {
        return tipoEvaluacionList;
    }

    public void setTipoEvaluacionList(List<TipoEvaluacion> tipoEvaluacionList) {
        this.tipoEvaluacionList = tipoEvaluacionList;
    }

    public List<Sucursal> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public List<TipoCriterio> getTipoCriterioList() {
        return tipoCriterioList;
    }

    public void setTipoCriterioList(List<TipoCriterio> tipoCriterioList) {
        this.tipoCriterioList = tipoCriterioList;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public List<TipoTransaccion> getTipoTransaccionList() {
        return tipoTransaccionList;
    }

    public void setTipoTransaccionList(List<TipoTransaccion> tipoTransaccionList) {
        this.tipoTransaccionList = tipoTransaccionList;
    }

    public List<Factor> getFactorList() {
        return factorList;
    }

    public void setFactorList(List<Factor> factorList) {
        this.factorList = factorList;
    }

    public List<TipoPuesto> getTipoPuestoList() {
        return tipoPuestoList;
    }

    public void setTipoPuestoList(List<TipoPuesto> tipoPuestoList) {
        this.tipoPuestoList = tipoPuestoList;
    }

    public List<EstadoConcurso> getEstadoConcursoList() {
        return estadoConcursoList;
    }

    public void setEstadoConcursoList(List<EstadoConcurso> estadoConcursoList) {
        this.estadoConcursoList = estadoConcursoList;
    }

    public List<TipoCuenta> getTipoCuentaList() {
        return tipoCuentaList;
    }

    public void setTipoCuentaList(List<TipoCuenta> tipoCuentaList) {
        this.tipoCuentaList = tipoCuentaList;
    }

    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
    }

    public List<TipoPlanilla> getTipoPlanillaList() {
        return tipoPlanillaList;
    }

    public void setTipoPlanillaList(List<TipoPlanilla> tipoPlanillaList) {
        this.tipoPlanillaList = tipoPlanillaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompania != null ? idCompania.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compania)) {
            return false;
        }
        Compania other = (Compania) object;
        if ((this.idCompania == null && other.idCompania != null) || (this.idCompania != null && !this.idCompania.equals(other.idCompania))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Compania[ idCompania=" + idCompania + " ]";
    }
    
}
