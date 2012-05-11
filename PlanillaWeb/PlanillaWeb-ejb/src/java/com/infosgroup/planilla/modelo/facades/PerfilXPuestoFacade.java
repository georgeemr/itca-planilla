/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.PerfilXPuesto;
import com.infosgroup.planilla.modelo.entidades.PerfilXPuestoPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PerfilXPuestoFacade extends AbstractFacade<PerfilXPuesto, PerfilXPuestoPK> {
    
    @PersistenceContext( unitName="PlanillaWeb-ejbPU" )
    private EntityManager em;
    
    public PerfilXPuestoFacade(){
        super(PerfilXPuesto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
 
    @PermitAll
    public List<PerfilXPuesto> findByEmpresa(Cias empresa){
        List<PerfilXPuesto> l = em.createQuery("PerfilXPuesto.findByCodCia", PerfilXPuesto.class).setParameter("codCia", empresa.getCodCia()).getResultList();
        return l!=null?l:new ArrayList<PerfilXPuesto>();
    }
    
}
