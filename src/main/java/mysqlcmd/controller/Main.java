package mysqlcmd.controller;

import mysqlcmd.controller.command.*;
import mysqlcmd.model.Table;
import mysqlcmd.model.manager.DatabaseManager;
import mysqlcmd.model.manager.MySqlDatabaseManager;
import mysqlcmd.view.Console;
import mysqlcmd.view.TableView;
import mysqlcmd.view.View;

public class Main {
    public static void main(String[] args) {
        View<String> view = new Console();
        View<Table> tableView = new TableView();
        DatabaseManager manager = new MySqlDatabaseManager();
        MainController controller = new MainController(view,
                new Connect(manager, view),
                new Help(view),
                new Exit(view),
                new IsConnected(manager, view),
                new GetTableNames(manager, view),
                new Clear(manager, view),
                new CreateTable(manager, view),
                new Insert(manager, view),
                new Update(manager, view),
                new DisplayingTableContent(manager, tableView),
                new DropTable(manager, view),
                new Unsupported(view));
        controller.run();
    }
}
