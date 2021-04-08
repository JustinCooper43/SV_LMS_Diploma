package com.streltsov.SV_LMS_Diploma.dao.inMemoryImpl;

import com.streltsov.SV_LMS_Diploma.domain.Feed;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.FeedDao;
import com.streltsov.SV_LMS_Diploma.dao.interfacesDAO.Persistence;

import java.util.List;

public class InMemoryFeedDaoImpl implements FeedDao {

    Persistence persistence = Persistence.getInstance();

    @Override
    public List<Feed> getAll() {
        return persistence.getFeedDB();
    }

    @Override
    public boolean saveFeed(Feed feed) {
        long newID = Persistence.getNewId(persistence.getFeedDB());
        feed.setFeedId(newID);
        persistence.getFeedDB().add(feed);
        return true;
    }

    @Override
    public Feed getFeedById(long id) {
        for (Feed feed : persistence.getFeedDB()) {
            if (feed.getFeedId().equals(id)) {
                return feed;
            }
        }
        return null;
    }

    @Override
    public boolean updateFeed(Feed feed) {
        long idGroup = feed.getFeedId();
        deleteFeedById(idGroup);
        saveFeed(feed);
        return true;
    }

    @Override
    public boolean deleteFeedById(long id) {
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
