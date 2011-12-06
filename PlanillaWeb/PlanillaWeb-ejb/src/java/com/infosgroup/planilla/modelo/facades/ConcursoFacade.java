/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class ConcursoFacade extends AbstractFacade<Concurso, ConcursoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConcursoFacade() {
        super(Concurso.class);
    }

    public List<Concurso> getConcursosByDate(Date fechaInicial, Date fechaFinal) {
        List<Concurso> lstConcurso = new ArrayList<Concurso>();
        CriteriaQuery<Concurso> cq = em.getCriteriaBuilder().createQuery(Concurso.class);
        Root<Concurso> rootConcurso = cq.from(Concurso.class);
        if (fechaInicial != null && fechaFinal != null) {
            cq.where(em.getCriteriaBuilder().equal(rootConcurso.get(Concurso_.estadoConcurso), em.find(EstadoConcurso.class, new EstadoConcursoPK(1, "A"))),
                    em.getCriteriaBuilder().and(em.getCriteriaBuilder().between(rootConcurso.get(Concurso_.fechaInicial), fechaInicial, fechaFinal)));
        } else {
            cq.where(em.getCriteriaBuilder().equal(rootConcurso.get(Concurso_.estadoConcurso), em.find(EstadoConcurso.class, new EstadoConcursoPK(1, "A"))));
        }
        lstConcurso.addAll(getEntityManager().createQuery(cq).getResultList());
        return lstConcurso;
    }

    public List<Concurso> getConcursosActivos(Integer empresa) {
        List<Concurso> lstConcurso = new ArrayList<Concurso>();
        CriteriaQuery<Concurso> cq = em.getCriteriaBuilder().createQuery(Concurso.class);
        Root<Concurso> rootConcurso = cq.from(Concurso.class);
        cq.where(em.getCriteriaBuilder().equal(rootConcurso.get(Concurso_.estadoConcurso), em.find(EstadoConcurso.class, new EstadoConcursoPK(empresa, "A"))));
        lstConcurso.addAll(getEntityManager().createQuery(cq).getResultList());
        return lstConcurso;
    }

    public Long getMax(Integer empresa) {
        Long max = (Long) em.createNamedQuery("Concurso.max").setParameter("codCia", empresa).getSingleResult();
        return max != null ? ( ++max ): 1;
    }
}