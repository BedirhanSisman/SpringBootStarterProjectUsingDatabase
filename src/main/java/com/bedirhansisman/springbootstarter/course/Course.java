package com.bedirhansisman.springbootstarter.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.bedirhansisman.springbootstarter.topics.Topic;

@Entity
public class Course {

	@Id
	private String ID;
	private String Name;
	private String Description;
	
	@ManyToOne
	private Topic topic;
		
	public Course() {

	}

	public Course(String iD, String name, String decription, String topicID) {
		super();
		ID = iD;
		Name = name;
		Description = decription;
		topic = new Topic(topicID, "", "");
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDecription() {
		return Description;
	}
	public void setDecription(String decription) {
		Description = decription;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
