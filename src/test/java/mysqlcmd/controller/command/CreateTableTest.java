package mysqlcmd.controller.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import mysqlcmd.model.Column;
import mysqlcmd.model.manager.DatabaseManager;
import mysqlcmd.view.View;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateTableTest {
   private DatabaseManager manager;
   private View<String> view;
   private Command command;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        manager = mock(DatabaseManager.class);
        view = mock(View.class);
        command = new CreateTable(manager, view);
    }

    @Test
    public void shouldException_WhenInvalidCreateCommand() {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("wrong format please check help for help ");

        // When
        command.process("create|");

        //Then
    }

    @Test
    public void canProcessShouldReturnFalse_WhenInvalidCommandCreate() {
        //Given-When
        boolean canProcess = command.canProcess("qwe|");

        //Then
        assertFalse(canProcess);
    }

    @Test
    public void canProcessShouldReturnTrue_WhenValidCommandCreate() {
        //Given-When
        boolean canProcess = command.canProcess("create|");

        //Then
        assertTrue(canProcess);
    }

    @Test
    public void processShouldSuccess_WhenValidCommandCreate() {
        //Given

        // When
        command.process("create|test|id:INTEGER|name:VARCHAR(25)");

        //Then
        verify(manager).create("test", List.of(new Column("id", "INTEGER"), new Column("name", "VARCHAR(25)")));
        verify(view).write("Success");
    }

}