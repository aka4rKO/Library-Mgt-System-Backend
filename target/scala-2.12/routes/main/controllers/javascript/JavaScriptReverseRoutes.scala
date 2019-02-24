// @GENERATOR:play-routes-compiler
// @SOURCE:/home/arko/Downloads/w1673707/library-manager-backend/conf/routes
// @DATE:Thu Jan 24 23:51:11 IST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def addDvd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addDvd",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "dvd"})
        }
      """
    )
  
    // @LINE:11
    def addBook: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addBook",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "book"})
        }
      """
    )
  
    // @LINE:23
    def deleteItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.deleteItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delete"})
        }
      """
    )
  
    // @LINE:25
    def borrowItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.borrowItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "borrow"})
        }
      """
    )
  
    // @LINE:15
    def getBooks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getBooks",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "books"})
        }
      """
    )
  
    // @LINE:19
    def getReaderId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getReaderId",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "readerid"})
        }
      """
    )
  
    // @LINE:27
    def returnItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.returnItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "return"})
        }
      """
    )
  
    // @LINE:17
    def getDvds: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getDvds",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dvds"})
        }
      """
    )
  
    // @LINE:21
    def addReader: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addReader",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reader"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:29
    def generateReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.generateReport",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "report"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
