package service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import entity.Apprentice;
import entity.Event;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ApprenticeService {

    private Dao<Apprentice, String> dao;

    public static void main(String[] args) throws SQLException {

        ApprenticeService apprenticeService = new ApprenticeService();
        List<Apprentice> apprenticeList = apprenticeService.getAll();
        for (Apprentice apprentice : apprenticeList) {
            System.out.println(apprentice.getId() + " "
                    + apprentice.getName()
                    + " "
                    + apprentice.getAge()
                    + " "
                    + apprentice.getSkills());
        }
    }

    public ApprenticeService() throws SQLException {
        String url = "jdbc:sqlite:C:\\Users\\ОП\\IdeaProjects\\TryJavaFx\\itea.sqlite";
        ConnectionSource source = new JdbcConnectionSource(url);
        dao = DaoManager.createDao(source, Apprentice.class);
    }

    public int createEntity(Apprentice apprentice) throws SQLException {
        return dao.create(apprentice);
    }

    public List<Apprentice> getAll() throws SQLException {
        return dao.queryForAll();
    }
}
