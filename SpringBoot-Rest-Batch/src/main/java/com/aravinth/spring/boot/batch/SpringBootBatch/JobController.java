package com.aravinth.spring.boot.batch.SpringBootBatch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
	
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
    Job job;
	
	@GetMapping("/hi")
	public String hi() {
		return "hi";
	}
	
	@GetMapping("/start")
	public String start() {
		Map<String, JobParameter> parameters = new HashMap<>();
        try {
			JobExecution jobExecution = jobLauncher.run(job, new JobParameters(parameters));
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "completed";
	}

}
