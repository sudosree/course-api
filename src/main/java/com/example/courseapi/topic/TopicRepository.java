package com.example.courseapi.topic;

public interface TopicRepository {

    Iterable<Topic> getAllTopics();

    Topic getTopicById(String id);

    Topic createTopic(Topic topic);

    Topic updateTopic(Topic topic, String id);

    void deleteTopic(String id);
}
