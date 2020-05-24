package service;

import mysqlcmd.model.manager.DatabaseManager;
import mysqlcmd.model.manager.MySqlDatabaseManager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by oleksandr.baglai on 30.10.2015.
 */
public class ServiceImpl implements Service {

    private DatabaseManager manager;

    public ServiceImpl() {
        manager = new MySqlDatabaseManager();
    }

    @Override
    public List<String> commandsList() {
        return Arrays.asList("help", "menu", "connect");
    }

    @Override
    public void connect(String databaseName, String userName, String password) {
        manager.connect(databaseName, userName, password);
    }

}
