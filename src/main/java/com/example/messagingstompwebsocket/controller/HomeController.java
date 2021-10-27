package com.example.messagingstompwebsocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.messagingstompwebsocket.model.Message;
@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@GetMapping(path="/home") // Map ONLY POST Requests
	public @ResponseBody String addNewMessage () {
		
		logger.info("Successful test of Cryptiq");
		return "Successful test of Cryptiq";
		
	}
}
