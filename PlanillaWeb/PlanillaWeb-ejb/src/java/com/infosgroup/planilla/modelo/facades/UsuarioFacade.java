/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Usuario;
import com.infosgroup.planilla.modelo.entidades.UsuarioPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario, UsuarioPK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Integer findByUsuarioPassword(String usuario, String password)
    {
        Query consulta = em.createNamedQuery("Usuario.findByNomUsuarioPassword");
        consulta.setParameter("nomUsuario", usuario);
        consulta.setParameter("password", password);
        return consulta.getResultList().size();
    }
    
}
