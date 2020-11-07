package tabby.instances

import org.scalatest.funsuite.AnyFunSuite
import tabby.implicits._

class IntInstancesTest extends AnyFunSuite {
  test("semigroup") {
    assert((1 combine 2) == 3)
    assert((3 |+| 4) == 7)
  }
}
