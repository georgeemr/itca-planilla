/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**

 @author root
 */
@Entity
@Table(name = "EQUIPO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByCodCia", query = "SELECT e FROM Equipo e WHERE e.equipoPK.codCia = :codCia"),
    @NamedQuery(name = "Equipo.findByCodEquipo", query = "SELECT e FROM Equipo e WHERE e.equipoPK.codEquipo = :codEquipo"),
    @NamedQuery(name = "Equipo.findByNomEquipo", query = "SELECT e FROM Equipo e WHERE e.nomEquipo = :nomEquipo")
    })
public class Equipo implements Serializable
{

private static final long serialVersionUID = 1L;
@EmbeddedId
protected EquipoPK equipoPK;
@Basic(optional = false)
@NotNull
@Size(min = 1, max = 100)
@Column(name = "NOM_EQUIPO", nullable = false, length = 100)
private String nomEquipo;
@ManyToMany(mappedBy = "equipoList")
private List<Candidato> candidatoList;

public Equipo()
{
}

public Equipo(EquipoPK equipoPK)
{
    this.equipoPK = equipoPK;
}

public Equipo(EquipoPK equipoPK, String nomEquipo)
{
    this.equipoPK = equipoPK;
    this.nomEquipo = nomEquipo;
}

public Equipo(short codCia, short codEquipo)
{
    this.equipoPK = new EquipoPK(codCia, codEquipo);
}

public EquipoPK getEquipoPK()
{
    return equipoPK;
}

public void setEquipoPK(EquipoPK equipoPK)
{
    this.equipoPK = equipoPK;
}

public String getNomEquipo()
{
    return nomEquipo;
}

public void setNomEquipo(String nomEquipo)
{
    this.nomEquipo = nomEquipo;
}

@XmlTransient
public List<Candidato> getCandidatoList()
{
    return candidatoList;
}

public void setCandidatoList(List<Candidato> candidatoList)
{
    this.candidatoList = candidatoList;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (equipoPK != null ? equipoPK.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Equipo))
        {
        return false;
        }
    Equipo other = (Equipo) object;
    if ((this.equipoPK == null && other.equipoPK != null) || (this.equipoPK != null && !this.equipoPK.equals(other.equipoPK)))
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.Equipo[ equipoPK=" + equipoPK + " ]";
}
}
