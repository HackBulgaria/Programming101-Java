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

## Vector
We can represent a 2D vector with two values: [x1, x2]. 3D vectors can be represented by [x1, x2, x3]. n-dimensional vectors are represented by [x1, x2, x3, ..., xn]. (Obviously, 2D and 3D vectors are n-dimensional vectors, where n is 2 and 3, respectively)

In this task you will create a Vector class for n-dimensional vectors.

* Create a constructor that takes a variable number of arguments - the coordinates
* Create a constructor that copies an existing vector
* Think of a way to get and set each coordinate of the vector
* Create a method for returning the dimensionality of the vector (E.g. for a 3D vector it should return 3)
* Create a method for returning the length of the vector
* Override `toString()`
* Override `equals()`
* Override `hashCode()`
* define methods `add(Vector vector)`, `subtract(Vector vector` between vectors (First check if the 2 vectors have the same dimension! If they don't, print a message that they cannot be added.)
* define methods `add(float by)`, `subtract(flaot by)`, `multiply(float by)`, `divide(float by)` between a vector and a scalar
* define `dotProduct(Vector vector)` - the dot product of 2 vectors (First check if the 2 vectors have the same dimension!)
 
## VAT TAX calculator

You need to create a VAT tax calculator.
The calculator must calculate a product's price VAT tax based on a country.
The list with countries with the corresponding taxes must be passed to the calculator when it is initialized.
One of the countries must be the default country.
The calculator should return the additional tax on a specific product price based on its country.
If the country isn't specified then the default country must be used instead.

The following classes and method must be implemented:

* CountryVatTax class which contains the following properties : countryId, VATTax, IsDefault.
Note : the class must be immutable
* VAT tax calculator class that implementes a default contrustror which accept a list of CountryVatTax
* VAT tax calculator class must implements a method CalculateTax which should calculate VAT tax on a product price
* CalculateTax() method should accept product price and countryId (countryId isn't mandatory so an overload method should be implemented which doesn't accept countryId. In that case the default country tax must be used for calculations)
* If country isn't supported then an appropriate NotSupportedCountryException should be thrown.

## Shop Inventory

Create an ShopInventory class which contains all products available in an inventory:

* Every product must keep information about the product's price (before and after taxes), in which country the product could be bought(only one country) and the name of the product, product's quantity, product's id (integer). 
* The price with the taxes must be calculated with the help of the VAT Tax calculator. 
* The inventory must keep all available products (they should be passed to the constructor of the class). 
* The inventory should have a method called Audit which should tell the user how much money will be earned if all products are sold out
* Implement class order which contains information about a particular order (product's ids that must be bought + their quantity)
* The Inventory class must implements a method RequestOrder. It should get an order and calculates its amount. If the inventory doesn't contain all the required products then a specific exception must be thrown - NotAvailableInInventoryException. 
