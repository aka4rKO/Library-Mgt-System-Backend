// @GENERATOR:play-routes-compiler
// @SOURCE:/home/arko/Downloads/w1673707/library-manager-backend/conf/routes
// @DATE:Thu Jan 24 23:51:11 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
