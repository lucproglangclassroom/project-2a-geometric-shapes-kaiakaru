package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior
// Implemented in COMP 313 in Java

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    // same logic as onRectangle
    case Rectangle(width, height) => 
      Location(0, 0, Rectangle(width, height)) 


    // same logic as onCircle in COMP313
    case Ellipse(width, height) =>
      Location(-width, -height, Rectangle(2 * width, 2 * height))


    // same logic as onLocation
    case Location(x, y, shape) =>
      val Location(x2, y2, Rectangle(w, h)) = apply(shape)
      Location(x + x2, y + y2, Rectangle(w, h))


/*     public Location onGroup(final Group g) {
        int x, y, width, height;
        x = y = Integer.MAX_VALUE;
        width = height = 0;

        for(Shape s : g.shapes) {
            Location l = s.accept(this);
            var r = (Rectangle) l.shape;
            if(l.x < x) x = l.x;
            if(l.y < y) y = l.y;
            if(x + width < l.x + r.width) width = (l.x + r.width) - x;
            if(y + height < l.y + r.height) height = (l.y + r.height) - y;
        }
        return new Location(x,y,new Rectangle(width, height)); */


    // compute min/max
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
