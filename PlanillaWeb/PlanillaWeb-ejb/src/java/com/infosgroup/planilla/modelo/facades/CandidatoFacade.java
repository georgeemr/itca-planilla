/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CandidatoPK;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.estructuras.ModelConsultaCriterio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class CandidatoFacade extends AbstractFacade<Candidato, CandidatoPK> {

    private enum operacion {

        equal, between
    };
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CandidatoFacade() {
        super(Candidato.class);
    }

    public List<Candidato> findByCanditadoByEmpresa(Long empresa) {
        List<Candidato> listaCandidatos = new ArrayList<Candidato>();
        listaCandidatos.addAll(getEntityManager().createQuery("SELECT c FROM Candidato c WHERE c.candidatoPK.codCia = :codCia", Candidato.class).setParameter("codCia", empresa).getResultList());
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

    public List<Candidato> getCandidatoConCriteriosPuesto(Concurso c, String usuario) {
        List<Candidato> listaCandidatos = new ArrayList<Candidato>();
        for (Candidato candidato : findCandidatosAPreseleccionar(c)) {
            if (getCandidatosByCriterios(c.getConcursoPK().getCodCia(), c.getPuesto().getPuestoPK().getCodPuesto(), candidato.getCandidatoPK().getCodCandidato(), usuario) == 1) {
                listaCandidatos.add(candidato);
            }
        }
        return listaCandidatos;
    }

    private Integer getCandidatosByCriterios(Long empresa, Long puesto, Long candidato, String usuario) {
        String nativeQuery = "select distinct t.cod_cia, t.puesto, t.tipo_criterio, t.correlativo, t.valor, t.valor_inicial_rango, t.valor_final_rango, "
                + " u.operador,u.clase, "
                + " v.campo, v.entidad, v.entidadpk "
                + "from planilla.criterios_x_puesto t, planilla.criterio u, planilla.criterios_x_candidato v, planilla.criterio_seleccionado w "
                + "where t.cod_cia = ? and t.puesto = ? "
                + " and u.cod_cia = t.cod_cia "
                + " and u.tipo = t.tipo_criterio "
                + " and u.codigo = t.criterio "
                + " and v.cod_cia = u.cod_cia "
                + " and v.tipo_criterio = u.tipo "
                + " and v.criterio = u.codigo "
                + " and w.cod_cia = v.cod_cia "
                + " and w.codigo = v.criterio "
                + " and w.tipo = v.tipo_criterio "
                + " and w.usuario = ? union "
                + " select distinct t.cod_cia, t.puesto, t.tipo_criterio, t.correlativo, t.valor, t.valor_inicial_rango, t.valor_final_rango, "
                + " u.operador,u.clase, "
                + " v.campo, v.entidad, v.entidadpk "
                + "from planilla.criterios_x_puesto t, planilla.criterio u, planilla.criterios_x_candidato v, planilla.criterio_seleccionado w "
                + "where t.cod_cia = ? "
                + " and u.cod_cia = t.cod_cia "
                + " and u.tipo = t.tipo_criterio "
                + " and u.codigo = t.criterio "
                + " and v.cod_cia = u.cod_cia "
                + " and v.tipo_criterio = u.tipo "
                + " and v.criterio = u.codigo "
                + " and w.cod_cia = v.cod_cia "
                + " and w.codigo = v.criterio "
                + " and w.tipo = v.tipo_criterio "
                + " and w.usuario = ? ";
        for (Object o : getEntityManager().createNativeQuery(nativeQuery).setParameter(1, empresa).setParameter(2, puesto).setParameter(3, usuario).setParameter(4, empresa).setParameter(5, usuario).getResultList()) {
            ModelConsultaCriterio model = new ModelConsultaCriterio((Object[]) o);
            Object t = getEntityManager().createQuery("SELECT v." + model.getCampo() + " FROM " + model.getEntidad() + " v WHERE v." + model.getEntidadPK().split(":")[0] + " = " + empresa + " AND v." + model.getEntidadPK().split(":")[1] + " =  " + candidato).setMaxResults(1).getSingleResult();
            if (model.getOperacion().equals(operacion.equal.toString())) {
                if (model.getValor() == null) {
                    return 0;
                }
                if (model.getClase().equals("java.lang.String")) {
                    try {
                        if (!t.toString().equals(model.getValor().toString())) {
                            return 0;
                        }
                    } catch (Exception e) {
                        return 0;
                    }
                } else if (model.getClase().equals("java.lang.Integer")) {
                    try {
                        if (!t.toString().equals(model.getValor().toString())) {
                            return 0;
                        }
                    } catch (Exception e) {
                        return 0;
                    }

                } else if (model.getClase().equals("java.util.Date")) {
                    try {
                        if (!new SimpleDateFormat("dd/MM/yyyy").format((Date) t).equals(new SimpleDateFormat("dd/MM/yyyy").format(model.getValor().toString()))) {
                            return 0;
                        }
                    } catch (Exception e) {
                        return 0;
                    }
                }
            } else if (model.getOperacion().equals(operacion.between.toString())) {
                if (model.getValorInicialRango() == null || model.getValorInicialRango() == null) {
                    return 0;
                }

                if (model.getClase().equals("java.lang.Integer")) {
                    try {
                        if (!(new Integer(t.toString()) >= new Integer(model.getValorInicialRango().toString()) && new Integer(t.toString()) <= new Integer(model.getValorInicialRango().toString()))) {
                            return 0;
                        }
                    } catch (Exception e) {
                        return 0;
                    }

                } else if (model.getClase().equals("java.util.Date")) {
                    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date a = null, b = null, c = null;
                    try {
                        a = (Date) t;
                        b = f.parse(model.getValorInicialRango());
                        c = f.parse(model.getValorFinalRango());
                    } catch (ParseException ex) {
                        Logger.getLogger(CandidatoFacade.class.getName()).log(Level.SEVERE, null, ex);
                        return 0;
                    }
                    try {
                        if (!(a.compareTo(b) >= 0 && a.compareTo(c) <= 0)) {
                            return 0;
                        }
                    } catch (Exception e) {
                        return 0;
                    }
                }
            }
        }

        return 1;
    }
}