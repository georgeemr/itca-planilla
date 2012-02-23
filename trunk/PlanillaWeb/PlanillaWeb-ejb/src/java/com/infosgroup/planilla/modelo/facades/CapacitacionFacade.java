/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionPK;
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
public class CapacitacionFacade extends AbstractFacade<Capacitacion, CapacitacionPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public CapacitacionFacade() {
        super(Capacitacion.class);
    }

    public Integer max(Cias empresa) {
        Integer max = (Integer) em.createQuery("SELECT max(c.capacitacionPK.codCapacitacion) FROM Capacitacion c WHERE c.capacitacionPK.codCia = :codCia").setParameter("codCia", empresa.getCodCia()).getSingleResult();
        return max != null ? ( ++max ): 1;
    }
    
    public List<Capacitacion> findCapByEmpresa(Cias empresa){
        List<Capacitacion> l = new ArrayList<Capacitacion>();
        l.addAll(getEntityManager().createQuery("SELECT c FROM Capacitacion c WHERE c.capacitacionPK.codCia = :codCia", Capacitacion.class).setParameter("codCia", empresa.getCodCia()).getResultList());
        
        //l.addAll( em.createQuery("SELECT c FROM Instituciones c WHERE c.institucionesPK.codCia = :codCia", Instituciones.class).setParameter("codCia", empresa.getCodCia()).getResultList() );
        return l != null ? l : new ArrayList<Capacitacion>();
    }

}
