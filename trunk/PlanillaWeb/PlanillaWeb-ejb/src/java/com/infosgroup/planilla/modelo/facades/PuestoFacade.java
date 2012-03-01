/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Puestos;
import com.infosgroup.planilla.modelo.entidades.PuestosPK;
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
public class PuestoFacade extends AbstractFacade<Puestos, PuestosPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Puestos> findPuestoByEmpresa(Cias cias) {
        List<Puestos> puestos = new ArrayList<Puestos>();
        puestos = getEntityManager().createQuery("SELECT p FROM Puestos p WHERE p.puestosPK.codCia = :codCia AND p.status = 'A' ORDER BY p.nomPuesto ASC", Puestos.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return puestos != null ? puestos : new ArrayList<Puestos>();
    }

    @PermitAll
    public Short max(Cias cias) {
        Short max = (Short) getEntityManager().createQuery("SELECT max(p.puestosPK.codPuesto) FROM Puestos p WHERE p.puestosPK.codCia = :codCia").setParameter("codCia", cias.getCodCia()).getSingleResult();
        return (max == null) ? new Short("1") : ++max;
    }

    public PuestoFacade() {
        super(Puestos.class);
    }
}
