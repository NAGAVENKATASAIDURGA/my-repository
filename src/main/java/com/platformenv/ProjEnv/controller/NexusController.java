package com.platformenv.ProjEnv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import com.platformenv.ProjEnv.service.NexusService;

@RestController
@RequestMapping("/nexus")
public class NexusController {
	@Autowired
	private NexusService service;
	//done
@PostMapping("/createUser")
public Object createUser(@RequestHeader("Authorization") String token,@RequestBody JsonNode body) throws JsonMappingException, JsonProcessingException {

	return service.createUser(token, body);
	//return "djhd";

}
@PostMapping("/createRepository")
public Object createRepository(@RequestHeader("Authorization") String token,@RequestBody JsonNode body) {
	return service.Repository(token, body);
}
@GetMapping("/findByUserName")
public String findByRepoName(@RequestBody String username) {
	return service.getByName(username);
}
}
