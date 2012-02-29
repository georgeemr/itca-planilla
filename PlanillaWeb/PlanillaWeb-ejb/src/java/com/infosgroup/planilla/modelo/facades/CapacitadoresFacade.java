/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionPK;
import com.infosgroup.planilla.modelo.entidades.Capacitadores;
import com.infosgroup.planilla.modelo.entidades.CapacitadoresPK;
import com.infosgroup.planilla.modelo.entidades.Cias;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class CapacitadoresFacade extends AbstractFacade<Capacitadores, CapacitadoresPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public CapacitadoresFacade() {
        super(Capacitadores.class);
    }

    public Integer max(Cias empresa) {
        Integer max = (Integer) em.createQuery("SELECT max(c.capacitacionPK.codCapacitacion) FROM Capacitacion c WHERE c.capacitacionPK.codCia = :codCia").setParameter("codCia", empresa.getCodCia()).getSingleResult();
        return max != null ? ( ++max ): 1;
    }
    
    public List<Capacitadores> findCapByEmpresa(Cias empresa){
        List<Capacitadores> l = new ArrayList<Capacitadores>();
        l.addAll(getEntityManager().createQuery("SELECT c FROM Capacitadores c WHERE c.capacitadoresPK.codCia = :codCia", Capacitadores.class).setParameter("codCia", empresa.getCodCia()).getResultList());
        
        //l.addAll( em.createQuery("SELECT c FROM Instituciones c WHERE c.institucionesPK.codCia = :codCia", Instituciones.class).setParameter("codCia", empresa.getCodCia()).getResultList() );
        return l != null ? l : new ArrayList<Capacitadores>();
    }

}
