package com.summer.structure

import scala.concurrent.Future
import scala.language.implicitConversions

abstract class Fither[+A, +B] {

  val value: Future[Either[A, B]]

  val await = 3L

}
