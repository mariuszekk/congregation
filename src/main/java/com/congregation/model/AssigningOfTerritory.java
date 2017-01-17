package com.congregation.model;

import static java.time.LocalDateTime.now;

import com.common.model.BaseEntity;
import info.ludwikowski.fluentbuilder.annotation.GenerateBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@GenerateBuilder
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "AssigningOfTerritory", schema = "GRABISZYNEK")
public class AssigningOfTerritory extends BaseEntity {


  private static final long MAX_ASSINGNIN_OF_TERRITORY = 4;

  @Column(name = "DATE_OF_ASSIGNING", nullable = false)
  private LocalDateTime dateOfAssigning;

  @Column(name = "DATE_OF_DEVELOP")
  private LocalDateTime dateOfDevelop;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "publisherId")
  private Publisher publisher;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "territoryId")
  private Territory territory;

  @Column(name = "ACTIVE", nullable = false)
  private boolean active = true;


  public AssigningOfTerritory(LocalDateTime dateOfAssigning, Territory territory, Publisher publisher) {
    this.dateOfAssigning = dateOfAssigning;
    this.territory = territory;
    this.publisher = publisher;
  }

  public boolean shouldReturn() {
    return now().isAfter(dateOfAssigning.plusMonths(MAX_ASSINGNIN_OF_TERRITORY));
  }

  public void developTerritory(LocalDateTime dateOfDevelop) {
    this.dateOfDevelop = dateOfDevelop;
    deactivate();
  }

  public void deactivate(){
    this.active = false;
  }
}
