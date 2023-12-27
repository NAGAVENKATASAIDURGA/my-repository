package com.platformenv.ProjEnv.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import com.platformenv.ProjEnv.Entity.nexusentity;
import com.platformenv.ProjEnv.Entity.nexususers;
import com.platformenv.ProjEnv.Repository.nexusrepository;
import com.platformenv.ProjEnv.Repository.nexususerrepository;

@Service
public class NexusService {
	@Autowired
	private RestTemplate restTemplate;
	@Value("${nexusurl}")
	String nexusurl;
	
	@Autowired
	nexusrepository repo;
	@Autowired
	nexususerrepository urepo;
	JSONObject json=new JSONObject();
public Object createUser(String token,JsonNode body) throws JsonMappingException, JsonProcessingException {
	json.clear();
	HttpHeaders header = new HttpHeaders();
	

     // Encode the credentials to Base64
     //String credentials = username + ":" + password;
     //String encodedCredentials = java.util.Base64.getEncoder().encodeToString(credentials.getBytes());
     header.set("Authorization", token);
	JSONObject jsonObj = new JSONObject();
	jsonObj.put("userId", body.get("userId").asText());
	jsonObj.put("firstName", body.get("firstName").asText());
	jsonObj.put("lastName", body.get("lastName").asText());
	jsonObj.put("emailAddress", body.get("emailAddress").asText());
	jsonObj.put("password", body.get("password").asText());
	jsonObj.put("status", body.get("status").asText());
	List<String> list = new ArrayList<String>();

		/*
		 * ObjectMapper mapper = new ObjectMapper(); JsonNode node =
		 * mapper.readTree(body.get("roles").asText());
		 * 
		 * for (JsonNode j : node) { list.add(j.asText());
		 * 
		 * }
		 */
	jsonObj.put("roles", body.get("roles"));
	
	ResponseEntity<Object> entity=restTemplate.exchange(nexusurl+"/"+"service/rest/v1/security/users", HttpMethod.POST,
			new HttpEntity<>(jsonObj, header),Object.class);
	nexususers en=new nexususers();
if(entity.getStatusCode().is2xxSuccessful()) {
	en.setUid(body.get("userId").asText());
	en.setEmail(body.get("emailAddress").asText());
	en.setPassword(body.get("password").asText());
  urepo.save(en);
	json.put("context", "create a user in nexus");
	json.put("status", "success");
	json.put("message", "user created successfully");
}
else {
	json.put("context", "create a user in nexus");
	json.put("status", "failed");
	json.put("message", "unable to create user");
}
return json;
}
public Object Repository(String token,JsonNode body) {
	json.clear();
	
	HttpHeaders header = new HttpHeaders();

     // Encode the credentials to Base64
header.set("Authorization", token);				
	JSONObject jsonObj = new JSONObject();
	jsonObj.put("name", body.get("name").asText());
	jsonObj.put("online", body.get("online").asText());
	
	jsonObj.put("storage", body.get("storage"));
	jsonObj.put("cleanup", body.get("cleanup"));
	
	jsonObj.put("component", body.get("component"));
	jsonObj.put("maven", body.get("maven"));

	ResponseEntity<Object> entity=restTemplate.exchange(nexusurl+"/"+"service/rest/v1/repositories/maven/hosted", HttpMethod.POST,
			new HttpEntity<>(jsonObj, header),Object.class);
	nexusentity en=new nexusentity();
	
if(entity.getStatusCode().is2xxSuccessful()) {
	en.setReponame(body.get("name").asText());
	en.setType("repo");
	repo.save(en);
	json.put("context", "create a repository in nexus");
	json.put("status", "success");
	json.put("message", "repository created successfully");
}
else {
	json.put("context", "create a repository in sonarqube");
	json.put("status", "failed");
	json.put("message", "unable to create repository");
}
return json;
}
public  String getByName(String username) {
	System.out.println(username);
	System.out.println(repo.findByusername(username));
	return repo.findByusername(username);
}
}
