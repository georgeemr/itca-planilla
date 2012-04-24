/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.security.PermitAll;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author root
 */
public abstract class AbstractFacade<T, P> {

    protected Class<T> entityClass;
    public static final Logger logger = Logger.getLogger(AbstractFacade.class.getPackage().getName());
    
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    @PermitAll
    public void create(T entity) throws javax.persistence.EntityExistsException {
        getEntityManager().persist(entity);
    }

    @PermitAll
    public void edit(T entity) throws javax.persistence.EntityNotFoundException {
        getEntityManager().merge(entity);
    }

    @PermitAll
    public void remove(T entity) throws javax.persistence.EntityNotFoundException {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @PermitAll
    public void refresh(T entity) {
        getEntityManager().refresh(entity);
    }

    @PermitAll
    public void flush() {
        getEntityManager().flush();
    }

    @PermitAll
    public T find(P id) {
        return getEntityManager().find(entityClass, id);
    }

    @PermitAll
    public List<T> findAll() {
        CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /*
     * public List<T> findRange(int[] range) {
     * javax.persistence.criteria.CriteriaQuery cq =
     * getEntityManager().getCriteriaBuilder().createQuery();
     * cq.select(cq.from(entityClass)); javax.persistence.Query q =
     * getEntityManager().createQuery(cq); q.setMaxResults(range[1] - range[0]);
     * q.setFirstResult(range[0]); return q.getResultList(); }
     *
     * public int count() { javax.persistence.criteria.CriteriaQuery cq =
     * getEntityManager().getCriteriaBuilder().createQuery();
     * javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
     * cq.select(getEntityManager().getCriteriaBuilder().count(rt));
     * javax.persistence.Query q = getEntityManager().createQuery(cq); return
     * ((Long) q.getSingleResult()).intValue(); }
     */
    @PermitAll
    public Date obtenerFecha() {
        return (Date) getEntityManager().createNativeQuery("SELECT SYSDATE FROM DUAL").getSingleResult();
    }
}
