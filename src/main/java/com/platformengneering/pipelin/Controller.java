package com.platformengneering.pipelin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/telepresence")
public class Controller {
	@Value("${url}")
	private String url;
@GetMapping("/test")
public String hello() {
	System.out.println(url);
	return "hello world";
}
}
