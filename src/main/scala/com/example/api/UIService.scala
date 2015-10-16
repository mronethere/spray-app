package com.example.api

import spray.routing.HttpService

trait UIService {
  self: HttpService =>

  val uiServiceRoute =
    path("ui") {
      get {
        complete {
          <html>
            <body>
              <h1>UI Service</h1>
            </body>
          </html>
        }
      }
    }
}
