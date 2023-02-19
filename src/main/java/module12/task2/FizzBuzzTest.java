package module12.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FizzBuzzTest {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        FizzBuzzService fizzBuzzService = new FizzBuzzService(18);

        executorService.submit(fizzBuzzService::fizz);
        executorService.submit(fizzBuzzService::buzz);
        executorService.submit(fizzBuzzService::fizzBuzz);
        executorService.submit(fizzBuzzService::number);
        executorService.submit(() -> fizzBuzzPrint(fizzBuzzService));
        Thread.sleep(2000);
        executorService.shutdown();
    }

    private static void fizzBuzzPrint(FizzBuzzService fizzBuzzService) {
        while (fizzBuzzService.isNumberLessEqualsN()) {
            if (fizzBuzzService.getQueue().isEmpty()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            while (!fizzBuzzService.getQueue().isEmpty()) {
                System.out.println(fizzBuzzService.getQueue().poll());
            }
        }
    }
}
