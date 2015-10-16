import sbt.Keys._

lazy val commonSettings = Seq(
  organization := "com.example",
  version := "1.0.0-SNAPSHOT",
  scalaVersion := "2.11.7",
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "spray-app",
    libraryDependencies ++= {
      val akkaV = "2.4.0"
      val sprayV = "1.3.3"
      Seq(
        "io.spray"            %%  "spray-can"     % sprayV,
        "io.spray"            %%  "spray-routing" % sprayV,
        "io.spray"            %%  "spray-testkit" % sprayV  % "test",
        "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
        "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
        "org.specs2"          %%  "specs2-core"   % "3.6.4" % "test"
      )
    })
  .settings(Revolver.settings: _*)



