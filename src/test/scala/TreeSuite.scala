package com.tkroman.kpi.y2022.l1
import munit.FunSuite

class TreeSuite extends FunSuite {
  test("size_test1") {
    val expected = 3
    val actual = size(Tree.Branch(Tree.Leaf(2), Tree.Leaf(3), 4))
    assertEquals(actual, expected)
  }
  test("size_test2") {
    val expected = 0
    val actual = size(Tree.Empty)
    assertEquals(actual, expected)
  }
  test("size_test3") {
    val expected = 2
    val actual = size(Tree.Branch(Tree.Empty, Tree.Leaf(3), 4))
    assertEquals(actual, expected)
  }
  test("size_test4") {
    val expected = 3
    val actual = size(Tree.Branch(Tree.Branch(Tree.Leaf(5), Tree.Empty, 6), Tree.Empty, "Hello"))
    assertEquals(actual, expected)
  }
  test("depth_test1") {
    val expected = 2
    val actual = depth(Tree.Branch(Tree.Branch(Tree.Leaf(2), Tree.Leaf(3), 4), Tree.Leaf(5), 6))
    assertEquals(actual, expected)
  }
  test("depth_test2") {
    val expected = 0
    val actual = depth(Tree.Empty)
    assertEquals(actual, expected)
  }
  test("depth_test3") {
    val expected = 2
    val actual = depth(Tree.Branch(Tree.Branch(Tree.Leaf("2"), Tree.Empty, "4"), Tree.Leaf("5"), "6"))
    assertEquals(actual, expected)
  }
  test("depth_test4") {
    val expected = 2
    val actual = depth(Tree.Branch(Tree.Branch(Tree.Leaf(9), Tree.Empty, 4), Tree.Empty, 6))
    assertEquals(actual, expected)
  }
  test("map_test1") {
    val expected = Tree.Branch(Tree.Branch(Tree.Leaf("2Hello"), Tree.Leaf("3Hello"), "4Hello"), Tree.Leaf("5Hello"), "6Hello")
    val actual = map(Tree.Branch(Tree.Branch(Tree.Leaf("2"), Tree.Leaf("3"), "4"), Tree.Leaf("5"), "6"), (a) => a+"Hello")
    assertEquals(actual, expected)
  }
  test("map_test2") {
    val expected = Tree.Empty
    val actual = map(Tree.Empty, (a) => "Hello")
    assertEquals(actual, expected)
  }
  test("map_test3") {
    val expected = Tree.Branch(Tree.Branch(Tree.Leaf("2Hello"), Tree.Empty, "4Hello"), Tree.Leaf("5Hello"), "6Hello")
    val actual = map(Tree.Branch(Tree.Branch(Tree.Leaf("2"), Tree.Empty, "4"), Tree.Leaf("5"), "6"), (a) => a+"Hello")
    assertEquals(actual, expected)
  }
  test("map_test4") {
    val expected = Tree.Branch(Tree.Branch(Tree.Leaf(6), Tree.Empty, 12), Tree.Empty, 18)
    val actual = map(Tree.Branch(Tree.Branch(Tree.Leaf(2), Tree.Empty, 4), Tree.Empty, 6), (a) => a*3)
    assertEquals(actual, expected)
  }
  test("fold_test1") {
    val expected = 720
    val actual = fold(Tree.Branch(Tree.Branch(Tree.Leaf(2), Tree.Leaf(3), 4), Tree.Leaf(5), 6), 1, (a, b) => a*b)
    assertEquals(actual, expected)
  }
  test("fold_test2") {
    val expected = 17
    val actual = fold(Tree.Branch(Tree.Branch(Tree.Leaf(2), Tree.Empty, 4), Tree.Leaf(5), 6), 0, (a, b) => a+b)
    assertEquals(actual, expected)
  }
  test("fold_test3") {
    val expected = 1
    val actual = fold(Tree.Empty, 1, (a, b) => a*b)
    assertEquals(actual, expected)
  }
  test("fold_test4") {
    val expected = "2456"
    val actual = fold(Tree.Branch(Tree.Branch(Tree.Leaf("2"), Tree.Empty, "4"), Tree.Leaf("5"), "6"), "", (a, b) => a + b)
    assertEquals(actual, expected)
  }
}
