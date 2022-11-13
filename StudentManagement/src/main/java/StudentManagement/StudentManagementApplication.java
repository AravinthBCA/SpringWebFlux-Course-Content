package StudentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="College API",version="1.0",description="This API is for Products..."))
public class StudentManagementApplication {

	public static void main(String[] args) {		
		SpringApplication.run(StudentManagementApplication.class, args);
	}

}
