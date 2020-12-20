package tabby
package free

sealed trait Free[S[_], A] {

  def map[B](f: A => B)(implicit S: Functor[S]): Free[S, B] = flatMap(a => Pure(f(a)))

  def flatMap[B](f: A => Free[S, B])(implicit F: Functor[S]): Free[S, B] =
    this match {
      case Pure(a) => f(a)
      case FlatMapped(ff) => FlatMapped(F.map(ff)(_.flatMap(f)))
    }
}

case class Pure[S[_], A](a: A) extends Free[S, A]
case class FlatMapped[S[_], A](ff: S[Free[S, A]]) extends Free[S, A]
