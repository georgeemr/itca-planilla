/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "documento_empleado", catalog = "planilla", schema = "public")
@NamedQueries({
    @NamedQuery(name = "DocumentoEmpleado.findAll", query = "SELECT d FROM DocumentoEmpleado d"),
    @NamedQuery(name = "DocumentoEmpleado.findByIdCompania", query = "SELECT d FROM DocumentoEmpleado d WHERE d.documentoEmpleadoPK.idCompania = :idCompania"),
    @NamedQuery(name = "DocumentoEmpleado.findByIdSucursal", query = "SELECT d FROM DocumentoEmpleado d WHERE d.documentoEmpleadoPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "DocumentoEmpleado.findByIdEmpleado", query = "SELECT d FROM DocumentoEmpleado d WHERE d.documentoEmpleadoPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "DocumentoEmpleado.findByIdTipoDocumento", query = "SELECT d FROM DocumentoEmpleado d WHERE d.documentoEmpleadoPK.idTipoDocumento = :idTipoDocumento"),
    @NamedQuery(name = "DocumentoEmpleado.findByNumDocumento", query = "SELECT d FROM DocumentoEmpleado d WHERE d.documentoEmpleadoPK.numDocumento = :numDocumento")})
public class DocumentoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentoEmpleadoPK documentoEmpleadoPK;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleado empleado;

    public DocumentoEmpleado() {
    }

    public DocumentoEmpleado(DocumentoEmpleadoPK documentoEmpleadoPK) {
        this.documentoEmpleadoPK = documentoEmpleadoPK;
    }

    public DocumentoEmpleado(int idCompania, int idSucursal, int idEmpleado, int idTipoDocumento, String numDocumento) {
        this.documentoEmpleadoPK = new DocumentoEmpleadoPK(idCompania, idSucursal, idEmpleado, idTipoDocumento, numDocumento);
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
