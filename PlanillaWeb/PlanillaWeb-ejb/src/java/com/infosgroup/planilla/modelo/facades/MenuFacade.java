/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Menu;
import com.infosgroup.planilla.modelo.entidades.MenuPK;
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
public class MenuFacade extends AbstractFacade<Menu, MenuPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menu.class);
    }

    @PermitAll
    public List<Menu> findAllEnOrden(Cias c, String rol) {
        //TypedQuery<Menu> tq = em.createQuery("SELECT m FROM Menu m WHERE m.nivel = 1 AND m.estado = 1 ORDER BY m.menuPK.codMenu", Menu.class);
        List<Menu> l = em.createNativeQuery("select a.* from menu a, menu_rol b where a.cod_cia = ? and a.estado=1 and a.nivel=1 "
                + " and b.cod_cia = a.cod_cia and b.cod_modulo=a.cod_modulo "
                + " and b.cod_menu=a.cod_menu and b.cod_rol = ? order by a.cod_menu asc", Menu.class).setParameter(1, c.getCodCia()).setParameter(2, rol).getResultList();
        return l != null ? l : new ArrayList<Menu>();
    }

    @PermitAll
    public List<Menu> findAllSubMenu(Cias c, String rol) {
        List<Menu> l = em.createNativeQuery("select a.* from menu a, menu_rol b where a.cod_cia = ? and a.estado=1 and a.nivel!=1 "
                + " and b.cod_cia = a.cod_cia and b.cod_modulo=a.cod_modulo and b.cod_menu=a.cod_menu and b.cod_rol = ? "
                + " order by a.cod_menu asc", Menu.class).setParameter(1, c.getCodCia()).setParameter(2, rol).getResultList();
        return l != null ? l : new ArrayList<Menu>();
    }
}
