package com.icolak.service;

import com.icolak.model.Comment;
import com.icolak.proxy.CommentNotificationProxy;
import com.icolak.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope(BeanDefinition.SCOPE_SINGLETON) // it is default
//@Scope("prototype")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {

    private final CommentRepository commentRepository; // putting final is important
    private final CommentNotificationProxy commentNotificationProxy; // not to forget initializing

    // Creating constructor for automatically DI
    public CommentService(CommentRepository commentRepository,
                          @Qualifier("emailCommentNotificationProxy") CommentNotificationProxy commentNotificationProxy) {
                        // @Qualifier("EMAIL") can be used after naming @Qualifier as EMAIL
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
