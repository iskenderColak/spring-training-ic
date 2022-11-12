package com.icolak.service;

import com.icolak.model.Comment;
import com.icolak.proxy.CommentNotificationProxy;
import com.icolak.repository.CommentRepository;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private final CommentRepository commentRepository; // putting final is important
    private final CommentNotificationProxy commentNotificationProxy; // not to forget initializing

    // Creating constructor for automatically DI
    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        // save in the DB
        commentRepository.storeComment(comment);
        //send email
        commentNotificationProxy.sendComment(comment);
    }
}
