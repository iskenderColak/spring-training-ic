package com.icolak.proxy;

import com.icolak.model.Comment;

public interface CommentNotificationProxy {

    void sendComment(Comment comment);
}
