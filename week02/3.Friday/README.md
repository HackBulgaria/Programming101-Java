## 31. Some Git fun

Create a new directory and create a new local Git repo there.

Make a new file called `hello` with the following content:

```
This is line one.
This is line two.
This is line three.
This is line four.
```

Now commit. You get an error? Did you remember to `add`?

Now create a new branch called `panda` and switch to it.

Change the second line of `hello` with `Uh, I forgot how to count!` and add a fifth line `This is line five.`.

Commit this and switch back to the master branch.

Now change the third line of `hello` with `I am number three.` and remove the fourth line. Commit.

We will now simulate something called a **merge conflict**. A merge conflict happens when we attempt to merge two files when it is not obvious how to merge them (e.g. when the file has been modified from two different branches as in this case).

While on the `master` branch, merge it with the `panda` branch. You will see the error.

In order to fix the merge conflict, we need to use a merge tool. Before that, however, we need to actually install a merge tool - that's a GUI app that lets us see the changes in a file from different branches. We are fans of [meld](http://meldmerge.org/) (install it with `sudo apt-get install meld`).

Now run `git mergetool` and start `meld`. Get familiar with the interface. We want the file to look like this after the merge:

```
This is line one.
Uh, I forgot how to count!
I am number three.
This is line five.
```
### 32. Commit it all!

This is a big one. Go to our repository and note how our directories are structured.

```
|--week01
|  |--1.Monday
|  |--2.Wednesday
|  |--3.Friday
|
|--week02
   |--1.Monday
   |--2.Wednesday
   |--3.Friday
```

Your task is to create a GitHub repo of your own. Add all of your solutions to your repo and **use the same directory structure**.

__Hint: Instead of manually creating the directories, you can clone our repo and then integrate it with your GitHub repo.__

You will need to push all of your solutions to GitHub from now on. We will sometimes review your code and give you feedback directly through GitHub.

### 32. Calc the Calculator
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