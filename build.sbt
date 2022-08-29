ThisBuild / scalaVersion := "2.13.8"

lazy val root = project.in(file("."))
  .settings(
    libraryDependencies += "org.antlr" % "antlr4-runtime" % "4.10.1",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % Test,
    scalacOptions ++= Seq(
      "-deprecation"
    )
  )