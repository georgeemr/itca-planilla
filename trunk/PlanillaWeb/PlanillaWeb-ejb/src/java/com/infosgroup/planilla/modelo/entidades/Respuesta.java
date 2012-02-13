/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "RESPUESTA", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByCodCia", query = "SELECT r FROM Respuesta r WHERE r.respuestaPK.codCia = :codCia"),
    @NamedQuery(name = "Respuesta.findByCodTipoRespuesta", query = "SELECT r FROM Respuesta r WHERE r.respuestaPK.codTipoRespuesta = :codTipoRespuesta"),
    @NamedQuery(name = "Respuesta.findByCodRespuesta", query = "SELECT r FROM Respuesta r WHERE r.respuestaPK.codRespuesta = :codRespuesta"),
    @NamedQuery(name = "Respuesta.findByTexto", query = "SELECT r FROM Respuesta r WHERE r.texto = :texto"),
    @NamedQuery(name = "Respuesta.findByNivel", query = "SELECT r FROM Respuesta r WHERE r.nivel = :nivel"),
    @NamedQuery(name = "Respuesta.findByValor", query = "SELECT r FROM Respuesta r WHERE r.valor = :valor")})
public class Respuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RespuestaPK respuestaPK;
    @Basic(optional = false)
    @Column(name = "TEXTO", nullable = false, length = 300)
    private String texto;
    @Column(name = "NIVEL", length = 20)
    private String nivel;
    @Column(name = "VALOR")
    private Short valor;

    public Respuesta() {
    }

    public Respuesta(RespuestaPK respuestaPK) {
        this.respuestaPK = respuestaPK;
    }

    public Respuesta(RespuestaPK respuestaPK, String texto) {
        this.respuestaPK = respuestaPK;
        this.texto = texto;
    }

    public Respuesta(short codCia, short codTipoRespuesta, short codRespuesta) {
        this.respuestaPK = new RespuestaPK(codCia, codTipoRespuesta, codRespuesta);
    }

    public RespuestaPK getRespuestaPK() {
        return respuestaPK;
    }

    public void setRespuestaPK(RespuestaPK respuestaPK) {
        this.respuestaPK = respuestaPK;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Short getValor() {
        return valor;
    }

    public void setValor(Short valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (respuestaPK != null ? respuestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.respuestaPK == null && other.respuestaPK != null) || (this.respuestaPK != null && !this.respuestaPK.equals(other.respuestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.planilla.Respuesta[ respuestaPK=" + respuestaPK + " ]";
    }
    
}
