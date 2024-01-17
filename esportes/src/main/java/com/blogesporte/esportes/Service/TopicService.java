package com.blogesporte.esportes.Service;

import com.blogesporte.esportes.Repository.TopicRepository;
import com.blogesporte.esportes.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicService {
    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository){
        this.topicRepository = topicRepository;
    }

    @Transactional(readOnly = true)
    public Topic findById(Long id){
        return topicRepository.findById(id).orElseThrow(() -> new TopicNotFoundException(id));

    }
    @Transactional
    public Topic saveTopic(Topic topic){
        return topicRepository.save(topic);

    }
    @Transactional
    public void deleteTopic(Long id){
        Topic topic = findById(id);
        topicRepository.delete(topic);
    }

    @Transactional(readOnly = true)
    public List<Topic> findAllTopics(){
        return topicRepository.findAll();
    }
    class TopicNotFoundException extends RuntimeException{
        TopicNotFoundException(Long id){
            super("Could not find topic "+id);
        }
    }
}
