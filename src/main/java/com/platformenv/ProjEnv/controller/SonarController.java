package com.platformenv.ProjEnv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.platformenv.ProjEnv.service.SonarService;


@RestController
@RequestMapping("/sonar")
public class SonarController {
	@Autowired
	private SonarService service;
@PostMapping("/createUser")
public Object createUser(@RequestBody JsonNode body,@RequestHeader(name="Authorization") String token) {
	
	 return service.createUser(body, token);
}
@PostMapping("/createProject")
public Object createProject(@RequestBody JsonNode body,@RequestHeader(name="Authorization") String token) {
	 
	return service.createProject(body, token);
}
@GetMapping("/findByUserName")
public String findByRepoName(@RequestBody String username) {
	return service.getByName(username);
}
}
