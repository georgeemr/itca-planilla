/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CandidatoPK;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class CandidatoFacade extends AbstractFacade<Candidato, CandidatoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CandidatoFacade() {
        super(Candidato.class);
    }

  
    public List<Candidato> findByCriterios(List<CriteriosXPuesto> criterios) {
        List<Candidato> listaCandidatos = new ArrayList<Candidato>();
        String q = "select * from candidato ";
        
        for (CriteriosXPuesto cx : criterios) {
            if ( cx.getCriterio1().getClase() != null && cx.getCriterio1().getCampo() != null ) {
                
            }
        }

        return listaCandidatos;
    }
}
