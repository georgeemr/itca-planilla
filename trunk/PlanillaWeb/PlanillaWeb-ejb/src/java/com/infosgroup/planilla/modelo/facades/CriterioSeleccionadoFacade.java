/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.CriterioSeleccionado;
import com.infosgroup.planilla.modelo.entidades.CriterioSeleccionadoPK;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
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

    public CriterioSeleccionadoFacade() {
        super(CriterioSeleccionado.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PermitAll
    public Integer eliminarCriterioSeleccionado(String usuario) {
        return getEntityManager().createNativeQuery("delete from criterio_seleccionado where usuario = '" + usuario +"'").executeUpdate();
    }

    public void seleccionarCriterio(String usuario, List<String> listaCriterios) {
        for (String l : listaCriterios) {
            CriterioSeleccionado x = new CriterioSeleccionado(new Long(l.split(":")[0]), correlativo(usuario).longValue(), usuario);
            x.setCodigo(new Long(l.split(":")[1]));
            x.setTipo(new Long(l.split(":")[2]));
            create(x);
        }
    }

    private BigDecimal correlativo(String usuario) {
        BigDecimal n = (BigDecimal) getEntityManager().createQuery("SELECT MAX(c.correlativo) FROM CriterioSeleccionado c WHERE c.usuario = '" +usuario +"'").getSingleResult();
        return n != null ? n : new BigDecimal(BigInteger.ONE);
    }
}
