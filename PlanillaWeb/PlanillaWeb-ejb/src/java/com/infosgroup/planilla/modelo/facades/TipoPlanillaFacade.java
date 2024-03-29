/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanillaPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
public class TipoPlanillaFacade extends AbstractFacade<TiposPlanilla, TiposPlanillaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPlanillaFacade() {
        super(TiposPlanilla.class);
    }

    @PermitAll
    public List<TiposPlanilla> findByCompania(Cias compania) {
        List<TiposPlanilla> lista = null;
        TypedQuery<TiposPlanilla> q = em.createQuery("SELECT t FROM TiposPlanilla t WHERE t.tiposPlanillaPK.codCia = :codCia and t.status = 'A'  ORDER BY t.nomTipopla ASC", TiposPlanilla.class).setParameter("codCia", compania.getCodCia());
        lista = q.getResultList();
        return lista != null ? lista : new ArrayList<TiposPlanilla>(0);
    }

    @PermitAll
    public List<TiposPlanilla> findByEmpleados(Empleados empleado) {
        List<TiposPlanilla> lista = em.createNativeQuery("select * from tipos_planilla where (cod_cia, cod_tipopla) in ( select unique cod_cia, cod_tipopla from planilla where cod_cia = ? and cod_emp = ? ) order by nom_tipopla asc ", TiposPlanilla.class)
                .setParameter(1, empleado.getEmpleadosPK().getCodCia())
                .setParameter(2, empleado.getEmpleadosPK().getCodEmp())
                .getResultList();
        return lista != null ? lista : new ArrayList<TiposPlanilla>(0);
    }

    public short max(Cias cias) {
        Short max = (Short) getEntityManager().createQuery("SELECT max(t.tiposPlanillaPK.codTipopla) FROM TiposPlanilla t WHERE t.tiposPlanillaPK.codCia = :codCia").setParameter("codCia", cias.getCodCia()).getSingleResult();
        return (max == null) ? 1 : ++max;
    }
}
