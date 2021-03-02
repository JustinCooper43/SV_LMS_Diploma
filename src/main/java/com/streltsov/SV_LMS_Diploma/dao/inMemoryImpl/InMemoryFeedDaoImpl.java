package com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl;

import com.streltsov.SV_LMS_Diploma.domain.Feed;
import com.streltsov.SV_LMS_Diploma.dao.FeedDao;
import com.streltsov.SV_LMS_Diploma.dao.Persistence;

import java.util.List;

public class InMemoryFeedDaoImpl implements FeedDao {

    Persistence persistence = Persistence.getInstance();

    @Override
    public List<Feed> getAll() {
        return persistence.getFeedDB();
    }

    @Override
    public Feed saveFeed(Feed feed) {
        int newID = Persistence.getNewId(persistence.getFeedDB());
        feed.setFeedId(newID);
        persistence.getFeedDB().add(feed);
        return feed;
    }

    @Override
    public Feed getFeedById(int id) {
        for (Feed feed : persistence.getFeedDB()) {
            if (feed.getFeedId().equals(id)) {
                return feed;
            }
        }
        return null;
    }

    @Override
    public boolean updateFeedById(Feed feed) {
        int idGroup = feed.getFeedId();
        deleteFeedById(idGroup);
        saveFeed(feed);
        return true;
    }

    @Override
    public boolean deleteFeedById(int id) {
        for (Feed feed : persistence.getFeedDB()) {
            if (feed.getFeedId().equals(id)) {
                persistence.getFeedDB().remove(feed);
                feed.setFeedId(null);
                return true;
            }
        }
        return false;
    }
}
