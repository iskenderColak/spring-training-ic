package com.icolak.service;

import com.icolak.model.Comment;
import com.icolak.proxy.CommentNotificationProxy;
import com.icolak.repository.CommentRepository;

public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

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
