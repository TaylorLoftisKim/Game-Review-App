import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/add-user", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/add-user.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/add-user", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      String userName = request.queryParams("userName");
      String userBio = request.queryParams("userBio");
      User newUser = new User(userName, userBio);
      newUser.save();
      model.put("users", User.all());
      model.put("template", "templates/added-user.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/games", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("games", Game.all());
      model.put("template", "templates/games.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/games/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Game game = Game.find(Integer.parseInt(request.params(":id")));
      Review review = Review.find(Integer.parseInt(request.params(":id")));
      model.put("game", game);
      model.put("review", review);
      model.put("template", "templates/game.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/users", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("users", User.all());
      model.put("template", "templates/users.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/user/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      User user = User.find(Integer.parseInt(request.params(":id")));
      model.put("users", "templates/user.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
