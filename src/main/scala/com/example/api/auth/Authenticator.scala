package com.example.api.auth

import com.example.core.{UserDetails, FakeDataBase}
import spray.routing.authentication.{UserPass, BasicAuth}
import spray.routing.directives.AuthMagnet

import scala.concurrent.{ExecutionContext, Future}

trait Authenticator {
  def basicUserAuthenticator(implicit ec: ExecutionContext): AuthMagnet[UserDetails] = {
    def validateUser(userPass: Option[UserPass]): Option[UserDetails] = {
      println(s"Hey I've did a validation $userPass")
      for {
        p <- userPass
        user <- FakeDataBase.findUser(p.user, p.pass)
      } yield user
    }

    def authenticator(userPass: Option[UserPass]): Future[Option[UserDetails]] = {
      Future(validateUser(userPass))
    }

    BasicAuth(authenticator _, realm = "Auth")
  }
}