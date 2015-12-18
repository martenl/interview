package de.martenl.interview

import de.martenl.interview.util.datastructures.{Stack, Heap, MutableLinkedList, ArrayList}
import de.martenl.interview.util.datastructures.immutable.{MyNil, Cons, LinkedList}
/**
 * Created by Marten on 19.10.2014.
 */
object App {

  def curry[A,B,C](f:(A,B)=>C):A =>(B=>C) = {a:A => {b:B => f(a,b)}}
  def decurry[A,B,C](f: A => B => C):(A,B) => C = {(a:A,b:B) => f(a)(b)}
  def compose[A,B,C](f:B => C,g:A => B):A=>C = {a:A => f(g(a))}

  def main(args:Array[String]): Unit ={
    /*val printFunc = (x:Int)=>println(x)
    val list = LinkedList(0,1,2,3,4,5)
    list.remove(-2)
    list.add(-123,0)
    list.foreach(printFunc)
    val myHeap = Heap(2,7,25,19,1,17,3,36,100)
    myHeap.print()
    val stack = Stack()
    println(stack.pop())
    stack.push(1)
    stack.push(2)
    println(stack.pop())*/

    //val myList = ArrayList(1,2,3)
    //myList.print()
    val myList = Cons(1,Cons(2,MyNil))
    val myOtherList = myList.map(x=>x*x)
    myOtherList.print()
    println(decurry(curry((a:Int,b:Int)=>{ a +b }))(1,1))
    println(compose({a:Int => 2*a},{b:Int => b+1})(2))
  }
}
