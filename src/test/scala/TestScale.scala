package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:
  def testScale(description: String, s: Shape, factor: Double, expected: Shape): Unit =
    test(description):
      assert(scale(s, factor) == expected)

  testScale("simple ellipse", simpleEllipse, 0.5, Ellipse(25, 15))

  testScale("simple rectangle", simpleRectangle, 2.0, Rectangle(160, 240))

  testScale("simple location", simpleLocation, 2.0,
    Location(140, 60, Rectangle(160, 240))
  )

  testScale("basic group", basicGroup, 2.0,
    Group(Ellipse(100, 60), Rectangle(40, 80))
  )

    testScale("simple group", simpleGroup, 2.0,
    Group(
      Location(400, 200, Ellipse(100, 60)),
      Location(800, 600, Rectangle(200, 100))
    )
  )

  testScale("complex group", complexGroup, 2.0,
    Location(100, 200,
      Group(
        Ellipse(40, 80),
        Location(300, 100,
          Group(
            Rectangle(100, 60),
            Rectangle(600, 120),
            Location(200, 400,
              Ellipse(100, 60)
            )
          )
        ),
        Rectangle(200, 400)
      )
    )
  )

end TestScale