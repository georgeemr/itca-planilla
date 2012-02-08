/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DOCUMENTO_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoEmpleado.findAll", query = "SELECT d FROM DocumentoEmpleado d"),
    @NamedQuery(name = "DocumentoEmpleado.findByCodCia", query = "SELECT d FROM DocumentoEmpleado d WHERE d.documentoEmpleadoPK.codCia = :codCia"),
    @NamedQuery(name = "DocumentoEmpleado.findByCodSucursal", query = "SELECT d FROM DocumentoEmpleado d WHERE d.documentoEmpleadoPK.codSucursal = :codSucursal"),
    @NamedQuery(name = "DocumentoEmpleado.findByCodEmpleado", query = "SELECT d FROM DocumentoEmpleado d WHERE d.documentoEmpleadoPK.codEmpleado = :codEmpleado"),
    @NamedQuery(name = "DocumentoEmpleado.findByCodTipoDocumento", query = "SELECT d FROM DocumentoEmpleado d WHERE d.documentoEmpleadoPK.codTipoDocumento = :codTipoDocumento"),
    @NamedQuery(name = "DocumentoEmpleado.findByNumDocumento", query = "SELECT d FROM DocumentoEmpleado d WHERE d.documentoEmpleadoPK.numDocumento = :numDocumento")})
public class DocumentoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentoEmpleadoPK documentoEmpleadoPK;
    @JoinColumn(name = "COD_TIPO_DOCUMENTO", referencedColumnName = "COD_TIPO_DOCUMENTO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;

    public DocumentoEmpleado() {
    }

    public DocumentoEmpleado(DocumentoEmpleadoPK documentoEmpleadoPK) {
        this.documentoEmpleadoPK = documentoEmpleadoPK;
    }

    public DocumentoEmpleado(long codCia, long codSucursal, long codEmpleado, long codTipoDocumento, String numDocumento) {
        this.documentoEmpleadoPK = new DocumentoEmpleadoPK(codCia, codSucursal, codEmpleado, codTipoDocumento, numDocumento);
    }

    public DocumentoEmpleadoPK getDocumentoEmpleadoPK() {
        return documentoEmpleadoPK;
    }

    public void setDocumentoEmpleadoPK(DocumentoEmpleadoPK documentoEmpleadoPK) {
        this.documentoEmpleadoPK = documentoEmpleadoPK;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoEmpleadoPK != null ? documentoEmpleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoEmpleado)) {
            return false;
        }
        DocumentoEmpleado other = (DocumentoEmpleado) object;
        if ((this.documentoEmpleadoPK == null && other.documentoEmpleadoPK != null) || (this.documentoEmpleadoPK != null && !this.documentoEmpleadoPK.equals(other.documentoEmpleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DocumentoEmpleado[ documentoEmpleadoPK=" + documentoEmpleadoPK + " ]";
    }
    
}
