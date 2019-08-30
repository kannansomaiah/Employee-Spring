package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	Logger LOGGER = Logger.getLogger(EmployeeController.class.toString());
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/employee")
	public List<Employee> addEmployees(@RequestBody Employee employee) {
		LOGGER.info("coming inside controller1 " + employee.getFirstName());
		LOGGER.info("coming inside controller2 " + employee.getLastName());
		LOGGER.info("coming inside controller3 " + employee.getEmail());
		employeeRepository.save(employee);
		
		List<Employee> lstEmployee = employeeRepository.findAll();
		LOGGER.info("number of employees: " + lstEmployee.size());
		return lstEmployee;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/employee")
	public List<Employee> getEmployees() {
		LOGGER.info("coming inside controller for get ");
		List<Employee> lstEmployee = employeeRepository.findAll();
		LOGGER.info("number of employees: " + lstEmployee.size());
		return lstEmployee;
	}

//	@CrossOrigin(origins = "http://localhost:3000")
//	@DeleteMapping("/employee")
//	public List<Employee> deleteEmployee(@RequestParam("email") String email, @RequestParam("first") String first, @RequestParam("last") String last) {
//		LOGGER.info("inside delete method: " + email);
//		LOGGER.info("inside delete method: " + first);
//		LOGGER.info("inside delete method: " + last);
//		Employee employee = new Employee();
//		employee.setEmail(email);
//		employee.setFirstName(first);
//		employee.setLastName(last);
//		
//		employeeRepository.delete(employee);
//		List<Employee> lstEmployee = employeeRepository.findAll();
//		LOGGER.info("number of employees: " + lstEmployee.size());
//		return lstEmployee;
//	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/employee")
	public List<Employee> deleteEmployee(@RequestBody Employee employee) {
		LOGGER.info("inside delete method: " + employee);
		
		employeeRepository.delete(employee);
		List<Employee> lstEmployee = employeeRepository.findAll();
		LOGGER.info("number of employees: " + lstEmployee.size());
		return lstEmployee;
	}
	
}
