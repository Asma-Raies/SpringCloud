package com.asma.MakeUp.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomMake", types = { makeUp.class })
public interface MakeUpProjection {

	
	public String getNomMakeUp();
}
