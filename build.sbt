name := """batsounds"""
organization := "com.almorcrette"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.11"

libraryDependencies += guice

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.1.1",
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.almorcrette.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.almorcrette.binders._"
