package com.blogesporte.esportes.Controllers;
import com.blogesporte.esportes.DTO.TopicDTO;
import com.blogesporte.esportes.Service.TopicService;
import com.blogesporte.esportes.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDTO> getTopic(@PathVariable Long id) {
        Topic topic = topicService.findById(id);
        TopicDTO topicDTO = new TopicDTO();
        return ResponseEntity.ok(topicDTO);
    }

    @PostMapping
    public ResponseEntity<TopicDTO> createTopic(@RequestBody TopicDTO topicDTO) {
        Topic topic = new Topic();
                Topic savedTopic = topicService.saveTopic(topic);
        TopicDTO savedTopicDTO = new TopicDTO();
        return new ResponseEntity<>(savedTopicDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicDTO> updateTopic(@PathVariable Long id, @RequestBody TopicDTO topicDTO) {
        Topic topic = new Topic();
                topic.setId(id);
        Topic updatedTopic = topicService.saveTopic(topic);
        TopicDTO updatedTopicDTO = new TopicDTO();
        return ResponseEntity.ok(updatedTopicDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

}
