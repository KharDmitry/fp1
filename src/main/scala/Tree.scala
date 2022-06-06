package com.tkroman.kpi.y2022.l1


enum Tree[+A]:
  case Branch(l: Tree[A], r: Tree[A], v: A)
  case Leaf(a: A)


def size[A](t: Tree[A]): Int = {
  t match{
    case Tree.Branch(l, r, v) => 1 + size(l) + size(r)
    case Tree.Leaf(a) => 1
  }
}
def depth[A](t: Tree[A]): Int = {
  t match{
    case Tree.Branch(l, r, v) => Math.max(depth(l), depth(r)) + 1
    case Tree.Leaf(a) => 0
  }
}
def map[A, B](t: Tree[A], f: A => B): Tree[B] = {
  t match{
    case Tree.Branch(l, r, v) => Tree.Branch(map(l, f), map(r, f), f(v))
    case Tree.Leaf(a) => Tree.Leaf(f(a))
  }
}
def fold[A](t: Tree[A], f:(A, A) => A): A = {
  t match{
    case Tree.Branch(l, r, v) => f(f(fold(l, f), fold(r, f)), v)
    case Tree.Leaf(a) => a
  }
}

@main def run() =
  val tree = Tree.Leaf(2)
  val tree1 = Tree.Leaf(3)
  val tree11 = Tree.Leaf(7)
  val tree2 = Tree.Branch(tree, tree1, 4)
  val tree3 = Tree.Branch(tree2, tree11, 5)
  val tree4 = Tree.Leaf(1)
  val tree5 = Tree.Leaf(6)
  val tree6 = Tree.Leaf(8)
  val tree7 = Tree.Branch(tree4, tree5, 9)
  val tree8 = Tree.Branch(tree7, tree6, 10)
  val tree9 = Tree.Branch(tree3, tree8, 11)
  println(tree3.getClass)