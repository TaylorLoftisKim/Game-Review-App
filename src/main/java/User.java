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

  public int getId() {
    return id;
  }

  public static List<User> all() {
    String sql = "SELECT id, userName FROM users";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(User.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO users (userName, bio) VALUES (:userName, :userBio)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("userName", this.userName)
      .addParameter("userBio", this.userBio)
      .executeUpdate()
      .getKey();
    }
  }

  public static User find(int id) {
   try(Connection con = DB.sql2o.open()) {
     String sql = "SELECT * FROM users WHERE id=:id";
     User user = con.createQuery(sql)
     .addParameter("id", id)
     .executeAndFetchFirst(User.class);
     return user;
   }
 }

  @Override
  public boolean equals(Object otherUser){
    if (!(otherUser instanceof User)) {
      return false;
    } else {
      User newUser = (User) otherUser;
      return this.getUserName().equals(newUser.getUserName()) && this.getId() == newUser.getId();
    }
  }
}
