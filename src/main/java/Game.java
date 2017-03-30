import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Game {
  private int id;
  private String gameName;
  private String genre;
  private String details;
  private String platform;

  public Game(String gameName, String genre, String details, String platform) {
    this.gameName = gameName;
    this.genre = genre;
    this.details = details;
    this.platform = platform;
  }

  public String getGameName() {
    return gameName;
  }

  public String getGenre() {
    return genre;
  }

  public String getDetails() {
    return details;
  }

  public String getPlatform() {
    return platform;
  }

  public static Game find(int id) {
   try(Connection con = DB.sql2o.open()) {
     String sql = "SELECT * FROM games WHERE id=:id";
     Game game = con.createQuery(sql)
     .addParameter("id", id)
     .executeAndFetchFirst(Game.class);
     return game;
   }
 }

  public static List<Game> all() {
    String sql = "SELECT id, gameName FROM games";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Game.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO games(gameName) VALUES (:gameName)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("gameName", this.gameName)
        .executeUpdate()
        .getKey();
    }
  }

  @Override
  public boolean equals(Object otherGame) {
    if (!(otherGame instanceof Game)) {
      return false;
    } else {
      Game newGame = (Game) otherGame;
      return this.getGameName().equals(newGame.getGameName()) &&
      this.getId() == newGame.getId();
    }
  }

  public int getId() {
    return id;
  }

}
