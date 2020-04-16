package mysqlcmd.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;
import mysqlcmd.model.Column;
import mysqlcmd.model.Table;
import mysqlcmd.model.manager.DatabaseManager;
import mysqlcmd.view.View;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DisplayingTableContentTest {
    private DatabaseManager manager;
    private View<Table> view;
    private Command command;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        manager = mock(DatabaseManager.class);
        view = mock(View.class);
        command = new DisplayingTableContent(manager, view);
    }

    @Test
    public void canProcessShouldReturnTrue_WhenValidFindCommand() {
        //Given-When
        boolean canProcess = command.canProcess("find|");

        //Then
        assertTrue(canProcess);
    }

    @Test
    public void canProcessShouldReturnFalse_WhenInvalidFindCommand() {
        //Given-When
        boolean canProcess = command.canProcess("qwe|");

        //Then
        assertFalse(canProcess);
    }

    @Test
    public void shouldException_WhenInvalidFindCommand() {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("wrong format please check help for help");

        // When
        command.process("find|");

        //Then
    }

    @Test
    public void processShouldSuccess_WhenValidCommandFind() {
        //Given
        List<Column> column = new ArrayList<>();
        Column column1 = new Column("id", "INTEGER");
        Column column2 = new Column("name", "VARCHAR(25)");

        column.add(column1);
        column.add(column2);

        List<Table.Data> dataList = new ArrayList<>();
        Table.Data data = new Table.Data("id", "1");
        Table.Data data1 = new Table.Data("name", "Jack");

        dataList.add(data);
        dataList.add(data1);

        List<List<Table.Data>> rows = new ArrayList<>();
        rows.add(dataList);

        Table table = new Table("user", column, rows);
        when(manager.getTable("user"))
                .thenReturn(table);

        //When
        command.process("find|user");

        //Then
        ArgumentCaptor<Table> captor = ArgumentCaptor.forClass(Table.class);
        verify(view).write(captor.capture());
        Table resultTable = captor.getValue();
        assertEquals("user", resultTable.getName());
    }
}