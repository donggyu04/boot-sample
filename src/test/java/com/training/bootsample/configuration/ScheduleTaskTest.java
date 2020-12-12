package com.training.bootsample.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.TaskScheduler;

import static java.lang.Thread.sleep;

@SpringBootTest
public class ScheduleTaskTest {

    @Autowired
    private TaskScheduler taskScheduler;

    private Runnable normalRunnable;

    private Runnable exceptionRunnable;

    @Test
    public void testTaskSchedulerException() throws InterruptedException {
        normalRunnable = () -> System.out.println("Normal runnable called!");
        exceptionRunnable = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                count++;
                exceptionTask(count);
            }
        };

        taskScheduler.scheduleWithFixedDelay(normalRunnable, 1000);
        taskScheduler.scheduleWithFixedDelay(exceptionRunnable, 1000);
        sleep(50000);
    }

    private void exceptionTask(int count) {
        System.out.println("Exception runnable called!");
        count++;
        if (count > 10) {
            System.out.println("runtime exception is occurred!");
            throw new RuntimeException("Running time is over 10 sec");
        }
    }

}
