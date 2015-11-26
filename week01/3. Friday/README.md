###29. Hack Numbers

A hack number is an integer, that matches the following criteria:

* The number, represented in binary, is a palindrome
* The number, represented in binary, has an odd number of 1's in it

Example of hack numbers:

* 1 is `1` in binary
* 7 is `111` in binary
* 7919 is `1111011101111` in binary

Implement the following functions:

* `isHack(n)` -> checks if `n` is a hack number
* `nextHack(n)` -> returns the next hack number, that is bigger than `n`

Few examples:

```
isHack(1) = True
nextHack(0) = 1

isHack(21) = True
nextHack(10) = 21

isHack(8191) = True
nextHack(8031) = 8191
```
###30. Vowels in a string

Implement a function, called `countVowels(str)`, which returns the count of all vowels in the string `str`.

__Count uppercase vowels aswell!__

The English vowels are `aeiouy` and their Cappital versions.

**Examples:**

```
* countVowels("Java") = 2
* countVowels("Theistareykjarbunga") =  8
* countVowels("grrrrgh!") = 0
* count_vowels("Github is the second best thing that happend to programmers, after the keyboard!") = 22
* count_vowels("A nice day to code!") = 8
```

###31. Consonants in a string

Implement a function, called `countConsonants(str)`, which returns the count of all consonants in the string `str`.

__Count uppercase consonants as well!__

The English consonants are `bcdfghjklmnpqrstvwxz`.

**Examples:**

```
* countConsonants("Java") = 2
* countConsonants("Theistareykjarbunga") = 11
* countConsonants("grrrrgh!") = 7
* countConsonants("Github is the second best thing that happend to programmers, after the keyboard!") = 44
* countConsonants("A nice day to code!") = 6
```
###32. Palindrome Score

We denote the "Palindrome score" of an integer by the following function:

* `P(n) = 1`, if `n` is palindrome
* `P(n) = 1 + P(s)` where `s` is the sum of `n` and the `reverse of n`

Implement a function, called `pScore(n)`, which finds the palindrome score for n.

Lets see two examples:

* `pScore(121) = 1`, because `121` is a palindrome.
* `pScore(48) = 3`, because: 

1. `P(48) = 1 + P(48 + 84) = 132`
2. `P(132) = 1 + 1 + P(132 + 321 = 363)`
3. `P(363) = 1`.
4. When we return from the recursion, we get 3.

**Examples:**

```
* pScore(121) = 1
* pScore(48) = 3
* pScore(198) = 6
```

###33. 100 SMS

Before the smartphones, when you had to write some message, the keypads looked like that:

![Nokia 3310 Keypad](nokia.jpg)

For example, on such keypad, if you want to write **Java**, you had to press the following sequence of numbers:

```
528882
```

Each key contains some letters from the alphabet. And by pressing that key, you rotate the letters until you get to your desired one.

It's time to implement some encode / decode functions for the old keypads!

## `numbersToMessage(pressedSequence)`

First, implement the function that takes a array of integers - the sequence of numbers that have been pressed. The function should return the corresponding string of the message. 

There are a few special rules:

* If you press `1`, the next letter is going to be capitalized
* If you press `0`, this will insert a single white-space
* If you press a number and wait for a few seconds, the special breaking number `-1` enters the sequence. This is the way to write different letters from only one keypad!

Few examples:

```
* numbersToMessage([2, -1, 2, 2, -1, 2, 2, 2]) = "abc"
* numbersToMessage([2, 2, 2, 2]) = "a"
* numbersToMessage([1, 4, 4, 4, 8, 8, 8, 6, 6, 6, 0, 3, 3, 0, 1, 7, 7, 7, 7, 7, 2, 6, 6, 3, 2])
=
"Ivo e panda"
```

## `messageToNumbers(messsage)`

This function takes a string - the `message` and returns the **minimal** keystrokes that you ned to write that `message`

Few examples:

```
messageToNumbers("abc") = [2, -1, 2, 2, -1, 2, 2, 2]
messageToNumbers("a") = [2]
messageToNumbers("Ivo e panda")
=
[1, 4, 4, 4, 8, 8, 6, 6, 0, 3, 3, 0, 1, 7, 2, 6, 6, 3, 2]
messageToNumbers("aabbcc") = [2, -1, 2, -1, 2, 2, -1, 2, 2, -1, 2, 2, 2, -1, 2, 2, 2]
```
###34. Friday Years

Have you every wondered how many fridays are there in one year?

The count can be 52 or 53, depending on the weeks of that year (leap or not) and the start of the year.

If an year contains 53 fridays, we call that **"A Friday Year"**

You are to implement a function, called `friday_years(String start, String end)`, where `start` and `end` are integers, representing years.

The function should return the count of all friday years between `[start, end]`


Examples:

* friday_years(1000, 2000) = 178
* friday_years(1753, 2000) = 44
* friday_years(1990, 2015) = 4

###35. Credit card validation

Implement a function, called `is_credit_card_valid(String number)`, which returns True/False based on the following algorithm:

* Each credit card number must contain odd count of digits.
* We transform the number with the following steps (based on the fact that we start from index 0)
  - All digits, read from right to left, at even positions (index), **remain the same.**
  - Every digit, read from right to left, at odd position is replaced by the result, that is obtained from doubling the given digit.
* After the transformation, we find the sum of all digits in the transformed number.
* The number is valid, if the sum is divisible by 10.

For example: `79927398715` is valid, bacause:

* When we double and replace all digits at odd position we get: `7 (18 = 2 * 9) 9 (4 = 2 * 2) 7 (6 = 2 * 3) 9 (16 = 2 * 8) 7 (2 = 2 * 1) 5`
* The sum of all digits of the new number is 90, which is divisible by 10 => the card number is valid.

More examples:

* `79927398715` is a valid number
* `79927398713` is invalid number

###36. Word from a^nb^n

Implement a function, called `is_an_bn(word)` that checks if the given `word` is from the `a^nb^n for n>=0` language.
Here, `a^n` means a to the power of n - __repeat the character "a" n times.__

Lets see few words from this language:

* for `n = 0`, this is the empty word `""`
* for `n = 1`, this is the word `"ab"`
* for `n = 2`, this is the word `"aabb"`
* for `n = 3`, this is the word `"aaabbb"`
* and so on - first, you repeat the character "a" n times, and after this - repeat "b" n times

The function should return True if the given `word` is from `a^nb^n for n>=0"` for some n.

### Test examples

* is_an_bn("") = True
* is_an_bn("hack") = False
* is_an_bn("aaabb") = False
* is_an_bn("aaabbb") = True
* is_an_bn("aabbaabb") = False
* is_an_bn("bbbaaa") = False
* is_an_bn("aaaaabbbbb") = True

###37. Reduce file path

A file path in a Unix OS looks like this - `/home/radorado/code/hackbulgaria/week0`

We start from the root - `/` and we navigate to the destination fodler.

But there is a problem - if we have `..` and `.` in our file path, it's not clear where we are going to end up.

* `..` means to go back one directory
* `.`  means to stay in the same directory
* we can have more then one `/` between the directories - `/home//code`

So for example : `/home//radorado/code/./hackbulgaria/week0/../` reduces to `/home/radorado/code/hackbulgaria`.


Implement a function, called `reduce_file_path(path)` which takes a string and returns the reduced version of the path.

* Every `..` means that we have to go one directory back
* Every `.` means that we are staying in the same directory
* Every extra `/` is unnecessary
* Always remove the last `/`

### Test examples

* reduce_file_path("/") = "/"
* reduce_file_path("/srv/../") = "/"
* reduce_file_path("/srv/www/htdocs/wtf/") = "/srv/www/htdocs/wtf"
* reduce_file_path("/srv/www/htdocs/wtf") = "/srv/www/htdocs/wtf"
* reduce_file_path("/srv/./././././") = "/srv"
* reduce_file_path("/etc//wtf/") = "/etc/wtf"
* reduce_file_path("/etc/../etc/../etc/../") = "/"
* reduce_file_path("//////////////") = "/"
* reduce_file_path("/../") = "/"

###38. Zero Insertion

Given an integer, implement the function `int zero_insert(int n)`, which returns a new int, constructed by the following algorithm:

* If two neighboring digits are the same (like `55`), insert a 0 between them (`505`)
* Also, if we add two neighboring digits and take their module by 10 (`% 10`) and the result is 0 - add 0 between them.

For example, if we have the number `116457`, result will be: `10160457`:

* 1 and 1 are the same, so we insert 0 between them
* `6 + 4 % 10 = 0`, so we insert 0 between them.


### Examples

* zero_insert(116457) = 10160457
* zero_insert(55555555) = 505050505050505
* zero_insert(1) = 1
* zero_insert(6446) = 6040406
