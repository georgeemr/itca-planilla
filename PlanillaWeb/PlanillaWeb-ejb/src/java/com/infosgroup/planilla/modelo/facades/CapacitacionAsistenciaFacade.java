/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAsistencia;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAsistenciaPK;
import com.infosgroup.planilla.modelo.entidades.CapacitacionPK;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Empleados;
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
public class CapacitacionAsistenciaFacade extends AbstractFacade<CapacitacionAsistencia, CapacitacionAsistenciaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CapacitacionAsistenciaFacade() {
        super(CapacitacionAsistencia.class);
    }

    public Integer max(Cias empresa) {
        Integer max = (Integer) em.createQuery("SELECT max(c.capacitacionPK.codCapacitacion) FROM Capacitacion c WHERE c.capacitacionPK.codCia = :codCia").setParameter("codCia", empresa.getCodCia()).getSingleResult();
        return max != null ? (++max) : 1;
    }

    public List<CapacitacionAsistencia> findAsistenciaByEmpresa(Cias empresa, Capacitacion cap, Empleados emp) {
        List<CapacitacionAsistencia> l = new ArrayList<CapacitacionAsistencia>();
        l.addAll(getEntityManager().createQuery("SELECT c FROM CapacitacionAsistencia c WHERE c.capacitacionAsistenciaPK.codCia = :codCia and c.capacitacionAsistenciaPK.codCapacitacion = :codCapacitacion and c.capacitacionAsistenciaPK.codEmp = :codEmp", CapacitacionAsistencia.class).setParameter("codCia", empresa.getCodCia()).setParameter("codCapacitacion", cap.getCapacitacionPK().getCodCapacitacion()).setParameter("codEmp", emp.getEmpleadosPK().getCodEmp()).getResultList());

        return l != null ? l : new ArrayList<CapacitacionAsistencia>();
    }
}
