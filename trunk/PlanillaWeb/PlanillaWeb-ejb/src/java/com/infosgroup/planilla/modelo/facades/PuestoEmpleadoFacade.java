/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.PuestoEmpleado;
import com.infosgroup.planilla.modelo.entidades.PuestoEmpleadoPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class PuestoEmpleadoFacade extends AbstractFacade<PuestoEmpleado, PuestoEmpleadoPK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PuestoEmpleadoFacade() {
        super(PuestoEmpleado.class);
    }
    
    public PuestoEmpleado findByEmpleado(Integer emp, Short cia){
        PuestoEmpleado pueEmp = new PuestoEmpleado();
        Query pue = em.createQuery("select p from PuestoEmpleado p where p.puestoEmpleadoPK.idCompania = :cia "
                +"and p.empleado.empleadoPK.codEmp = :emp", PuestoEmpleado.class);
        pue.setParameter("cia", cia);
        pue.setParameter("emp", emp);
        pueEmp = (PuestoEmpleado) pue.getSingleResult();
        return pueEmp;
    }
}
