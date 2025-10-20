package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(width, height) => 
      Location(0, 0, Rectangle(width, height)) // not yet implemented

    case Ellipse(width, height) =>
      Location(-width, -height, Rectangle(2 * width, 2 * height))

    case Location(x, y, shape) =>
      val Location(x2, y2, Rectangle(w, h)) = apply(shape)
      Location(x + x2, y + y2, Rectangle(w, h))

    case Group(shapes*) =>
      val boxes = shapes.map(apply)

      val xs = boxes.map(_.x)
      val ys = boxes.map(_.y)
      val ws = boxes.map(b => b.x + b.shape.asInstanceOf[Rectangle].width)
      val hs = boxes.map(b => b.y + b.shape.asInstanceOf[Rectangle].height)

      val minX = xs.min
      val minY = ys.min
      val maxX = ws.max
      val maxY = hs.max

      Location(minX, minY, Rectangle(maxX - minX, maxY - minY))
  end apply

end boundingBox
