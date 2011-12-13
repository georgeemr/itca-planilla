/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Compania;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistenciaPK;
import com.infosgroup.planilla.modelo.entidades.Sucursal;
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
public class ResumenAsistenciaFacade extends AbstractFacade<ResumenAsistencia, ResumenAsistenciaPK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ResumenAsistenciaFacade() {
        super(ResumenAsistencia.class);
    }
    
    public List<ResumenAsistencia> findAsistencias(Integer empresa, Integer sucursal, Integer planilla){
        List<ResumenAsistencia> listAsis = new ArrayList<ResumenAsistencia>(0);
        
        Query q = em.createQuery("select p from ResumenAsistencia p "
                +"where p.resumenAsistenciaPK.idCompania = :empresa and p.planilla.planillaPK.numPlanilla = :planilla "
                +"and p.puestoEmpleado.sucursal.sucursalPK.idSucursal = :sucursal", ResumenAsistencia.class);
        q.setParameter("empresa", empresa);
        q.setParameter("planilla", planilla);
        q.setParameter("sucursal", sucursal);
        listAsis = q.getResultList();
        
        return listAsis;
    }
    
}
