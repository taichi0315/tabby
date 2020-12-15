package tabby.instances

import org.scalatest.funsuite.AnyFunSuite
import tabby._
import tabby.implicits._

class SeqInstancesTest extends AnyFunSuite {

  test("functor") {
    assert(Functor[Seq].map(Seq(1, 2, 3))(_ + 1) == Seq(2, 3, 4))
  }
}
