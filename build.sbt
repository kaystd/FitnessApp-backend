name := "FitnessApp-backend"

version := "0.2"

scalaVersion := "2.12.8"

organization := "astu"

val http4sVersion     = "0.20.0-M6"
val logbackVersion    = "1.2.3"
val pureConfigVersion = "0.10.2"
val doobieVersion     = "0.6.0"

libraryDependencies ++= Seq(
  "org.http4s"             %% "http4s-dsl"           % http4sVersion,
  "org.http4s"             %% "http4s-blaze-server"  % http4sVersion,
  "ch.qos.logback"         %  "logback-classic"      % logbackVersion,
  "com.github.pureconfig"  %% "pureconfig"           % pureConfigVersion,
  "org.tpolecat"           %% "doobie-core"          % doobieVersion,
  "org.tpolecat"           %% "doobie-postgres"      % doobieVersion,
  "org.tpolecat"           %% "doobie-specs2"        % doobieVersion,
  "org.tpolecat"           %% "doobie-hikari"        % doobieVersion,
)

scalacOptions ++= Seq(
  "-language:higherKinds",
  "-Ypartial-unification"
)

enablePlugins(FlywayPlugin)

flywayUrl := "jdbc:postgresql:fitness-app"
flywayUser := "postgres"
flywayPassword := "admin"
flywayLocations += "db/migration"
flywayUrl in Test := "jdbc:postgresql:fitness-app"
flywayUser in Test := "postgres"
flywayPassword in Test := "admin"
