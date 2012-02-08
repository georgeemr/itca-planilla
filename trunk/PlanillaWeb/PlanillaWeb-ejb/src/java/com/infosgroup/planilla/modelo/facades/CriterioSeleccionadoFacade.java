/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.CriterioSeleccionado;
import com.infosgroup.planilla.modelo.entidades.CriterioSeleccionadoPK;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.security.PermitAll;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class CriterioSeleccionadoFacade extends AbstractFacade<CriterioSeleccionado, CriterioSeleccionadoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;
    private static String DELETE_NATIVE_QUERY = "delete from criterio_seleccionado where cod_cia = ? and usuario = ? ";

    public CriterioSeleccionadoFacade() {
        super(CriterioSeleccionado.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PermitAll
    public void eliminarCriteriosSeleccionados(Cias empresa, String usuario) {
        getEntityManager().createNativeQuery(DELETE_NATIVE_QUERY).setParameter(1, empresa.getCodCia()).setParameter(2, usuario).executeUpdate();
    }

    private Long correlativo(String usuario) {
        Long n = (Long) getEntityManager().createQuery("SELECT MAX(c.criterioSeleccionadoPK.correlativo) FROM CriterioSeleccionado c WHERE c.criterioSeleccionadoPK.usuario = :usuario ").setParameter("usuario", usuario).getSingleResult();
        return n != null ? ++n : new Long("1");
    }

    public void guardarCriterio(CriteriosXPuesto cxp, String usuario) {
        CriterioSeleccionado cs = new CriterioSeleccionado(cxp.getCriteriosXPuestoPK().getCodCia(), correlativo(usuario).longValue(), usuario);
        cs.setCodigo(cxp.getCriterio1().getCriterioPK().getCodigo());
        cs.setTipo(cxp.getCriterio1().getCriterioPK().getTipo());
        create(cs);
    }

    public void eliminarCriterio(CriteriosXPuesto cxp, String usuario) {
        int i = getEntityManager().createNativeQuery(DELETE_NATIVE_QUERY + " and codigo = ? and tipo = ? ").setParameter(1, cxp.getCriterio1().getCriterioPK().getCodCia()).setParameter(2, usuario).setParameter(3, cxp.getCriterio1().getCriterioPK().getCodigo()).setParameter(4, cxp.getCriterio1().getCriterioPK().getTipo()).executeUpdate();
    }
    
}