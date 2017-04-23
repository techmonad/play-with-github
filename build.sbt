name := """play-with-github"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

val playVersion = "2.5.0"

libraryDependencies ++= Seq(jdbc, cache, ws, evolutions)

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % playVersion,
  "org.webjars.bower" % "adminlte" % "2.3.11",
  "org.webjars" % "font-awesome" % "4.3.0-2",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

TwirlKeys.templateImports += "domains._"

