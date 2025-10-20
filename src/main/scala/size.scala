package edu.luc.cs.laufer.cs371.shapes

import Shape.*

// create a size behavior that counts the number of concrete leaf shapes 
// (such as ellipses and rectangles) in a general shape.

object size:
  def apply(s: Shape): Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _)   => 1
    case Location(_, _, shape) => apply(shape)
    case Group(shapes*) => shapes.map(apply).sum
end size