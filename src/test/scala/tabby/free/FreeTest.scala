package tabby.free

import org.scalatest.funsuite.AnyFunSuite
import tabby._
import tabby.free._
import tabby.implicits._

class FreeTest extends AnyFunSuite {

  test("case 1") {
    val pure: Free[Option, Int] = Pure(1)

    val f = pure.flatMap(p => Pure(p + 2))

    assert(f == Pure(3))
  }

  test("case 2") {
    val pure: Free[Option, Int] = Pure(1)

    val f = pure.map(p => p + 2)

    assert(f == Pure(3))
  }

  test("case 3") {
    val pure1: Free[Option, Int] = Pure(1)
    val pure2: Free[Option, Int] = Pure(2)

    val f = pure1.flatMap(p1 =>
      pure2.map(p2 => p1 + p2)
    )

    assert(f == Pure(3))
  }

  test("case 4") {
    val pure1: Free[Option, Int] = Pure(1)
    val pure2: Free[Option, Int] = Pure(2)

    val f = for {
      p1 <- pure1
      p2 <- pure2
    } yield p1 + p2

    assert(f == Pure(3))
  } 
}
