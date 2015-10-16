package com.example.core

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import spray.can.Http

import scala.concurrent.duration._

object Boot extends App {
  // an actor system on which the app is hosted
  implicit val system = ActorSystem("spray-app")

  // service actor which handles http requests
  val service = system.actorOf(Props[RequestHandlerActor], "http-service")

  implicit val timeout = Timeout(5.seconds)
  // start a new HTTP server on port 8080 with service actor as the handler
  IO(Http) ? Http.Bind(service, interface = "localhost", port = 9000)
}


object FakeDataBase {
  val users = List(
    UserDetails("misha", "pass", "email@gmail.com"),
    UserDetails("hello", "pass", "hello@gmail.com"),
    UserDetails("some", "pass", "some@gmail.com"),
    UserDetails("any", "pass", "any@gmail.com")
  )
  def findUser(username: String, password: String) =
    users.find(u => u.username == username && u.password == password)
}

case class UserDetails(username: String, password: String, email: String)