/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.ejb;

import com.pos.entity.SegRole;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Soporte
 */
@Stateless
public class SegRoleFacade extends AbstractFacade<SegRole> {
    @PersistenceContext(unitName = "pos-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public SegRoleFacade() {
        super(SegRole.class);
    }

}
