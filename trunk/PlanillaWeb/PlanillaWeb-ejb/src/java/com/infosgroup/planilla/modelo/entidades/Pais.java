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
@Table(name = "PAIS")
@NamedQueries(
    {
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
    @NamedQuery(name = "Pais.findByIdPais", query = "SELECT p FROM Pais p WHERE p.idPais = :idPais"),
    @NamedQuery(name = "Pais.findByNomPais", query = "SELECT p FROM Pais p WHERE p.nomPais = :nomPais"),
    @NamedQuery(name = "Pais.findByDetPais", query = "SELECT p FROM Pais p WHERE p.detPais = :detPais")
    })
public class Pais implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PAIS", nullable = false)
    private Long idPais;

    @Size(max = 200)
    @Column(name = "NOM_PAIS", length = 200)
    private String nomPais;

    @Size(max = 200)
    @Column(name = "DET_PAIS", length = 200)
    private String detPais;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private List<Provincia> provinciaList;

    public Pais()
    {
    }

    public Pais(Long idPais)
    {
        this.idPais = idPais;
    }

    public Long getIdPais()
    {
        return idPais;
    }

    public void setIdPais(Long idPais)
    {
        this.idPais = idPais;
    }

    public String getNomPais()
    {
        return nomPais;
    }

    public void setNomPais(String nomPais)
    {
        this.nomPais = nomPais;
    }

    public String getDetPais()
    {
        return detPais;
    }

    public void setDetPais(String detPais)
    {
        this.detPais = detPais;
    }

    public List<Provincia> getProvinciaList()
    {
        return provinciaList;
    }

    public void setProvinciaList(List<Provincia> provinciaList)
    {
        this.provinciaList = provinciaList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idPais != null ? idPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais))
            {
            return false;
            }
        Pais other = (Pais) object;
        if ((this.idPais == null && other.idPais != null) || (this.idPais != null && !this.idPais.equals(other.idPais)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.infosgroup.planilla.modelo.entidades.Pais[ idPais=" + idPais + " ]";
    }
    
}
