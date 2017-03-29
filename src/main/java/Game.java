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
}
