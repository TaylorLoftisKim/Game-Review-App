import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class GameTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/gaming_site_test", null, null);
  }

  @After
  public void tearDown() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM games *;";
      con.createQuery(sql).executeUpdate();
    }
  }

  @Test
  public void games_instanceOfGames_true() {
    Game test = new Game("TestGameName","String2","String3","String4");
    assertEquals(true, test instanceof Game);
  }

  @Test
  public void getGameName_returnsGameName_test() {
    Game test = new Game("TestGameName","String2","String3","String4");
    assertEquals("TestGameName", test.getGameName());
  }

  @Test
  public void getGenre_returnsGameGenre_Action() {
    Game test = new Game("TestGameName","Action","String3","String4");
    assertEquals("Action", test.getGenre());
  }

  @Test
  public void getDetails_returnsGameDetails_String3() {
    Game test = new Game("TestGameName","Action","String3","String4");
    assertEquals("String3", test.getDetails());
  }

  @Test
  public void getDetails_returnsGamePlatform_String4() {
    Game test = new Game("TestGameName","Action","String3","String4");
    assertEquals("String4", test.getPlatform());
  }
  @Test
  public void find_returnsGamesinDatabase_true() {
    Game test2 = new Game("TestGameName", "Action", "String3", "String4");
    test2.save();
    assertEquals(test2, Game.find(test2.getId()));
  }

}
