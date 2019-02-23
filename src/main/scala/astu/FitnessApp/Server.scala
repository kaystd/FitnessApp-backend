package astu.FitnessApp

import cats.effect.{Effect, IO}
import fs2.{Stream, StreamApp}
import fs2.StreamApp.ExitCode
import org.http4s.server.blaze._

import scala.concurrent.ExecutionContext.Implicits.global

object Server extends StreamApp[IO] {
  override def stream(args: List[String], requestShutdown: IO[Unit]): Stream[IO, ExitCode] =
    createStream(args, requestShutdown)

  def createStream[F[_]](args: List[String], requestShutdown: F[Unit])
      (implicit E: Effect[F]): Stream[F, ExitCode] =
    BlazeBuilder[F]
      .bindHttp(8080, "localhost")
      .mountService( new FitnessAppEndpoints().hello, "/")
      .serve
}
