/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Perfil;
import com.infosgroup.planilla.modelo.entidades.PerfilPK;
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
public class PerfilFacade extends AbstractFacade<Perfil, PerfilPK> {

    @PersistenceContext(unitName="PlanillaWeb-ejbPU")
    private EntityManager em;
    
    public PerfilFacade(){
        super(Perfil.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @PermitAll
    public List<Perfil> findByEmpresa(Cias empresa){
        List<Perfil> l = em.createNamedQuery("Perfil.findByCodCia", Perfil.class).setParameter("codCia", empresa.getCodCia()).getResultList();
        return l!=null?l:new ArrayList<Perfil>();
    }
}
