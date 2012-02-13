/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Agencias;
import com.infosgroup.planilla.modelo.entidades.AgenciasPK;
import com.infosgroup.planilla.modelo.entidades.Cias;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class AgenciasFacade extends AbstractFacade<Agencias, AgenciasPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgenciasFacade() {
        super(Agencias.class);
    }

    @PermitAll
    public List<Agencias> findByCompania(Cias compania) {
        List<Agencias> lista = null;
        Query q = getEntityManager().createQuery("SELECT a FROM Agencias a WHERE a.agenciasPK.codCia = :codCia", Agencias.class).setParameter("codCia", compania.getCodCia());
        lista = q.getResultList();
        return lista != null ? lista : new ArrayList<Agencias>(0);
    }
}
