/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Indicador;
import com.infosgroup.planilla.modelo.entidades.IndicadorPK;
import com.infosgroup.planilla.modelo.estructuras.ModelIndicadores;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Soporte
 */
@Stateless
public class IndicadorFacade extends AbstractFacade<Indicador, IndicadorPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IndicadorFacade() {
        super(Indicador.class);
    }

    @PermitAll
    public List<Indicador> findIndicadoresByCias(Cias cias) {
        List<Indicador> i = em.createNativeQuery("SELECT * FROM Indicador i WHERE i.cod_Cia = ? ORDER BY i.nombre_Indicador", Indicador.class).setParameter(1, cias.getCodCia()).getResultList();
        return i != null ? i : new ArrayList<Indicador>();
    }

    @PermitAll
    public void calcularIndicadores(Cias empresa, Date fechaInicial, Date fechaFinal) {
        try {
            Query query = em.createNativeQuery("begin pkg_indicadores.calcular_indicadores( ?, ?, ? ); end;");
            query.setParameter(1, empresa.getCodCia());
            query.setParameter(2, fechaInicial);
            query.setParameter(3, fechaFinal);
            query.executeUpdate();
        } catch (Exception excpt) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Ha ocurrido la siguiente excepción: ", excpt);
        }
    }

    @PermitAll
    public List<ModelIndicadores> listaIndicadores(Cias cias) {
        List<Indicador> listaIndicadores = findIndicadoresByCias(cias);
        if (listaIndicadores == null) {
            return new ArrayList<ModelIndicadores>();
        }
        List<ModelIndicadores> indicadores = new ArrayList<ModelIndicadores>();
        List<String> categorias = new ArrayList<String>();
        for (Indicador i : listaIndicadores) {
            categorias.add(i.getNombreModulo());
        }
        Set t = new HashSet();
        t.addAll(categorias);
        categorias.clear();
        categorias.addAll(t);
        for (String i : categorias) {
            ModelIndicadores m = new ModelIndicadores();
            m.setCategoria(i);
            m.setListaIndicadores(new ArrayList<Indicador>());
            for (Indicador e : listaIndicadores) {
                if (e.getNombreModulo().equals(i)) {
                    m.getListaIndicadores().add(e);
                }
            }
            indicadores.add(m);
        }
        return indicadores;
    }
}
