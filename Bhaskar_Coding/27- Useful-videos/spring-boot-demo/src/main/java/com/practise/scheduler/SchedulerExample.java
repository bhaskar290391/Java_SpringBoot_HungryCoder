package com.practise.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

@Configuration
@EnableScheduling
public class SchedulerExample {


    @Scheduled(fixedRate = 1000)
    @Async
    public void fixedRateScheduling() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Fixed rate fixedRateScheduling "+ (System.currentTimeMillis()/1000));
    }


    @Scheduled(fixedDelay = 1000)
    public void fixedDelayScheduling() throws InterruptedException {

        System.out.println("Fixed Delay  "+ (System.currentTimeMillis()/1000));
    }

}
