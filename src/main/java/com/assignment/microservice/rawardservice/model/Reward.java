package com.assignment.microservice.rawardservice.model;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

public abstract class Reward {
  // including Jackson serialization
	@JsonInclude  
  // marking a field as not persistable
	@Transient    
	protected Long points;

	public abstract Long getPoints();

}



