/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.TipoContrato;
import com.infosgroup.planilla.modelo.entidades.TipoContratoPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gabriel Bran
 */
@Stateless
@LocalBean
public class TipoContratoFacade extends AbstractFacade<TipoContrato, TipoContratoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public TipoContratoFacade() {
        super(TipoContrato.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PermitAll
    public List<TipoContrato> getTipoContratoByEmpresa( Long empresa ) {
        List<TipoContrato> l = new ArrayList<TipoContrato>();
        l.addAll( em.createQuery("SELECT t FROM TipoContrato t WHERE t.tipoContratoPK.codCia = :codCia", TipoContrato.class).setParameter("codCia", empresa) .getResultList() );
        return l;
    }
}
