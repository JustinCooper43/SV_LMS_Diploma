package com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl;

import com.streltsov.SV_LMS_Diploma.domain.Post;
import com.streltsov.SV_LMS_Diploma.dao.Persistence;
import com.streltsov.SV_LMS_Diploma.dao.PostDao;

import java.util.List;

public class InMemoryPostDaoImpl implements PostDao {

    Persistence persistence = Persistence.getInstance();

    @Override
    public List<Post> getAll() {
        return persistence.getPostsDB();
    }

    @Override
    public Post savePost(Post post) {
        int newID = Persistence.getNewId(persistence.getPostsDB());
        post.setPostId(newID);
        persistence.getPostsDB().add(post);
        return post;
    }

    @Override
    public Post getPostById(int id) {
        for (Post post : persistence.getPostsDB()) {
            if (post.getPostId().equals(id)) {
                return post;
            }
        }
        return null;
    }

    @Override
    public boolean updatePostById(Post post) {
        int idPost = post.getPostId();
        deletePostById(idPost);
        savePost(post);
        return true;
    }

    @Override
    public boolean deletePostById(int id) {
        for (Post post : persistence.getPostsDB()) {
            if (post.getPostId().equals(id)) {
                persistence.getPostsDB().remove(post);
                post.setPostId(null);
                return true;
            }
        }
        return false;
    }
}
