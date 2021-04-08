package com.streltsov.SV_LMS_Diploma.dao.jdbcImpl;

import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.FeedDao;
import com.streltsov.SV_LMS_Diploma.domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcFeedDaoImpl implements FeedDao {

    private final Connection connect = ConnectionSingle.getConnectionToAll();
    private final JdbcPostDaoImpl jdbcPostDao = new JdbcPostDaoImpl();

    @Override
    public List<Feed> getAll() throws SQLException {
        Statement statementListFeed = null;
        String queryLesson = "SELECT feedId FROM feeds ;";

        List<Feed> resultListOfFeeds = new ArrayList<>();
        try {
            statementListFeed = connect.createStatement();
            if (statementListFeed.execute(queryLesson)) {
                ResultSet resultListPost = statementListFeed.executeQuery(queryLesson);
                while (resultListPost.next()) {
                    long feedId = resultListPost.getLong(1);
                    resultListOfFeeds.add(getFeedById(feedId));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementListFeed != null;
            statementListFeed.close();
        }
        return resultListOfFeeds;
    }

    @Override
    public boolean saveFeed(Feed feed) throws SQLException {
        Long groupId = feed.getGroup().getGroupId();
        List<Post> listPosts = feed.getPosts();

        PreparedStatement statement = null;
        String query = "INSERT INTO feeds (groupId) VALUES (?)";
        try {
            statement = connect.prepareStatement(query);
            statement.setLong(1, groupId);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        for (Post varPost : listPosts) {
            jdbcPostDao.savePost(varPost);
        }
        return true;
    }

    @Override
    public Feed getFeedById(long feedId) throws SQLException {

        PreparedStatement statementGroup = null;
        PreparedStatement statementListPosts;
        String queryGroup = "SELECT groupId FROM feeds WHERE feedId = ?";
        String queryListPosts = "SELECT postId FROM posts WHERE feedId = ?";

        Feed newFeed;
        JdbcGroupDaoImpl jdbcGroupDao = new JdbcGroupDaoImpl();
        Group groupResult = null;
        List<Post> listPosts = new ArrayList<>();
        try {
            statementGroup = connect.prepareStatement(queryGroup);
            statementGroup.setLong(1, feedId);
            if (statementGroup.execute()) {
                ResultSet resultGroup = statementGroup.executeQuery();
                while (resultGroup.next()) {
                    long groupId = resultGroup.getLong(1);
                    groupResult = jdbcGroupDao.getGroupById(groupId);
                }
            }
            statementListPosts = connect.prepareStatement(queryListPosts);
            statementListPosts.setLong(1, feedId);
            if (statementListPosts.execute()) {
                ResultSet resultListPosts = statementListPosts.executeQuery();
                while (resultListPosts.next()) {
                    long postId = resultListPosts.getLong(1);
                    Post postForListPosts = jdbcPostDao.getPostById(postId);
                    listPosts.add(postForListPosts);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementGroup != null;
            statementGroup.close();
        }
        newFeed = new Feed(groupResult);
        newFeed.setPosts(listPosts);
        newFeed.setFeedId(feedId);
        return newFeed;
    }

    @Override
    public boolean updateFeed(Feed feed) throws SQLException {
        Long groupId = feed.getGroup().getGroupId();
        Long feedId = feed.getGroup().getGroupId();
        List<Post> listPosts = feed.getPosts();

        PreparedStatement statement = null;
        String query = "UPDATE feeds SET groupId = ? WHERE feedID = ?;";
        try {
            statement = connect.prepareStatement(query);

            statement.setLong(1, groupId);
            statement.setLong(2, feedId);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        for (Post varPost : listPosts) {
            jdbcPostDao.updatePost(varPost);
        }
        return true;
    }

    @Override
    public boolean deleteFeedById(long feedId) throws SQLException {
        PreparedStatement statementFeed = null;
        PreparedStatement statementPost;
        String queryFeed = "DELETE FROM feeds WHERE feedId = ?";
        String queryPost = "DELETE FROM posts WHERE feedId = ?";
        try {
            statementPost = connect.prepareStatement(queryPost);
            statementPost.setLong(1, feedId);
            statementPost.executeUpdate();

            statementFeed = connect.prepareStatement(queryFeed);
            statementFeed.setLong(1, feedId);
            statementFeed.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementFeed != null;
            statementFeed.close();
        }
        return true;
    }
}
