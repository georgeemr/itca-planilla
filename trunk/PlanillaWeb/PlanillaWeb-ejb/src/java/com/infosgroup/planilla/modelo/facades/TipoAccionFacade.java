/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.TipoAccion;
import com.infosgroup.planilla.modelo.entidades.TipoAccionPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class TipoAccionFacade extends AbstractFacade<TipoAccion, TipoAccionPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoAccionFacade() {
        super(TipoAccion.class);
    }

    @PermitAll
    public List<TipoAccion> findByAfecta(Cias cias, String afecta) {
        List<TipoAccion> listaTipo = em.createQuery("SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codCia = :codCia AND t.afectaSal = :afectaSal ", TipoAccion.class).setParameter("codCia", cias.getCodCia()).setParameter("afectaSal", afecta).getResultList();
        return listaTipo != null ? listaTipo : new ArrayList<TipoAccion>();
    }

    @PermitAll
    public List<TipoAccion> listarTipoAccionActivas(Cias cias) {
        List<TipoAccion> listaTipo = em.createQuery("SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codCia = :codCia AND t.estado = 'A' ORDER BY t.nomTipoaccion", TipoAccion.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return listaTipo != null ? listaTipo : new ArrayList<TipoAccion>();
    }

    @PermitAll
    public List<TipoAccion> listarTipoAccionByCias(Cias cias) {
        List<TipoAccion> listaTipo = em.createQuery("SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codCia = :codCia ORDER BY t.nomTipoaccion", TipoAccion.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return listaTipo != null ? listaTipo : new ArrayList<TipoAccion>();
    }

    @PermitAll
    public List<TipoAccion> listarTipoAccionAfectaPlanilla(Cias cias, String rol) {
        //List<TipoAccion> listaTipo = em.createQuery("SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codCia = :codCia AND t.estado = 'A' AND t.afectaSal = 'S' ORDER BY t.nomTipoaccion", TipoAccion.class).setParameter("codCia", cias.getCodCia()).getResultList();
        StringBuilder query = new StringBuilder();
        query.append("select c.* from rol a, acciones_x_rol b, tipo_accion c ");
        query.append("where a.cod_cia = ? and a.nom_rol = ? ");
        query.append("and b.cod_cia = a.cod_cia and b.cod_rol = a.cod_rol ");
        query.append("and c.cod_cia = b.cod_cia and c.cod_tipoaccion = b.cod_tipoaccion and c.estado = 'A' and c.afecta_sal = 'S' ");
        query.append("order by c.nom_tipoaccion");
        List<TipoAccion> listaTipo = em.createNativeQuery(query.toString(), TipoAccion.class).setParameter(1, cias.getCodCia()).setParameter(2, rol).getResultList();
        return listaTipo != null ? listaTipo : new ArrayList<TipoAccion>();
    }

    @PermitAll
    public List<TipoAccion> listarTipoAccionNoAfectaPlanilla(Cias cias, String rol) {
        //List<TipoAccion> listaTipo = em.createQuery("SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codCia = :codCia AND t.estado = 'A' AND t.afectaSal = 'N' ORDER BY t.nomTipoaccion", TipoAccion.class).setParameter("codCia", cias.getCodCia()).getResultList();
        StringBuilder query = new StringBuilder();
        query.append("select c.* from rol a, acciones_x_rol b, tipo_accion c ");
        query.append("where a.cod_cia = ? and a.nom_rol = ? ");
        query.append("and b.cod_cia = a.cod_cia and b.cod_rol = a.cod_rol ");
        query.append("and c.cod_cia = b.cod_cia and c.cod_tipoaccion = b.cod_tipoaccion and c.estado = 'A' and c.afecta_sal = 'N' ");
        query.append("order by c.nom_tipoaccion");
        List<TipoAccion> listaTipo = em.createNativeQuery(query.toString(), TipoAccion.class).setParameter(1, cias.getCodCia()).setParameter(2, rol).getResultList();
        return listaTipo != null ? listaTipo : new ArrayList<TipoAccion>();
    }

    @PermitAll
    public List<TipoAccion> findByTipoAccionRetiro(Cias cias) {
        List<TipoAccion> listaTipo = em.createQuery("SELECT t FROM TipoAccion t WHERE t.tipoAccionPK.codCia = :codCia AND t.afectaSal = 'N' AND t.estado = 'A' and t.tipoAccionPK.codTipoaccion in (10, 15)", TipoAccion.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return listaTipo != null ? listaTipo : new ArrayList<TipoAccion>();
    }
}
