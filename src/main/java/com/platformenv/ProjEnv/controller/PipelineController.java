package com.platformenv.ProjEnv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.platformenv.ProjEnv.service.PipelineService;

@RestController
@RequestMapping("/pipeline")
public class PipelineController {
	@Autowired
	private PipelineService service;
	@PostMapping("/trigger")
	public String triggerPipeline(@RequestBody JsonNode body) throws JsonMappingException, JsonProcessingException {
		return service.triggerPipeline(body);
	}
}
