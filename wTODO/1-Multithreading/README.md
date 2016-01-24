### A demonstration of a race condition
Create a project 'Threads'.

Create a static variable `counter`.
Create two threads - A and B.
In their `run()` methods just increment the shared variable 2_000_000 times.

Start the two threads, join them, and print out `counter`. What happens? Why?
Print out the time needed.

##### Introduce critical blocks
Now wrap the incrementing in a synchronized block in each thread. (They should be **synchronized on the same monitor**).
First, wrap the whole `for` statements in a synchronized blocks.

See the result is now correct, and observe the minor performance penalty.

Now, move the synochronized block `inside` the `for` statements.
Notice the increased performance penalty.
Experiment different ways to write it and see what is the behavior.

##### Replace the synchronized blocks with a call to a synchronized method increment()

##### Replace the synchronized stuff with an AtomicInteger. Notice the performance penalty!

##### Replace the Atomic Integer with wait/notify + mutex variable mechanism
The scenario we want is the following:
- Thread A obtains the mutex (`wait()`s until the mutex is available) 
- Works (increments the integer) 
- Then calls `notify` on the monitor 
- Which fires the Thread B, which does the same 


### Implement a simple blocking queue.
A blocking queue is just like a regular queue, with the difference that if someone calls `poll()` and the queue is empty, the call is blocked until somebody adds an element to the queue. After an element is added, the caller (the one who called `poll()`) gets unblocked and the `poll()` call returns.

### Bonus: 
Introduce classical very common interview scenario *Producer - Consumer problem*. Create several threads (Producers) that only produce `add(E e)` in your queue and several threads (Consumers) that only consume `poll()` from your queue. Your blocking queue should have a max size. When a max size is reached all producers are halted until some object have been consumed.  



### Paralel minimal point calculations

Create a static method `generatePoints()` which returns a `List<Point>` - `create your Point impl (with maybe different implementations)`   
Implement it, generating a 100 000 points (in java that is written `100_000`) points with random coordinates - ranging from 0 to 10_000.

Now, for each of those points, I'd like you to find it's nearest point. Do this in a method `Map<Point,Point> getNearestPoints(List<Point> generatedPoints)`  

It takes a while. By calculations, it should take like lots of seconds to complete (depending on your CPU speed).  

Now introduce some multithreading to speed it up.  
Declare and implement a method `doCalculations(List<Point> inPoints, int indexFrom, int indexTo, Map<Point, Point> outMap)`.
Move calculations logic from `getNearestPoints` to `doCalculations`, but work strictly from `indexFrom`, to `indexTo`. 

Now in `getNearestPoints(List<Point> generatedPoints)` method, start two Threads that call `doCalculations`, in their run methods, one from 0 to half of the elements, the other from half of the elements to the last of them.

Measure speedup between the two implementations (See `System.currentTimeMillis()`).

Introduce a third and forth thread. Does your implementation go faster?

Think how to generalize the number of threads and how to implement it.
