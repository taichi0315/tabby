package example

import org.scalatest.funsuite.AnyFunSuite

import tabby.implicits._

class MoneyTest extends AnyFunSuite {

  test("semigroup") {
    val x = Money(1)
    val y = Money(2)

    assert((x combine y) == Money(3))
    assert((x |+| y) == Money(3))
  }
}
