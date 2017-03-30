// import org.sql2o.*;
// import org.junit.*;
// import static org.junit.Assert.*;
//
// public class GameTest {
//
//   @Before
//   public void setUp() {
//     DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/gaming_site_test", null, null);
//   }
//
//   @After
//   public void tearDown() {
//     try (Connection con = DB.sql2o.open()) {
//       String sql = "DELETE FROM games *;";
//       con.createQuery(sql).executeUpdate();
//     }
//   }
//
//   @Test
//   public void reviews_instanceOfReviews_true() {
//     Review test = new Review("TestReview");
//     assertEquals(true, test instanceof Review);
//
//   }
// }
