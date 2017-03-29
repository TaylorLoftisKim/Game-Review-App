import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class UserTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/gaming_site_test", null, null);
  }

  // @After
  // public void tearDown() {
  //   try (Connection con = DB.sql2o.open()) {
  //     String sql = "DELETE FROM users *;";
  //     con.createQuery(sql).executeUpdate();
  //   }
  // }

  @Test
  public void games_instanceOfUser_true() {
    User test = new User("TestUser", "I <3 games rawr XD Notice me senpai (´･ω･`) / https://twitch.tv/narutoLover");
    assertEquals(true, test instanceof User);
  }

  @Test
  public void all_returnsAllInstancesOfUser_true() {
    User testUser = new User("TestUser", "String");
    testUser.save();
    assertEquals(true, User.all().contains(testUser));
  }

  @Test
  public void getUserName_returnsUserName_Jack() {
    User test = new User("Samurai Jack", "Hash Slinging Slasher");
    assertEquals("Samurai Jack", test.getUserName());
  }

  @Test
  public void getUserBio_returnsUserBio_bio() {
    User test = new User("Samurai Jack", "Hash Slinging Slasher");
    assertEquals("Hash Slinging Slasher", test.getUserBio());
  }


}
