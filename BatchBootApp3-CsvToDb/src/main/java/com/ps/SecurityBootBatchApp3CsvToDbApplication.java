package com.ps;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SecurityBootBatchApp3CsvToDbApplication {
	
	@Autowired
	private static JobLauncher launcher;
	@Autowired
	private static Job job1;

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		JobExecution execution=null;
		
		//get IOC container		
		ctx=SpringApplication.run(SecurityBootBatchApp3CsvToDbApplication.class, args);
		try {
			//run the job			
			execution=launcher.run(job1, new JobParameters());			
			System.out.println("Status :: "+execution.getStatus());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
