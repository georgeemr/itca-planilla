/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.NivelAcademico;
import com.infosgroup.planilla.modelo.entidades.NivelAcademicoPK;
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
public class NivelAcademicoFacade extends AbstractFacade<NivelAcademico, NivelAcademicoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelAcademicoFacade() {
        super(NivelAcademico.class);
    }

    public Short max(Cias cia) {
        Short max = (Short) getEntityManager().createQuery("SELECT max(n.nivelAcademicoPK.codNivelAcademico) FROM NivelAcademico n WHERE n.nivelAcademicoPK.codCia = :codCia").setParameter("codCia", cia.getCodCia()).getSingleResult();
        return (max == null) ? 1 : ++max;
    }
}
