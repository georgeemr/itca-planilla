/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionPK;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleado;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleadoPK;
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
public class CapacitacionXEmpleadoFacade extends AbstractFacade<CapacitacionXEmpleado, CapacitacionXEmpleadoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CapacitacionXEmpleadoFacade() {
        super(CapacitacionXEmpleado.class);
    }

    public List<CapacitacionXEmpleado> findCapByEmpresaCap(Cias empresa, Capacitacion cap) {
        List<CapacitacionXEmpleado> l = new ArrayList<CapacitacionXEmpleado>();
        l.addAll(getEntityManager().createQuery("SELECT c FROM CapacitacionXEmpleado c WHERE c.capacitacionXEmpleadoPK.codCia = :codCia and c.capacitacionXEmpleadoPK.codCapacitacion = :codCapacitacion", CapacitacionXEmpleado.class).setParameter("codCia", empresa.getCodCia()).setParameter("codCapacitacion", cap.getCapacitacionPK().getCodCapacitacion()).getResultList());
        return l != null ? l : new ArrayList<CapacitacionXEmpleado>();
    }
}
