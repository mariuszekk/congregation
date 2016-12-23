package com.common.model;

import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;

/**
 * Created by mariuszn on 23/12/2016.
 */
@Getter
@MappedSuperclass
@SequenceGenerator(name = "ID_SEQ", initialValue = 1, allocationSize = 100)
public abstract class BaseEntity implements Serializable {

  private static final String ID_COLUMN_NAME = "ID";

  @Id
  @Column(name = ID_COLUMN_NAME, nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
  private Long id;

  @Column(name = "TECH_CREATE_TIME")
  private LocalDateTime createTime;

  @Column(name = "TECH_UPDATE_TIME")
  private LocalDateTime updateTime;

  private void createAndUpdateTime() {
    createTime = LocalDateTime.now();
    updateTime = LocalDateTime.now();
  }

  @PreUpdate
  private void updateTime() {
    updateTime = LocalDateTime.now();
  }

  @Override
  public boolean equals(Object object) {

    if (this == object) return true;

    if (!(object instanceof BaseEntity)) return false;

    BaseEntity entity = (BaseEntity) object;

    if (id != 0 && entity.getId() != 0) {
      return id == entity.getId();
    }

    return new EqualsBuilder().append(createTime, entity.createTime).append(updateTime, entity.updateTime).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(createTime)
        .append(updateTime)
        .toHashCode();
  }
}
