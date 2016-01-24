### Java 8 Problems

Stream and lambda problems  
1. Download and import the Java8 project to your eclipse or IntellIJ platforms  
2. Subclass the `StudentOperations` interface and add all the methods so it compiles  
3. Run the unit tests. Everything should fail.  

4. Make them all green : )

Gotcha*: 
Create a functional interface, that would make the following code compile
X x = () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> null;

Spliterator task:
'Spliterator' (`java.util.Spliterator`) is a new term from java8 - you can create streams by supplying spliterators. Spliterator is responsible for partitioning and object and advancing a stream.

Implement a `SlidingWindowSpliterator` for collections. 

How to verify your spliterator is working correctly:

```
Collection<String> testCollection = Arrays.asList("This","is","a","lame","example");
Spliterator<String> yourSpliterator = new SlidingWindowSpliterator(testCollection, 2) //2 is the sliding window length
StreamSupport.stream(yourSpliteratorObject).forEach(System.out::println);
```
----
```
This is
is a 
a lame
lame example
```