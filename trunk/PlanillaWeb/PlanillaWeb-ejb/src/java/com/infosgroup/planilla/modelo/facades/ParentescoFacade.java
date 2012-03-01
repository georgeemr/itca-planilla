<<<<<<< .mine
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Parentesco;
import com.infosgroup.planilla.modelo.entidades.ParentescoPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class ParentescoFacade extends AbstractFacade<Parentesco, ParentescoPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    public ParentescoFacade() {
        super(Parentesco.class);
    }

    @PermitAll
    public List<Parentesco> findParentescoByCias(Cias cias) {
        List<Parentesco> l = new ArrayList<Parentesco>();
        l = em.createQuery("SELECT p FROM Parentesco p WHERE p.parentescoPK.codCia = :codCia", Parentesco.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return l != null ? l : new ArrayList<Parentesco>();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
=======
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Parentesco;
import com.infosgroup.planilla.modelo.entidades.ParentescoPK;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**

 @author root
 */
@Stateless
public class ParentescoFacade extends AbstractFacade<Parentesco, ParentescoPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public ParentescoFacade()
{
    super(Parentesco.class);
}

@PermitAll
public List<Parentesco> findAllByCia(Cias cia)
{
    TypedQuery<Parentesco> tq = getEntityManager().createNamedQuery("Parentesco.findByCodCia", Parentesco.class);
    tq.setParameter("codCia", cia.getCodCia());
    return tq.getResultList();
}
}
>>>>>>> .r704
