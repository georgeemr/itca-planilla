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
        return ec;
    }

    @PermitAll
    public void registraPruebasPorCandidato(CandidatoConcurso c) {
        for (PruebaXPuesto pxp : c.getConcurso1().getPuestos().getPruebaXPuestoList()) {
            EvaluacionCandidato avc = new EvaluacionCandidato();
            EvaluacionCandidatoPK pk = new EvaluacionCandidatoPK(
                    c.getCandidato1().getCandidatoPK().getCodCia(),
                    c.getConcurso1().getPuestos().getPuestosPK().getCodPuesto(),
                    pxp.getPruebaXPuestoPK().getCodigo(),
                    c.getCandidato1().getCandidatoPK().getCodCandidato(),
                    c.getConcurso1().getConcursoPK().getCodConcurso());
            avc.setEvaluacionCandidatoPK(pk);
            avc.setCandidatoConcurso(c);
            avc.setPruebaXPuesto(pxp);
            avc.setNota(BigDecimal.ZERO);
            avc.setFecha(new Date());
            try {
                if (find(pk) == null) {create(avc);};
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @PermitAll
    public void actualizarNotaCandidato(List<EvaluacionCandidato> lc) {
        Double total = 0D;
        CandidatoConcurso n;
        for (int i = 0; i < lc.size(); i++) {
            total +=  lc.get(i).getNota() != null ? lc.get(i).getNota().doubleValue() : 0D;
        }
        n = lc.get(0).getCandidatoConcurso();
        n.setNotaEvaluacion( new BigDecimal(  total / lc.size() ));
        candidatoConcursoFacade.edit(n);
    }
}
