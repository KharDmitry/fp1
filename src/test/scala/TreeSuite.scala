package com.tkroman.kpi.y2022.l1
import munit.FunSuite

class TreeSuite extends FunSuite {
  test("size") {
    val expected = 3
    val actual = size(Tree.Branch(Tree.Leaf(2), Tree.Leaf(3), 4))
    assertEquals(actual, expected)
  }
  test("depth") {
    val expected = 2
    val actual = depth(Tree.Branch(Tree.Branch(Tree.Leaf(2), Tree.Leaf(3), 4), Tree.Leaf(5), 6))
    assertEquals(actual, expected)
  }
  test("map") {
    val expected = Tree.Branch(Tree.Branch(Tree.Leaf("2Hello"), Tree.Leaf("3Hello"), "4Hello"), Tree.Leaf("5Hello"), "6Hello")
    val actual = map(Tree.Branch(Tree.Branch(Tree.Leaf("2"), Tree.Leaf("3"), "4"), Tree.Leaf("5"), "6"), (a) => a+"Hello")
    assertEquals(actual, expected)
  }
  test("fold") {
    val expected = 720
    val actual = fold(Tree.Branch(Tree.Branch(Tree.Leaf(2), Tree.Leaf(3), 4), Tree.Leaf(5), 6), (a, b) => a*b)
    assertEquals(actual, expected)
  }
}