package com.example.mvc;

import org.springframework.context.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDay06FileUploadDownloadApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDay06FileUploadDownloadApplication.class, args);

		// 사용하는 Bean 확인할 ㅜㅅ 있다. 
//		for(String name : context.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
	}

}
