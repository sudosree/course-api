package com.example.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "Javascript", "Javascript Description")
    ));

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        Iterator<Topic> iterator = topicRepository.getAllTopics().iterator();
        while (iterator.hasNext()) {
            topics.add(iterator.next());
        }
        return topics;
    }

    public Topic getTopicById(String id) {
//        return topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
        return topicRepository.getTopicById(id);
    }

    public Topic createTopic(Topic topic) {
//        topics.add(topic);
//        return topic;
        return topicRepository.createTopic(topic);
    }

    public Topic updateTopic(Topic topic, String id) {
        /*for (int i=0; i<topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equalsIgnoreCase(id)) {
                topics.set(i, topic);
                return topic;
            }
        }
        return null;*/
        return topicRepository.updateTopic(topic, id);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(t -> t.getId().equalsIgnoreCase(id));
        topicRepository.deleteTopic(id);
    }
}
