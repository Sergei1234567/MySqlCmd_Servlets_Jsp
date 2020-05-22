//package mysqlcmd.model;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//import mysqlcmd.model.manager.MySqlDatabaseManager;
//import mysqlcmd.util.DBUtil;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
//public class MySqlDatabaseManagerTest {
//
//    private static final MySqlDatabaseManager mySqlManager = new MySqlDatabaseManager();
//
//    private static final DBUtil dbUtil = new DBUtil();
//
//    private static final String TEST_DATABASE = "TEST_DATABASE";
//
//    @Rule
//    public ExpectedException exception = ExpectedException.none();
//
//    @BeforeClass
//    public static void beforeClass() {
//        String userName = "root";
//        String password = "root";
//        dbUtil.connect(userName, password);
//        dbUtil.createDatabase(TEST_DATABASE);
//        mySqlManager.connect(TEST_DATABASE, userName, password);
//    }
//
//    @AfterClass
//    public static void cleanUp() {
//        dbUtil.dropDatabase(TEST_DATABASE);
//    }
//
//    @Test
//    public void tableShouldBeEmpty_WhenClear() {
//        //Given
//        String tableName = "Dog";
//        Column id = new Column("ID", "INTEGER");
//        Column name = new Column("NAME", "VARCHAR(20)");
//        List<Column> columns = List.of(id, name);
//        mySqlManager.create(tableName, columns);
//
//        Map<Column, String> dataToInsert = Map.of(id, "1", name, "Jack");
//        mySqlManager.insert(tableName, dataToInsert);
//
//        //When
//        mySqlManager.clear(tableName);
//
//        //Then
//        assertEquals(0, dbUtil.countRows(tableName));
//        mySqlManager.dropTable(tableName);
//    }
//
//    @Test
//    public void connect_ShouldThrowsRuntimeException_WhenInvalidPassword() {
//        //Given - Then
//        exception.expect(RuntimeException.class);
//        exception.expectMessage("Could not get database connection\n:databaseName:TEST_DATABASE user:root password:roo,");
//        //When
//        mySqlManager.connect(TEST_DATABASE, "root", "roo");
//    }
//
//    @Test
//    public void shouldContainsTableNames_WhenConnectionSuccessful() {
//        //Given
//        List<Column> userColumns = List.of(new Column("ID", "INTEGER"),
//                new Column("AGE", "INTEGER"));
//
//        List<Column> testColumns = List.of(new Column("ID", "INTEGER"));
//
//        mySqlManager.create("user", userColumns);
//        mySqlManager.create("test", testColumns);
//
//        //When
//        Set<String> tables = mySqlManager.getTableNames();
//        //Then
//        assertTrue(tables.contains("user"));
//        assertTrue(tables.contains("test"));
//
//        mySqlManager.dropTable("user");
//        mySqlManager.dropTable("test");
//    }
//
//    @Test
//    public void shouldContainTableNames_WhenTablesNotEqualToZero() {
//        //Given
//
//        //When
//        Set<String> tables = mySqlManager.getTableNames();
//        //Then
//        assertEquals(0, tables.size());
//    }
//
//    @Test
//    public void shouldDropTable() {
//        //Given
//        String tableName = "car";
//        List<Column> columns = List.of(new Column("ID", "INTEGER"));
//        mySqlManager.create(tableName, columns);
//
//        //When
//        mySqlManager.dropTable("car");
//
//        //Then
//        Set<String> tableNames = mySqlManager.getTableNames();
//        assertFalse(tableNames.contains("car"));
//    }
//
//    @Test
//    public void shouldCreateTable() {
//        //Given
//        String tableName = "cat";
//        List<Column> columns = List.of(new Column("ID", "INTEGER"), new Column("NAME", "VARCHAR(20)"));
//
//        //When
//        mySqlManager.create(tableName, columns);
//
//        //Then
//        Set<String> tables = mySqlManager.getTableNames();
//        assertTrue(tables.contains(tableName));
//        mySqlManager.dropTable(tableName);
//    }
//}
