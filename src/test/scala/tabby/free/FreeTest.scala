package tabby.free

import org.scalatest.funsuite.AnyFunSuite
import tabby._
import tabby.free._
import tabby.implicits._

class FreeTest extends AnyFunSuite {

  test("case 1") {
    val pure: Pure[Option, Int] = Pure(1)

    val f = pure.flatMap(p => Pure(p + 2))

    assert(f == Pure(3))
  }

  test("case 2") {
    val pure: Pure[Option, Int] = Pure(1)

    val f = pure.map(p => p + 2)

    assert(f == Pure(3))
  }

  test("case 3") {
    val pure1: Pure[Option, Int] = Pure(1)
    val pure2: Pure[Option, Int] = Pure(2)

    val f = pure1.flatMap(p1 =>
      pure2.map(p2 => p1 + p2)
    )

    assert(f == Pure(3))
  }

  test("case 4") {
    val pure1: Pure[Option, Int] = Pure(1)
    val pure2: Pure[Option, Int] = Pure(2)

    val f = for {
      p1 <- pure1
      p2 <- pure2
    } yield p1 + p2

    assert(f == Pure(3))
  } 

  test("case 5") {
    val pure:   Pure[Option, Int]   = Pure(1)
    val impure: Impure[Option, Int] = Impure[Option, Int](Some(pure))

    val f = impure.flatMap(ip => Pure(ip))

    assert(impure == f)

  }
}
