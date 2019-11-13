package com.example.batchspringexample.web;

import com.example.batchspringexample.BankTransactionItemAnalyticsProcessor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JobRestController {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;
    @Autowired
    private BankTransactionItemAnalyticsProcessor analyticsProcessor;

    @GetMapping("/startJob")
    public BatchStatus load() throws Exception{
        Map<String, JobParameter> parameterMap = new HashMap<>();
        parameterMap.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(parameterMap);
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        while(jobExecution.isRunning()){
            System.out.println("....");
        }
        return jobExecution.getStatus();
    }

    @GetMapping("/analytics")
    public Map<String, Double> analytics(){
        Map<String, Double> map = new HashMap<>();
        map.put("totalCredit", analyticsProcessor.getTotalCredit());
        map.put("totalDebit", analyticsProcessor.getTotalDebit());
        return map;
    }


}