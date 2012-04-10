/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CRITERIO", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NOMBRE"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Criterio.findAll", query = "SELECT c FROM Criterio c"),
    @NamedQuery(name = "Criterio.findByCodCia", query = "SELECT c FROM Criterio c WHERE c.criterioPK.codCia = :codCia"),
    @NamedQuery(name = "Criterio.findByCodigo", query = "SELECT c FROM Criterio c WHERE c.criterioPK.codigo = :codigo"),
    @NamedQuery(name = "Criterio.findByNombre", query = "SELECT c FROM Criterio c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Criterio.findByQuery", query = "SELECT c FROM Criterio c WHERE c.query = :query"),
    @NamedQuery(name = "Criterio.findByEntidad", query = "SELECT c FROM Criterio c WHERE c.entidad = :entidad"),
    @NamedQuery(name = "Criterio.findByOperador", query = "SELECT c FROM Criterio c WHERE c.operador = :operador"),
    @NamedQuery(name = "Criterio.findByValor", query = "SELECT c FROM Criterio c WHERE c.valor = :valor"),
    @NamedQuery(name = "Criterio.findByValorInicial", query = "SELECT c FROM Criterio c WHERE c.valorInicial = :valorInicial"),
    @NamedQuery(name = "Criterio.findByValorFinal", query = "SELECT c FROM Criterio c WHERE c.valorFinal = :valorFinal")})
public class Criterio implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criterio")
    private List<CriteriosXPuesto> criteriosXPuestoList;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriterioPK criterioPK;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "QUERY", nullable = false, length = 1000)
    private String query;
    @Column(name = "ENTIDAD", length = 50)
    private String entidad;
    @Basic(optional = false)
    @Column(name = "OPERADOR", nullable = false, length = 50)
    private String operador;
    @Column(name = "VALOR", length = 100)
    private String valor;
    @Column(name = "VALOR_INICIAL", length = 100)
    private String valorInicial;
    @Column(name = "VALOR_FINAL", length = 100)
    private String valorFinal;
    @Transient
    private String partialQuery;
    
    public Criterio() {
    }

    public Criterio(CriterioPK criterioPK) {
        this.criterioPK = criterioPK;
    }

    public Criterio(CriterioPK criterioPK, String nombre, String query, String operador) {
        this.criterioPK = criterioPK;
        this.nombre = nombre;
        this.query = query;
        this.operador = operador;
    }

    public Criterio(short codCia, int codigo) {
        this.criterioPK = new CriterioPK(codCia, codigo);
    }

    public CriterioPK getCriterioGbPK() {
        return criterioPK;
    }

    public void setCriterioGbPK(CriterioPK criterioPK) {
        this.criterioPK = criterioPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(String valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(String valorFinal) {
        this.valorFinal = valorFinal;
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

    public void setPartialQuery(String partialQuery) {
        this.partialQuery = partialQuery;
    }
        
    public String getPartialQuery() throws Exception {
        if (operador == null) {
            throw new Exception("No se ha definido el operador en el descriptor de Criterios.");
        }
        if (operador.equals("equal")) {
            partialQuery = query.replace("{0}", getValor()).replace("$", "'");
        } else {
            partialQuery = query.replace("{0}", getValorInicial()).replace("{1}", getValorFinal()).replace("$", "'");
        }
        return partialQuery;
    }
    
    @Override
    public String toString() {
        return "sv.com.infosgroup.modelocandidatojpa.entidades.Criterio[ criterioPK=" + criterioPK + " ]";
    }

    @XmlTransient
    public List<CriteriosXPuesto> getCriteriosXPuestoList() {
        return criteriosXPuestoList;
    }

    public void setCriteriosXPuestoGbList(List<CriteriosXPuesto> criteriosXPuestoList) {
        this.criteriosXPuestoList = criteriosXPuestoList;
    }
    
}
