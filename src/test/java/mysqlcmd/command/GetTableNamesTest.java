package mysqlcmd.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import mysqlcmd.model.manager.DatabaseManager;
import mysqlcmd.view.View;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class GetTableNamesTest {
    DatabaseManager manager;
    View<String> view;
    Command command;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        manager = mock(DatabaseManager.class);
        view = mock(View.class);
        command = new GetTableNames(manager, view);
    }

    @Test
    public void shouldErrorMassageNonExistentCommand_WhenInvalidCommandTables() {
        //Given
        //When
        command.process("table");

        //Then
        verify(view).write("Non-existent command: wrong format please check help for help");
    }

    @Test
    public void canProcessShouldReturnFalse_WhenInvalidCommandTables() {
        //Given
        //When
        boolean canProcess = command.canProcess("qwe");

        //Then
        assertFalse(canProcess);
    }

    @Test
    public void canProcessReturnTrue_WhenValidCommandTables() {
        //Given
        //When
        boolean canProcess = command.canProcess("tables");

        //Then
        assertTrue(canProcess);
    }

    @Test
    public void processShouldSuccess_WhenValidCommandTables() {
        //Given
        Set<String> tableNames = new LinkedHashSet<>(Arrays.asList("table", "test"));
        when(manager.getTableNames()).thenReturn(tableNames);

        //When
        command.process("tables");

        //Then
        verify(manager).getTableNames();
        verify(view).write("[table, test]");
    }
}