package service;

import java.util.List;

/**
 * Created by oleksandr.baglai on 30.10.2015.
 */
public interface Service {

    List<String> commandsList();

    void connect(String databaseName, String userName, String password);
}
