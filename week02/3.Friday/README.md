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