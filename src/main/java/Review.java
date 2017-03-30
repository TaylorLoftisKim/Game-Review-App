import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Review {
  private int id;
  private String gameName;
  private String gameGenre;
  private String platform;
  private int rating;

  public Review(String gameName, String gameGenre, String platform, int rating) {
    this.gameName = gameName;
    this.gameGenre = gameGenre;
    this.rating = rating;
    this.platform = platform;
  }

  public String getGameName() {
    return gameName;
  }

  public String getGameGenre() {
    return gameGenre;
  }

  public int getRating() {
    return rating;
  }

  public String getPlatform() {
    return platform;
  }

  public static Review find(int id) {
   try(Connection con = DB.sql2o.open()) {
     String sql = "SELECT * FROM reviews WHERE id=:id";
     Review review = con.createQuery(sql)
     .addParameter("id", id)
     .executeAndFetchFirst(Review.class);
     return review;
   }
  }
}
