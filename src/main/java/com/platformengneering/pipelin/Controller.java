package com.platformengneering.pipelin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/telepresence")
public class Controller {
@GetMapping("/test")
public String hello() {
	return "hello world";
}
}
