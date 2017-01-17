package com.congregation.model;

import static com.congregation.model.builder.PublisherBuilder.aPublisher;
import static com.congregation.model.builder.TerritoryBuilder.aTerritory;
import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.List;

/**
 * Created by mariuszn on 04/01/2017.
 */
public class TerritoryTest {


  @Test
  public void shouldAssingNewPublisher() throws Exception {
    //Given
    Territory territory = aTerritory().build();
    Publisher publisher = aPublisher().build();
    int assignPublisher = territory.getAssigningOfTerritories().size();

    //When
    territory.assignPublisher(now(), publisher);

    //Then
    List<AssigningOfTerritory> assigningOfTerritories = territory.getAssigningOfTerritories();
    assertThat(assigningOfTerritories).hasSize(assignPublisher + 1);
  }
}