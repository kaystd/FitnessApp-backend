name := "FitnessApp-backend"

version := "0.1"

scalaVersion := "2.12.8"

organization := "astu"

val http4sVersion    = "0.18.21"
val logbackVersion   = "1.2.3"

libraryDependencies ++= Seq(
  "org.http4s"      %% "http4s-dsl"           % http4sVersion,
  "org.http4s"      %% "http4s-blaze-server"  % http4sVersion,
  "ch.qos.logback"  %  "logback-classic"      % logbackVersion
)

scalacOptions ++= Seq(
  "-language:higherKinds",
  "-Ypartial-unification"
)
