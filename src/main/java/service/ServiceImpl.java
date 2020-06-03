package service;

import mysqlcmd.model.Table;
import mysqlcmd.model.manager.DatabaseManager;
import mysqlcmd.model.manager.MySqlDatabaseManager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by oleksandr.baglai on 30.10.2015.
 */
public class ServiceImpl implements Service {

    @Override
    public List<String> commandsList() {
        return Arrays.asList("help", "menu", "connect", "find");
    }

    @Override
    public DatabaseManager connect(String databaseName, String userName, String password) {
        DatabaseManager manager = new MySqlDatabaseManager();
        manager.connect(databaseName, userName, password);
        return manager;
    }

    @Override
    public Table find(DatabaseManager manager, String tableName) {
        Table table = manager.getTable(tableName);
        return table;
    }

}
