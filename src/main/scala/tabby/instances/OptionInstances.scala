package tabby
package instances

trait OptionInstances {
  implicit def tabbyStdSemigroupForOption[A: Semigroup]: Semigroup[Option[A]] =
    new OptionSemigroup[A]
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
