import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class User {
  private int id;
  private String userName;
  private String userBio;

  public User(String userName, String userBio) {
    this.userName = userName;
    this.userBio = userBio;
  }
  public String getUserName() {
    return userName;
  }

  public String getUserBio() {
    return userBio;
  }

}
