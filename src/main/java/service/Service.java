package service;

import mysqlcmd.model.manager.DatabaseManager;

import java.util.List;
import java.util.Set;

/**
 * Created by oleksandr.baglai on 30.10.2015.
 */
public interface Service {

    List<String> commandsList();

    DatabaseManager connect(String databaseName, String userName, String password);

    Set<String> findTableName(DatabaseManager manager);
}
