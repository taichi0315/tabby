package tabby.instances

import org.scalatest.funsuite.AnyFunSuite
import tabby._
import tabby.implicits._

class ListInstancesTest extends AnyFunSuite {

  test("functor") {
    assert(Functor[List].map(List(1, 2, 3))(_ + 1) == List(2, 3, 4))
  }
}
