/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.CausasRenuncia;
import com.infosgroup.planilla.modelo.entidades.CausasRenunciaPK;
import com.infosgroup.planilla.modelo.entidades.Cias;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class CausasRenunciaFacade extends AbstractFacade<CausasRenuncia, CausasRenunciaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public CausasRenunciaFacade() {
        super(CausasRenuncia.class);
    }
    
    @PermitAll
    public List<CausasRenuncia> findByCias( Cias cias ){
        List<CausasRenuncia> l = em.createQuery("SELECT c FROM CausasRenuncia c WHERE c.causasRenunciaPK.codCia = :codCia", CausasRenuncia.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return l!=null?l:new ArrayList<CausasRenuncia>();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}