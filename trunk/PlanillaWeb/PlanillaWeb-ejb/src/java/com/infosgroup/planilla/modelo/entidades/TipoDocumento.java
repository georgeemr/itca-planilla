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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "TIPO_DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByCodTipoDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.codTipoDocumento = :codTipoDocumento"),
    @NamedQuery(name = "TipoDocumento.findByNomTipoDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.nomTipoDocumento = :nomTipoDocumento")})
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_TIPO_DOCUMENTO", nullable = false)
    private Long codTipoDocumento;
    @Column(name = "NOM_TIPO_DOCUMENTO", length = 100)
    private String nomTipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private List<DocumentoEmpleado> documentoEmpleadoList;

    public TipoDocumento() {
    }

    public TipoDocumento(Long codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public Long getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(Long codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public String getNomTipoDocumento() {
        return nomTipoDocumento;
    }

    public void setNomTipoDocumento(String nomTipoDocumento) {
        this.nomTipoDocumento = nomTipoDocumento;
    }

    @XmlTransient
    public List<DocumentoEmpleado> getDocumentoEmpleadoList() {
        return documentoEmpleadoList;
    }

    public void setDocumentoEmpleadoList(List<DocumentoEmpleado> documentoEmpleadoList) {
        this.documentoEmpleadoList = documentoEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoDocumento != null ? codTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.codTipoDocumento == null && other.codTipoDocumento != null) || (this.codTipoDocumento != null && !this.codTipoDocumento.equals(other.codTipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.TipoDocumento[ codTipoDocumento=" + codTipoDocumento + " ]";
    }
    
}
