package com.platformengneering.nexus.controller;

import java.util.Base64;

import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.platformengneering.nexus.service.Service;

@RestController
@RequestMapping("/nexus")
public class Controller {
	@Autowired
	private Service service;
	//done
@PostMapping("/createUser")
public Object createUser(@RequestHeader("Authorization") String token,@RequestBody JsonNode body) throws JsonMappingException, JsonProcessingException {

	return service.createUser(token, body);
	//return "djhd";

}


//done
/*
@DeleteMapping("/deleteUser/{userId}")
public Object deleteUser(@RequestHeader("Authorization") String token,@PathVariable("userId")String userId) {
	return service.deleteUser(token,userId
			);
}
//done
@PutMapping("/changePassword/{userId}")
public Object changePassword(@RequestHeader("Authorization") String token,@PathVariable("userId")String userId,@RequestBody String password) {
	return service.changePassword(token,userId,password);
}
//done
@PutMapping("/updateUser/{userId}")
public Object updateUser(@RequestHeader("Authorization") String token,@PathVariable("userId") String userId,@RequestBody JsonNode body) {
	return service.updateUser(token,userId, body);
}
//done
@PostMapping("/createRole")
public Object createRole(@RequestHeader("Authorization") String token,@RequestBody JsonNode body) {
	return service.createRole(token, body);
}
//done
@DeleteMapping("/deleteRole/{Id}")
public Object deleteRole(@RequestHeader("Authorization") String token,@PathVariable("Id") String Id) {
	return service.deleteRole(token,Id);
}
//done
@PostMapping("/updateRole")
public Object updateRole(@RequestHeader("Authorization") String token,@RequestBody JsonNode body) {
	return service.updateRole(token, body);
}
//done
@PostMapping("/createPrivilaege")
public Object createPrivilaege(@RequestHeader("Authorization") String token,@RequestBody JsonNode body) {
	return service.createPrivilaege(token, body);
}
@DeleteMapping("/deleteprivilege/{privilegename}")
public Object deleteprivilege(@RequestHeader("Authorization") String token,@PathVariable("privilegename") String privilegename) {
	return service.deleteprivilege(token, privilegename);
}


//done
@DeleteMapping("/deleteblobstores/{name}")
public Object deleteblobstores(@RequestHeader("Authorization") String token,@PathVariable("name") String name) {
	return service.deleteblobstores(token,name);
}
//done

//done
@PostMapping("/createContentSelector")
public Object createContentSelector(@RequestHeader("Authorization") String token,@RequestBody JsonNode body) {
	return service.createContentSelector(token, body);
}
//done
@DeleteMapping("/deleteContentSelector/{name}")
public Object deleteContentSelector(@RequestHeader("Authorization") String token,@PathVariable("name") String name) {
	return service.deleteContentSelector(token, name);
}
//done
@PostMapping("/createRoutingRules")
public Object createRoutingRules(@RequestHeader("Authorization") String token,@RequestBody JsonNode body) {
	return service.createRoutingRules(token, body);
}
//done
@DeleteMapping("/deleteRoutingRules/{name}")
public Object deleteRoutingRules(@RequestHeader("Authorization") String token,@PathVariable("name") String  name) {
	return service.deleteRoutingRules(token, name);
}
//done
@PutMapping("/updateAnonymousAccess")
public Object updateAnonymousAccess(@RequestHeader("Authorization") String token,@RequestBody JsonNode body) {
	return service.updateAnonymousAccess(token, body);
}
@GetMapping("/getUsers")
public ResponseEntity<String> getUsers(@RequestHeader("Authorization") String token){
	return service.getUsers(token);
}
@GetMapping("/getRoles")
public ResponseEntity<String> getRoles(@RequestHeader("Authorization") String token){
	return service.getRoles(token);
}
@GetMapping("/getPrivileges")
public ResponseEntity<String> getPrivileges(@RequestHeader("Authorization") String token){
	return service.getPrivileges(token);
}
@GetMapping("/getBlobstores")
public ResponseEntity<String> getBlobstores(@RequestHeader("Authorization") String token){
	return service.getBlobstores(token);
}
@PostMapping("/createRepository")
public Object test(@RequestHeader("Authorization") String token,@RequestBody JsonNode body) {
	return service.Repository(token, body);
}
*/
}
