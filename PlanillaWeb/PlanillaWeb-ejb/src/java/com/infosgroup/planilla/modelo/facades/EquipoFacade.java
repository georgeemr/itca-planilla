/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Equipo;
import com.infosgroup.planilla.modelo.entidades.EquipoPK;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**

 @author root
 */
@Stateless
@LocalBean
public class EquipoFacade extends AbstractFacade<Equipo, EquipoPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

public EquipoFacade()
{
    super(Equipo.class);
}

@Override
protected EntityManager getEntityManager()
{
    return em;
}

@PermitAll
public List<Equipo> findAllByCia(Cias cia)
{
    TypedQuery<Equipo> tq = getEntityManager().createNamedQuery("Equipo.findByCodCia", Equipo.class);
    tq.setParameter("codCia", cia.getCodCia());
    return tq.getResultList();
}
}
