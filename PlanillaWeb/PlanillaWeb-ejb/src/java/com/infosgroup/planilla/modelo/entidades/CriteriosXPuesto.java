/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CRITERIOS_X_PUESTO")
@NamedQueries(
    {
    @NamedQuery(name = "CriteriosXPuesto.findAll", query = "SELECT c FROM CriteriosXPuesto c"),
    @NamedQuery(name = "CriteriosXPuesto.findByCodCia", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.codCia = :codCia"),
    @NamedQuery(name = "CriteriosXPuesto.findByPuesto", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.puesto = :puesto"),
    @NamedQuery(name = "CriteriosXPuesto.findByTipoCriterio", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.tipoCriterio = :tipoCriterio"),
    @NamedQuery(name = "CriteriosXPuesto.findByCriterio", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.criterio = :criterio"),
    @NamedQuery(name = "CriteriosXPuesto.findByCorrelativo", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.correlativo = :correlativo"),
    @NamedQuery(name = "CriteriosXPuesto.findByValor", query = "SELECT c FROM CriteriosXPuesto c WHERE c.valor = :valor"),
    @NamedQuery(name = "CriteriosXPuesto.findByValorInicialRango", query = "SELECT c FROM CriteriosXPuesto c WHERE c.valorInicialRango = :valorInicialRango"),
    @NamedQuery(name = "CriteriosXPuesto.findByValorFinalRango", query = "SELECT c FROM CriteriosXPuesto c WHERE c.valorFinalRango = :valorFinalRango"),
<<<<<<< .mine
    @NamedQuery(name = "CriteriosXPuesto.findByCampo", query = "SELECT c FROM CriteriosXPuesto c WHERE c.campo = :campo"),
    @NamedQuery(name = "CriteriosXPuesto.findByEntidad", query = "SELECT c FROM CriteriosXPuesto c WHERE c.entidad = :entidad")
    })
public class CriteriosXPuesto implements Serializable
{

=======
    @NamedQuery(name = "CriteriosXPuesto.findByTipoCriterio", query = "SELECT c FROM CriteriosXPuesto c WHERE c.criteriosXPuestoPK.tipoCriterio = :tipoCriterio")})
public class CriteriosXPuesto implements Serializable {
>>>>>>> .r287
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected CriteriosXPuestoPK criteriosXPuestoPK;
<<<<<<< .mine

    @Size(max = 200)
    @Column(name = "VALOR", length = 200)
=======
    @Column(name = "valor", length = 2147483647)
>>>>>>> .r287
    private String valor;
<<<<<<< .mine

    @Size(max = 200)
    @Column(name = "VALOR_INICIAL_RANGO", length = 200)
    private String valorInicialRango;

    @Size(max = 200)
    @Column(name = "VALOR_FINAL_RANGO", length = 200)
    private String valorFinalRango;

    @Size(max = 200)
    @Column(name = "CAMPO", length = 200)
    private String campo;

    @Size(max = 200)
    @Column(name = "ENTIDAD", length = 200)
    private String entidad;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "PUESTO", referencedColumnName = "COD_PUESTO", nullable = false, insertable = false, updatable = false)
        })
=======
    @Column(name = "valor_inicial_rango")
    private String valorInicialRango;
    @Column(name = "valor_final_rango")
    private String valorFinalRango;
    @JoinColumns({
        @JoinColumn(name = "cod_cia", referencedColumnName = "cod_cia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "puesto", referencedColumnName = "cod_puesto", nullable = false, insertable = false, updatable = false)})
>>>>>>> .r287
    @ManyToOne(optional = false)
    private Puesto puesto1;

    @JoinColumns(
        {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "TIPO_CRITERIO", referencedColumnName = "TIPO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CRITERIO", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Criterio criterio1;

    public CriteriosXPuesto()
    {
    }

    public CriteriosXPuesto(CriteriosXPuestoPK criteriosXPuestoPK)
    {
        this.criteriosXPuestoPK = criteriosXPuestoPK;
    }

    public CriteriosXPuesto(long codCia, long puesto, long tipoCriterio, long criterio, long correlativo)
    {
        this.criteriosXPuestoPK = new CriteriosXPuestoPK(codCia, puesto, tipoCriterio, criterio, correlativo);
    }

    public CriteriosXPuestoPK getCriteriosXPuestoPK()
    {
        return criteriosXPuestoPK;
    }

    public void setCriteriosXPuestoPK(CriteriosXPuestoPK criteriosXPuestoPK)
    {
        this.criteriosXPuestoPK = criteriosXPuestoPK;
    }

    public String getValor()
    {
        return valor;
    }

    public void setValor(String valor)
    {
        this.valor = valor;
    }

<<<<<<< .mine
    public String getValorInicialRango()
    {
=======
    public String getValorInicialRango() {
>>>>>>> .r287
        return valorInicialRango;
    }

<<<<<<< .mine
    public void setValorInicialRango(String valorInicialRango)
    {
=======
    public void setValorInicialRango(String valorInicialRango) {
>>>>>>> .r287
        this.valorInicialRango = valorInicialRango;
    }

<<<<<<< .mine
    public String getValorFinalRango()
    {
=======
    public String getValorFinalRango() {
>>>>>>> .r287
        return valorFinalRango;
    }

<<<<<<< .mine
    public void setValorFinalRango(String valorFinalRango)
    {
=======
    public void setValorFinalRango(String valorFinalRango) {
>>>>>>> .r287
        this.valorFinalRango = valorFinalRango;
    }

<<<<<<< .mine
    public String getCampo()
    {
        return campo;
    }

    public void setCampo(String campo)
    {
        this.campo = campo;
    }

    public String getEntidad()
    {
        return entidad;
    }

    public void setEntidad(String entidad)
    {
        this.entidad = entidad;
    }

=======
>>>>>>> .r287
    public Puesto getPuesto1()
    {
        return puesto1;
    }

    public void setPuesto1(Puesto puesto1)
    {
        this.puesto1 = puesto1;
    }

    public Criterio getCriterio1()
    {
        return criterio1;
    }

    public void setCriterio1(Criterio criterio1)
    {
        this.criterio1 = criterio1;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (criteriosXPuestoPK != null ? criteriosXPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosXPuesto))
            {
            return false;
            }
        CriteriosXPuesto other = (CriteriosXPuesto) object;
        if ((this.criteriosXPuestoPK == null && other.criteriosXPuestoPK != null) || (this.criteriosXPuestoPK != null && !this.criteriosXPuestoPK.equals(other.criteriosXPuestoPK)))
            {
            return false;
            }
        return true;
    }

    @Override
    public String toString()
    {
        return "testjqpl.modelo.entidades.CriteriosXPuesto[ criteriosXPuestoPK=" + criteriosXPuestoPK + " ]";
    }
    
}