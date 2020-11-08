package tabby.instances

import org.scalatest.funsuite.AnyFunSuite
import tabby.implicits._

class OptionInstancesTest extends AnyFunSuite {
  test("semigroup") {
    val x = Option(1)
    val y = Option(2)

    assert((x combine y) == Option(3))
  }
}
