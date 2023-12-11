package com.platformengneering.pipelin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/istio")
@RestController
public class Controller {
	@Autowired
	RestTemplate restTemplate;
@PostMapping("/test")
public void istio(@RequestBody String text) {
	
	HttpHeaders header = new HttpHeaders();
	header.set("Host", "cryptography.example.com");
	
	
	
ResponseEntity<Object> entity=restTemplate.exchange("aa7eabfa05ed24fc3ad6d2c4007e805c-1204085443.us-east-1.elb.amazonaws.com"+"/data-encrypt/encrypt", HttpMethod.POST, new HttpEntity<>(text, header),Object.class);
	System.out.println(entity);
}
}
