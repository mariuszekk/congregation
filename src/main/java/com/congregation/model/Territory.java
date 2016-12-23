package com.congregation.model;

import com.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by mariuszn on 23/12/2016.
 */
public class Territory extends BaseEntity {


  @Column(name = "ADDRESS")
  private String address;

  @Column(name = "NUMBER_OF_APARTMENTS")
  private int numberOfApartments;

  @Column(name = "NOTES")
  private String notes;

  @Column(name = "TERRITORY_TYPE")
  @Enumerated(EnumType.STRING)
  private TerritoryType territoryType;
}
