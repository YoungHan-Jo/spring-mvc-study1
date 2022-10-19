package hello.servletprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ServletpracApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletpracApplication.class, args);
	}

}
