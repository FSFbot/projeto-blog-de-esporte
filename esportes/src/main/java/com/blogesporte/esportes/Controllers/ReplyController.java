package com.blogesporte.esportes.Controllers;

import com.blogesporte.esportes.DTO.ReplyDTO;
import com.blogesporte.esportes.Service.ReplyService;
import com.blogesporte.esportes.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/replies")
public class ReplyController {

    private final ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReplyDTO> getReply(@PathVariable Long id) {
        Reply reply = replyService.findById(id);
        ReplyDTO replyDTO = new ReplyDTO();
        return ResponseEntity.ok(replyDTO);
    }

    @PostMapping
    public ResponseEntity<ReplyDTO> createReply(@RequestBody ReplyDTO replyDTO) {
        Reply reply = new Reply();
                Reply savedReply = replyService.saveReply(reply);
        ReplyDTO savedReplyDTO = new ReplyDTO();
        return new ResponseEntity<>(savedReplyDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReplyDTO> updateReply(@PathVariable Long id, @RequestBody ReplyDTO replyDTO) {
        Reply reply = new Reply();
                reply.setId(id);
        Reply updatedReply = replyService.saveReply(reply);
        ReplyDTO updatedReplyDTO = new ReplyDTO();
        return ResponseEntity.ok(updatedReplyDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable Long id) {
        replyService.deleteReply(id);
        return ResponseEntity.noContent().build();
    }

}
