package de.martenl.interview.util.datastructures

/**
 * Created by Marten on 19.10.2014.
 */

object Heap{

  val max:(Int,Int)=>Boolean = (x:Int,y:Int) => x > y

  def apply(data:Int*):Heap= {
    new Heap(buildHeap(data.toArray,max))
  }

  def apply(cmp:(Int,Int)=>Boolean,data:Int*):Heap = {
    new Heap(buildHeap(data.toArray,cmp))
  }

  def buildHeap(data : Array[Int],cmp:(Int,Int)=>Boolean):Array[Int] = {
    val middleOfArray = data.length / 2
    for(i <- middleOfArray.to(0,-1)){
      heapify(i,data,cmp)
    }
    data
  }

  def heapify(i:Int,data : Array[Int],cmp:(Int,Int)=>Boolean):Array[Int] = {
    val l = left(i)
    val r = right(i)
    var largest = i
    if(l < data.length && cmp(data(l),data(largest))){
        largest = l
    }
    if(r < data.length && cmp(data(r),data(largest))){
      largest = r
    }
    if(largest != i){
      val first = data(i)
      data(i) = data(largest)
      data(largest) = first
      heapify(largest,data,cmp)
    }
    data
  }

  private def parent(i:Int):Int = {
    Math.floor((i-1) / 2).toInt
  }

  private def left(i:Int):Int = {
    i*2 +1
  }

  private def right(i:Int):Int = {
    i*2 + 2
  }


}


class Heap(val data : Array[Int]) {

  def peek():Int = {
    data(0)
  }

  def print(): Unit ={
    for(datum <- data){
      println(datum)
    }
  }

}
