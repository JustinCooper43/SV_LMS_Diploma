package com.streltsov.SV_LMS_Diploma.dao.interfacesDAO;

import com.streltsov.SV_LMS_Diploma.domain.Post;

import java.sql.SQLException;
import java.util.List;

public interface PostDao {

    List<Post> getAll() throws SQLException;

    boolean savePost(Post post) throws SQLException;

    Post getPostById(long id ) throws SQLException;

    boolean updatePost(Post post) throws SQLException;

    boolean deletePostById(long id) throws SQLException;
}
