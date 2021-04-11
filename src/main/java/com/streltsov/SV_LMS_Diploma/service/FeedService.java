package com.streltsov.SV_LMS_Diploma.service;

import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.InMemoryFeedDaoImpl;
import com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl.InMemoryPostDaoImpl;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.FeedDao;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.PostDao;
import com.streltsov.SV_LMS_Diploma.domain.Feed;
import com.streltsov.SV_LMS_Diploma.domain.HomeworkTask;
import com.streltsov.SV_LMS_Diploma.domain.Lesson;
import com.streltsov.SV_LMS_Diploma.domain.Post;

import java.sql.SQLException;
import java.util.List;

public class FeedService {

    private final FeedDao feedDao = new InMemoryFeedDaoImpl();
    private final PostDao postDao = new InMemoryPostDaoImpl();

    public boolean saveFeedInMemory(Feed feed) throws SQLException {
        List<Post> postList = feed.getPosts();
        feedDao.saveFeed(feed);
        for(Post varPost: postList){
            postDao.savePost(varPost);
        }
        return true;
    }

    public boolean updateFeedInMemory(Feed feed) throws SQLException {
        feedDao.updateFeed(feed);
        List<Post> postList = feed.getPosts();
        for(Post varPost: postList){
            postDao.updatePost(varPost);
        }
        return true;
    }

    public boolean deleteFeedInMemory(Feed feed) throws SQLException {
        long feedId = feed.getFeedId();
        feedDao.deleteFeedById(feedId);
        List<Post> postList = feed.getPosts();
        for(Post varPost: postList){
            long postId = varPost.getPostId();
            postDao.deletePostById(postId);
        }
        return true;
    }
}
