package example

import tabby.Semigroup

case class Money(value: Int)

object Money {
  implicit val moneySemigroup: Semigroup[Money] = new Semigroup[Money] {
    def combine(x: Money, y: Money): Money = Money(x.value + y.value)
  }
}
