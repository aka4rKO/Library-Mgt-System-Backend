// @GENERATOR:play-routes-compiler
// @SOURCE:/home/arko/Downloads/w1673707/library-manager-backend/conf/routes
// @DATE:Thu Jan 24 23:51:11 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def addDvd(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "dvd")
    }
  
    // @LINE:11
    def addBook(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "book")
    }
  
    // @LINE:23
    def deleteItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "delete")
    }
  
    // @LINE:25
    def borrowItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "borrow")
    }
  
    // @LINE:15
    def getBooks(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "books")
    }
  
    // @LINE:19
    def getReaderId(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "readerid")
    }
  
    // @LINE:27
    def returnItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "return")
    }
  
    // @LINE:17
    def getDvds(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dvds")
    }
  
    // @LINE:21
    def addReader(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "reader")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:29
    def generateReport(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "report")
    }
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
