package com.bamcoding.toy.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobScheduler {
    private final JobLauncher jobLauncher;
    private final Job job;

    @Scheduled(cron = "0 5 * * * *")
    public void task1() {
        System.out.println("schedule task1... ");
    }

    @Scheduled(cron = "0 * * * * *")
    public void excuteSimpleJob() {

        Map<String, JobParameter> map = new HashMap<>();
        map.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(map);

        try{
            jobLauncher.run(job,jobParameters);
        }
        catch(JobExecutionException e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
