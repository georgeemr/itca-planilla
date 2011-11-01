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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "cuenta")
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByIdCompania", query = "SELECT c FROM Cuenta c WHERE c.cuentaPK.idCompania = :idCompania"),
    @NamedQuery(name = "Cuenta.findByIdTipoCuenta", query = "SELECT c FROM Cuenta c WHERE c.cuentaPK.idTipoCuenta = :idTipoCuenta"),
    @NamedQuery(name = "Cuenta.findByIdCuenta", query = "SELECT c FROM Cuenta c WHERE c.cuentaPK.idCuenta = :idCuenta"),
    @NamedQuery(name = "Cuenta.findByNivel1", query = "SELECT c FROM Cuenta c WHERE c.nivel1 = :nivel1"),
    @NamedQuery(name = "Cuenta.findByNivel2", query = "SELECT c FROM Cuenta c WHERE c.nivel2 = :nivel2"),
    @NamedQuery(name = "Cuenta.findByNivel3", query = "SELECT c FROM Cuenta c WHERE c.nivel3 = :nivel3"),
    @NamedQuery(name = "Cuenta.findByNivel4", query = "SELECT c FROM Cuenta c WHERE c.nivel4 = :nivel4"),
    @NamedQuery(name = "Cuenta.findByNivel5", query = "SELECT c FROM Cuenta c WHERE c.nivel5 = :nivel5"),
    @NamedQuery(name = "Cuenta.findByNivel6", query = "SELECT c FROM Cuenta c WHERE c.nivel6 = :nivel6"),
    @NamedQuery(name = "Cuenta.findByNivel7", query = "SELECT c FROM Cuenta c WHERE c.nivel7 = :nivel7"),
    @NamedQuery(name = "Cuenta.findByNivel8", query = "SELECT c FROM Cuenta c WHERE c.nivel8 = :nivel8")})
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CuentaPK cuentaPK;
    @Size(max = 20)
    @Column(name = "nivel1", length = 20)
    private String nivel1;
    @Size(max = 20)
    @Column(name = "nivel2", length = 20)
    private String nivel2;
    @Size(max = 20)
    @Column(name = "nivel3", length = 20)
    private String nivel3;
    @Size(max = 20)
    @Column(name = "nivel4", length = 20)
    private String nivel4;
    @Size(max = 20)
    @Column(name = "nivel5", length = 20)
    private String nivel5;
    @Size(max = 20)
    @Column(name = "nivel6", length = 20)
    private String nivel6;
    @Size(max = 20)
    @Column(name = "nivel7", length = 20)
    private String nivel7;
    @Size(max = 20)
    @Column(name = "nivel8", length = 20)
    private String nivel8;
    @JoinTable(name = "transaccion_cuenta", joinColumns = {
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false),
        @JoinColumn(name = "id_tipo_cuenta", referencedColumnName = "id_tipo_cuenta", nullable = false),
        @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false),
        @JoinColumn(name = "id_tipo_transaccion", referencedColumnName = "id_tipo_transaccion", nullable = false),
        @JoinColumn(name = "id_transaccion", referencedColumnName = "id_transaccion", nullable = false)})
    @ManyToMany
    private List<Transaccion> transaccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
    private List<DeduccionesPrestaciones> deduccionesPrestacionesList;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_tipo_cuenta", referencedColumnName = "id_tipo_cuenta", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TipoCuenta tipoCuenta;

    public Cuenta() {
    }

    public Cuenta(CuentaPK cuentaPK) {
        this.cuentaPK = cuentaPK;
    }

    public Cuenta(int idCompania, int idTipoCuenta, int idCuenta) {
        this.cuentaPK = new CuentaPK(idCompania, idTipoCuenta, idCuenta);
    }

    public CuentaPK getCuentaPK() {
        return cuentaPK;
    }

    public void setCuentaPK(CuentaPK cuentaPK) {
        this.cuentaPK = cuentaPK;
    }

    public String getNivel1() {
        return nivel1;
    }

    public void setNivel1(String nivel1) {
        this.nivel1 = nivel1;
    }

    public String getNivel2() {
        return nivel2;
    }

    public void setNivel2(String nivel2) {
        this.nivel2 = nivel2;
    }

    public String getNivel3() {
        return nivel3;
    }

    public void setNivel3(String nivel3) {
        this.nivel3 = nivel3;
    }

    public String getNivel4() {
        return nivel4;
    }

    public void setNivel4(String nivel4) {
        this.nivel4 = nivel4;
    }

    public String getNivel5() {
        return nivel5;
    }

    public void setNivel5(String nivel5) {
        this.nivel5 = nivel5;
    }

    public String getNivel6() {
        return nivel6;
    }

    public void setNivel6(String nivel6) {
        this.nivel6 = nivel6;
    }

    public String getNivel7() {
        return nivel7;
    }

    public void setNivel7(String nivel7) {
        this.nivel7 = nivel7;
    }

    public String getNivel8() {
        return nivel8;
    }

    public void setNivel8(String nivel8) {
        this.nivel8 = nivel8;
    }

    public List<Transaccion> getTransaccionList() {
        return transaccionList;
    }

    public void setTransaccionList(List<Transaccion> transaccionList) {
        this.transaccionList = transaccionList;
    }

    public List<DeduccionesPrestaciones> getDeduccionesPrestacionesList() {
        return deduccionesPrestacionesList;
    }

    public void setDeduccionesPrestacionesList(List<DeduccionesPrestaciones> deduccionesPrestacionesList) {
        this.deduccionesPrestacionesList = deduccionesPrestacionesList;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaPK != null ? cuentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.cuentaPK == null && other.cuentaPK != null) || (this.cuentaPK != null && !this.cuentaPK.equals(other.cuentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Cuenta[ cuentaPK=" + cuentaPK + " ]";
    }
    
}