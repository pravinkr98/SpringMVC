package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ps.service.PurchaseService;

@SpringBootApplication
public class SpringMailApp1Application {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PurchaseService service=null;
		String msg=null;
		
		//get IOC container
		ctx=SpringApplication.run(SpringMailApp1Application.class, args);
		//get Bean
		service=ctx.getBean("purchaseService", PurchaseService.class);
		try {
			msg=service.purchase(new String[] {"Laptop", "Harddisk"},new float[] {35000,4500}, "gdukmr843117@gmail.com");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
