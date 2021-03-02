package com.streltsov.SV_LMS_Diploma.dao;

import com.streltsov.SV_LMS_Diploma.domain.Post;

import java.util.List;

public interface PostDao {

    List<Post> getAll();

    Post savePost(Post post);

    Post getPostById(int id );

    boolean updatePostById(Post post);

    boolean deletePostById(int id);
}
