package module12.task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PassedTime {
    private static final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

    public static void main(String[] args) throws InterruptedException {
        long programStartTime = System.currentTimeMillis();

        scheduledExecutorService.scheduleAtFixedRate(
                () -> System.out.println((System.currentTimeMillis() - programStartTime) / 1000),
                1,
                1,
                TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(
                () -> System.out.println("Минуло 5 секунд"),
                5,
                5,
                TimeUnit.SECONDS);
        Thread.sleep(20000);
        scheduledExecutorService.shutdown();
    }
}
