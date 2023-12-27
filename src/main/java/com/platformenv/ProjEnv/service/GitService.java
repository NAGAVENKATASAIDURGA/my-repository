package com.platformenv.ProjEnv.service;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.platformenv.ProjEnv.Entity.entity;
import com.platformenv.ProjEnv.Entity.gitusers;
import com.platformenv.ProjEnv.Repository.gitrepository;
import com.platformenv.ProjEnv.Repository.gituserrepository;


@Service
public class GitService {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	gitrepository repo;
	@Autowired
	gituserrepository urepo;
	
	@Value("${giturl}")
	String giturl;
    @Value("${jenkinsurl}")
    private String jenkinsurl;
    @Value("${jenkinsusername")
    private String jenkinsusername;
    @Value("${jenkinstoken}")
    private String jenkinstoken;
    
    @Value("${jenkinspassword}")
    private String jenkinspassword;
    
    @Value("${gitconfigid}")
    private String gitconfigid;
	JSONObject json=new JSONObject();
//create a Repository
//done
	public Object createRepo(JsonNode data, String token) {
		json.clear();
		
		String newtoken = token.replaceAll("Bearer ", "");
		HttpHeaders header = new HttpHeaders();
		header.setBearerAuth(newtoken);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", data.get("name").asText());
		jsonObj.put("private", data.get("name").asText());
		
		System.out.println(jsonObj);
		entity en=new entity();
	ResponseEntity<Object> entity=restTemplate.exchange(giturl+"/api/v4/projects", HttpMethod.POST, new HttpEntity<>(jsonObj, header),Object.class);
	if(entity.getStatusCode().is2xxSuccessful()) {
		
		en.setType("repo");
		en.setReponame(data.get("name").asText());
		en.setUsername(data.get("username").asText());
		en.setRepourl(giturl+"/gitlab/root"+data.get("name").asText());
		repo.save(en);
		json.put("context", "create a repo in git");
		json.put("status", "success");
		json.put("message", "repo created successfully");
	}
	else {
		
		json.put("context", "create a repo in git");
		json.put("status", "failed");
		json.put("message", "unable to create repo");
	}
	return json;
	}

	public Object createUser(JsonNode body, String token) {
		json.clear();
		gitusers u=new gitusers();
		HttpHeaders header = new HttpHeaders();
		String newtoken = token.replaceAll("Bearer ", "");
		header.setBearerAuth(newtoken);
		JSONObject json = new JSONObject();
		json.put("username", body.get("username").asText());
		json.put("email", body.get("email").asText());
		json.put("password", body.get("password").asText());
		json.put("name", body.get("name").asText());
		ResponseEntity<Object> entity=restTemplate.exchange(
				giturl+"/api/v4/users" ,
				HttpMethod.POST, new HttpEntity<>(json, header), Object.class);
		if(entity.getStatusCode().is2xxSuccessful()) {
			//boolean b=setGlobalCredentials(body);
			//System.out.println(b);
			u.setUsername(body.get("username").asText());
			u.setPassword( body.get("password").asText());
			u.setEmail(body.get("email").asText());
			u.setName(body.get("name").asText());

				
			urepo.save(u);
			json.put("context", "create a user in gitlab");
			json.put("status", "success");
			json.put("message", "successfully user created in gitlab");
		}
		else {
			json.put("context", "create a user in gitlab");
			json.put("status", "failed");
			json.put("message", "unable to create a user");
		}
		return json;
	}	
	
public  String getByName(String username) {
	System.out.println(username);
	System.out.println(repo.findByusername(username));
	return repo.findByusername(username);
}

}
