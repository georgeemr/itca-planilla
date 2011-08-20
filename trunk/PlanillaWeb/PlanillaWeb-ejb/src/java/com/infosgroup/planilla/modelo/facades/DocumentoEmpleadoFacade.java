/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.DocumentoEmpleado;
import com.infosgroup.planilla.modelo.entidades.DocumentoEmpleadoPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DocumentoEmpleadoFacade extends AbstractFacade<DocumentoEmpleado, DocumentoEmpleadoPK> {
    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentoEmpleadoFacade() {
        super(DocumentoEmpleado.class);
    }
    
}
