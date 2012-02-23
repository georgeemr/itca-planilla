/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Instituciones;
import com.infosgroup.planilla.modelo.entidades.InstitucionesPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Soporte
 */
@Stateless
public class InstitucionesFacade extends AbstractFacade<Instituciones, InstitucionesPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstitucionesFacade() {
        super(Instituciones.class);
    }
    
    public List<Instituciones> findInstitucionByEmpresa(Cias empresa){
        List<Instituciones> l = new ArrayList<Instituciones>();
        l.addAll(getEntityManager().createQuery("SELECT c FROM Instituciones c WHERE c.institucionesPK.codCia = :codCia", Instituciones.class).setParameter("codCia", empresa.getCodCia()).getResultList());
        
        //l.addAll( em.createQuery("SELECT c FROM Instituciones c WHERE c.institucionesPK.codCia = :codCia", Instituciones.class).setParameter("codCia", empresa.getCodCia()).getResultList() );
        return l != null ? l : new ArrayList<Instituciones>();
    }
}
