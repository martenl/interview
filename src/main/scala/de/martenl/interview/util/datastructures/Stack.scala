package de.martenl.interview.util.datastructures

/**
 * Created by Marten on 24.01.2015.
 */

object Stack{

  def apply():Stack = {
    new Stack(MutableLinkedList())
  }
}
class Stack(data:MutableLinkedList) {


  def push(x:Int):Stack = {
    data.push(x)
    this
  }

  def pop():Int = {
    data.pop()
  }
}
