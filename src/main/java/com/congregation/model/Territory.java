package com.congregation.model;

import static com.google.common.collect.Lists.newArrayList;

import com.common.model.BaseEntity;
import info.ludwikowski.fluentbuilder.annotation.GenerateBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@GenerateBuilder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "Territory", schema = "GRABISZYNEK")
public class Territory extends BaseEntity {


  @Column(name = "ADDRESS", nullable = false)
  private String address;

  @Column(name = "NUMBER_OF_APARTMENTS")
  private int numberOfApartments;

  @Column(name = "NOTES")
  private String notes;

  @Column(name = "TERRITORY_TYPE", nullable = false)
  @Enumerated(EnumType.STRING)
  private TerritoryType territoryType;

  @OneToMany(mappedBy = "territory", fetch = FetchType.LAZY)
  private List<AssigningOfTerritory> assigningOfTerritories = newArrayList();


  private Territory(String address, TerritoryType territoryType){
    this.address = address;
    this.territoryType = territoryType;
  }



  public void assignPublisher(LocalDateTime localDateTime, Publisher publisher) {
    AssigningOfTerritory assigningOfTerritory = new AssigningOfTerritory(localDateTime, this, publisher);
    assigningOfTerritories.add(assigningOfTerritory);
  }
}
