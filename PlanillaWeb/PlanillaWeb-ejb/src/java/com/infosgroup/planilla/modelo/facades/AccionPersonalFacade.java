/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.AccionPersonalPK;
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
public class AccionPersonalFacade extends AbstractFacade<AccionPersonal, AccionPersonalPK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AccionPersonalFacade() {
        super(AccionPersonal.class);
    }
    
    /**
     * Listado de solicitudes de accion de personal por jefe
     * @param jefe
     * @param cia
     * @return 
     */
    public List<AccionPersonal> findAprobacionJefe(Long jefe, Long cia){
        List<AccionPersonal> listaAccion = new ArrayList<AccionPersonal>(0);
        
        Query acc = em.createQuery("select a from AccionPersonal a "
                +"where a.accionPersonalPK.codCia = :cia "
                +"and a.empleado.empleadoPK.codEmp = :jefe "
                +"and a.status = 'G'", AccionPersonal.class);
        acc.setParameter("cia", cia);
        acc.setParameter("jefe", jefe);
        listaAccion = (List<AccionPersonal>)acc.getResultList();
        
        return listaAccion;
    }
    
    /**
     * Listado de solicitudes de accion de personal a ser aprobadas por RRHH
     * @return 
     */
    public List<AccionPersonal> findAprobacionRRHH(){
        List<AccionPersonal> listaAccion = new ArrayList<AccionPersonal>(0);
        
        Query acc = em.createQuery("select a from AccionPersonal a "
                +"where a.status = 'J'", AccionPersonal.class);
        listaAccion = (List<AccionPersonal>)acc.getResultList();
        
        return listaAccion;
    }
    
    /**
     * Listado a acccion de personal aprobadas
     * @return 
     */
    public List<AccionPersonal> findAccionesAprobadas(){
        List<AccionPersonal> listaAccion = new ArrayList<AccionPersonal>(0);
        
        Query acc = em.createQuery("select a from AccionPersonal a "
                +"where a.status = 'B'", AccionPersonal.class);
        listaAccion = (List<AccionPersonal>)acc.getResultList();
        
        return listaAccion;
    }
    
    /**
     * Listado de acciones de personal segun tipo de acción
     * @param cia
     * @param tipo
     * @return 
     */
    public List<AccionPersonal> findByTipo(long cia, long tipo){
        List<AccionPersonal> listaAccion = new ArrayList<AccionPersonal>(0);
        
        Query acc = em.createQuery("select a from AccionPersonal a "
                +"where a.tipoAccion.tipoAccionPK.codCia = :cia "
                +"and a.tipoAccion.tipoAccionPK.codTipoaccion = :tipo", AccionPersonal.class);
        acc.setParameter("cia", cia);
        acc.setParameter("tipo", tipo);
        listaAccion = (List<AccionPersonal>)acc.getResultList();
        
        return listaAccion;
    }
    
    public List<AccionPersonal> findByNoAfecta(long cia){
        List<AccionPersonal> listaAccion = new ArrayList<AccionPersonal>(0);
        
        Query acc = em.createQuery("select a from AccionPersonal a "
                +"where a.tipoAccion.tipoAccionPK.codCia = :cia "
                +"and a.tipoAccion.afectaSal = 'N'", AccionPersonal.class);
        acc.setParameter("cia", cia);
        listaAccion = (List<AccionPersonal>)acc.getResultList();
        
        return listaAccion;
    }
    
}
