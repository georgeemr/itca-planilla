/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.ejb;

import com.pos.entity.Servidor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Soporte
 */
@Stateless
public class ServidorFacade extends AbstractFacade<Servidor> {

    @PersistenceContext(unitName = "pos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServidorFacade() {
        super(Servidor.class);
    }
}
