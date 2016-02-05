package producer_consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {

  private static final int NUMBER_OF_ELEMENTS = 1000000;

  public static void main(String[] args) throws Exception {
    int timesToRun = 5;
    int totalTime = 0;
    for (int i = 0; i < timesToRun ; i++) {
      long timeToFinish = experiment(3,10, 1000);
      totalTime += timeToFinish;
    }

    System.out.println("time: " + totalTime / timesToRun);
  }

  private static long experiment(int producerCount, int consumersCount, int capacity) throws InterruptedException {
    IMemory memory = Factory.createMemory(capacity);
//    IMemory memory = Factory.createJavaMemory(10000);
    AtomicInteger elementsToProduce = new AtomicInteger(NUMBER_OF_ELEMENTS);
    AtomicInteger elementsToConsume = new AtomicInteger(NUMBER_OF_ELEMENTS);
    List<Thread> threads = new ArrayList<Thread>();
    for (int i = 0; i < producerCount; i++) {
      Producer p= new Producer(memory, elementsToProduce);
      threads.add(new Thread(p));
    }
    for (int i = 0; i < consumersCount; i++) {
      Consumer p= new Consumer(memory, elementsToConsume);
      threads.add(new Thread(p));
    }
    
    long startTime = System.currentTimeMillis();
    for (Thread thread : threads) {
      thread.start();
    }
    for (Thread thread : threads) {
      thread.join();
    }
    return (System.currentTimeMillis() - startTime );
  }
  
  static class Producer implements Runnable {
    int count = 0;
    IMemory m;
    private AtomicInteger totalElementsToProduce;

    public Producer(IMemory m, AtomicInteger totalElementsToProduce) {
      this.m = m;
      this.totalElementsToProduce = totalElementsToProduce;
    }

    @Override
    public void run() {
      int elementsToProduce = -1;
//      while (totalElementsToProduce.getAndAdd(0) > 0) {
//        int andDecrement = totalElementsToProduce.getAndDecrement();
//        m.put(andDecrement);
//      }
      while((elementsToProduce = totalElementsToProduce.getAndDecrement()) > 0) {
        try {
//          Thread.sleep(100);
          m.put(elementsToProduce);
          System.out.println("Produced " + (NUMBER_OF_ELEMENTS - elementsToProduce) + " " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
  
  static class Consumer implements Runnable {
    IMemory m;
    private AtomicInteger totalElementsToConsume;
    public Consumer(IMemory m, AtomicInteger totalElementsToConsume) {
      this.m = m;
      this.totalElementsToConsume = totalElementsToConsume;
    }

    @Override
    public void run() {
      while(totalElementsToConsume.getAndAdd(0) > 0) {
        try {
          Object result = m.get();
          totalElementsToConsume.decrementAndGet();
          System.out.println("Consumed " + result + " " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
  
  interface IMemory {
    public void put (Object o) throws InterruptedException;
    Object get() throws InterruptedException ;
  }
  
  static class Factory {
    static IMemory createMemory(int capacity) {
      return new Memory(capacity);
    }
    static IMemory createJavaMemory(int capacity) {
      return new JavaMemory();
    }
  }
  
  static class JavaMemory implements IMemory {
    
    CopyOnWriteArrayList memory = new CopyOnWriteArrayList();
    
    @Override
    public void put(Object o) throws InterruptedException {
      memory.add(o);
    }

    @Override
    public Object get() throws InterruptedException {
      return memory.get(memory.size() - 1);
    }
    
  }
  
  
  static class Memory implements IMemory {
    
    List data = new ArrayList();
    int capacity;
    
    public Memory(int capacity) {
      this.capacity = capacity;
    }
    
    public void put (Object o) throws InterruptedException {
      synchronized (data) {
        while (data.size() == capacity) {
          data.wait();
        }
        data.add(o);
        data.notifyAll();
      }
    }

    public Object get() throws InterruptedException {
      Object element = null;
      synchronized (data) {
        while (data.size() == 0) {
          data.wait();
        }
        element = data.remove(data.size() - 1);
        data.notifyAll();
      }
      return element;
    }
  }

}
