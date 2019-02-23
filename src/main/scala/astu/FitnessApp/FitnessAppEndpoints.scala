package astu.FitnessApp

import cats.effect.Effect
import org.http4s._
import org.http4s.dsl.Http4sDsl

class FitnessAppEndpoints[F[_]: Effect] extends Http4sDsl[F] {
  def hello: HttpService[F] = HttpService[F] {
    case GET -> Root / "hello" / name =>
      Ok(s"Hello, $name, Welcome to FitnessApp")
  }
}
