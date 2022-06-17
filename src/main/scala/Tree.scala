//Я вважаю, що у моїй реалізації не можна було створити порожнє дерево, тому я додав case Empty, додав тести, та прибрав
// сміття


package com.tkroman.kpi.y2022.l1
import scala.annotation.tailrec

enum Tree[+A]:
  case Branch(l: Tree[A], r: Tree[A], v: A)
  case Leaf(a: A)
  case Empty


def size[A](t: Tree[A]): Int = {
  t match{
    case Tree.Branch(l, r, v) => 1 + size(l) + size(r)
    case Tree.Leaf(a) => 1
    case Tree.Empty => 0
  }
}
def depth[A](t: Tree[A]): Int = {
  t match{
    case Tree.Branch(l, r, v) => Math.max(depth(l), depth(r)) + 1
    case Tree.Leaf(a) => 0
    case Tree.Empty => 0
  }
}
def map[A, B](t: Tree[A], f: A => B): Tree[B] = {
  t match{
    case Tree.Branch(l, r, v) => Tree.Branch(map(l, f), map(r, f), f(v))
    case Tree.Leaf(a) => Tree.Leaf(f(a))
    case Tree.Empty => Tree.Empty
  }
}
def fold[A](t: Tree[A], z: A, f:(A, A) => A): A = {            //z-нейтральний елемент в системі з операцією f
  t match{
    case Tree.Branch(l, r, v) => f(f(fold(l, z, f), fold(r, z, f)), v)
    case Tree.Leaf(a) => a
    case Tree.Empty => z
  }
}

@main def run() =
  println("Hello")
