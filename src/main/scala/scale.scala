package edu.luc.cs.laufer.cs371.shapes

import Shape.*

// Create a scale behavior that (recursively) scales the dimensions of a shape by a given factor.
// (This affects shapes that have dimensions, including locations.)

object scale:
  def apply(s: Shape, factor: Double): Shape = s match
    case Rectangle(width, height) =>
      Rectangle((width * factor).round.toInt, (height * factor).round.toInt)

    case Ellipse(width, height) =>
      Ellipse((width * factor).round.toInt, (height * factor).round.toInt)

    case Location(x, y, shape) =>
      Location((x * factor).round.toInt, (y * factor).round.toInt, apply(shape, factor))

    case Group(shapes*) =>
      Group(shapes.map(apply(_, factor))*)
end scale