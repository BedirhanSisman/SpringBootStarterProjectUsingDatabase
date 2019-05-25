package com.bedirhansisman.springbootstarter.topics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> listOfTopics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(listOfTopics::add);
		return listOfTopics;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String iD, Topic topic) {
		topicRepository.save(topic); //Repository will understand what is the process, update or add another one?
	}

	public void deleteTopic(String iD) {
		topicRepository.delete(iD);
	}

}
