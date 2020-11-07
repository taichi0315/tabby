package tabby

trait Semigroup[A] {
  def combine(x: A, y: A): A
}
