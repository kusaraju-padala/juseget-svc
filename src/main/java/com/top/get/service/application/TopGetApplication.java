package com.top.get.service.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.top.get.service.rest.get.TopGetService;
import com.top.get.service.rest.verifyToken.VerifyTokenFilter;

public class TopGetApplication extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	
	public TopGetApplication() {
		singletons.add(new TopGetService());
		singletons.add(new VerifyTokenFilter());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
	

}
