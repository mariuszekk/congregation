package com.common.dao;

import java.util.Collection;

public interface CreateDao<E> {

  void persist(E entity);

  void persist(Collection<E> entities);

  E merge(E entity);
}
