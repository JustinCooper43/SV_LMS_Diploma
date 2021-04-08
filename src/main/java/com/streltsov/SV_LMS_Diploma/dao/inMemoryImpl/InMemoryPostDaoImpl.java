package com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl;

import com.streltsov.SV_LMS_Diploma.domain.Post;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.Persistence;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.PostDao;

import java.util.List;

public class InMemoryPostDaoImpl implements PostDao {

    Persistence persistence = Persistence.getInstance();

    @Override
    public List<Post> getAll() {
        return persistence.getPostsDB();
    }

    @Override
    public boolean savePost(Post post) {
        long newID = Persistence.getNewId(persistence.getPostsDB());
        post.setPostId(newID);
        persistence.getPostsDB().add(post);
        return true;
    }

    @Override
    public Post getPostById(long id) {
        for (Post post : persistence.getPostsDB()) {
            if (post.getPostId().equals(id)) {
                return post;
            }
        }
        return null;
    }

    @Override
    public boolean updatePost(Post post) {
        long idPost = post.getPostId();
        deletePostById(idPost);
        savePost(post);
        return true;
    }

    @Override
    public boolean deletePostById(long id) {
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
