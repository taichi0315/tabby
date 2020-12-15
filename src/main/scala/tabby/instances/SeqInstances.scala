package tabby
package instances

trait SeqInstances {
  implicit val tabbyStdFunctorForSeq: Functor[Seq] = new Functor[Seq] {
    def map[A, B](fa: Seq[A])(f: A => B): Seq[B] = fa.map(f)
  }
}
