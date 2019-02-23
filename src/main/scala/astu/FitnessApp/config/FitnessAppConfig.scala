package astu.FitnessApp.config

import cats.effect.Effect
import cats.implicits._
import pureconfig._
import pureconfig.generic.auto._
import pureconfig.error.ConfigReaderException

case class FitnessAppConfig(db: DatabaseConfig)

object SimpleApiConfig {
  def load[F[_]](implicit E: Effect[F]): F[FitnessAppConfig] =
    E.delay(loadConfig[FitnessAppConfig]("fitness-app")).flatMap {
      case Right(ok) => E.pure(ok)
      case Left(e) => E.raiseError(new ConfigReaderException[FitnessAppConfig](e))
    }
}