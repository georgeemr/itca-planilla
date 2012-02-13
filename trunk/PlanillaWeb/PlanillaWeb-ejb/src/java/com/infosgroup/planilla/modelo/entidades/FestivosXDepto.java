/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "FESTIVOS_X_DEPTO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FestivosXDepto.findAll", query = "SELECT f FROM FestivosXDepto f"),
    @NamedQuery(name = "FestivosXDepto.findByCodCia", query = "SELECT f FROM FestivosXDepto f WHERE f.festivosXDeptoPK.codCia = :codCia"),
    @NamedQuery(name = "FestivosXDepto.findByCodPais", query = "SELECT f FROM FestivosXDepto f WHERE f.festivosXDeptoPK.codPais = :codPais"),
    @NamedQuery(name = "FestivosXDepto.findByCodDepto", query = "SELECT f FROM FestivosXDepto f WHERE f.festivosXDeptoPK.codDepto = :codDepto"),
    @NamedQuery(name = "FestivosXDepto.findByAnio", query = "SELECT f FROM FestivosXDepto f WHERE f.festivosXDeptoPK.anio = :anio"),
    @NamedQuery(name = "FestivosXDepto.findByDia", query = "SELECT f FROM FestivosXDepto f WHERE f.festivosXDeptoPK.dia = :dia"),
    @NamedQuery(name = "FestivosXDepto.findByMes", query = "SELECT f FROM FestivosXDepto f WHERE f.festivosXDeptoPK.mes = :mes")})
public class FestivosXDepto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FestivosXDeptoPK festivosXDeptoPK;

    public FestivosXDepto() {
    }

    public FestivosXDepto(FestivosXDeptoPK festivosXDeptoPK) {
        this.festivosXDeptoPK = festivosXDeptoPK;
    }

    public FestivosXDepto(short codCia, short codPais, short codDepto, short anio, short dia, short mes) {
        this.festivosXDeptoPK = new FestivosXDeptoPK(codCia, codPais, codDepto, anio, dia, mes);
    }

    public FestivosXDeptoPK getFestivosXDeptoPK() {
        return festivosXDeptoPK;
    }

    public void setFestivosXDeptoPK(FestivosXDeptoPK festivosXDeptoPK) {
        this.festivosXDeptoPK = festivosXDeptoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (festivosXDeptoPK != null ? festivosXDeptoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FestivosXDepto)) {
            return false;
        }
        FestivosXDepto other = (FestivosXDepto) object;
        if ((this.festivosXDeptoPK == null && other.festivosXDeptoPK != null) || (this.festivosXDeptoPK != null && !this.festivosXDeptoPK.equals(other.festivosXDeptoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.FestivosXDepto[ festivosXDeptoPK=" + festivosXDeptoPK + " ]";
    }
    
}
