/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CandidatoPK;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class CandidatoFacade extends AbstractFacade<Candidato, CandidatoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CandidatoFacade() {
        super(Candidato.class);
    }

    public List<Candidato> findByCanditadoByEmpresa(Integer empresa) {
        List<Candidato> listaCandidatos = new ArrayList<Candidato>();
        listaCandidatos.addAll(getEntityManager().createQuery("SELECT c FROM Candidato c WHERE c.candidatoPK.codCia = :codCia", Candidato.class).setParameter("codCia", empresa).getResultList());
        return listaCandidatos;
    }

    public List<Candidato> getCandidatoConCriteriosPuesto(Concurso c) {
        List<Candidato> listaCandidatos = new ArrayList<Candidato>();
        String q = "SELECT c FROM Candidato c WHERE c.candidatoPK.codCia = " + c.getConcursoPK().getCodCia();

        listaCandidatos.addAll(/**/getEntityManager().createQuery(q, Candidato.class).getResultList()/**/);
        return listaCandidatos;
    }

    public Integer validaCriterios(Integer empresa, Integer puesto) {
        String q = "SELECT "
                + " t.criteriosXPuestoPK.codCia, "
                + " t.criteriosXPuestoPK.puesto, "
                + " t.criteriosXPuestoPK.tipoCriterio, "
                + " t.criteriosXPuestoPK.correlativo, "
                + " t.valor,  "
                + " t.valorInicialRango,  "
                + " t.valorFinalRango,  "
                + " u.operador, "
                + " v.clase, "
                + " v.campo "
                + "FROM CriteriosXPuesto t JOIN t.criterio1 u JOIN u.criteriosXCandidatoList v "
                + "WHERE t.criteriosXPuestoPK.codCia = :codCia AND t.criteriosXPuestoPK.puesto = :puesto";

        for (Object o : getEntityManager().createQuery(q).setParameter("codCia", empresa).setParameter("puesto", puesto).getResultList()) {
            Object[] s = (Object[]) o;
            System.out.println("objeto " + s[0]);
        }
        return null;
    }
}
