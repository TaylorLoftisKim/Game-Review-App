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

    get("/add-user", (request response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("users", User.all());
      model.put("template", "templates/users.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/add-user", (request response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      // User user = User.find(request.queryParams("userName"));
      String userName = request.queryParams("userName");
      String userBio = request.queryParams("userBio");
      User newUser = new User(userName, userBio);
      User.save(newUser);
      model.put("template", "templates/user-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
