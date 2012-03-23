/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.CandidatoConcurso;
import com.infosgroup.planilla.modelo.entidades.EvaluacionCandidato;
import com.infosgroup.planilla.modelo.entidades.EvaluacionCandidatoPK;
import com.infosgroup.planilla.modelo.entidades.PruebaXPuesto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
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
public class EvaluacionCandidatoFacade extends AbstractFacade<EvaluacionCandidato, EvaluacionCandidatoPK> {

    @EJB
    private CandidatoConcursoFacade candidatoConcursoFacade;
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public EvaluacionCandidatoFacade() {
        super(EvaluacionCandidato.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PermitAll
    public List<EvaluacionCandidato> getListEvaluacionCandidato(CandidatoConcurso c) {
        List<EvaluacionCandidato> ec = new ArrayList<EvaluacionCandidato>();
        ec.addAll(em.createQuery("SELECT e FROM EvaluacionCandidato e WHERE e.candidatoConcurso = :cc", EvaluacionCandidato.class).setParameter("cc", c).getResultList());
        return ec!=null?ec:new ArrayList<EvaluacionCandidato>();
    }

    @PermitAll
    public void actualizarNotaCandidato(List<EvaluacionCandidato> lc, CandidatoConcurso x) {
        Double total = 0D;
        for (int i = 0; i < lc.size(); i++) {
            total +=  lc.get(i).getNota() != null ? lc.get(i).getNota().doubleValue() : 0D;
        }
        if (lc.size()>0){
        x.setNotaEvaluacion( new BigDecimal(  total / lc.size() ));
        candidatoConcursoFacade.edit(x);
        }else{
        x.setNotaEvaluacion(BigDecimal.ZERO);
        candidatoConcursoFacade.edit(x);
        }
    }
}
