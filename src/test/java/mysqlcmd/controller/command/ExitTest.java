//package mysqlcmd.controller.command;
//
//import org.junit.Test;
//import org.mockito.Mockito;
//import mysqlcmd.view.View;
//
//import static junit.framework.TestCase.*;
//import static org.mockito.Mockito.verify;
//
//public class ExitTest {
//
//    private View<String> view = Mockito.mock(View.class);
//
//    @Test
//    public void shouldExit() {
//        //Given
//        Command command = new Exit(view);
//
//        //When
//        boolean canProcess = command.canProcess("exit");
//
//        //Then
//        assertTrue(canProcess);
//
//    }
//
//    @Test
//    public void shouldQweString() {
//        //Given
//        Command command = new Exit(view);
//
//        //When
//        boolean canProcess = command.canProcess("qwe");
//
//        //Then
//        assertFalse(canProcess);
//
//    }
//
//    @Test
//    public void testExitCommand_throwsExitException() {
//        //Given
//        Command command = new Exit(view);
//
//        //When
//        try {
//            command.process("exit");
//            fail("Expected ExitException");
//        } catch (ExitException e) {
//            //do nothing
//        }
//
//        //Then
//        verify(view).write("See you soon!");
//        //throws ExitException
//    }
//}