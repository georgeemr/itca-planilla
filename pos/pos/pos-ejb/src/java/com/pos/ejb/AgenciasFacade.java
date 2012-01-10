/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.ejb;

import com.pos.entity.Agencias;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Soporte
 */
@Stateless
public class AgenciasFacade extends AbstractFacade<Agencias> {

    @PersistenceContext(unitName = "pos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgenciasFacade() {
        super(Agencias.class);
    }

    public List<Agencias> getAgenciasPorCIA(Integer cia) {
        Query q = getEntityManager().createQuery("select a from Agencias a where a.agenciasPK.codCia = :codCia", Agencias.class);
        q.setParameter("codCia", cia);
        return q.getResultList();
    }

    public List<Agencias> getAgenciasAConsultar() {
        Query q = getEntityManager().createQuery("SELECT a FROM Agencias a WHERE a.tipo = :tipo", Agencias.class);
        q.setParameter("tipo", "O");
        return q.getResultList();
    }

    public List<Agencias> getAgenciasAConsultar(Integer cia) {
        String query = "select * from ( select * from agencias "
                + "union "
                + "select " + cia + " as cod_cia, 0 as cod_agencia, 'TODAS' as nom_agencia, trunc(sysdate) as fec_creacion, 'A' as status, '' as dir_agencia, '' as tel_agencia, '' as fax_agencia, '' as mail_agencia, '' as encargado, trunc(sysdate) as fec_status, '' as abrev, '' as url, '' as usuario, '' as pass, '' as sid, '' as ip, '' as tipo  from dual ) a where a.cod_cia = ?";
        Query q = getEntityManager().createNativeQuery(query, Agencias.class);
        q.setParameter(1, cia);
        return q.getResultList();
    }
}
