package example.free

import org.scalatest.funsuite.AnyFunSuite

class KVStoreTest extends AnyFunSuite {
  import kvstore._

  test("program") {
    def program: KVStore[Option[Int]] =
      for {
        _ <- put("wild-cats", 2)
        _ <- update[Int]("wild-cats", (_ + 12))
        _ <- put("tame-cats", 5)
        n <- get[Int]("wild-cats")
        _ <- delete("tame-cats")
      } yield n

    println(program)
  }
}
