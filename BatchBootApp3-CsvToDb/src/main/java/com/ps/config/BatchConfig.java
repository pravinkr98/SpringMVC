package com.ps.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.ps.model.IExamResult;
import com.ps.model.OExamResult;
import com.ps.processor.ExamResultProcessor;

@Configuration
@EnableBatchProcessing
@ComponentScan(basePackages = "com.ps.processor")
public class BatchConfig {
	
	@Autowired
	private ExamResultProcessor processor;
	@Autowired
	private StepBuilderFactory stepFactory;
	@Autowired
	private JobBuilderFactory jobFactory;
	
	@Autowired
	private DataSource ds;
	
	@Bean
	public ItemReader reader() {
		FlatFileItemReader reader=null;
		reader=new FlatFileItemReader<IExamResult>();
		reader.setResource(new ClassPathResource("com/ps/csv/SuperBrains.csv"));
		reader.setLineMapper(new DefaultLineMapper<IExamResult>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setNames("id","semester","percentage","dob");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<IExamResult>() {{
				setTargetType(IExamResult.class);
			}});
		}});
		return reader;		
	}
	
	
	@Bean
	public JdbcBatchItemWriter<OExamResult> writer(){
		JdbcBatchItemWriter<OExamResult> writer=null;
		writer=new JdbcBatchItemWriter<OExamResult>();
		writer.setDataSource(ds);
		writer.setSql("INSERT INTO EXAM_RESULT1(ID,SEMESTER,PERCENTAGE,DOB) VALUES(:id,:semester,:percentage,:dob)");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<OExamResult>());
		return writer;
	}
	
	@Bean
	public Step createStep1() {
		return stepFactory.get("createStep1").<IExamResult,OExamResult>chunk(10).reader(reader()).writer(writer()).processor(processor).build();
	}
	
	@Bean
	public Job createJob1() {
		return jobFactory.get("createJob1").incrementer(new RunIdIncrementer())
				.flow(createStep1()).end().build();
	}

}
