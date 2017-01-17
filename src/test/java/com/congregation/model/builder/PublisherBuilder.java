package com.congregation.model.builder;

import com.congregation.model.AbstractPublisherBuilder;
import info.ludwikowski.fluentbuilder.common.AbstractBuilderFactory;


/**
 * Fluent builder for Publisher.
 * Don't hesitate to put your custom methods here.
 */
public abstract class PublisherBuilder extends AbstractPublisherBuilder<PublisherBuilder> {

	public static PublisherBuilder aPublisher(){
		return AbstractBuilderFactory.createImplementation(PublisherBuilder.class);
	}
}
