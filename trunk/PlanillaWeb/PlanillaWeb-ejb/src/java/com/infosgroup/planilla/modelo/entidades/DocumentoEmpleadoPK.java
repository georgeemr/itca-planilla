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
public class DocumentoEmpleadoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private long codCia;
    @Basic(optional = false)
    @Column(name = "COD_SUCURSAL", nullable = false)
    private long codSucursal;
    @Basic(optional = false)
    @Column(name = "COD_EMPLEADO", nullable = false)
    private long codEmpleado;
    @Basic(optional = false)
    @Column(name = "COD_TIPO_DOCUMENTO", nullable = false)
    private long codTipoDocumento;
    @Basic(optional = false)
    @Column(name = "NUM_DOCUMENTO", nullable = false, length = 200)
    private String numDocumento;

    public DocumentoEmpleadoPK() {
    }

    public DocumentoEmpleadoPK(long codCia, long codSucursal, long codEmpleado, long codTipoDocumento, String numDocumento) {
        this.codCia = codCia;
        this.codSucursal = codSucursal;
        this.codEmpleado = codEmpleado;
        this.codTipoDocumento = codTipoDocumento;
        this.numDocumento = numDocumento;
    }

    public long getCodCia() {
        return codCia;
    }

    public void setCodCia(long codCia) {
        this.codCia = codCia;
    }

    public long getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(long codSucursal) {
        this.codSucursal = codSucursal;
    }

    public long getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(long codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public long getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(long codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codSucursal;
        hash += (int) codEmpleado;
        hash += (int) codTipoDocumento;
        hash += (numDocumento != null ? numDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoEmpleadoPK)) {
            return false;
        }
        DocumentoEmpleadoPK other = (DocumentoEmpleadoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codSucursal != other.codSucursal) {
            return false;
        }
        if (this.codEmpleado != other.codEmpleado) {
            return false;
        }
        if (this.codTipoDocumento != other.codTipoDocumento) {
            return false;
        }
        if ((this.numDocumento == null && other.numDocumento != null) || (this.numDocumento != null && !this.numDocumento.equals(other.numDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DocumentoEmpleadoPK[ codCia=" + codCia + ", codSucursal=" + codSucursal + ", codEmpleado=" + codEmpleado + ", codTipoDocumento=" + codTipoDocumento + ", numDocumento=" + numDocumento + " ]";
    }
    
}
