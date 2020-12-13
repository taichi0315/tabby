package tabby.instances

import org.scalatest.funsuite.AnyFunSuite
import tabby._
import tabby.implicits._

class OptionInstancesTest extends AnyFunSuite {
  test("semigroup") {
    val x = Option(1)
    val y = Option(2)

    assert((x combine y) == Option(3))
  }

  test("functor") {
    assert(Functor[Option].map(Some(2))(_ + 1) == Some(3))
  }
}
