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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "criterio", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre"})})
@NamedQueries({
    @NamedQuery(name = "Criterio.findAll", query = "SELECT c FROM Criterio c"),
    @NamedQuery(name = "Criterio.findByCodCia", query = "SELECT c FROM Criterio c WHERE c.criterioPK.codCia = :codCia"),
    @NamedQuery(name = "Criterio.findByCodigo", query = "SELECT c FROM Criterio c WHERE c.criterioPK.codigo = :codigo"),
    @NamedQuery(name = "Criterio.findByTipo", query = "SELECT c FROM Criterio c WHERE c.criterioPK.tipo = :tipo"),
    @NamedQuery(name = "Criterio.findByNombre", query = "SELECT c FROM Criterio c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Criterio.findByClase", query = "SELECT c FROM Criterio c WHERE c.clase = :clase"),
    @NamedQuery(name = "Criterio.findByCampo", query = "SELECT c FROM Criterio c WHERE c.campo = :campo")})
public class Criterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriterioPK criterioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "clase", length = 2147483647)
    private String clase;
    @Size(max = 2147483647)
    @Column(name = "campo", length = 2147483647)
    private String campo;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "tipo", referencedColumnName = "codigo", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TipoCriterio tipoCriterio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criterio1")
    private List<CriteriosXPuesto> criteriosXPuestoList;

    public Criterio() {
    }

    public Criterio(CriterioPK criterioPK) {
        this.criterioPK = criterioPK;
    }

    public Criterio(CriterioPK criterioPK, String nombre) {
        this.criterioPK = criterioPK;
        this.nombre = nombre;
    }

    public Criterio(int codCia, int codigo, int tipo) {
        this.criterioPK = new CriterioPK(codCia, codigo, tipo);
    }

    public CriterioPK getCriterioPK() {
        return criterioPK;
    }

    public void setCriterioPK(CriterioPK criterioPK) {
        this.criterioPK = criterioPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public TipoCriterio getTipoCriterio() {
        return tipoCriterio;
    }

    public void setTipoCriterio(TipoCriterio tipoCriterio) {
        this.tipoCriterio = tipoCriterio;
    }

    public List<CriteriosXPuesto> getCriteriosXPuestoList() {
        return criteriosXPuestoList;
    }

    public void setCriteriosXPuestoList(List<CriteriosXPuesto> criteriosXPuestoList) {
        this.criteriosXPuestoList = criteriosXPuestoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criterioPK != null ? criterioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criterio)) {
            return false;
        }
        Criterio other = (Criterio) object;
        if ((this.criterioPK == null && other.criterioPK != null) || (this.criterioPK != null && !this.criterioPK.equals(other.criterioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Criterio[ criterioPK=" + criterioPK + " ]";
    }
    
}
