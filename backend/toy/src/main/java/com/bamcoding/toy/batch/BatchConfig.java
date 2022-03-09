package com.bamcoding.toy.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class BatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    Job simpleJob(){
        return jobBuilderFactory.get("simpleJob").start(simpleStep1()).build();
    }

    @Bean
    @JobScope
    Step simpleStep1(){
        return stepBuilderFactory.get("simpleStep1").tasklet((contribution, chunkContext) -> {
            log.info("함수형 인터페이스 테스트릿이 작동중입니다.");
            return RepeatStatus.FINISHED;
        }).build();
    }

}
