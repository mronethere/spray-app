package com.example.core

import akka.actor.Actor
import com.example.api._
import spray.routing.HttpService


class RequestHandlerActor extends Actor with HttpService
                                   with UIService
                                   with LoginService
                                   with DataService {

  def actorRefFactory = context

  def receive = runRoute(loginServiceRoute)
}

