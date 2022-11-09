package com.kafkapublisher.controller;

import com.kafkapublisher.model.User;
import com.kafkapublisher.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaPublisherController {

	@Autowired
	private KafkaTemplate<String,Object> template;

	@Autowired
	private KafkaService service;

	private String topic1 = "nametopic";
	private String topic2 = "usertopic";

	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name){
		template.send(topic1,"Hi "+name+" Welcome");
		return "Data published";
	}

	@GetMapping("/publishJson/{id}")
	public String publishMessage(@PathVariable Long id){
		User user = this.service.getUser(id);
		template.send(topic2,user);
		return "Data published of "+user.getName();
	}
}
