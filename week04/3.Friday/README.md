## Geometry Figures

We are going  to define some classes describing geometrical objects.
### Point

Create an immutable class Point:

* Create a constructor with 2 arguments - the x and the y coordinate
* Create a default constructor which initializes the Point with the origin of the coordinate system
* Create a constructor that makes a copy of a Point
* Create 2 methods for displaying the coordinates of the point - `getX()` and `getY()`
* Create a static method that returns the origin of the coordinate system `Point getOrigin()`
* Override `toString()` to return the coordinates of the point. Point(x, y) E.g. Point(2,5)
* Override `equals()`
* Override `hashCode()`:
```
public int hashCode() {
        int hash = 17;
        hash = hash * 23 + x.hashCode();
        hash = hash * 23 + y.hashCode();
        return hash;
}
```

### Line Segment

Create an immutable class LineSegment:
* Create a constructor with 2 arguments of type Point - the two ends of the line segment
  * if the points are equal the constructor should print the message `Cannot create a line segment with zero length` (when we learn about exceptions, we will make use of them here).
* Create a constructor that makes a copy of a LineSegment
* Create 2 getter methods for displaying the two ends of the segment
* Create a method `getLength()` which calculates the length of the segment
* Override `toString()`: Line[(x1,y1), (x2,y2)]
* Override `equals()`
* Make the class implement Comparable and compare two segments according to their lengths. 
  *  segment1.compareTo(segment2) should return a negative number if segment1's length is smaller than segment2's, a positive number if it's larger and zero if their lengths are equal.
* Override `hashCode()`:
```
public int hashCode() {
    int hash = 17;
    hash = hash * 23 + Point1.hashCode();
    hash = hash * 23 + Point2.hashCode();
    return hash;
}
```

Now go back to the Point class:
* define a static method `Add(Point point1, Point point2)` that returns a LineSegment of the two points.

### Rectangle

Create an immutable class Rectangle:

* Create a constructor with 2 arguments of type Point - the upper left and lower right points, respectively.
  * if the points are on the same coordinate axis print a message `"Points are on the same axis."`
* Create a constructor that makes a copy of a Rectangle
* Create 4 methods for displaying the 4 vertices of the rectangle (of type Point). I.e. `getUpperLeft`, `getLowerLeft`, etc.
* Create 4 methods for displaying the 4 edges of the rectangle (of type LineSegment)
* Create 2 methods for dispalying the width and height of the rectangle
* Create a method for displaying the center of the rectangle
* Create methods `getPerimeter()`, `getArea()`
* Override `toString()`: Rectangle[(x,y), (height,width)]
* Override `equals()`
* Override `hashCode()`

### Triangle

Create an immutable class Triangle:

* Create a constructor with 3 arguments of type Point - the three points of the triangle.
  * if the points are on the same coordinate axis print a message `"Points are on the same axis."`
* Create a constructor that makes a copy of a Triangle
* Create 3 methods for displaying the 3 vertices of the triangle (of type Point). I.e. `getUpperLeft`, `getLowerLeft`, etc.
* Create 3 methods for displaying the 3 edges of the triangle (of type LineSegment)
* Create 2 methods for dispalying the base and height of the triangle
* Create a method for displaying the center of the triangle
* Create methods `getPerimeter()`, `getArea()`
* Override `toString()`: Triangle[(x,y), (height,base)]
* Override `equals()`
* Override `hashCode()`

### Ellipse

Create an immutable class [Ellipse](https://en.wikipedia.org/wiki/Ellipse):

* Create a constructor with two arguments - numbers, which describe the major axis and the minor axis.
    * if the points are on the origin, print a message `"Points are on the origin."` 
* Create a constructor that makes a copy of an Ellipse
* Create four methods for displaying each point of the bounds of the ellipse. (e.g. the coordinates of an imaginary rectangle that encloses the ellipse)
* Create a method for displaying the center of the ellipse.
* Create methods `getPerimeter()`, `getArea()`
* Override `toString()`: Ellipse[(x,y), (height,width)]
* Override `equals()`
* Override `hashCode()`

### Circle

Create an immutable class Circle.

* Create a constructor with one argument - numbers, which describes its radius.
* Create a constructor that makes a copy of a Circle
* Create four methods for displaying each point of the bounds of the circle. (e.g. the coordinates of an imaginary rectangle that encloses the circle)
* Create a method for displaying the center of the circle.
* Create methods `getPerimeter()`, `getArea()`
* Override `toString()`: Circle[(x,y), (height,width)]
* Override `equals()`
* Override `hashCode()`

### Now make it more OOP
Okay, do you see some kind of a repetition here? Did you experience déjà vu? If only there was some way to extract the common functionality somewhere... [Oh wait, there is!](https://en.wikipedia.org/wiki/Inheritance_(object-oriented_programming)) Think of how you can reduce the repeated logic and do so.  
Also, pay special attention to the methods `getParameter()` and `getArea()`. These methods do different things for a rectangle, ellipse and triangle, but they *must* be present in both classes. Get the hint?

Now think of this hypothetical question: What if you also had to implement a class ArealessShape, which only has a method to display its center? Would it inherit from your base class? Would it have the methods `getParameter()` and `getArea()`?
