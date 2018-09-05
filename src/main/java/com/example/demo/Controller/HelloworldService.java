package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class HelloworldService {
	private List<Topic> topics= new ArrayList<>(Arrays.asList(new Topic("72", "Priya", "Foresight"),
			new Topic("74", "PK", "UBS")));
	
	public void addTopic(Topic topic){
		topics.add(topic);
	}
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getOneTopic(String id) {
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
	
	public void updateTopic(Topic topic, String id) {
		for(int i=0;i<topics.size(); i++) {
			Topic t= topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i,topic );
				
			}
		}
	}
	
	public void deleteTopic(String id) {
		/*for(int i=0;i<topics.size();i++) {   //first method
			Topic t=topics.get(i);
			if(t.getId().equals(id)) {
				topics.remove(i);
			}
		}*/
		topics.removeIf(t->t.getId().equals(id));  //Second method
	}
	
}
