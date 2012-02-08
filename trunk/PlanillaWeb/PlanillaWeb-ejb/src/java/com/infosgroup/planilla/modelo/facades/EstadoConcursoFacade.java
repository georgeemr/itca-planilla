/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.EstadoConcurso;
import com.infosgroup.planilla.modelo.entidades.EstadoConcursoPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class EstadoConcursoFacade extends AbstractFacade<EstadoConcurso, EstadoConcursoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public EstadoConcursoFacade() {
        super(EstadoConcurso.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<EstadoConcurso> findEstadoConcursoByEmpresa(Cias empresa) {
        List<EstadoConcurso> puestos = new ArrayList<EstadoConcurso>();
        puestos.addAll(getEntityManager().createNamedQuery("EstadoConcurso.findByCodCia", EstadoConcurso.class).setParameter("codCia", empresa.getCodCia()).getResultList());
        return puestos;
    }
}
