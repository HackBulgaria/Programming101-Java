### Implement a simple blocking queue.
A blocking queue is just like a regular queue, with the difference that if someone calls `poll()` and the queue is empty, the call is blocked until somebody adds an element to the queue. After an element is added, the caller (the one who called `poll()`) gets unblocked and the `poll()` call returns.

### Bonus:
Introduce classical very common interview scenario *Producer - Consumer problem*. Create several threads (Producers) that only produce `add(E e)` in your queue and several threads (Consumers) that only consume `poll()` from your queue. Your blocking queue should have a max size. When a max size is reached all producers are halted until some object have been consumed.

### Parallel minimal point calculations

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

### Bulk Thumbnail Creator
Picture processing can take a bit of time for some transformations. Especially if the image is large. Create an image program which can take a directory path and converts all images in it and its subdirectories to a specified size in the background thread while you do other things. For each directory, you should create a `thumbnails` directory and store the new thumbnails there. It should work like a console application, taking an argument for the directory and for the new thumbnail size.

Example usage: `java thumbnailGen /home/pesho/Desktop/pics/ 150 150`
This should generate thumbnails in /home/pesho/Desktop/pics/thumbnails/ with size 150x150 px.

**BONUS:** Handle the resizing in one thread and bulk renaming of thumbnails in another thread.
**BONUS 2:** Add an option whether to include the images in the subdirectories (e.g. whether it should be recursive or not). For example,  `java thumbnailGen -r /home/pesho/Desktop/pics/ 150 150` should do it recursively.

### Parallel Copy
Create a java tool which copies a source folder with all its files and subfolders to a target folder. The twist is to make the program intelligent enough to perform several copies in parallel. It should take into account the file sizes and the number of files. For example, if you copy 8 small files, the program can decide to copy them on one thread. If they are 16, it can copy them on 2 threads. If you copy 1 big file and 3 small files, it can copy the big file on a separate thread. It is up to you how it makes these decisions. It should work like a console application, taking as arguments the source and target directory. Add an option which specifies whether to use this optimization* or not (for example, if you add -s, you make a regular copy without creating new threads).

Example usage: `java cp /home/pesho/Desktop/source/ /home/pesho/Desktop/target/`
This should copy all files from /home/pesho/Desktop/source/ to /home/pesho/Desktop/target/

*Is it actually an optimization? Try your program with some big files with -s and without -s. Do you see a noticable difference? Can you explain why so?


### Reimplement atomic int with Lock objects - test and measure performance

###  Paralel web crawler

There is a bottleneck in web crawling - while waiting for an answer from the server, the CPU does nothing.
It would be better to make several requests at once.

Try to crawl 9gag.com, for instance, and print every page you've visited. See the speed is not that great.
Now Introduce parallelisation and speed up the solution. Use an approach similiar to the approach for task #1.

If your web crawler project is not working, use the one in this github folder instead. (It's a Maven project, you will need to fetch all dependencies).


### Multiply Matrices
Use the solution you did in the OOP lecture and add functionality to multiply two matrices - think about OOP decision to implement it - think how to speed it up, then measure how faster it is and also measure if CPU is allocated enough. (Team -- design)
