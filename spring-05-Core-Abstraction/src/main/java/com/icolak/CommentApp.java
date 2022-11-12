package com.icolak;

import com.icolak.config.CommentConfig;
import com.icolak.model.Comment;
import com.icolak.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);

        CommentService commentService = context.getBean(CommentService.class);

        commentService.publishComment(comment);

    }
}
