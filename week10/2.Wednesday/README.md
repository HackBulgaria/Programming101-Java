### Implement a simple blocking queue.
Implement a blocking queue with locks/conditions - just like a regular queue, with the difference that if someone calls `poll()` and the queue is empty, the call is blocked until somebody adds an element to the queue. After an element is added, the caller (the one who called `poll()`) gets unblocked and the `poll()` call returns. Create several threads (Producers) that only produce `add(E e)` in your queue and several threads (Consumers) that only consume `poll()` from your queue. Your blocking queue should have a max size. When a max size is reached all producers are halted until some object have been consumed.

### Parallel minimal point calculations

Try to implement the following with some different approach and concurrent object from java.util.concurrent.*.
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

### Reimplement atomic int with Lock objects - test and measure performance

### Implement advanced file search
Implement search for a text in file contents. (Joker - think how to use producer-consumer pattern to speed that up)
Your program, by given folder name, should find all the files inside it where a text is occurring and return the file name and in which line the match was found.

### Implement advanced concurrent data structure
Implement a data structure over which several producers and consumers can work simultaneously, which means:
- it is possible several producers to write into that structure simultaneously,
- it is possible several consumer to read from that structure simultaneously,
- it is possible several producers and consumers to read and write in that structure simultaneosly,
Try to measure what's the speedup (from this structure over the not so concurrent one where only one reader or writer at a time is allowed to operate) to produce and consume an amount of items - N, with that structure.


### Measurement tool
Implement a tool which has several confugurable factors:
- number of producers
- number of consumers
- number of elements to be produced/consumed
- size(number of elements) of a data structure to be used for shared memory
Measure the time needed all elements to be consumed and let your program tell you what are the optimal configuration numbers.
