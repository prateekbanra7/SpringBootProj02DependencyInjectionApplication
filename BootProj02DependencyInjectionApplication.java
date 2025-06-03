package in.abc;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import in.abc.target.Student;

@SpringBootApplication
@ImportResource(locations = "in/abc/cfg/applicationContext.xml")
public class BootProj02DependencyInjectionApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(BootProj02DependencyInjectionApplication.class, args);
		System.out.println();
		
		Student student = context.getBean(Student.class);
		System.out.println(student);
		
		student.preparation(student.getMaterial().getClass().getName());
		
		((ConfigurableApplicationContext) context).close();
	}

}
