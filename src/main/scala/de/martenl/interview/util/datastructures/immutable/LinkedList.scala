package de.martenl.interview.util.datastructures.immutable


sealed trait LinkedList[+A]{
  def map[B](func : (A)=>B):LinkedList[B]

  def print():Unit

  def reduce[B,T >: A](func:(T,T)=>Option[B],value : T):Option[B]
}

case object MyNil extends LinkedList[Nothing] {
  override def map[B](func: (Nothing) => B): LinkedList[B] = this

  override def print(): Unit = println("Nil")

  override def reduce[B, T >: Nothing](func: (T, T) => Option[B], value: T): Option[B] = None
}

case class Cons[+A](head:A,tail:LinkedList[A]) extends LinkedList[A] {
  override def map[B](func: (A) => B): LinkedList[B] = Cons(func(head),tail.map(func))

  override def print(): Unit = {
    println(head)
    tail.print()
  }

  override def reduce[B, T >: A](func: (T, T) => Option[B], value: T): Option[B] = None
}