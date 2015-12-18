package de.martenl.interview.util.datastructures

/**
 * Created by Marten on 24.01.2015.
 */

object Queue{
  
  def apply():Queue = {
    new Queue(true,MutableLinkedList())
  }
  
  def lifoQueue():Queue = {
    new Queue(false,MutableLinkedList())
  }
}
class Queue(val fifo:Boolean,data:MutableLinkedList) {

  def queue(x:Int):Queue = {
    if(fifo){
      data.add(x)
    }else{
      data.push(x)
    }
    this
  }

  def dequeue():Int = {
    data.pop()
  }
}
