# Introduction to SQL

## Data Definition Language

We will create a database for Our Company to store information about our employees, products and customers. For that purpose create a new database `OurCompany`. Create the appropriate tables and relationships between them. Don't forget to create a column and a primary key for each table!

It is a good idea to save the `.sql` scripts and save them in your repository.

### Departments and employees

The company has several departments a hierarchy of employees:
* Each department has:
  * Name
* Each employee has:
  * Name
  * Email - optional
  * Date of birth
  * Manager - another employee that is his/her manager. The big boss doesn't have a manager.
  * Department - the department the employee works in. The big boss doesn't have a department.

### Products
The company creates products with different categories:
* Each category has:
  * Unique 3 letter code
  * Name
* Each product has:
  * Name
  * Single price
  * Category

### Customers
The company keeps track of its customers:
* Each customer has:
  * Name
  * Email - optional
  * Address
  * Discount - a percent discount applied to everything the customer buys; optional

### Orders
The company keeps track of all orders:
Each order has:
* Date and time of the order
* Customer
* Total Price
* Each order may contain several products with different quantities - implement it as a many-to-many relationship with an additional table OrderProducts.

## Populating the database

### Departments and employees

Into the database insert 3 departments - Sales, Production, Financial.

Insert an entry for the Big Boss (has no manager and department).

Insert 5 employees into each of the departments. In each department there is a manager:
* He is the manager of all other employees in the department
* His manager is the Big Boss

### Products

Insert 4 product categories - Books, Music, Hardware, Software

Inside each category insert at least 3 products

### Customers

Insert at least 5 different customers with at least 2 having a discount.

### Orders

Insert at least 5 orders with each having at least 2 products.

## Selecting from and manipulating the database

### Selecting

* Select the big boss
* Select all department managers
* Select all employees in the Sales department ordered by Name
* Select all departments with employees that are born after 1990
* Select all departments with more than 3 employees
* Select the department having the most employees
* Select the order having the maximum total number of products
* Select the average discount of all customers

### Manipulating
* Update all employees adding 1 year to their birth date
* Double the discount of the customer with most orders
* Delete all products with no orders

### How to:
* Return the number of times a specific product is ordered(by productId)
* Switch the Big Boss with regular employee

