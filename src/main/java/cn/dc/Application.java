package cn.dc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//注解相当于使用@Configuration，@EnableAutoConfiguration和@ComponentScan和他们的默认属性
// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
