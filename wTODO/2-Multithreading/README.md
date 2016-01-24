### Reimplement atomic int with Lock objects - test and measure performance

###  Paralel web crawler

There is a bottleneck in web crawling - while waiting for an answer from the server, the CPU does nothing.   
It would be better to make several requests at once.

Try to crawl 9gag.com, for instance, and print every page you've visited. See the speed is not that great.
Now Introduce parallelisation and speed up the solution. Use an approach similiar to the approach for task #1.

If your web crawler project is not working, use the one in this github folder instead. (It's a Maven project, you will need to fetch all dependencies).


### Multiply Matrices
Use the solution you did in the OOP lecture and add functionality to multiply two matrices - think about OOP decision to implement it - think how to speed it up, then measure how faster it is and also measure if CPU is allocated enough. (Team -- design)