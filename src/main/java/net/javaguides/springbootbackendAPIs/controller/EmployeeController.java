package net.javaguides.springbootbackendAPIs.controller;

import net.javaguides.springbootbackendAPIs.exception.ResourceNotFoundException;
import net.javaguides.springbootbackendAPIs.model.Employee;
import net.javaguides.springbootbackendAPIs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    //this class will handle http request

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //implement create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){ //this anotation can work a json into java object
        return employeeRepository.save(employee);
    }

    //implement get employee by id REST API

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id: "+id));

        return ResponseEntity.ok(employee);
    }

    // implement update employee by Id Rest API
    @PutMapping("{id}")
    public ResponseEntity<Employee> uploadEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee =employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with Id: "+id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    // implement delete employee by ID Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with Id: "+id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
















