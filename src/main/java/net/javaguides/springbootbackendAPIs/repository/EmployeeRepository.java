package net.javaguides.springbootbackendAPIs.repository;

import net.javaguides.springbootbackendAPIs.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface EmployeeRepository extends JpaRepository<Employee, Long> { //We use long bc the primary key is long
    //here implement all crud


}
