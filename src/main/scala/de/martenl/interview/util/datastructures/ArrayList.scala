package de.martenl.interview.util.datastructures

/**
 * Created by Marten on 24.08.2015.
 */

object ArrayList {}

/* def apply[V]():ArrayList[V] = {
  val data:Array[V] = new Array[V](5)
  new ArrayList[V](data,0)
}

 def ly[V](capacity:Int) = {
  val data = new Array[V](capacity)
  new ArrayList[V](data,0)
}

def apply[V](initData:V*) = {
  val numberOfElements = initData.length
  val data:Array[V] = new Array[V](numberOfElements*2)
  for(i <- 0.until(numberOfElements)){
    data(i) = initData(i)
  }
  new ArrayList[V](data,numberOfElements)
}
}

class ArrayList[V](val data:Array[V],var lastPosition:Int) {

def capacity():Int = {
  data.length
}

def size():Int = {
  lastPosition+1
}

def isEmpty():Boolean = {
  lastPosition == 0
}

def get(position:Int):Option[V] = {
  if(position < lastPosition){
    Some(data(position))
  }else{
    None
  }
}

def add(elem:V):ArrayList[V] = {
  if(lastPosition >= capacity()){
    //resize data
  }
  data(lastPosition) = elem
  lastPosition+=1
  this
}

def add(elems:V*):ArrayList[V] = {
  val endPosition = lastPosition+elems.length
  if(endPosition > capacity()){
    this
  }else{
    for(i <- lastPosition.until(endPosition);j <- 0.until(elems.length)){
      data(i) = elems(j)
    }
    this
  }
}

def remove(position:Int):Option[V] = {
  if(position<lastPosition){
    val removedElem = data(position)
    for(i <- position.until(lastPosition-1)){
      data(i) = data(i+1)
    }
    lastPosition-=1
    Some(removedElem)
  } else {
    None
  }
}

def print(): Unit ={
  for(v <- data){
    println(v)
  }
}
}*/