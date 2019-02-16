package astu.FitnessApp

import cats.effect.IO
import org.http4s._
import org.http4s.dsl.io._

object FitnessApp {
  val helloService: HttpService[IO] = HttpService[IO] {
    case GET -> Root / "hello" / name =>
      Ok(s"Hello, $name, Welcome to FitnessApp")
  }
}
