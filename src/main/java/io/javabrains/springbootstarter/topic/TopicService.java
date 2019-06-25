package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			
			new Topic("spring", "Spring Framework Course", "Spring Description"),
			new Topic("java", "Java Core Course", "Java Description"),
			new Topic("javascript", "Javascript Course", "Javascript Description")
			
			));
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		
		for (Topic t : topics) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		
		return new Topic();
	}

	public void addTopic(Topic newTopic) {
		topics.add(newTopic);
	}

	public void updateTopic(Topic updatedTopic, String id) {
		for (Topic t : topics) {
			if (t.getId().equals(id)) {
				t = updatedTopic;
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		for (Topic t : topics) {
			if (t.getId().equals(id)) {
				topics.remove(t);
				return;
			}
		}
		
	}

}
