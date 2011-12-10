/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.CandidatoPK;
import com.infosgroup.planilla.modelo.entidades.Concurso;
import com.infosgroup.planilla.modelo.entidades.ConcursoPK;
import com.infosgroup.planilla.modelo.entidades.CriteriosXPuesto;
import com.infosgroup.planilla.modelo.estructuras.ModelConsultaCriterio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
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

    

    private enum operacion { equal, between };
    
    
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

    public List<Candidato> getCandidatoConCriteriosPuesto(Concurso c, List<String> criterios) {
        List<Candidato> listaCandidatos = new ArrayList<Candidato>();
        for ( Candidato candidato:  findByCanditadoByEmpresa( c.getConcursoPK().getCodCia() )  ){
            if ( validaCriterios( c.getConcursoPK().getCodCia(), c.getPuesto().getPuestoPK().getCodPuesto(), candidato.getCandidatoPK().getCodCandidato(), criterios) == 1 ){
                listaCandidatos.add( candidato );
            }
        }
        return listaCandidatos;
    }

    public Integer validaCriterios(Integer empresa, Integer puesto, Integer candidato, List<String> criterios) {
        //codCia + ":" + puesto + ":" + criterio + ":" + correlativo + ":" + tipoCriterio;
        /*String cq = "";
        
        for (String qt: criterios ){
            cq = qt.split(":")[0] + qt.split(":")[2] + qt.split(":")[4];
        }*/
        
        String q ="SELECT t.criteriosXPuestoPK.codCia, t.criteriosXPuestoPK.puesto, "
                + " t.criteriosXPuestoPK.tipoCriterio, t.criteriosXPuestoPK.correlativo, "
                + " t.valor, t.valorInicialRango, t.valorFinalRango,  "
                + " u.operador, u.clase, v.campo, v.entidad, v.entidadPK, u "
                + "FROM CriteriosXPuesto t JOIN t.criterio1 u JOIN u.criteriosXCandidatoList v "
                + "WHERE t.criteriosXPuestoPK.codCia = :codCia AND t.criteriosXPuestoPK.puesto = :puesto";
        for (Object o : getEntityManager().createQuery(q).setParameter("codCia", empresa).setParameter("puesto", puesto).getResultList()) {
            ModelConsultaCriterio model = new ModelConsultaCriterio((Object[]) o);
            Object t = getEntityManager().createQuery("SELECT v." + model.getCampo() + " FROM " + model.getEntidad() + " v WHERE v." + model.getEntidadPK().split(":")[0]+ " = " + empresa + " AND v." + model.getEntidadPK().split(":")[1] + " =  " + candidato).setMaxResults(1).getSingleResult();
            if (model.getOperacion().equals(operacion.equal.toString())) {
                if (model.getValor() == null){ return 0; }
                if (model.getClase().equals("java.lang.String")) {
                    if ( !t.toString().equals( model.getValor().toString() )) return 0;
                } else if (model.getClase().equals("java.lang.Integer")) {
                    if ( !t.toString().equals(model.getValor().toString())) return 0;
                } else if (model.getClase().equals("java.util.Date")) {
                    if (! new SimpleDateFormat("dd/MM/yyyy").format((Date) t).equals(new SimpleDateFormat("dd/MM/yyyy").format(model.getValor().toString()))) { return 0; }
                }
            } else if (model.getOperacion().equals(operacion.between.toString())) {
                if (model.getValorInicialRango() == null || model.getValorInicialRango() == null){ return 0; }
                
                if (model.getClase().equals("java.lang.Integer")) {
                    if (!( new Integer(t.toString()) >= new Integer(model.getValorInicialRango().toString()) && new Integer(t.toString()) <= new Integer(model.getValorInicialRango().toString()))) 
                       { return 0; }
                } else if (model.getClase().equals("java.util.Date")) {
                    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date a = null, b = null, c = null;
                    try {
                        a = (Date) t;
                        b = f.parse(model.getValorInicialRango());
                        c = f.parse(model.getValorFinalRango());
                    } catch (ParseException ex) {
                        Logger.getLogger(CandidatoFacade.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (!(a.compareTo(b) >= 0 && a.compareTo(c) <= 0)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
}
