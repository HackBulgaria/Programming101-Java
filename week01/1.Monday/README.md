### Verify java is working and is in $PATH ###
```java -version``` 

```javac -version```

```javap -version```

Friendly advice: These should be the same version, or you might have a bad time :) 

### Compiling fun with javac and java###
- Open a terminal. Navigate to any folder whatsoever. Make a new Empty.java file. Try to compile it with javac. See what happens.
- Make a class named Program. Try to compile it with javac.
- Rename the class to Empty. Compile it. 
- Make a main method. Make it print "Hello world!". Compile it and run it.
- Make the main method print its arguments (String[] args). Make the for loop as you would make one in C or C++, and use the System.out.println method for printing to the console.

### Getting to know what classpath is###
- Open a terminal, navigate to some folder. Make a new A.java file with a legitimate class A declared in it. 
- Do the same for a file/class named B.
- Declare a public method in B. 
- In class A, make a *main method*
- Instantiate B in it and call B's public method.
- Try, compile and run A. Does it run? Why? How does it know about B? What about import statements?

- Now move B up one folder to '..'
- Try compiling and running it.

- Add -cp ".." to your javac command and try again.

###Bundle them both###
- jar -c A.class
- Does this command look familiar to you? : )

### Disassembly with javap ###
- Disassemble Empty.class
- Does this look familiar to you? This is what Eclipse is doing when you open a look up a class file with no source attached.

