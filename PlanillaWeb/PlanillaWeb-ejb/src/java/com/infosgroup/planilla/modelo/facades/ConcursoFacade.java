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

    public List<Concurso> getConcursosByDate(Cias cias, Date fechaInicial, Date fechaFinal) {
        List<Concurso> lstConcurso = new ArrayList<Concurso>();
        CriteriaQuery<Concurso> cq = em.getCriteriaBuilder().createQuery(Concurso.class);
        Root<Concurso> rootConcurso = cq.from(Concurso.class);
        if (fechaInicial != null && fechaFinal != null) {
            cq.where(em.getCriteriaBuilder().equal(rootConcurso.get(Concurso_.estadoConcurso), em.find(EstadoConcurso.class, new EstadoConcursoPK(cias.getCodCia(), "A"))),
                    em.getCriteriaBuilder().and(em.getCriteriaBuilder().between(rootConcurso.get(Concurso_.fechaInicial), fechaInicial, fechaFinal)));
        } else {
            cq.where(em.getCriteriaBuilder().equal(rootConcurso.get(Concurso_.estadoConcurso), em.find(EstadoConcurso.class, new EstadoConcursoPK(cias.getCodCia(), "A"))));
        }
        lstConcurso.addAll(getEntityManager().createQuery(cq).getResultList());
        return lstConcurso;
    }

    public List<Concurso> getConcursosActivos(Cias empresa) {
        List<Concurso> lstConcurso = new ArrayList<Concurso>();
        CriteriaQuery<Concurso> cq = em.getCriteriaBuilder().createQuery(Concurso.class);
        Root<Concurso> rootConcurso = cq.from(Concurso.class);
        cq.where(em.getCriteriaBuilder().equal(rootConcurso.get(Concurso_.estadoConcurso), em.find(EstadoConcurso.class, new EstadoConcursoPK(empresa.getCodCia(), "A"))));
        lstConcurso.addAll(getEntityManager().createQuery(cq).getResultList());
        return lstConcurso;
    }

    public Long max(Cias empresa) {
        Long max = (Long) em.createQuery("SELECT max(c.concursoPK.codConcurso) FROM Concurso c WHERE c.concursoPK.codCia = :codCia").setParameter("codCia", empresa.getCodCia()).getSingleResult();
        return max != null ? ( ++max ): 1L;
    }
    
    public List<Concurso> findConcursoByEmpresa(Cias empresa){
        List<Concurso> l = new ArrayList<Concurso>();
        l.addAll( em.createQuery("SELECT c FROM Concurso c WHERE c.concursoPK.codCia = :codCia", Concurso.class).setParameter("codCia", empresa.getCodCia()).getResultList() );
        return l;
    }
    
}