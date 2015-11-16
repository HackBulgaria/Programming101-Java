###1. Is it an odd number?###
```boolean isOdd(int n)```
Return whether n is an odd number

###2. Is N prime?###
```boolean isPrime(int N)```

###3. Find the minimum element of an array###
```int min(int... array)```

###4. Find the kth minimal element of an array###
```int kthMin(int k, int[] array)```
*There will be no duplicates in the array. If they are duplicates in the test, ignore them (my bad).*

###5. Find the average(средно аритметично) of the elements of an array###
```int getAverage(int[] array);```

###6. Double factorial###
```long doubleFac(int n);```
return 
E.g. if n=3, => (3!)! = 6! = 720 

###7. Kth factorial###
```long kthFac(int k, int n);```
Get the kthFactorial of n. k is guaranteed to be positive. 
*Bonus* no "helper" methods, no recursion :)

###8. Smallest multiple###
```long getSmallestMultiple(int upperBound);```

Find the smallest (positive) number, that can be divided by each of the numbers from 1 to *upperBound*.

###9. Find the largest integer palindrome number up to N###
```long getLargestPalindrome(long N);```

1234321 is a palindrome. You are given a number => *N*. 
Find the largest number < N, that is a palindrome.

*Bonus* do this without using Collections.sort

###10. Grayscale image histogram###
```int[] histogram(short[][] image)``` 

A histogram is a representation of distribution of some data.

Here you receive a grayscale image matrix (*image*). Each of the matrix's values will be between 0 and 255.
Return an array *result*, which is a histogram of *image* => the value of *result[i]* should be the ammount of times *i* is in the matrix *image*. 

###11. Raise an integer to a power of another###
```long pow(int a, int b)```

Write a O(log(b)) solution.

###12. Find the only number, that occurs odd times in an array###
```int getOddOccurrence(int... array)```

Every element in array will occur an even ammount of times.  There will be exactly one element
Example: {1,2,2,1,3,4,3,4,4,6,5,6,5} => 4 occurs only an odd number of times.

###13. Maximal scalar product###
```long maximalScalarSum(int[] a, int[] b)```
You are given two vectors, *a* and *b*. Let a be ```{a1,a2,a3}``` and b be ```{b1,b2,b3}```. The scalar product of vectors *a* and *b* is the number ```a1*b1 + a2*b2 + a3*b3``` 

Find a permutation of a, and a permutation of b, for which their scalar product is the largest possible.  

###14. Max span###
```int maxSpan(int[] numbers)```
Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the number of elements between the two inclusive. A single value has a span of 1. Returns the largest span found in the given array. 

maxSpan({1, 2, 1, 1, 3}) → 4
maxSpan({1, 4, 2, 1, 4, 1, 4}) → 6
maxSpan({1, 4, 2, 1, 4, 4, 4}) → 6

###15. Can balance?###
```boolean canBalance(int[] numbers)```

canBalance({1, 1, 1, 2, 1}) → true
canBalance({2, 1, 1, 2, 1}) → false
canBalance({10, 10}) → true

Return true if there is an element in the array, where you can split the array in half and the sum of left side would be equal to the sum of the right part. 

###16. Rescale an image using nearest neighbour interpolation###
```int[][] rescale(int[][] original, int newWidth, int newHeight)```

You are given an image *original*. Rescale it to newWidth, newHeight, using nearest neighbour interpolation. (See http://en.wikipedia.org/wiki/Nearest-neighbor_interpolation)


###17. Reverse a String###
`String reverseMe(String argument)`

###18. Reverse each word in a String###
`String reverseEveryChar(String arg)`

`reverseEveryChar("What is this") => tahW si siht`

###18. Is this string a palindrome###
`boolean isPalindrome(String argument)`

###19. Is this number a palindrome###
`boolean isPalindrome(int argument)`


###18. Copy every character K times ###
`String copyEveryChar(String input, int k)`

`copyEveryChar("tldr", 3) => "tttllldddrrr"`
Important Note: There is an error in the unit test.
If you are failing on this line:
`assertEquals("ttt   www   rrr", problems2.copyEveryChar("t w r", 2));`
It is because is shoud be "3" instead of "2" as an argument at the end. 
(My bad).



###19. Check for palindrome length around '*' ###
`int getPalindromeLength(String input)`

`getPalindromeLength("taz*zad") => 2`

###20. Count number of (non-overlapping) occurences ###
`int countOcurrences(String needle, String haystack)`
`countOcurrences("da", "daaadaadada") => 4`

*Bonus* Only 1 line of code allowed. No loops :)

###21. Decode an URL ###
Input 'kitten%20pic.jpg'
Output 'kitten pic.jpg'
%20=>' '
%3A=>':'
%3D=>'?'
%2F=>'/'
`String decodeUrl(String input)`

1 line of code is allowed. 

###22. Sum all the numbers in a String###
`int sumOfNumbers(String input)`

Sum all of the numbers in the String. Ignore the characters.
`sumOfNumbers("abc123dd34") => 157`
`sumOfNumbers("12 99 1) => 112`

###23. Is String A an anagram of String B?###
`boolean anagram(String A, String B)`
See http://en.wikipedia.org/wiki/Anagram

No HashMaps, hashSets, or such stuff allowed : )
Note: The last unit test is a *faulty* one. Delete it. (My bad).
###24. Is an anagram of String A a susbstring in B?###
`boolean hasAnagramOf(A,B)` 
Return whether an anagram of String A can be found in String B.


###25. Convert To Greyscale

Implement the following function/method:
```
convertToGreyscale(imgPath)
```
Given the path of a color image (.jpg, .png, .bmp) create a greyscale version of it and save it. 

**WARNING!** You are not allowed to use any libraries, you have to write your own algorithm!
