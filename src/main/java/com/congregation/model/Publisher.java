package com.congregation.model;

import com.common.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

/**
 * Created by mariuszn on 23/11/2016.
 */
@Entity
@SequenceGenerator(name = "ID_SEQ", initialValue = 1, allocationSize = 100)
public class Publisher extends BaseEntity {


}
