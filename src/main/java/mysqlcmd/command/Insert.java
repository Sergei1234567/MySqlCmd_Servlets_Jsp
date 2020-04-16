package mysqlcmd.command;

import mysqlcmd.model.Column;
import mysqlcmd.model.manager.DatabaseManager;
import mysqlcmd.view.View;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Insert implements Command {

    private final DatabaseManager manager;
    private final View<String> view;

    public Insert(DatabaseManager manager, View<String> view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("insert|");
    }

    @Override
    public void process(String command) {

        List<String> data = Arrays.asList(command.split("\\|"));
        if (data.size() < 2 && !data.get(0).equals("insert|")) {
            throw new IllegalArgumentException("wrong format please check help for help " + command);
        }
        String tableName = data.get(1);

        Map<Column, String> dataInsert = new HashMap<>();

        for (int index = 1; index < data.size() / 2; index++) {
            String columnName = data.get(index * 2);
            String value = data.get(index * 2 + 1);

            dataInsert.put(new Column(columnName, ""), value);
        }
        manager.insert(tableName, dataInsert);

        view.write("Success");
    }
}
