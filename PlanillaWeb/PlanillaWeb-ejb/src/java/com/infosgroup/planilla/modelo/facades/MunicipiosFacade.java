/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Deptos;
import com.infosgroup.planilla.modelo.entidades.Municipios;
import com.infosgroup.planilla.modelo.entidades.MunicipiosPK;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class MunicipiosFacade extends AbstractFacade<Municipios, MunicipiosPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipiosFacade() {
        super(Municipios.class);
    }

    @PermitAll
    public java.util.List<Municipios> findByDepartamento(Deptos departamento) {
        java.util.List<Municipios> l = new java.util.ArrayList<Municipios>();
        l = em.createQuery("SELECT m FROM Municipios m WHERE m.municipiosPK.codPais = :codPais and m.municipiosPK.codDepto = :codDepto", Municipios.class)
                .setParameter("codPais", departamento.getDeptosPK().getCodPais())
                .setParameter("codDepto", departamento.getDeptosPK().getCodDepto()).getResultList();
        return l != null ? l : new java.util.ArrayList<Municipios>();
    }
}
