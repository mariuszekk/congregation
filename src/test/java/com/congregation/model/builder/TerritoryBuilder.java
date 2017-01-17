package com.congregation.model.builder;

import com.congregation.model.AbstractTerritoryBuilder;
import info.ludwikowski.fluentbuilder.common.AbstractBuilderFactory;


/**
 * Fluent builder for Territory.
 * Don't hesitate to put your custom methods here.
 */
public abstract class TerritoryBuilder extends AbstractTerritoryBuilder<TerritoryBuilder> {

	public static TerritoryBuilder aTerritory(){
		return AbstractBuilderFactory.createImplementation(TerritoryBuilder.class);
	}
}
