package com.common.dao;

import java.util.Collection;

public interface DeleteDao<E> {

  void delete(E entity);

  void deleteAll(Collection<E> entities);
}
