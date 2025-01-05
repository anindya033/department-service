package com.crafter.department_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.crafter.department_service.client.EmployeeClient;

@Configuration
public class WebClientConfig {
	
	@Autowired
	private LoadBalancedExchangeFilterFunction filterFunction;
	
	@Bean
    @LoadBalanced // Ensures that the WebClient can resolve service names via Eureka
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .filter(filterFunction); // Ensures tracing metadata is propagated
    }

    @Bean
    public WebClient employeeWebClient() {
        return webClientBuilder()
                .baseUrl("http://employee-service") // Base URL resolved by Eureka
                .build();
    }
	
	@Bean
	public EmployeeClient employeeClient() {
	
		HttpServiceProxyFactory proxy = 
				HttpServiceProxyFactory.builderFor(WebClientAdapter.create(employeeWebClient()))
				.build();
	
	return proxy.createClient(EmployeeClient.class); 
}

}
