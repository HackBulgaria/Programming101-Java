## Funny array sorter

Make a FunnyArraySorter class

It should have a constructor that takes an Integer (pivot)

It should have several sorting functions using anonymous classes:
#### reverseSort(List<Integer> list)

#### pivotSubtractionSort(List<Integer> list)

Assume that one Integer is greater than other if it is greater than the second with at lest the pivot value (a>b iff a-pivot>b, a=b iff a-pivot=b)

#### pivotDivisionSort(List<Integer> list)
Assume that one Integer is greater than other if when divided by the pivot is greater than the second (a>b iff a/pivot>b, a=b iff a/pivot=b)


Bonus: Try to explain why the pivot sorting functions are wrong and will have different result with the same numbers, but reordered.


## User input checker

Make a UserInputChecker class

It should have a nested interface Validator which has one function:
	public boolean validate(String input)

create inside the following classes:

#### PersonNameValidator
#### BulgarianPhoneNumberValidator
#### PersonAgeValidator
#### CreditCardNumberValidator
#### IpVersion4Validator
#### IpVersion6Validator
#### MacAddressValidator

## Binary Search Tree

Create a BST with a Node as nested class.

You should be able to add, search and remove an element.
You should also calculate the depth and the height of a given element.

Bonus: Try to calculate the depth and height in O(1).

If you need help look here: 
http://cpp.datastructures.net/presentations/BinarySearchTrees.pdf

http://stackoverflow.com/questions/2603692/what-is-the-difference-between-tree-depth-and-height