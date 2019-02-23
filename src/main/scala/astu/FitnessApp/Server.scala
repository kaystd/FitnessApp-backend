package astu.FitnessApp

import cats.effect.{IO, IOApp}
import org.http4s.server.blaze._
import cats.effect._
import cats.implicits._
import org.http4s.server.{Server => H4Server}

object Server extends IOApp {

  def createServer[F[_]: ContextShift : ConcurrentEffect : Timer]: Resource[F, H4Server[F]] =
    BlazeServerBuilder[F]
      .bindHttp(8080, "localhost")
      .withHttpApp( new FitnessAppEndpoints().hello)
      .resource

  def run(args : List[String]) : IO[ExitCode] = createServer.use(_ => IO.never).as(ExitCode.Success)
}
