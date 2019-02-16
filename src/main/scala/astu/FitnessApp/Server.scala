package astu.FitnessApp

import cats.effect.IO
import fs2.{Stream, StreamApp}
import fs2.StreamApp.ExitCode
import org.http4s.server.blaze._
import scala.concurrent.ExecutionContext.Implicits.global

object Server extends StreamApp[IO] {
  override def stream(args: List[String], requestShutdown: IO[Unit]): Stream[IO, ExitCode] =
    BlazeBuilder[IO]
    .bindHttp(8080, "localhost")
    .mountService(FitnessApp.helloService, "/")
    .serve
}
