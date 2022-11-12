package com.icolak.repository;

import com.icolak.model.Comment;

public interface CommentRepository {

    void storeComment(Comment comment);
}
