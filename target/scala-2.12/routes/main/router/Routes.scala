// @GENERATOR:play-routes-compiler
// @SOURCE:/home/arko/Downloads/w1673707/library-manager-backend/conf/routes
// @DATE:Thu Jan 24 23:51:11 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:9
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """book""", """controllers.HomeController.addBook"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dvd""", """controllers.HomeController.addDvd"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books""", """controllers.HomeController.getBooks"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dvds""", """controllers.HomeController.getDvds"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """readerid""", """controllers.HomeController.getReaderId"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """reader""", """controllers.HomeController.addReader"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete""", """controllers.HomeController.deleteItem"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """borrow""", """controllers.HomeController.borrowItem"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """return""", """controllers.HomeController.returnItem"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """report""", """controllers.HomeController.generateReport"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_addBook2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("book")))
  )
  private[this] lazy val controllers_HomeController_addBook2_invoker = createInvoker(
    HomeController_0.addBook,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addBook",
      Nil,
      "POST",
      this.prefix + """book""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HomeController_addDvd3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dvd")))
  )
  private[this] lazy val controllers_HomeController_addDvd3_invoker = createInvoker(
    HomeController_0.addDvd,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addDvd",
      Nil,
      "POST",
      this.prefix + """dvd""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_getBooks4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books")))
  )
  private[this] lazy val controllers_HomeController_getBooks4_invoker = createInvoker(
    HomeController_0.getBooks,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getBooks",
      Nil,
      "GET",
      this.prefix + """books""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_HomeController_getDvds5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dvds")))
  )
  private[this] lazy val controllers_HomeController_getDvds5_invoker = createInvoker(
    HomeController_0.getDvds,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getDvds",
      Nil,
      "GET",
      this.prefix + """dvds""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_HomeController_getReaderId6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("readerid")))
  )
  private[this] lazy val controllers_HomeController_getReaderId6_invoker = createInvoker(
    HomeController_0.getReaderId,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getReaderId",
      Nil,
      "GET",
      this.prefix + """readerid""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_HomeController_addReader7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("reader")))
  )
  private[this] lazy val controllers_HomeController_addReader7_invoker = createInvoker(
    HomeController_0.addReader,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addReader",
      Nil,
      "POST",
      this.prefix + """reader""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_HomeController_deleteItem8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete")))
  )
  private[this] lazy val controllers_HomeController_deleteItem8_invoker = createInvoker(
    HomeController_0.deleteItem,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "deleteItem",
      Nil,
      "POST",
      this.prefix + """delete""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_HomeController_borrowItem9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("borrow")))
  )
  private[this] lazy val controllers_HomeController_borrowItem9_invoker = createInvoker(
    HomeController_0.borrowItem,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "borrowItem",
      Nil,
      "POST",
      this.prefix + """borrow""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_HomeController_returnItem10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("return")))
  )
  private[this] lazy val controllers_HomeController_returnItem10_invoker = createInvoker(
    HomeController_0.returnItem,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "returnItem",
      Nil,
      "POST",
      this.prefix + """return""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_HomeController_generateReport11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("report")))
  )
  private[this] lazy val controllers_HomeController_generateReport11_invoker = createInvoker(
    HomeController_0.generateReport,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "generateReport",
      Nil,
      "GET",
      this.prefix + """report""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:11
    case controllers_HomeController_addBook2_route(params@_) =>
      call { 
        controllers_HomeController_addBook2_invoker.call(HomeController_0.addBook)
      }
  
    // @LINE:13
    case controllers_HomeController_addDvd3_route(params@_) =>
      call { 
        controllers_HomeController_addDvd3_invoker.call(HomeController_0.addDvd)
      }
  
    // @LINE:15
    case controllers_HomeController_getBooks4_route(params@_) =>
      call { 
        controllers_HomeController_getBooks4_invoker.call(HomeController_0.getBooks)
      }
  
    // @LINE:17
    case controllers_HomeController_getDvds5_route(params@_) =>
      call { 
        controllers_HomeController_getDvds5_invoker.call(HomeController_0.getDvds)
      }
  
    // @LINE:19
    case controllers_HomeController_getReaderId6_route(params@_) =>
      call { 
        controllers_HomeController_getReaderId6_invoker.call(HomeController_0.getReaderId)
      }
  
    // @LINE:21
    case controllers_HomeController_addReader7_route(params@_) =>
      call { 
        controllers_HomeController_addReader7_invoker.call(HomeController_0.addReader)
      }
  
    // @LINE:23
    case controllers_HomeController_deleteItem8_route(params@_) =>
      call { 
        controllers_HomeController_deleteItem8_invoker.call(HomeController_0.deleteItem)
      }
  
    // @LINE:25
    case controllers_HomeController_borrowItem9_route(params@_) =>
      call { 
        controllers_HomeController_borrowItem9_invoker.call(HomeController_0.borrowItem)
      }
  
    // @LINE:27
    case controllers_HomeController_returnItem10_route(params@_) =>
      call { 
        controllers_HomeController_returnItem10_invoker.call(HomeController_0.returnItem)
      }
  
    // @LINE:29
    case controllers_HomeController_generateReport11_route(params@_) =>
      call { 
        controllers_HomeController_generateReport11_invoker.call(HomeController_0.generateReport)
      }
  }
}
