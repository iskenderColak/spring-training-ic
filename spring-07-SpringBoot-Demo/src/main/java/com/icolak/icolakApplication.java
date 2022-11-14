package com.icolak;

import com.icolak.model.Comment;
import com.icolak.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class icolakApplication {

    public static void main(String[] args) {

        // SpringApplication.run(icolakApplication.class, args);

        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context = SpringApplication.run(icolakApplication.class, args);

        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

        commentService.printConfigData();
        commentService.printDBConfigData();

        String str = context.getBean(String.class);
        System.out.println(str);
    }
    @Bean
    public String string() {
        return "icolakSpringBootApplication";
    }
}
