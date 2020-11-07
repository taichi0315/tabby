package tabby
package instances

trait IntInstances {
  implicit val intSemigroup: Semigroup[Int] = new Semigroup[Int] {
    def combine(x: Int, y: Int): Int = x + y
  }
}
