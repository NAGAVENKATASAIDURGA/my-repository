package com.platformenv.ProjEnv.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.platformenv.ProjEnv.Entity.sonarentity;
import com.platformenv.ProjEnv.Entity.sonarusers;
import com.platformenv.ProjEnv.Repository.sonarrepository;
import com.platformenv.ProjEnv.Repository.sonaruserrepository;
 

@Service
public class SonarService {
	@Autowired
	private RestTemplate restTemplate;
	@Value("${sonarurl}")
	String sonarurl;
	
	@Autowired
	 sonarrepository repo;
	@Autowired
	sonaruserrepository urepo;
	
	JSONObject json=new JSONObject();
	public Object createUser(JsonNode body, String token) {
		json.clear();
		HttpHeaders header = new HttpHeaders();
		header.set("Authorization", token);

		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		formData.add("login", body.get("login").asText());
		formData.add("name", body.get("name").asText());
		formData.add("password", body.get("password").asText());
		ResponseEntity<Object> entity=restTemplate.exchange(sonarurl+"/"+"api/users/create", HttpMethod.POST,
				new HttpEntity<>(formData, header),Object.class);
		sonarusers en=new sonarusers();
		if(entity.getStatusCode().is2xxSuccessful()) {
		en.setLogin(body.get("login").asText());
		en.setName(body.get("name").asText());
		en.setPassword(body.get("password").asText());
		urepo.save(en);
		json.put("context", "create a user in sonarqube");
		json.put("status", "success");
		json.put("message", "user created successfully");
	}
	else {
		json.put("context", "create a user in sonarqube");
		json.put("status", "failed");
		json.put("message", "unable to create user");
	}
	return json;
	}

	public Object createProject(JsonNode body, String token) {
		json.clear();
		HttpHeaders header = new HttpHeaders();
		header.set("Authorization", token);
		// header.add("Authorization", "Bearer "+token);
		// header.
		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		formData.add("project", body.get("key").asText());
		formData.add("name", body.get("name").asText());
		formData.add("visibility", body.get("visibility").asText());
		
		sonarentity en=new sonarentity();
		ResponseEntity<Object> entity=restTemplate.exchange(sonarurl+"/"+"api/projects/create", HttpMethod.POST,
				new HttpEntity<>(formData, header), Object.class);
		if(entity.getStatusCode().is2xxSuccessful()) {
			JSONObject json=new JSONObject();
			json.put("project", body.get("key").asText());
			
			json.put("name",  body.get("name").asText());
			json.put("visibility", body.get("visibility").asText());
			
			json.put("context", "create a project in sonarqube");
			json.put("status", "success");
			json.put("message", "project created");
			en.setProjname(body.get("key").asText());
			en.setType("proj");
			repo.save(en);
		}
		else {
			json.put("context", "create a project in sonarqube");
			json.put("status", "failed");
			json.put("message", "unable to create project");
		}
		
		return json;
	}
	public  String getByName(String username) {
		System.out.println(username);
		System.out.println(repo.findByusername(username));
		return repo.findByusername(username);
	}
}
