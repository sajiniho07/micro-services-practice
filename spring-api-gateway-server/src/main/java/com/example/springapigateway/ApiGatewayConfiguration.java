package com.example.springapigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/get")
						.filters(f -> f
								.addRequestHeader("MyHeader", "MyURI")
								.addRequestParameter("Param", "MyValue"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/doRibbonTest/**")
						.uri("lb://school-micro-service"))		// lb : load balance
				.route(p -> p.path("/getStudentsInfo/**")
						.uri("lb://school-micro-service"))

				.route(p -> p.path("/getStudentsInfo-new/**")
						.filters(f -> f.rewritePath(
								"/getStudentsInfo-new/(?<segment>.*)",
								"/getStudentsInfo/${segment}"))
						.uri("lb://school-micro-service"))
				.build();
	}

}
