package com.common.dao;

import com.common.model.BaseEntity;
import org.springframework.core.GenericTypeResolver;

import java.util.Collection;
import javax.persistence.EntityManager;

public abstract class BaseDao<E extends BaseEntity> implements ReadDao<E>, DeleteDao<E>, CreateDao<E> {

  protected Class<E> entityClass;

  protected abstract EntityManager getEntityManager();

  public BaseDao() {
    entityClass = (Class<E>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDao.class);
  }

  @Override
  public E findById(Long id) {
    return getEntityManager().find(entityClass, id);
  }

  @Override
  public void persist(E entity) {
    getEntityManager().persist(entity);
    getEntityManager().flush();
  }

  @Override
  public void persist(Collection<E> entities) {
    for (E entity : entities) {
      getEntityManager().persist(entity);
    }
    getEntityManager().flush();
  }

  @Override
  public E merge(E entity) {
    E mergedEntity = getEntityManager().merge(entity);
    getEntityManager().flush();
    return mergedEntity;
  }

  @Override
  public void delete(E entity) {
    if (getEntityManager().contains(entity)) {
      getEntityManager().remove(entity);
      getEntityManager().flush();
    }
  }

  @Override
  public void deleteAll(Collection<E> entities) {
    for (E entity : entities) {
      if (getEntityManager().contains(entity)) {
        getEntityManager().remove(entity);
      }
    }
    getEntityManager().flush();
  }
}
