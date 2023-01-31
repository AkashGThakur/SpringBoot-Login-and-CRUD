package project.assignment.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.assignment.springboot.exception.EmployeeNotFoundException;
import project.assignment.springboot.model.EmployeeAddress;
import project.assignment.springboot.model.Employee;
import project.assignment.springboot.repository.EmployeeRepository;
import project.assignment.springboot.service.EmployeeAddressService;
import project.assignment.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	 	@Autowired
	 	private EmployeeService employeeService;
	 	
	 	@Autowired
		private EmployeeAddressService employeeAddressService;
	 	
	
	//get all Employee
	@GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		return employeeService.findAllEmployee();
	}	
	
	// create Employee rest api
	@PostMapping("/employee")
		public Employee createEmployee(@RequestBody Employee employee) {
			return employeeService.saveEmployee(employee);	
			
		}
		
		// get Employee by id rest api
		@GetMapping("/employee/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
			Employee employee = employeeService.findById(id);
			return ResponseEntity.ok(employee);
		}
		
		// update Employee rest api
		@PutMapping("/employee/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeDetails){
			Employee employee = employeeService.updateEmployee(id,employeeDetails);
			return ResponseEntity.ok(employee);
		}
		
		// delete Employee rest api
		@DeleteMapping("/employee/{id}")
		public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
			Employee employee = employeeService.deleteEmployee(id.intValue());
			
			EmployeeAddress employeeAddress = employeeAddressService.deleteEmployeeAddress(id.intValue());
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

}
