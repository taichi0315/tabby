package tabby
package instances

trait EitherInstances {
  implicit val tabbyStdFunctorForEither: Functor[Either] = new Functor[Either] {
    def map[A, B](fa: Either[A])(f: A => B): Option[B] = fa.map(f)
  }
}
