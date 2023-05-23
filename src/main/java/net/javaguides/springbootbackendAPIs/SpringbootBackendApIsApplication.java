package net.javaguides.springbootbackendAPIs;

import net.javaguides.springbootbackendAPIs.model.Employee;
import net.javaguides.springbootbackendAPIs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApIsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApIsApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception { //execute
		Employee employee=new Employee();
		employee.setFirstName("Julian");
		employee.setLastName("Casablancas");
		employee.setEmailId("julian@gmail.com");
		employeeRepository.save(employee);


		Employee employee1=new Employee();
		employee1.setFirstName("Thom");
		employee1.setLastName("Yorke");
		employee1.setEmailId("thomYorke@gmail.com");
		employeeRepository.save(employee1);

	}
}
