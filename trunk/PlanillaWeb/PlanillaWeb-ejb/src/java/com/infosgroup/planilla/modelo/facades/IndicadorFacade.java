/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Indicador;
import com.infosgroup.planilla.modelo.entidades.IndicadorPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Soporte
 */
@Stateless
public class IndicadorFacade extends AbstractFacade<Indicador, IndicadorPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IndicadorFacade() {
        super(Indicador.class);
    }
    
    public List<Indicador> findIndicadoresByCias(Cias cias){
        List<Indicador> i = em.createQuery("SELECT i FROM Indicador i WHERE i.indicadorPK.codCia = :codCia ORDER BY i.nombreIndicador" , Indicador.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return i!=null?i:new ArrayList<Indicador>();
    }
}
