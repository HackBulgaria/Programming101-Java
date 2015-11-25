## Linux warmups
### 1. Folder hierarchy
Use the command line to create the following directory structure:

```
A
|---B
|---C
|   |---E
|   |---F
|       |---G
|---D
    |---H
    |---I
```

Where `A` is the root folder, `B`, `C` and `D` are its direct subfolders and so on.
_Bonus points if you do it in 5 commands._

### 2. Panda
Using the folder structure above, create a file named `panda` in folder `G`. It should contain this text:
```
A Panda bear walks into a restaurant. He orders a meal and eats it.
After politely paying for his meal, he pulls out a gun and shoots it in the air. He immediately walks out the door. "Why did you do that?" hollered the confused waitress.
Looking back over his shoulder the panda says "I'm a panda". "Look it up in the dictionary."
The waitress locates the dictionary on her bosses desk and searches for the definition of panda bear. Finding it she reads, "Panda Bear - A large black and white bear like mammal native to the far east. Eats shoots and leaves."
``` 
_Bonus points if you do it in a single command._

### 3. The day panda was cloned
Copy the file `panda` into files named `panda1`, `panda2` and `panda3` in `G` and remove the original file. 
_Bonus points if you do this in 3 commands._ 

### 4. Penguin
Where there are pandas, there are also penguins. Create three empty files `penguin1`, `penguin2` and `penguin3`.
_Bonus points if you do this with a single command._

### 5. The panda factory
In the directory `E` create a new directory `J`, which has the same contents as `G`. 
_Bonus points if you do this in a single command._

### 6. Joke characters
How many characters does the panda joke have (The contents from any of the panda files)? Count them and print them on the console.

### 7. Add some laughs
The joke does not have enough laughs. Add `Lololololol!` to the end of the file `A/C/F/G/panda1` **without overwriting it**.

### 8. Without punchline
Show only the first 4 lines from the panda joke.

### 9. List some pandas
List all files named `panda1` from the whole directory structure.

### 10. Archive
Archive the entire `J` directory. Name it any way you like. Store the archive anywhere you like.

### 11. Omnomnom bamboo
Now list all files that contain the word `mammal` along with the line number of the occurence and save it to a file named `mammals` located in `A`.

### 12. Line numbers
Now save the **number of lines** in the file `mammals` in a file named `number_mammals` in `A`.

### 13. Remove panda1 from J
Remove the file `panda1` from `J`.

### 14. Honest mistake
Did I say `J`? My bad! Luckily, we made a backup, so unarchive that and restore `J` as it was before, with the file `panda1`.

### 15. I change my mind
Actually, let's remove **all files** from `A` and its subdirectories. **Do not remove the folders themselves.**

### 16. Void
Okay, now let's remove `A` and all of its subfolders. Leave no trace of your panda addiction.

## Now back to Java!
### 17. Fibonacci number

Implement a function `long fibNumber(int n)`, which takes an integer n and returns a number, which is formed by concatenating the first n Fibonacci numbers.

Examples:

```java
fibNumber(3) == 112
fibNumber(10) == 11235813213455
```

### 18. Lucas series

Because Fibonacci is way too trivial, implement the following functions that work with [Lucas series](https://en.wikipedia.org/wiki/Lucas_number):

* `int nthLucas(int n)` -> returns the nth Lucas number

Quick hint:

```
L(0) = 2
L(1) = 1
L(n) = L(n-1) + L(n-2)
```

### 19. Increasing and Decreasing Sequences

Implement the following functions:

* `boolean IsIncreasing(int[] sequence)` which returns true if for every two
consecutive elements `a` and `b`, `a < b` holds.
* `boolean IsDecreasing(int[] sequence)` which returns true if for every two
consecutive elements `a` and `b`, `a > b` holds.

### 20. Longest subsequence of equal consecutive elements

Implement the function `int maxEqualConsecutive(int[] items)`, which takes an array of ints and returns an integer - the count of elements in the longest subsequence of equal consecutive elements.

For example, in the array `[1, 2, 3, 3, 3, 3, 4, 3, 3]`, the result is 4, where the longest subsequence is formed by `3, 3, 3, 3`

**Test examples::**

```java
maxEqualConsecutive(new int[] {1, 2, 3, 3, 3, 3, 4, 3, 3}) == 4
maxEqualConsecutive(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5}) == 3
```

### 21. Longest subsequence of increasing consecutive elements

Implement the function `int maxIncreasingConsecutive(int[] items)`, which takes an array of ints and returns an integer - the count of elements in the longest subsequence of increasing consecutive elements.

For example, in the array `[1, 2, 3, 3, 3, 3, 4, 3, 3]`, the result is 7, where the longest subsequence is formed by `1, 2, 3, 3, 3, 3, 4`

**Test examples::**

```java
maxIncreasingConsecutive([1, 2, 3, 3, 3, 3, 4, 3, 3]) == 7
maxIncreasingConsecutive([1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5]) == 11
```

### 22. Unique words

Implement a function, called `int uniqueWordsCount(String[] arr)` which returns the number of different words in `arr`.

### Test examples

```java
uniqueWordsCount(new String[] {"apple", "banana", "apple", "pie"}) == 3
uniqueWordsCount(new String[] {"java", "java", "java", "android"}) == 2
uniqueWordsCount(new String[] {"HELLO!", "HELLO!", "HELLO!" "HELLO!"}) == 1
```
## Object-Oriented Programming
### 23. Fast and Furious
Make a class Car. 
Make subtypes of Car, representing the following brands of cars: Audi, BMW, Volkswagen, Honda and Skoda.

Each subtype should have a method `boolean isEcoFriendly(boolean testing)`, which does the following:
- For a Volkswagen car, if `testing` is `true`, it should return `true`. Return `false` otherwise.
- For any other car, return `true`. 

Later, for the Audi type you need to return its mileage, because all the German brand manufacturers require it - how you will do it?

### 24. The Time Lord

Make a class `Time` to hold information about the current time and *the current date* .

Make an *easy-to-use* constructor (from client perspective), that would represent the time and date the client wants to hold in your class.

Implement the toString() method, returning the time and date in format : "hh:mm:ss dd.MM.YY". 

Check out String.format method

*Bonus*
Make a factory method `now()` for your class, returning the Time at the present moment :)

See http://en.wikipedia.org/wiki/Factory_method_pattern

### 25. Pair 'em up

Make a class `Pair`, representing a pair of *Objects* (later we will revisit this with Generics)

Create getter methods for the first and second member of the pair.
http://stackoverflow.com/questions/2036970/how-do-getters-and-setters-work

Implement the toString method, giving a meaningful representation of the class.
Override the equals method from Object => two pairs are equal if both their members are equal.

Make the class *immutable*.
### 26. Stack 'em

Create and implement a class `StackImpl`, representing a... well, stack. 

Think about all the required (public) operations needed, so that one can use a stack class. You know, stuff like actually pushing an element, popping an element, length, clear, isEmpty, stuff like that. Think about the return types of those operations (see task 5, you may get a hint about one). *Extract them all to an interface  `Stack`, which your class should implement*. 

### 27. No clones allowed.

Create an implementation of your `Stack` interface, which has the added invariant:
-It does not allow an element to be duplicated. If there is an element 'a' in the stack, and some smart guy pushes 'a' again, his operation should fail, and the smart guy should have a way to know this.


### 28. On two fronts

Implement a (doubly-linked) list (using ints only). Just as before, extract all of its required public operations in an interface. Some of those operations are add, *remove*, size, get(int elementIndex), getHead (getFirst), getTail(getLast), etc. 
Think good and hard about your implementation, and whether you will need another class for a List Node.

### 29. Mr. ListStack
Implement your own `Stack` with your own (doubly) `LinkedList` class : )

*Bonus* implement a unique stack just as before, but using your `LinkedList` and an *anonymous implementation*, combined with a factory method. 
See http://www.programmerinterview.com/index.php/java-questions/java-anonymous-class-example/

Return your anonymous implementation from a factory method!

### 30. The One
Make a mutable class 'Matrix' represeting a NxM (Pixel[][]) matrix. `Pixel` is a POJO (Google it!) containing three float values - R, G, B. Think good about your constructors, your data. Your goal is to make this class as convenient as possible for the person using it.

Your class `Matrix` should have another cool thing about it => it would allow operations with every pixel.
In order for this to work, your class should declare a public method `operate(MatrixOperation op)`

Where `MatrixOperation` is an interface, containing a method 'Pixel withPixel(int x, int y, Pixel[][] matrix)'.
*Think - why are we getting x, y, and the matrix instead of just passing the pixel value?*

Implement the toString(), converting the whole matrix into a String in a way that it would be visible on the console.

The method should `operate(MatrixOperation op)`  should call the `withPixel` method for every x and y in the matrix and assign the result of `withPixel` to the matrix.

Now that you have this, implement:
- brightness reduce
- grayscale
- gaussian blur (optional)

### 31. Calc the Calculator
Create a friendly interactive calculator in java
Bundle, execute and test your program as a jar file.

Example usage of your program:
```
java -jar calc.jar  
Hello!

Enter expression:> 5  
Output:> 5.0  
Enter expression:> 3 + (5 + 9*7 + 9)  
Output:> 78  
Enter expression:>  4*(4 + 5)  
Output:> 36  
Enter expression:> exit  
  
Bye!  
```


Supported operations: 
- addition  
- multiplication  
- division (this is not integer division! 2/3 = 0.666666667, not 0!)  
- brackets   
- Negative numbers.  

Multiplication and addition take precedence and have higher priority than addition.  
Priority list: () before * before / before + before -  

Your program should support a *variable* ammount of spaces in the expression, as shown in the output below.

*Hints*
- Use this class if you have trouble reading from system.in:  https://gist.github.com/GeorgiPachov/bcc51f1fc3b3a1de1bce
- Separate this problem into smaller problems and focus on them instead.
- Do not worry about invalid input:  
`123/213/123/1/2/23/3 //order of divisions is undefined here, do what is easier for you.`  
`(12 + 5) + 65) //brackets mashup => this is invalid input`  
`(12++-*3) //operators mashup => this is invalid input`  
- There is no need to use any collections here.
- There is no need to use any generics here.
- There is no need to use any regular expressions here. You will probably just need to escape some stuff when calling `String.replace`, e.g. to replace a '+', you will need to call `someString.replace("\\+","my replaced output)` (because + is from regex syntax. And because `replace` accepts a regex input as a String, not as a Pattern, which is actually not the smartest decision in the world).

But if you think regexes will help you here and will make your life easier, you are free to use them. 
Use http://docs.oracle.com/javase/tutorial/essential/regex/ for reference
and http://www.tutorialspoint.com/java/java_regular_expressions.htm for example usage. 


*Bonus challenge objectives*
- Use less than 120 lines of code in total for all classes. (not counting bonuses implementations, you can test as much as you like there!)
- Add factorial operation support. It should precede multiplication and division, but bracket rules should apply. 
Examples:
```
java -jar yourJar.jar:
Hello!

Output:> 5.0
Enter expression:> (5+3)!
Output:> 40320.0
Enter expression:> (2*3 + 1*3)!
Output:> 362880.0
Enter expression:> 9!
```
- Add 'power' support: 2^3 = 8, 3^2 = 9, etc. It has the same priority as multiplication!
Examples:
```
java -jar yourJar.jar:
Hello!

Enter expression:> 3^2 + 2^3
Output:> 17.0
Enter expression:> 2^3 + (5+3)^2
Output:> 72.0
Enter expression:> 2^3! + 5*((3+2!)^2)
Output:> 189.0
```
-Add support for mashed up user input: E.g. 2+3\ should be parsed as 2+3. Discourage any symbols different from the ones you are interested in. //regexes will probably help you here, although the difference with/without is ~2 lines of code.