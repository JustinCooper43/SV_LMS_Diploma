package com.streltsov.SV_LMS_Diploma.dao;

import com.streltsov.SV_LMS_Diploma.domain.Feed;

import java.util.List;

public interface FeedDao {

    List<Feed> getAll();

    Feed saveFeed(Feed feed);

    Feed getFeedById(int id );

    boolean updateFeedById(Feed feed);

    boolean deleteFeedById(int id);
}
