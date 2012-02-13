/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "CAUSAS_RENUNCIA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CausasRenuncia.findAll", query = "SELECT c FROM CausasRenuncia c"),
    @NamedQuery(name = "CausasRenuncia.findByCodCia", query = "SELECT c FROM CausasRenuncia c WHERE c.causasRenunciaPK.codCia = :codCia"),
    @NamedQuery(name = "CausasRenuncia.findByCodTiporenuncia", query = "SELECT c FROM CausasRenuncia c WHERE c.causasRenunciaPK.codTiporenuncia = :codTiporenuncia"),
    @NamedQuery(name = "CausasRenuncia.findByDescripcion", query = "SELECT c FROM CausasRenuncia c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CausasRenuncia.findByOtras", query = "SELECT c FROM CausasRenuncia c WHERE c.otras = :otras"),
    @NamedQuery(name = "CausasRenuncia.findByStatus", query = "SELECT c FROM CausasRenuncia c WHERE c.status = :status")})
public class CausasRenuncia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CausasRenunciaPK causasRenunciaPK;
    @Column(name = "DESCRIPCION", length = 60)
    private String descripcion;
    @Column(name = "OTRAS", length = 60)
    private String otras;
    @Column(name = "STATUS", length = 1)
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "causasRenuncia")
    private List<Empleados> empleadosList;

    public CausasRenuncia() {
    }

    public CausasRenuncia(CausasRenunciaPK causasRenunciaPK) {
        this.causasRenunciaPK = causasRenunciaPK;
    }

    public CausasRenuncia(short codCia, short codTiporenuncia) {
        this.causasRenunciaPK = new CausasRenunciaPK(codCia, codTiporenuncia);
    }

    public CausasRenunciaPK getCausasRenunciaPK() {
        return causasRenunciaPK;
    }

    public void setCausasRenunciaPK(CausasRenunciaPK causasRenunciaPK) {
        this.causasRenunciaPK = causasRenunciaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOtras() {
        return otras;
    }

    public void setOtras(String otras) {
        this.otras = otras;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (causasRenunciaPK != null ? causasRenunciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CausasRenuncia)) {
            return false;
        }
        CausasRenuncia other = (CausasRenuncia) object;
        if ((this.causasRenunciaPK == null && other.causasRenunciaPK != null) || (this.causasRenunciaPK != null && !this.causasRenunciaPK.equals(other.causasRenunciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.CausasRenuncia[ causasRenunciaPK=" + causasRenunciaPK + " ]";
    }
    
}
