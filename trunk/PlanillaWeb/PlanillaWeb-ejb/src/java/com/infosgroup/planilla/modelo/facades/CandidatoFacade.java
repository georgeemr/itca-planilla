/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CandidatoPK;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
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

    public List<Candidato> findByCanditadoByEmpresa(Cias empresa) {
        List<Candidato> listaCandidatos = new ArrayList<Candidato>();
        listaCandidatos.addAll(getEntityManager().createQuery("SELECT c FROM Candidato c WHERE c.candidatoPK.codCia = :codCia", Candidato.class).setParameter("codCia", empresa.getCodCia()).getResultList());
        return listaCandidatos;
    }

    public List<Candidato> findCandidatosAPreseleccionar(Concurso c) {
        if (c == null) {
            return new ArrayList<Candidato>();
        }
        List<Candidato> listaCandidatos = new ArrayList<Candidato>();
        listaCandidatos.addAll(getEntityManager().createNativeQuery("select * from candidato c where c.cod_cia = ? and (cod_cia, cod_candidato) not in ( select cod_cia, candidato from candidato_concurso where cod_cia = c.cod_cia and concurso = ? )", Candidato.class).setParameter(1, c.getConcursoPK().getCodCia()).setParameter(2, c.getConcursoPK().getCodConcurso()).getResultList());
        return listaCandidatos;
    }

    public List<Candidato> findByConcurso(Concurso c) {
        if (c == null) {
            return new ArrayList<Candidato>();
        }
        List<Candidato> listaCandidatos = new ArrayList<Candidato>();
        listaCandidatos.addAll(getEntityManager().createNativeQuery("select distinct b.* from candidato_concurso a, candidato b where a.cod_cia = ? and a.concurso = ? and b.cod_cia = a.cod_cia and a.candidato = b.cod_candidato", Candidato.class).setParameter(1, c.getConcursoPK().getCodCia()).setParameter(2, c.getConcursoPK().getCodConcurso()).getResultList());
        return listaCandidatos;
    }

    public void preseleccionarCandidato(Concurso c, List<Candidato> candidatos) {
        for (Candidato z : candidatos) {
            getEntityManager().createNativeQuery("insert into candidato_concurso values (?, ?, ?, ?)").setParameter(1, c.getConcursoPK().getCodCia()).setParameter(2, z.getCandidatoPK().getCodCandidato()).setParameter(3, "P").setParameter(4, c.getConcursoPK().getCodConcurso()).executeUpdate();
        }
    }

    @PermitAll
    public List<Candidato> getCandidatoConCriteriosPuesto(Concurso c, String usuario, Integer maxRegistros) {
        List<Candidato> listaCandidatos = new ArrayList<Candidato>();
        StringBuilder query = new StringBuilder();
        query.append("select * from candidato ");
        query.append("where cod_cia = ").append(" ? ");
        query.append("and pkg_web_rh_humanos.candidato_valido( ").append( " ? " );
        query.append(", cod_candidato, ").append(" ? ");
        query.append(", ").append(" ? ").append(" ) = 1 ").append(" and rownum <= ").append( maxRegistros != null ? maxRegistros:10 ).append(" order by nombre,apellido");
        listaCandidatos = em.createNativeQuery(query.toString(),Candidato.class)
                .setParameter(1, c.getConcursoPK().getCodCia())
                .setParameter(2, c.getConcursoPK().getCodCia())
                .setParameter(3, c.getConcursoPK().getCodConcurso())
                .setParameter(4, usuario)
                .getResultList();
        return listaCandidatos != null ? listaCandidatos:new ArrayList<Candidato>() ;
    }
    
    @PermitAll
    public List<Candidato> findCandidatosLikeEmpleados(Cias cias) {
        List<Candidato> listaCandidatos = new ArrayList<Candidato>();
        StringBuilder query = new StringBuilder();
        query.append("select distinct * from candidato where ( cod_cia, cod_emp ) in ( select cod_cia, cod_emp from empleados where cod_cia = ? )");
        listaCandidatos = em.createNativeQuery(query.toString(),Candidato.class).setParameter(1, cias.getCodCia()).getResultList();
        return listaCandidatos != null ? listaCandidatos:new ArrayList<Candidato>() ;
    }

    public Integer max(Cias empresa) {
        Integer max = (Integer) em.createQuery("SELECT max(c.candidatoPK.codCandidato) FROM Candidato c WHERE c.candidatoPK.codCia = :codCia").setParameter("codCia", empresa.getCodCia()).getSingleResult();
        return max != null ? ( ++max ): 1;
    }
}