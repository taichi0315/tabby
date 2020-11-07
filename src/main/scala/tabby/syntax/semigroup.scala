package tabby
package syntax

trait SemigroupSyntax {
  implicit final def tabbySyntaxSemigroup[A: Semigroup](a: A): SemigroupOps[A] =
    new SemigroupOps[A](a)
}

final class SemigroupOps[A](lhs: A) {
  def combine(rhs: A)(implicit sa: Semigroup[A]): A = sa.combine(lhs, rhs)
}
