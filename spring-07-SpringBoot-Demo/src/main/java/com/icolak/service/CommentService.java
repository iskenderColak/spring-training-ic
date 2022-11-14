package com.icolak.service;

import com.icolak.config.AppConfigData;
import com.icolak.config.DBConfigData;
import com.icolak.model.Comment;
import com.icolak.proxy.CommentNotificationProxy;
import com.icolak.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private final CommentRepository commentRepository; // putting final is important
    private final CommentNotificationProxy commentNotificationProxy; // not to forget initializing

    private final AppConfigData appConfigData;
    private final DBConfigData dbConfigData;

    // Creating constructor for automatically DI
    public CommentService(CommentRepository commentRepository, AppConfigData appConfigData, DBConfigData dbConfigData,
                          @Qualifier("emailCommentNotificationProxy") CommentNotificationProxy commentNotificationProxy) {
                        // @Qualifier("EMAIL") can be used after naming @Qualifier as EMAIL
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
        this.dbConfigData = dbConfigData;
    }

    public void publishComment(Comment comment) {
        // save in the DB
        commentRepository.storeComment(comment);
        //send email
        commentNotificationProxy.sendComment(comment);
    }

    public void printConfigData() {

        // print username
        System.out.println(appConfigData.getUserName());
        // print password
        System.out.println(appConfigData.getPassword());
        // print url
        System.out.println(appConfigData.getUrl());
    }

    public void printDBConfigData() {
        System.out.println(dbConfigData.getUserName());
        System.out.println(dbConfigData.getPassword());
        System.out.println(dbConfigData.getType());
    }
}
