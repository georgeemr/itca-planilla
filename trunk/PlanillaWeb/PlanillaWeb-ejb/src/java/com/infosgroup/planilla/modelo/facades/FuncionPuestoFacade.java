/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.FuncionPuesto;
import com.infosgroup.planilla.modelo.entidades.FuncionPuestoPK;
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
public class FuncionPuestoFacade extends AbstractFacade<FuncionPuesto, FuncionPuestoPK> {

    @PersistenceContext(unitName="PlanillaWeb-ejbPU")
    private EntityManager em;
    
    public FuncionPuestoFacade(){
        super(FuncionPuesto.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @PermitAll
    public List<FuncionPuesto> findByEmpresa(Cias empresa){
        List<FuncionPuesto> l = em.createNamedQuery("FuncionPuesto.findByCodCia", FuncionPuesto.class).setParameter("codCia", empresa.getCodCia()).getResultList();
        return l!=null?l:new ArrayList<FuncionPuesto>();
    }
}
