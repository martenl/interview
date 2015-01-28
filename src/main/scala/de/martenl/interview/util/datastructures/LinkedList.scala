package de.martenl.interview.util.datastructures

/**
 * Created by Marten on 19.10.2014.
 */

object LinkedList {

  def apply(data :Int*): LinkedList ={
    new LinkedList(data)
  }
}


class LinkedList(data :Seq[Int])  {

  var root : Option[Node] = None

  for(x <- data){
    add(x)
  }

  def size():Int = {
    root match {
      case Some(rootElem) => rootElem.size()
      case None => 0
    }
  }

  def isEmpty(): Boolean = {
    root match {
      case Some(_) => false
      case _ => true
    }
  }

  def clear(): Unit ={
    root = None
  }

  def get(index:Int):Int={
    root match {
      case Some(rootElem) => rootElem.get(index)
      case None => -1
    }
  }

  def contains(value:Int): Boolean = {
    root match {
      case Some(rootElem) => rootElem.contains(value)
      case None => false
    }
  }

  def indexOf(value:Int): Int = {
    root match {
      case Some(rootElem) => rootElem.indexOf(value,0)
      case None => -1
    }
  }

  def set(index:Int,value:Int): Int = {
    root match {
      case Some(rootElem) => {
        if(index == 0) {
          val _root = root.get
          root = Some(new Node(value))
          root.get.next = _root.next
          _root.data
        }else{
          rootElem.set(index,0,value)
        }
      }
      case None => -1
    }
  }

  def add(value:Int): Unit ={
    root match {
        case Some(rootElem) => rootElem.addNode(value)
        case None => root = Some(new Node(value))
    }
  }

  def add(value:Int,index:Int): Unit ={
    index match {
      case 0 => push(value)
      case _ if index > 0 => {
        root match{
          case Some(rootElem) => rootElem.add(value,index)
          case None => push(value)
        }
      }
      case _ => add(value)
    }
  }

  def foreach(func : (Int)=>Unit):Unit = {
    root match {
      case Some(rootElem) => rootElem.foreach(func)
      case None => ;
    }
  }

  def pop(): Int = {
    root match{
      case Some(rootElem) => {
        root = rootElem.next
        rootElem.data
      }
      case None => -1
    }
  }

  def push(value:Int): Unit ={
    val _root = root
    root = Some(new Node(value))
    root.get.next = _root
  }

  def remove(index: Int): Int = {
    index match {
      case 0 => pop()
      case _ if index > 0 => {
        root match {
          case Some(rootElem) => rootElem.remove(index)
          case None => -1
        }
      }
      case _ => {
        val realIndex = size() + index
        root match {
          case Some(rootElem) => rootElem.remove(realIndex)
          case None => -1
        }
      }
    }
  }

  def reverse():LinkedList = {
    root match {
      case Some(rootElem) => {
        root = rootElem.reverse(None)
        this
      }
      case None => {
        this
      }
    }
  }

  def merge(otherList:LinkedList): LinkedList = {
    val result = LinkedList()

    result
  }

  def concat(otherList:LinkedList): LinkedList = {
    otherList.root.getOrElse()

    this
  }

  class Node(val data:Int){

   def set(index: Int, currentIndex: Int, value: Int): Int = {
     if(index == currentIndex+1){
       val _next = next
       next = Some(new Node(value))
       next.get.next = _next.get.next
       _next.get.data
     }else{
       next match {
         case Some(nextElem) => nextElem.set(index,currentIndex+1,value)
         case None => -1
       }
     }
   }


   def contains(value:Int): Boolean = {
     value match {
       case _ if(data == value) => true
       case _ => {
         next match {
           case Some(nextElem) => nextElem.contains(value)
           case None => false
         }
       }
     }
   }

   def indexOf(value:Int,currentIndex:Int):Int = {
     if(value == data){
       currentIndex
     }else{
       next match {
         case Some(nextElem) => nextElem.indexOf(value,currentIndex+1)
         case None => -1
       }
     }
   }

   def get(index: Int): Int = {
     index match {
       case 0 => data
       case _ if(index > 0) => {
         next match {
           case Some(nextElem) => nextElem.get(index-1)
           case None => -1
         }
       }
       case _ => -1
     }
   }

   var next : Option[Node] = None

   def add(value : Int, index: Int): Unit = {
     if(index == 1){
       next  match {
         case Some(nextElem) => {
           val _next = next
           next = Some(new Node(value))
           next.get.next = _next
         }
         case None => next = Some(new Node(value))
       }
     }else {
       next match {
         case Some(nextElem) => nextElem.add(value,index-1)
         case None => next = Some(new Node(value))
       }
     }

   }

   def size():Int = {
      next match {
        case Some(nextElem) => 1 + nextElem.size()
        case None => 1
      }
    }

   def reverse(newNext:Option[Node]):Option[Node] = {
     next match {
       case Some(nextElem) => {
         next = newNext
         nextElem.reverse(Some(this))
       }
       case None => {
         next = newNext
         Some(this)
       }
     }
   }

   def addNode(value : Int): Unit ={
     next match {
       case Some(nextElem) => nextElem.addNode(value)
       case None => next = Some(new Node(value))
     }
   }

   def remove(i: Int): Int = {
     if(i==1){
       next match {
         case Some(nextElem) => {
           next = nextElem.next
           nextElem.data
         }
         case None => -1
       }
     }else{
       next match {
         case Some(nextElem) => nextElem.remove(i-1)
         case None => -1
       }
     }
   }

   def foreach(func :(Int)=>Unit): Unit ={
     func(data)
     next match {
       case Some(nextElem) => nextElem.foreach(func)
       case None => ;
     }
   }
 }
}
