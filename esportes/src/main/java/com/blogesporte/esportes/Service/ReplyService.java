package com.blogesporte.esportes.Service;

import com.blogesporte.esportes.Repository.ReplyRepository;
import com.blogesporte.esportes.model.Reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    @Autowired
    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Transactional(readOnly = true)
    public Reply findById(Long id) {
        return replyRepository.findById(id).orElseThrow(() -> new ReplyNotFoundException(id));
    }

    @Transactional
    public Reply saveReply(Reply reply) {
        return replyRepository.save(reply);
    }

    @Transactional
    public void deleteReply(Long id) {
        Reply reply = findById(id);
        replyRepository.delete(reply);
    }

    @Transactional(readOnly = true)
    public List<Reply> findAllReplies() {
        return replyRepository.findAll();
    }
    class ReplyNotFoundException extends RuntimeException {
        ReplyNotFoundException(Long id) {
            super("Could not find reply " + id);
        }
}
}
