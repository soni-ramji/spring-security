/**
 * 
 */
package com.ramji.capital.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP
 *
 */
@RestController
@RequestMapping("/user")
public class MyController {

	@GetMapping("/sayhello")
	public String sayHello() {
		return "hello";
	}
	
	@GetMapping("/secure")
	public String noSayHello() {
		return "No hello";
	}
	
}
