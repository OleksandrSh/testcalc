package com.calculate.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import com.owlike.genson.ext.jaxrs.GensonJaxRSFeature;

@ApplicationPath("/services/*")
public class OasisApplication extends ResourceConfig {
	
	public OasisApplication() {
		super(LoggingFilter.class, MultiPartFeature.class);
		Genson genson = new GensonBuilder().useIndentation(true)
				.useRuntimeType(true).useConstructorWithArguments(true)
				.create();
		this.register(new GensonJaxRSFeature().use(genson));
		packages("com.calculate.services");
	}
	
}
