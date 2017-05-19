package controllers
import play.api._
import play.api.mvc._

class Application extends Controller {


  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def hello(passedName: String) = Action {
    Ok(views.html.hello("Hello there", passedName))
  }

}
