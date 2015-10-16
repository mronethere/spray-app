package com.example.api

import spray.routing.HttpService

trait DataService {
  self: HttpService =>

  val dataServiceRoute =
    path("data") {
      get {
        complete {
          <html>
            <body>
              <h1>Data Service</h1>
            </body>
          </html>
        }
      }
    }
}
