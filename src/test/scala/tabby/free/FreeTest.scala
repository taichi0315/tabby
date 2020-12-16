package tabby.free

import org.scalatest.funsuite.AnyFunSuite
import tabby._
import tabby.free._
import tabby.implicits._

class FreeTest extends AnyFunSuite {

  test("simple map") {
    val pure1: Free[Option, Int] = Pure(1)

    val f = pure1.map(p1 => p1 + 2)

    println(f)
  }

  test("simple flatMap") {
    val pure1: Free[Option, Int] = Pure(1)

    val f = pure1.flatMap(p1 => Pure(p1 + 2))

    println(f)
  }
}
