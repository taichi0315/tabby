package tabby
package instances

trait OptionInstances {
  implicit def tabbyStdSemigroupForOption[A: Semigroup]: Semigroup[Option[A]] =
    new OptionSemigroup[A]

  implicit val tabbyStdFunctorForOption: Functor[Option] = new Functor[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }
}

class OptionSemigroup[A](implicit A: Semigroup[A]) extends Semigroup[Option[A]] {
  def combine(x: Option[A], y: Option[A]): Option[A] =
    x match {
      case None    => y
      case Some(a) =>
        y match {
          case None    => x
          case Some(b) => Some(A.combine(a, b))
        }
    }
}
