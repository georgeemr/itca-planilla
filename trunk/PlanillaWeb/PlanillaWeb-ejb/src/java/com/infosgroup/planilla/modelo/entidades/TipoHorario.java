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
@Table(name = "TIPO_HORARIO", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoHorario.findAll", query = "SELECT t FROM TipoHorario t"),
    @NamedQuery(name = "TipoHorario.findByCodCia", query = "SELECT t FROM TipoHorario t WHERE t.tipoHorarioPK.codCia = :codCia"),
    @NamedQuery(name = "TipoHorario.findByTipoHorario", query = "SELECT t FROM TipoHorario t WHERE t.tipoHorarioPK.tipoHorario = :tipoHorario"),
    @NamedQuery(name = "TipoHorario.findByDesTipoHorario", query = "SELECT t FROM TipoHorario t WHERE t.desTipoHorario = :desTipoHorario"),
    @NamedQuery(name = "TipoHorario.findByHoraInicio", query = "SELECT t FROM TipoHorario t WHERE t.horaInicio = :horaInicio"),
    @NamedQuery(name = "TipoHorario.findByMinutosInicio", query = "SELECT t FROM TipoHorario t WHERE t.minutosInicio = :minutosInicio"),
    @NamedQuery(name = "TipoHorario.findByHoraFin", query = "SELECT t FROM TipoHorario t WHERE t.horaFin = :horaFin"),
    @NamedQuery(name = "TipoHorario.findByMinutosFin", query = "SELECT t FROM TipoHorario t WHERE t.minutosFin = :minutosFin"),
    @NamedQuery(name = "TipoHorario.findByEstatus", query = "SELECT t FROM TipoHorario t WHERE t.estatus = :estatus"),
    @NamedQuery(name = "TipoHorario.findByHoraFInicio", query = "SELECT t FROM TipoHorario t WHERE t.horaFInicio = :horaFInicio"),
    @NamedQuery(name = "TipoHorario.findByHoraFFin", query = "SELECT t FROM TipoHorario t WHERE t.horaFFin = :horaFFin"),
    @NamedQuery(name = "TipoHorario.findByMinutosFInicio", query = "SELECT t FROM TipoHorario t WHERE t.minutosFInicio = :minutosFInicio"),
    @NamedQuery(name = "TipoHorario.findByMinutosFFin", query = "SELECT t FROM TipoHorario t WHERE t.minutosFFin = :minutosFFin"),
    @NamedQuery(name = "TipoHorario.findByHoras", query = "SELECT t FROM TipoHorario t WHERE t.horas = :horas")})
public class TipoHorario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoHorarioPK tipoHorarioPK;
    @Column(name = "DES_TIPO_HORARIO", length = 100)
    private String desTipoHorario;
    @Column(name = "HORA_INICIO")
    private Short horaInicio;
    @Column(name = "MINUTOS_INICIO")
    private Short minutosInicio;
    @Column(name = "HORA_FIN")
    private Short horaFin;
    @Column(name = "MINUTOS_FIN")
    private Short minutosFin;
    @Column(name = "ESTATUS", length = 1)
    private String estatus;
    @Column(name = "HORA_F_INICIO")
    private Short horaFInicio;
    @Column(name = "HORA_F_FIN")
    private Short horaFFin;
    @Column(name = "MINUTOS_F_INICIO")
    private Short minutosFInicio;
    @Column(name = "MINUTOS_F_FIN")
    private Short minutosFFin;
    @Column(name = "HORAS")
    private Short horas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoHorario")
    private List<HorarioEmp> horarioEmpList;

    public TipoHorario() {
    }

    public TipoHorario(TipoHorarioPK tipoHorarioPK) {
        this.tipoHorarioPK = tipoHorarioPK;
    }

    public TipoHorario(short codCia, String tipoHorario) {
        this.tipoHorarioPK = new TipoHorarioPK(codCia, tipoHorario);
    }

    public TipoHorarioPK getTipoHorarioPK() {
        return tipoHorarioPK;
    }

    public void setTipoHorarioPK(TipoHorarioPK tipoHorarioPK) {
        this.tipoHorarioPK = tipoHorarioPK;
    }

    public String getDesTipoHorario() {
        return desTipoHorario;
    }

    public void setDesTipoHorario(String desTipoHorario) {
        this.desTipoHorario = desTipoHorario;
    }

    public Short getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Short horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Short getMinutosInicio() {
        return minutosInicio;
    }

    public void setMinutosInicio(Short minutosInicio) {
        this.minutosInicio = minutosInicio;
    }

    public Short getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Short horaFin) {
        this.horaFin = horaFin;
    }

    public Short getMinutosFin() {
        return minutosFin;
    }

    public void setMinutosFin(Short minutosFin) {
        this.minutosFin = minutosFin;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Short getHoraFInicio() {
        return horaFInicio;
    }

    public void setHoraFInicio(Short horaFInicio) {
        this.horaFInicio = horaFInicio;
    }

    public Short getHoraFFin() {
        return horaFFin;
    }

    public void setHoraFFin(Short horaFFin) {
        this.horaFFin = horaFFin;
    }

    public Short getMinutosFInicio() {
        return minutosFInicio;
    }

    public void setMinutosFInicio(Short minutosFInicio) {
        this.minutosFInicio = minutosFInicio;
    }

    public Short getMinutosFFin() {
        return minutosFFin;
    }

    public void setMinutosFFin(Short minutosFFin) {
        this.minutosFFin = minutosFFin;
    }

    public Short getHoras() {
        return horas;
    }

    public void setHoras(Short horas) {
        this.horas = horas;
    }

    @XmlTransient
    public List<HorarioEmp> getHorarioEmpList() {
        return horarioEmpList;
    }

    public void setHorarioEmpList(List<HorarioEmp> horarioEmpList) {
        this.horarioEmpList = horarioEmpList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoHorarioPK != null ? tipoHorarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoHorario)) {
            return false;
        }
        TipoHorario other = (TipoHorario) object;
        if ((this.tipoHorarioPK == null && other.tipoHorarioPK != null) || (this.tipoHorarioPK != null && !this.tipoHorarioPK.equals(other.tipoHorarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.TipoHorario[ tipoHorarioPK=" + tipoHorarioPK + " ]";
    }
    
}
