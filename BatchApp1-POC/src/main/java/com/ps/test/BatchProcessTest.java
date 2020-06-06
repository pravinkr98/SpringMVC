package com.ps.test;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchProcessTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		JobLauncher launcher=null;
		Job job1=null;
		JobExecution execution=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//get Access to launcher object
		launcher=ctx.getBean("jobLauncher", JobLauncher.class);
		//get Access to job object
		job1=ctx.getBean("job1", Job.class);
		//execute the job
		try {
			execution=launcher.run(job1, new JobParameters());
			System.out.println("Status :: "+execution.getStatus());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
