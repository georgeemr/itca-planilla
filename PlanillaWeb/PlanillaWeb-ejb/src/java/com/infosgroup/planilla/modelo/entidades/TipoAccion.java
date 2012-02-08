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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TIPO_ACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAccion.findAll", query = "SELECT t FROM TipoAccion t"),
    @NamedQuery(name = "TipoAccion.findByCodCia", query = "SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codCia = :codCia"),
    @NamedQuery(name = "TipoAccion.findByCodTipoaccion", query = "SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codTipoaccion = :codTipoaccion"),
    @NamedQuery(name = "TipoAccion.findByNomTipoaccion", query = "SELECT t FROM TipoAccion t WHERE t.nomTipoaccion = :nomTipoaccion"),
    @NamedQuery(name = "TipoAccion.findByAfectaSal", query = "SELECT t FROM TipoAccion t WHERE t.afectaSal = :afectaSal"),
    @NamedQuery(name = "TipoAccion.findByEstado", query = "SELECT t FROM TipoAccion t WHERE t.estado = :estado")})
public class TipoAccion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoAccionPK tipoAccionPK;
    @Column(name = "NOM_TIPOACCION", length = 100)
    private String nomTipoaccion;
    @Column(name = "AFECTA_SAL", length = 1)
    private String afectaSal;
    @Column(name = "ESTADO", length = 1)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAccion")
    private List<AccionPersonal> accionPersonalList;
    @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cias cias;
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
    
    public TipoAccion() {
    }

    public TipoAccion(TipoAccionPK tipoAccionPK) {
        this.tipoAccionPK = tipoAccionPK;
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

    @XmlTransient
    public List<AccionPersonal> getAccionPersonalList() {
        return accionPersonalList;
    }

    public void setAccionPersonalList(List<AccionPersonal> accionPersonalList) {
        this.accionPersonalList = accionPersonalList;
    }

    public Cias getCias() {
        return cias;
    }

    public void setCias(Cias cias) {
        this.cias = cias;
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
    
}
