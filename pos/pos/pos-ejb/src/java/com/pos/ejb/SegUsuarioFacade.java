/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.ejb;

import com.pos.entity.SegUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Soporte
 */
@Stateless
public class SegUsuarioFacade extends AbstractFacade<SegUsuario> {

    @PersistenceContext(unitName = "pos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegUsuarioFacade() {
        super(SegUsuario.class);
    }

    public SegUsuario validaUsuario(String usuario, String password) {
        SegUsuario u = new SegUsuario();
        Query q = getEntityManager().createQuery("select u from SegUsuario u where u.usuario = :usuario and u.password = :password", SegUsuario.class);
        q.setParameter("usuario", usuario);
        q.setParameter("password", password);
        u = q.getResultList().size() > 0 ? (SegUsuario) q.getResultList().get(0) : null;
        return u;
    }
}
