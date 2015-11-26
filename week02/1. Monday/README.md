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