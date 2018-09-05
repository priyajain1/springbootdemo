package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloWorld {
	@Autowired
	HelloworldService helloworldservices;  
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return helloworldservices.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getOneTopic(@PathVariable String id) {
		return helloworldservices.getOneTopic(id);
	}

	@RequestMapping(method= RequestMethod.POST, value= "/topics")  
    public void addTopic(@RequestBody Topic topic){
		helloworldservices.addTopic(topic);
	}
	
	@RequestMapping(method= RequestMethod.PUT, value= "/topics/{id}")  
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
		helloworldservices.updateTopic(topic,id);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value= "/topics/{id}")  
    public void deleteTopic(@PathVariable String id){
		helloworldservices.deleteTopic(id);
	}
	
}
