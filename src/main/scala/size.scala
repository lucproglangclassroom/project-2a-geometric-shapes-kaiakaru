package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object size:
  def apply(s: Shape): Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _)   => 1
    case Location(_, _, shape) => apply(shape)
    case Group(shapes*) => shapes.map(apply).sum
end size