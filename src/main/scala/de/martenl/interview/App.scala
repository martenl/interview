package de.martenl.interview

import de.martenl.interview.util.datastructures.{Stack, Heap, LinkedList}

/**
 * Created by Marten on 19.10.2014.
 */
object App {

  def main(args:Array[String]): Unit ={
    /*val printFunc = (x:Int)=>println(x)
    val list = LinkedList(0,1,2,3,4,5)
    list.remove(-2)
    list.add(-123,0)
    list.foreach(printFunc)
    val myHeap = Heap(2,7,25,19,1,17,3,36,100)
    myHeap.print()*/
    val stack = Stack()
    println(stack.pop())
    stack.push(1)
    stack.push(2)
    println(stack.pop())
  }
}
