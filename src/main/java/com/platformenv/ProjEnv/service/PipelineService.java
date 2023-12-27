package com.platformenv.ProjEnv.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PipelineService {
	@Value("${jenkinsurl}")
	private String jenkinsurl;
	@Value("${jenkinsusername}")
	private String username;
	@Value("${jenkinspassword}")
	private String password;
	@Value("${jenkinstoken}")
	private String token;
	
	@Autowired
	private GitService gitservice;
	boolean responsecode = false;
	public String triggerPipeline(JsonNode body) throws JsonMappingException, JsonProcessingException {
		String authStr = username + ":" + password;
		String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

		RestTemplate resttemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);headers.setBasicAuth(base64Creds);


		
		String Jenkinsurl = jenkinsurl + "/job/" + body.get("job").asText()+"/buildWithParameters?token="+token;

        // Create the form data
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        String repourl=gitservice.getByName(body.get("username").asText());
        formData.add("name", "sourceCodeRepoUrl");
        formData.add("value", repourl);
        formData.add("name", "GitLab_Creds");
        formData.add("value", body.get("credsid").asText());
        formData.add("name", "programmingLanguage");
        formData.add("value", body.get("language").asText());
        formData.add("name", "dockerImageName");
        formData.add("value", body.get("imganame").asText());
        formData.add("name", "dockerImageTag");
        formData.add("value", body.get("tag").asText());
        formData.add("name", "buildTool");
        formData.add("value", body.get("tool").asText());
        formData.add("name", "testingFramework");
        formData.add("value",body.get("test").asText());
        formData.add("name", "codeQualityTool");
        formData.add("value", body.get("qa").asText());
        formData.add("name", "artifactRepository");
        formData.add("value", body.get("arti").asText());
        formData.add("name", "imageScanner");
        formData.add("value", body.get("scanner").asText());

        // Create the request entity with headers and form data
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Send the POST request
        
		ResponseEntity<JsonNode> response = resttemplate.postForEntity(Jenkinsurl, new HttpEntity<>(requestEntity,headers),
				JsonNode.class);
		responsecode = response.getStatusCode().is2xxSuccessful();

        // Print the result
        
        if(responsecode) {
        	return "Job triggered successfully";
        	
        }
        else {
        	return "job has not been triggered";
        }
    }
}
