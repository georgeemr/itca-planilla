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
@Table(name = "TIPO_DOCUMENTO")
@NamedQueries(
    {
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByIdTipoDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.idTipoDocumento = :idTipoDocumento"),
    @NamedQuery(name = "TipoDocumento.findByNomTipoDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.nomTipoDocumento = :nomTipoDocumento")
    })
public class TipoDocumento implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_DOCUMENTO", nullable = false)
    private Long idTipoDocumento;

    @Size(max = 100)
    @Column(name = "NOM_TIPO_DOCUMENTO", length = 100)
    private String nomTipoDocumento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private List<DocumentoEmpleado> documentoEmpleadoList;

    public TipoDocumento()
    {
    }

    public TipoDocumento(Long idTipoDocumento)
    {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Long getIdTipoDocumento()
    {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento)
    {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNomTipoDocumento()
    {
        return nomTipoDocumento;
    }

    public void setNomTipoDocumento(String nomTipoDocumento)
    {
        this.nomTipoDocumento = nomTipoDocumento;
    }

    public List<DocumentoEmpleado> getDocumentoEmpleadoList()
    {
        return documentoEmpleadoList;
    }

    public void setDocumentoEmpleadoList(List<DocumentoEmpleado> documentoEmpleadoList)
    {
        this.documentoEmpleadoList = documentoEmpleadoList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idTipoDocumento != null ? idTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento))
            {
            return false;
            }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idTipoDocumento == null && other.idTipoDocumento != null) || (this.idTipoDocumento != null && !this.idTipoDocumento.equals(other.idTipoDocumento)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.TipoDocumento[ idTipoDocumento=" + idTipoDocumento + " ]";
    }
    
}
