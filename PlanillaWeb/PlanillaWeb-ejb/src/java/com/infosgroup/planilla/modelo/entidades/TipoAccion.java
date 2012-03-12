/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_ACCION", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAccion.findAll", query = "SELECT t FROM TipoAccion t"),
    @NamedQuery(name = "TipoAccion.findByCodCia", query = "SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codCia = :codCia"),
    @NamedQuery(name = "TipoAccion.findByCodTipoaccion", query = "SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codTipoaccion = :codTipoaccion"),
    @NamedQuery(name = "TipoAccion.findByNomTipoaccion", query = "SELECT t FROM TipoAccion t WHERE t.nomTipoaccion = :nomTipoaccion"),
    @NamedQuery(name = "TipoAccion.findByAfectaSal", query = "SELECT t FROM TipoAccion t WHERE t.afectaSal = :afectaSal"),
    @NamedQuery(name = "TipoAccion.findByEstado", query = "SELECT t FROM TipoAccion t WHERE t.estado = :estado"),
    @NamedQuery(name = "TipoAccion.findByCodRol", query = "SELECT t FROM TipoAccion t WHERE t.codRol = :codRol"),
    @NamedQuery(name = "TipoAccion.findByUrlPlantilla", query = "SELECT t FROM TipoAccion t WHERE t.urlPlantilla = :urlPlantilla"),
    @NamedQuery(name = "TipoAccion.findByFirmaJefe", query = "SELECT t FROM TipoAccion t WHERE t.firmaJefe = :firmaJefe"),
    @NamedQuery(name = "TipoAccion.findByFirmaRh", query = "SELECT t FROM TipoAccion t WHERE t.firmaRh = :firmaRh")})
public class TipoAccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoAccionPK tipoAccionPK;
    @Size(max = 100)
    @Column(name = "NOM_TIPOACCION", length = 100)
    private String nomTipoaccion;
    @Size(max = 1)
    @Column(name = "AFECTA_SAL", length = 1)
    private String afectaSal;
    @Size(max = 1)
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @Column(name = "COD_ROL")
    private Long codRol;
    @Size(max = 200)
    @Column(name = "URL_PLANTILLA", length = 200)
    private String urlPlantilla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "FIRMA_JEFE", nullable = false, length = 1)
    private String firmaJefe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "FIRMA_RH", nullable = false, length = 1)
    private String firmaRh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAccion")
    private List<AccionPersonal> accionPersonalList;
    @ManyToMany(mappedBy = "tipoAccionList")
    private List<Rol> rolList;

    public TipoAccion() {
    }

    public TipoAccion(TipoAccionPK tipoAccionPK) {
        this.tipoAccionPK = tipoAccionPK;
    }

    public TipoAccion(TipoAccionPK tipoAccionPK, String firmaJefe, String firmaRh) {
        this.tipoAccionPK = tipoAccionPK;
        this.firmaJefe = firmaJefe;
        this.firmaRh = firmaRh;
    }

    public TipoAccion(short codCia, short codTipoaccion) {
        this.tipoAccionPK = new TipoAccionPK(codCia, codTipoaccion);
    }

    public TipoAccionPK getTipoAccionPK() {
        return tipoAccionPK;
    }

    public void setTipoAccionPK(TipoAccionPK tipoAccionPK) {
        this.tipoAccionPK = tipoAccionPK;
    }

    public String getNomTipoaccion() {
        return nomTipoaccion;
    }

    public void setNomTipoaccion(String nomTipoaccion) {
        this.nomTipoaccion = nomTipoaccion;
    }

    public String getAfectaSal() {
        return afectaSal;
    }

    public void setAfectaSal(String afectaSal) {
        this.afectaSal = afectaSal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCodRol() {
        return codRol;
    }

    public void setCodRol(Long codRol) {
        this.codRol = codRol;
    }

    public String getUrlPlantilla() {
        return urlPlantilla;
    }

    public void setUrlPlantilla(String urlPlantilla) {
        this.urlPlantilla = urlPlantilla;
    }

    public String getFirmaJefe() {
        return firmaJefe;
    }

    public void setFirmaJefe(String firmaJefe) {
        this.firmaJefe = firmaJefe;
    }

    public String getFirmaRh() {
        return firmaRh;
    }

    public void setFirmaRh(String firmaRh) {
        this.firmaRh = firmaRh;
    }

    @XmlTransient
    public List<AccionPersonal> getAccionPersonalList() {
        return accionPersonalList;
    }

    public void setAccionPersonalList(List<AccionPersonal> accionPersonalList) {
        this.accionPersonalList = accionPersonalList;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoAccionPK != null ? tipoAccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAccion)) {
            return false;
        }
        TipoAccion other = (TipoAccion) object;
        if ((this.tipoAccionPK == null && other.tipoAccionPK != null) || (this.tipoAccionPK != null && !this.tipoAccionPK.equals(other.tipoAccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoAccion[ tipoAccionPK=" + tipoAccionPK + " ]";
    }
}
