package edu.luc.cs.laufer.cs371.shapes

import Shape.*

// create a height behavior that computes the height of a shape tree 
// (taking all kinds of shape nodes into consideration). [This used to be called depth in previous versions]

object height:
  def apply(s: Shape): Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _)   => 1
    case Location(_, _, shape) => 1 + apply(shape)
    case Group(shapes*) =>
      1 + (if shapes.isEmpty then 0 else shapes.map(apply).max)
end height