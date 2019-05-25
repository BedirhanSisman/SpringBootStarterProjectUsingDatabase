package com.bedirhansisman.springbootstarter.topics;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{ID}")
	public Topic getTopic(@PathVariable String ID) {
		return topicService.getTopic(ID);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{ID}")
	public void updateTopic(@PathVariable String ID, @RequestBody Topic topic) {
		topicService.updateTopic(ID, topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{ID}")
	public void deleteTopic(@PathVariable String ID) {
		topicService.deleteTopic(ID);
	}
}
