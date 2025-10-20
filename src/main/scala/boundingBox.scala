package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(width, height) => 
      Location(0, 0, Rectangle(width, height)) 


    // same logic as onCircle in COMP313
    case Ellipse(width, height) =>
      Location(-width, -height, Rectangle(2 * width, 2 * height))

    case Location(x, y, shape) =>
      val Location(x2, y2, Rectangle(w, h)) = apply(shape)
      Location(x + x2, y + y2, Rectangle(w, h))


          // Group → compute min/max like the Java version
    case Group(shapes*) =>
      var minX = Int.MaxValue
      var minY = Int.MaxValue
      var maxX = Int.MinValue
      var maxY = Int.MinValue

      for shape <- shapes do
        val Location(x, y, Rectangle(w, h)) = apply(shape)
        if x < minX then minX = x
        if y < minY then minY = y
        if x + w > maxX then maxX = x + w
        if y + h > maxY then maxY = y + h

      Location(minX, minY, Rectangle(maxX - minX, maxY - minY))
  end apply

end boundingBox
