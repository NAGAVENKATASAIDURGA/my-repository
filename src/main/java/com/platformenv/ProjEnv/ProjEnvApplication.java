package com.platformenv.ProjEnv;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProjEnvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjEnvApplication.class, args);
	}
	  @Bean
	   public RestTemplate restTemplate() {
		  HttpClient httpClient = HttpClientBuilder.create().build();
		    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		    RestTemplate restTemplate=new RestTemplate();
		    restTemplate.setRequestFactory(requestFactory);
	      return restTemplate;
	   }
}
