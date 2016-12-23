package com.congregation.model;

import static com.google.common.collect.Lists.newArrayList;

import com.common.model.BaseEntity;

import java.util.List;

/**
 * Created by mariuszn on 23/12/2016.
 */
public class AssigningOfTerritory extends BaseEntity{


  private List<Publisher> publishers = newArrayList();


  private List<Territory> territories = newArrayList();
}
