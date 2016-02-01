package producer_consumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

  public static void main(String[] args) throws Exception {
    Memory memory = new Memory(100);
    Producer p= new Producer(memory);
    Consumer pp= new Consumer(memory);
    Consumer ppp= new Consumer(memory);
    Thread t = new Thread(p);
    Thread tt = new Thread(pp);
    Thread ttt = new Thread(ppp);
    t.start();
    tt.start();
    ttt.start();
    t.join();
    tt.join();
    
    System.out.println("dsadas");
    System.out.println("dsadas");System.out.println("dsadas");
    System.out.println("dsadas");System.out.println("dsadas");
    System.out.println("dsadas");
    
  }
  
  static class Producer implements Runnable {
    int count = 0;
    Memory m;
    
    public Producer(Memory m) {
      this.m = m;
    }

    @Override
    public void run() {
      // TODO Auto-generated method stub
      while(true) {
        try {
//          Thread.sleep(100);
          m.put(++count);
          System.out.println("Produced " + count + " " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
  
  static class Consumer implements Runnable {
    Memory m;
    
    public Consumer(Memory m) {
      this.m = m;
    }

    @Override
    public void run() {
      // TODO Auto-generated method stub
      while(true) {
        try {
//          Thread.sleep(110);
          Object result = m.get();
          System.out.println("Consumed " + result + " " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        
      }
    }
    
  }
  
  static class Memory {
    
    List data = new ArrayList();
    int capacity;
    
    public Memory(int capacity) {
      this.capacity = capacity;
    }
    
    void put (Object o) throws InterruptedException {
      synchronized (data) {
        while (data.size() == capacity) {
          data.wait();
        }
        data.add(o);
        data.notifyAll();
      }
    }

    Object get() throws InterruptedException {
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
