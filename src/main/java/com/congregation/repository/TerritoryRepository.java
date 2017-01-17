package com.congregation.repository;

import com.congregation.model.Territory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerritoryRepository extends CrudRepository<Territory,Long>{
}