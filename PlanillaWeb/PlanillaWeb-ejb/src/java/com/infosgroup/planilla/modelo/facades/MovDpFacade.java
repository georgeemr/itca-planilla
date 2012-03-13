/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.MovDp;
import com.infosgroup.planilla.modelo.entidades.MovDpPK;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    public List<MovDp> movimientosEliminarDP(Short empresa, Short anio, Short mes, Short tipoPlanilla, Short numeroplanilla, Short deduccionPrestacion) {
        List<MovDp> e=em.createNativeQuery("select * from mov_dp where cod_cia = ? and anio = ? and mes = ? and cod_tipopla = ? and num_planilla = ? and generado = 'N' and cod_dp = ? ", MovDp.class).
                setParameter(1, empresa).setParameter(2, anio).setParameter(3, mes).setParameter(4, tipoPlanilla).setParameter(5, numeroplanilla).setParameter(6, deduccionPrestacion).getResultList();
        return e!=null?e:new ArrayList<MovDp>();
    }

    public Integer max(Short codCia, Short anio, Short mes, Short numPlanilla) {
        Integer max = (Integer) getEntityManager().createQuery("select max(m.movDpPK.noMovto) from MovDp m where m.movDpPK.codCia = :codCia AND m.movDpPK.anio = :anio AND m.movDpPK.mes = :mes AND m.movDpPK.numPlanilla = :numPlanilla").setParameter("codCia", codCia).setParameter("anio", anio).setParameter("mes", mes).setParameter("numPlanilla", numPlanilla).getSingleResult();
        return (max == null) ? 1 : ++max;
    }

    public MovDpPK getMovDpPK(MovDpPK pk) {
        pk.setNoMovto(max(pk.getCodCia(), pk.getAnio(), pk.getMes(), pk.getNumPlanilla()));
        return pk;
    }
    
    public List<MovDp> movimientosByPlanilla(Planilla planilla, String sumaResta) {
        List<MovDp> listmov = new ArrayList<MovDp>(0);
        TypedQuery<MovDp> q = em.createQuery("select m from MovDp m where m.resumenAsistencia.planilla = :planilla and m.sumaResta = :sumaResta", MovDp.class).setParameter("planilla", planilla).setParameter("sumaResta", sumaResta);
        listmov = q.getResultList();
        return listmov != null ? listmov : new ArrayList<MovDp>();
    }
}
