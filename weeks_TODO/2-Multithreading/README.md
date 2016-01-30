### Reimplement atomic int with Lock objects - test and measure performance

###  Paralel web crawler

There is a bottleneck in web crawling - while waiting for an answer from the server, the CPU does nothing.   
It would be better to make several requests at once.

Try to crawl 9gag.com, for instance, and print every page you've visited. See the speed is not that great.
Now Introduce parallelisation and speed up the solution. Use an approach similiar to the approach for task #1.

If your web crawler project is not working, use the one in this github folder instead. (It's a Maven project, you will need to fetch all dependencies).


### Multiply Matrices
Use the solution you did in the OOP lecture and add functionality to multiply two matrices - think about OOP decision to implement it - think how to speed it up, then measure how faster it is and also measure if CPU is allocated enough. (Team -- design)

### Instagram Processor

Your task is to create an Instagram image processor. It must handle calling from multiple threads. Use the [Producer-Consumer pattern](https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html) in order to achieve this. 

For the filtering, use [this excellent image processing library by JH Labs](http://www.jhlabs.com/ip/filters/download.html).

The entry point is the following method:  
`Instagram.process(String source, String target)`

The first parameter is the path to the source image. The second parameter is the directory, into which to save the filtered image.

For now we will use only a single filter - the Mask filter. In a future task, we will add more filters.

Let's remind ourselves that the Producer-Consumer pattern has three objects: *Producer*, *Consumer* and *Shared object*. *Producer* and *Consumer* communicate via the *Shared object*.

Here is the workflow:
- When you call `Instagram.process` from any thread, the Producer puts the source and target paths into the *Shared  object* and waits for notification that *Consumer* is ready.
- The *Consumer* reads the source path from the *Shared object*, loads the image, performs the filtering and saves it to the target directory. When it finishes, it notifies the *Shared object* it's ready and waits for the next path.


Example usage: 

```java
new Thread(new Runnable() {
  public void run() {
    Instagram.process("/home/me/Documents/my_image1.jpg", "/home/me/Documents/output/");
  }
}).start();

new Thread(new Runnable() {
  public void run() {
    Instagram.process("/home/me/Documents/my_image2.jpg", "/home/me/Documents/output/");
  }
}).start();
```

After calling this, your program must get either the image at `/home/me/Documents/my_image1.jpg` or `/home/me/Documents/my_image2.jpg`, execute Mask filter on it and save it to `/home/me/Documents/output/` Then it must get the other image and do the same. 