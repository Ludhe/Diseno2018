/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author rcarlos
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();
    
    public boolean create(T entity){
        boolean salida = false;
        T e = this.crear(entity);
        if(e != null){
        salida =true;
    }
        return salida;
    }
    
    public T crear(T entity){
      T salida = null;
      try{
          EntityManager em = getEntityManager();
          if(em != null && entity != null){
              em.persist(entity);
              salida = entity;
          }
      }catch(Exception e){
          Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
      }
      return salida;
    }
    
    
        
    public boolean edit(T entity) {
        boolean salida = false;
        T e = this.editar(entity);
        if(e != null){
        salida =true;
    }
        return salida;
    }
    
    public T editar(T entity){
      T salida = null;
      try{
          EntityManager em = getEntityManager();
          if(em != null && entity != null){
              em.merge(entity);
              salida = entity;
          }
      }catch(Exception e){
          Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
      }
      return salida;
    }

    public boolean remove(T entity) {
        try {
           getEntityManager().remove(getEntityManager().merge(entity));
           return true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);            
        }
        return false;            
    }
    

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int desde, int hasta) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(hasta);
        q.setFirstResult(desde);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
