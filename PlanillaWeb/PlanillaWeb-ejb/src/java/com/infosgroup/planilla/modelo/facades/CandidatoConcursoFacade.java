/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;


import com.infosgroup.planilla.modelo.entidades.CandidatoConcurso;
import com.infosgroup.planilla.modelo.entidades.CandidatoConcursoPK;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import java.util.ArrayList;
import java.util.List;
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
public class CandidatoConcursoFacade extends AbstractFacade<CandidatoConcurso, CandidatoConcursoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public CandidatoConcursoFacade() {
        super(CandidatoConcurso.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @PermitAll
    public List<CandidatoConcurso> getCandidatoConcurso(Concurso c, String estado) {
        if (c == null) { return new ArrayList<CandidatoConcurso>(); }
        List<CandidatoConcurso> listaCandidatoConcurso = getEntityManager().createQuery("SELECT c FROM CandidatoConcurso c WHERE c.candidatoConcursoPK.codCia = :codCia AND c.candidatoConcursoPK.concurso = :concurso", CandidatoConcurso.class).setParameter("codCia", c.getConcursoPK().getCodCia()).setParameter("concurso", c.getConcursoPK().getCodConcurso()).getResultList();
        return listaCandidatoConcurso!=null?listaCandidatoConcurso:new ArrayList<CandidatoConcurso>();
    }
    
    @PermitAll
    public List<CandidatoConcurso> getCandidatoConcursoSeleccionado(Concurso c, List<String> estado) {
        if (c == null) { return new ArrayList<CandidatoConcurso>(); }
        List<CandidatoConcurso> listaCandidatoConcurso = getEntityManager().createQuery("SELECT c FROM CandidatoConcurso c WHERE c.candidatoConcursoPK.codCia = :codCia AND c.candidatoConcursoPK.concurso = :concurso AND c.estado in :estado", CandidatoConcurso.class).setParameter("codCia", c.getConcursoPK().getCodCia()).setParameter("concurso", c.getConcursoPK().getCodConcurso()).setParameter("estado", estado).getResultList();
        return listaCandidatoConcurso!=null?listaCandidatoConcurso:new ArrayList<CandidatoConcurso>();
    }
}
