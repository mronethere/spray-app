package com.example.api

import akka.actor.Actor
import com.example.api.auth.Authenticator
import spray.routing.HttpService

trait LoginService extends Authenticator {
  this: Actor with HttpService =>

  import this.context.dispatcher

  val loginServiceRoute =
    path("login") {
      authenticate(basicUserAuthenticator) { user =>
        complete(s"${user.email} \n " /*+ request.headers.mkString("\n")*/)
      }
    } ~ path("login2") {
      complete("1"/*x.request.headers.mkString("\n")*/)
    }
}
