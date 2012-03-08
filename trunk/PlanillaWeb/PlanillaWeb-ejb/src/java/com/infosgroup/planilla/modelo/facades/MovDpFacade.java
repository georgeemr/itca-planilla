/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.MovDp;
import com.infosgroup.planilla.modelo.entidades.MovDpPK;
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
public class MovDpFacade extends AbstractFacade<MovDp, MovDpPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public MovDpFacade() {
        super(MovDp.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PermitAll
    public void eliminarMovimientosDP(Short empresa, Short anio, Short mes, Short tipoPlanilla, Short numeroplanilla, Short deduccionPrestacion) {
        em.createNativeQuery("delete mov_dp where cod_cia = ? and anio = ? and mes = ? and cod_tipopla = ? and num_planilla = ? and generado = 'N' and cod_presta = ? ").
                setParameter(1, empresa).setParameter(2, anio).setParameter(3, mes).setParameter(4, tipoPlanilla).setParameter(5, numeroplanilla).setParameter(6, deduccionPrestacion).executeUpdate();
    }

    public Integer max(Short codCia, Short anio, Short mes, Short numPlanilla) {
        Integer max = (Integer) getEntityManager().createQuery("select max(m.movDpPK.noMovto) from MovDp m where m.movDpPK.codCia = :codCia AND m.movDpPK.anio = :anio AND m.movDpPK.mes = :mes AND m.movDpPK.numPlanilla = :numPlanilla").setParameter("codCia", codCia).setParameter("anio", anio).setParameter("mes", mes).setParameter("numPlanilla", numPlanilla).getSingleResult();
        return (max == null) ? 1 : ++max;
    }

    public MovDpPK getMovDpPK(MovDpPK pk) {
        pk.setNoMovto(max(pk.getCodCia(), pk.getAnio(), pk.getMes(), pk.getNumPlanilla()));
        return pk;
    }
}
