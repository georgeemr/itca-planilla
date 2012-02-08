/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.EstadoContrato;
import com.infosgroup.planilla.modelo.entidades.EstadoContratoPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class EstadoContratoFacade extends AbstractFacade<EstadoContrato, EstadoContratoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoContratoFacade() {
        super(EstadoContrato.class);
    }

    @PermitAll
    public List<EstadoContrato> findEstadoContratoByEmpresa(Cias empresa) {
        List<EstadoContrato> l = new ArrayList<EstadoContrato>();
        l.addAll(em.createQuery("SELECT e FROM EstadoContrato e WHERE e.estadoContratoPK.codCia = :codCia", EstadoContrato.class).setParameter("codCia", empresa.getCodCia()).getResultList());
        return l;
    }
}
