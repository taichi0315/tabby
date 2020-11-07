package tabby.instances

import org.scalatest.funsuite.AnyFunSuite
import tabby.implicits._

object IntInstancesTest extends AnyFunSuite {
  test("semigroup") {
    assert(1.combine(2) == 3)
  }
}
