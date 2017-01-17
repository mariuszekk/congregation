package com.congregation.model;

import com.common.model.BaseEntity;
import info.ludwikowski.fluentbuilder.annotation.GenerateBuilder;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by mariuszn on 23/11/2016.
 */
@Entity
@Getter
@GenerateBuilder
@Table(name = "Publisher", schema = "GRABISZYNEK")
public class Publisher extends BaseEntity {

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "SURNAME", nullable = false)
  private String surname;

  @Column(name = "DATE_OF_BABTIST", nullable = false)
  private LocalDateTime dateOfBabtist;

  @Column(name = "DATE_OF_BIRTH", nullable = false)
  private LocalDateTime dateOfBirth;

  @Override
  public boolean equals(Object object) {

    if (this == object) return true;

    if (!(object instanceof Publisher)) return false;

    Publisher publisher = (Publisher) object;

    return new EqualsBuilder()
        .append(name, publisher.getName())
        .append(surname, publisher.getSurname())
        .append(dateOfBabtist, publisher.getDateOfBabtist())
        .append(dateOfBirth, publisher.getDateOfBirth())
        .isEquals();
  }
}
