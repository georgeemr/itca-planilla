/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.DependienteXCandidato;
import com.infosgroup.planilla.modelo.entidades.DependienteXCandidatoPK;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class DependienteXCandidatoFacade extends AbstractFacade<DependienteXCandidato, DependienteXCandidatoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public DependienteXCandidatoFacade() {
        super(DependienteXCandidato.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Integer max(Candidato c)
    {
    Query q = getEntityManager().createQuery("SELECT max(d.dependienteXCandidatoPK.codDocumentoPres) FROM DependienteXCandidato d WHERE d.dependienteXCandidatoPK.codCia = :codCia AND d.dependienteXCandidatoPK.codCandidato = :codCandidato");
    q.setParameter("codCia", c.getCandidatoPK().getCodCia());
    q.setParameter("codCandidato", c.getCandidatoPK().getCodCandidato());
    Integer max = (Integer) q.getSingleResult();
    return (max == null) ? 1 : ++max;
    }
}