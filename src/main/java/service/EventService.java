package service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import entity.Event;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Igor Hnes on 6/20/17.
 */
public class EventService {

    private Dao<Event, String> dao;

    public EventService() throws SQLException {
        String url = "jdbc:sqlite:/Users/igor/workspace/TryJavaFx/itea.sqlite";
        ConnectionSource source = new JdbcConnectionSource(url);
        dao = DaoManager.createDao(source, Event.class);
    }

    public int createEntity(Event event) throws SQLException {
       return dao.create(event);
    }

    public List<Event> getAll() throws SQLException {
        return dao.queryForAll();
    }
}
