/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.ConcursoPK;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        lstConcurso.addAll( getEntityManager().createNamedQuery("Concurso.findByFechaInicialFinal").setParameter("fechaInicial", fechaInicial).setParameter("fechaFinal", fechaFinal).getResultList() );
        return lstConcurso;
    }
}
