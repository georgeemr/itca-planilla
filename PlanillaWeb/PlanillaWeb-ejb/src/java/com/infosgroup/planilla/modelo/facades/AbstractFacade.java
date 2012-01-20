/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import java.util.Date;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.persistence.EntityManager;

/**
 *
 * @author root
 */
public abstract class AbstractFacade<T, P> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) throws javax.persistence.EntityExistsException {
        getEntityManager().persist(entity);
        //getEntityManager().flush();
    }

    public void edit(T entity) throws javax.persistence.EntityNotFoundException {
        getEntityManager().merge(entity);
        //getEntityManager().flush();
    }

    public void remove(T entity) throws javax.persistence.EntityNotFoundException {
        getEntityManager().remove(getEntityManager().merge(entity));
        //getEntityManager().flush();
    }

    public void refresh(T entity) {
        getEntityManager().refresh(entity);
    }

    public T find(P id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    @PermitAll
    public Date obtenerFecha() {
        return (Date) getEntityManager().createNativeQuery("SELECT SYSDATE FROM DUAL").getSingleResult();
    }
}
