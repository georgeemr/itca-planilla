/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Menu;
import com.infosgroup.planilla.modelo.entidades.MenuPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
*
* @author root
*/
@Stateless
public class MenuFacade extends AbstractFacade<Menu, MenuPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
return em;
}

public MenuFacade()
{
super( Menu.class );
}

public List<Menu> getListaMenus()
{
List<Menu> m = em.createQuery( "select m from Menu m where m.menu is null", Menu.class ).getResultList();
return m != null ? m : new ArrayList<Menu>( 0 );
}
@PermitAll
public List<Menu> findAllEnOrden()
{
TypedQuery<Menu> tq = em.createQuery( "SELECT m FROM Menu m WHERE m.nivel = 1 AND m.estado = 1 ORDER BY m.menuPK.idMenu", Menu.class );
return tq.getResultList();
}
}
