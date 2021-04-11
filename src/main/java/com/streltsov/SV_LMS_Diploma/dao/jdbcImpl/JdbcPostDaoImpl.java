package com.streltsov.SV_LMS_Diploma.dao.jdbcImpl;

import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.PostDao;
import com.streltsov.SV_LMS_Diploma.domain.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcPostDaoImpl implements PostDao {

    private final Connection connect = ConnectionSingle.getConnectionToAll();

    @Override
    public List<Post> getAll() throws SQLException {
        java.sql.Statement statementListPosts = null;
        String queryPost = "SELECT postId FROM posts;";

        List<Post> resultListOfPosts = new ArrayList<>();

        try {
            statementListPosts = connect.createStatement();
            if (statementListPosts.execute(queryPost)) {
                ResultSet resultListPost = statementListPosts.executeQuery(queryPost);
                while (resultListPost.next()) {
                    long postId = resultListPost.getLong(1);
                    resultListOfPosts.add(getPostById(postId));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementListPosts != null;
            statementListPosts.close();
        }
        return resultListOfPosts;
    }

    @Override
    public boolean savePost(Post post) throws SQLException {
        Long feedId = post.getFeed().getFeedId();
        String author = post.getAuthor();
        String text = post.getText();
        LocalDate datePosted = post.getDatePosted();

        PreparedStatement statement = null;
        String query = "INSERT INTO posts (feedId,text,author,datePosted) VALUES (?, ?, ?, ?)";

        try {
            statement = connect.prepareStatement(query);
            statement.setLong(1, feedId);
            statement.setString(2, text);
            statement.setString(3, author);
            statement.setDate(4, Date.valueOf(datePosted));
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        return true;
    }

    @Override
    public Post getPostById(long postId) throws SQLException {

        PreparedStatement statementPost = null;
        PreparedStatement statementGroup;
        PreparedStatement statementListPosts;
        String queryPost = "SELECT feedId,text,author,datePosted FROM posts WHERE postId = ?;";
        String queryGroup = "SELECT name,direction,startDate FROM groups WHERE groupId = ? ";
        String queryListPosts = "SELECT text,author,datePosted FROM posts WHERE feedId = ?";

        Post newPost = null;
        try {
            long feedId = 0;
            String text = null;
            String author = null;
            LocalDate datePosted = null;

            statementPost = connect.prepareStatement(queryPost);
            statementPost.setLong(1, postId);
            if (statementPost.execute()) {
                ResultSet resultPost = statementPost.executeQuery();
                while (resultPost.next()) {
                    feedId = resultPost.getLong(1);
                    author = resultPost.getString(3);
                    text = resultPost.getString(2);
                    datePosted = resultPost.getDate(4).toLocalDate();
                }
            }
            Feed newFeedForPost = null;

            statementGroup = connect.prepareStatement(queryGroup);
            statementGroup.setLong(1, feedId);
            if (statementGroup.execute()) {
                ResultSet resultGroup = statementGroup.executeQuery();
                while (resultGroup.next()) {
                    String nameForNewGroup = resultGroup.getString(1);
                    String directionForNewGroup = resultGroup.getString(2);
                    LocalDate startDateForNewGroup = resultGroup.getDate(3).toLocalDate();
                    Group groupResult = new Group(nameForNewGroup, directionForNewGroup, startDateForNewGroup);
                    groupResult.setGroupId(feedId);
                    newFeedForPost = new Feed(groupResult);
                    newFeedForPost.setFeedId(feedId);
                }
            }
            List<Post> listPosts = new ArrayList<>();

            statementListPosts = connect.prepareStatement(queryListPosts);
            statementListPosts.setLong(1, feedId);
            if (statementListPosts.execute()) {
                ResultSet resultListPosts = statementListPosts.executeQuery();
                while (resultListPosts.next()) {
                    String authorForPostList = resultListPosts.getString(2);
                    String textForPostList = resultListPosts.getString(1);
                    LocalDate datePostedForPostList = resultListPosts.getDate(3).toLocalDate();
                    Post postForListPosts = new Post(textForPostList, datePostedForPostList, authorForPostList);
                    listPosts.add(postForListPosts);
                }
            }
            assert newFeedForPost != null;
            newFeedForPost.setPosts(listPosts);

            newPost = new Post(text, datePosted, author);
            newPost.setPostId(postId);
            newPost.setFeed(newFeedForPost);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statementPost != null;
            statementPost.close();
        }

        return newPost;
    }

    @Override
    public boolean updatePost(Post post) throws SQLException {
        Long postId = post.getPostId();
        Long feedId = post.getFeed().getFeedId();
        String author = post.getAuthor();
        String text = post.getText();
        LocalDate datePosted = post.getDatePosted();

        PreparedStatement statement = null;
        String query = "UPDATE posts SET feedId = ?,text = ?,author = ?,datePosted = ? WHERE postId = ?;";

        try {
            statement = connect.prepareStatement(query);

            statement.setLong(1, feedId);
            statement.setString(3, author);
            statement.setString(2, text);
            statement.setDate(4, Date.valueOf(datePosted));
            statement.setLong(5, postId);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        return true;
    }

    @Override
    public boolean deletePostById(long postId) throws SQLException {
        java.sql.PreparedStatement statement = null;
        String query = "DELETE FROM posts WHERE postID = ?";

        try {
            statement = connect.prepareStatement(query);
            statement.setLong(1, postId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            statement.close();
        }
        return true;
    }
}
