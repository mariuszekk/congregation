package com.common.dao;

public interface ReadDao<E> {

  E findById(Long id);
}
