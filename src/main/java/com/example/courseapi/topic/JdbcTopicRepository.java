package com.example.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcTopicRepository implements TopicRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Topic> getAllTopics() {
        return jdbcTemplate.query("select id, name, description from Topic", this::mapRowToTopic);
    }

    @Override
    public Topic getTopicById(String id) {
        return jdbcTemplate.queryForObject("select id, name, description from Topic where id=?",
                this::mapRowToTopic, id);
    }

    @Override
    public Topic createTopic(Topic topic) {
        jdbcTemplate.update("insert into Topic (id, name, description) values (?, ?, ?)",
                topic.getId(), topic.getName(), topic.getDescription());
        return topic;
    }

    @Override
    public Topic updateTopic(Topic topic, String id) {
        jdbcTemplate.update("update Topic set id = ?, name = ?, description = ? where id = ?",
                topic.getId(), topic.getName(), topic.getDescription(), id);
        return topic;
    }

    @Override
    public void deleteTopic(String id) {
        jdbcTemplate.update("delete from Topic where id = ?", id);
    }

    private Topic mapRowToTopic(ResultSet rs, int rowNum) throws SQLException {
        return new Topic(rs.getString("id"), rs.getString("name"),
                rs.getString("description"));
    }
}
