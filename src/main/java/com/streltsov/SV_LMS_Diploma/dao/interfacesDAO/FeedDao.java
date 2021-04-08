package com.streltsov.SV_LMS_Diploma.dao.interfacesDAO;

import com.streltsov.SV_LMS_Diploma.domain.Feed;

import java.sql.SQLException;
import java.util.List;

public interface FeedDao {

    List<Feed> getAll() throws SQLException;

    boolean saveFeed(Feed feed) throws SQLException;

    Feed getFeedById(long id ) throws SQLException;

    boolean updateFeed(Feed feed) throws SQLException;

    boolean deleteFeedById(long id) throws SQLException;
}
