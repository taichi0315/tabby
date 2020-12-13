package tabby
package instances

trait ListInstances {
  implicit val tabbyStdFunctorForList: Functor[List] = new Functor[List] {
    def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }
}
