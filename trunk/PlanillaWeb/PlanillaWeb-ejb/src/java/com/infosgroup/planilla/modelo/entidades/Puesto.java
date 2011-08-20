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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "puesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puesto.findAll", query = "SELECT p FROM Puesto p"),
    @NamedQuery(name = "Puesto.findByIdTipoPuesto", query = "SELECT p FROM Puesto p WHERE p.puestoPK.idTipoPuesto = :idTipoPuesto"),
    @NamedQuery(name = "Puesto.findByIdPuesto", query = "SELECT p FROM Puesto p WHERE p.puestoPK.idPuesto = :idPuesto"),
    @NamedQuery(name = "Puesto.findByNomPuesto", query = "SELECT p FROM Puesto p WHERE p.nomPuesto = :nomPuesto"),
    @NamedQuery(name = "Puesto.findByDetPuesto", query = "SELECT p FROM Puesto p WHERE p.detPuesto = :detPuesto")})
public class Puesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PuestoPK puestoPK;
    @Size(max = 100)
    @Column(name = "nom_puesto", length = 100)
    private String nomPuesto;
    @Size(max = 400)
    @Column(name = "det_puesto", length = 400)
    private String detPuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puesto", fetch = FetchType.EAGER)
    private List<PuestoEmpleado> puestoEmpleadoList;
    @JoinColumn(name = "id_tipo_puesto", referencedColumnName = "id_tipo_puesto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoPuesto tipoPuesto;

    public Puesto() {
    }

    public Puesto(PuestoPK puestoPK) {
        this.puestoPK = puestoPK;
    }

    public Puesto(int idTipoPuesto, int idPuesto) {
        this.puestoPK = new PuestoPK(idTipoPuesto, idPuesto);
    }

    public PuestoPK getPuestoPK() {
        return puestoPK;
    }

    public void setPuestoPK(PuestoPK puestoPK) {
        this.puestoPK = puestoPK;
    }

    public String getNomPuesto() {
        return nomPuesto;
    }

    public void setNomPuesto(String nomPuesto) {
        this.nomPuesto = nomPuesto;
    }

    public String getDetPuesto() {
        return detPuesto;
    }

    public void setDetPuesto(String detPuesto) {
        this.detPuesto = detPuesto;
    }

    @XmlTransient
    public List<PuestoEmpleado> getPuestoEmpleadoList() {
        return puestoEmpleadoList;
    }

    public void setPuestoEmpleadoList(List<PuestoEmpleado> puestoEmpleadoList) {
        this.puestoEmpleadoList = puestoEmpleadoList;
    }

    public TipoPuesto getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(TipoPuesto tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puestoPK != null ? puestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puesto)) {
            return false;
        }
        Puesto other = (Puesto) object;
        if ((this.puestoPK == null && other.puestoPK != null) || (this.puestoPK != null && !this.puestoPK.equals(other.puestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Puesto[ puestoPK=" + puestoPK + " ]";
    }
    
}
