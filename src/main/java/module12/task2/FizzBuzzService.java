package module12.task2;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzzService {
    private int n;
    private static final AtomicInteger number = new AtomicInteger(1);
    private static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    public FizzBuzzService(int n) {
        this.n = n;
    }

    public ConcurrentLinkedQueue<String> getQueue() {
        return queue;
    }

    public boolean isNumberLessEqualsN() {
        return number.get() <= n;
    }

    public synchronized void fizz() {
        while (isNumberLessEqualsN()) {
            if (number.get() % 3 == 0 && number.get() % 5 != 0) {
                queue.add("Fizz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void buzz() {
        while (isNumberLessEqualsN()) {
            if (number.get() % 3 != 0 && number.get() % 5 == 0) {
                queue.add("Buzz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void fizzBuzz() {
        while (isNumberLessEqualsN()) {
            if (number.get() % 15 == 0) {
                queue.add("FizzBuzz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void number() {
        while (isNumberLessEqualsN()) {
            if (number.get() % 5 != 0 && number.get() % 3 != 0) {
                queue.add(String.valueOf(number.get()));
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
