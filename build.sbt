ThisBuild / version := "0.1.0-SNAPSHOT"


version := "1.0"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.6.5" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")


lazy val root = (project in file("."))
  .settings(
    name := "demo-project-1"
  )
