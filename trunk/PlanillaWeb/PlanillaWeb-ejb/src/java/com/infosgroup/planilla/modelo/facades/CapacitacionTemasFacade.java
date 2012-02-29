/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAreas;
import com.infosgroup.planilla.modelo.entidades.CapacitacionPK;
import com.infosgroup.planilla.modelo.entidades.CapacitacionTemas;
import com.infosgroup.planilla.modelo.entidades.CapacitacionTemasPK;
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
public class CapacitacionTemasFacade extends AbstractFacade<CapacitacionTemas, CapacitacionTemasPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public CapacitacionTemasFacade() {
        super(CapacitacionTemas.class);
    }

    public Integer max(Cias empresa) {
        Integer max = (Integer) em.createQuery("SELECT max(c.capacitacionPK.codCapacitacion) FROM Capacitacion c WHERE c.capacitacionPK.codCia = :codCia").setParameter("codCia", empresa.getCodCia()).getSingleResult();
        return max != null ? ( ++max ): 1;
    }
    
    public List<CapacitacionTemas> findTemasByArea(Cias empresa, CapacitacionAreas area){
        List<CapacitacionTemas> l = new ArrayList<CapacitacionTemas>();
        l.addAll(getEntityManager().createQuery("SELECT c FROM CapacitacionTemas c WHERE c.capacitacionTemasPK.codCia = :codCia and c.capacitacionTemasPK.codArea = :codArea", CapacitacionTemas.class).setParameter("codCia", empresa.getCodCia()).setParameter("codArea", area.getCapacitacionAreasPK().getCodArea()).getResultList());
        return l != null ? l : new ArrayList<CapacitacionTemas>();
    }

}
