package service;

import mysqlcmd.model.Table;
import mysqlcmd.model.manager.DatabaseManager;

import java.util.List;

/**
 * Created by oleksandr.baglai on 30.10.2015.
 */
public interface Service {

    List<String> commandsList();

    DatabaseManager connect(String databaseName, String userName, String password);

    Table find(DatabaseManager manager, String tableName);
}
