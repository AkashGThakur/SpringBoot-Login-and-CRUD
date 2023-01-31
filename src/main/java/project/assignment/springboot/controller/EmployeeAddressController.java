package project.assignment.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import project.assignment.springboot.exception.EmployeeAddressNotFoundException;
import project.assignment.springboot.model.EmployeeAddress;
import project.assignment.springboot.repository.EmployeeAddressRepository;
import project.assignment.springboot.service.EmployeeAddressService;

@RestController
@RequestMapping("/api")
public class EmployeeAddressController {
	
	@Autowired
	private EmployeeAddressService employeeAddressService;
	
	//get all Employee
	@GetMapping("/employeeAddress")
	public List<EmployeeAddress> getAllEmployeeAddress(){
		return employeeAddressService.findAllEmployeeAddress();
	}	
	
	// create employee rest api
	@PostMapping("/employeeAddress")
		public EmployeeAddress createEmployeeAddress(@RequestBody EmployeeAddress employeeAddress) {
			return employeeAddressService.saveEmployeeAddress(employeeAddress);
		}
		
		// get employee by id rest api
		@GetMapping("/employeeAddress/{id}")
		public ResponseEntity<EmployeeAddress> getEmployeeAddressById(@PathVariable Integer id) {
			EmployeeAddress employeeAddress = employeeAddressService.findById(id);
			return ResponseEntity.ok(employeeAddress);
		}
		
		// update employee rest api
		
		@PutMapping("/employeeAddress/{id}")
		public ResponseEntity<EmployeeAddress> updateEmployeeAddress(@PathVariable Integer id,
				@RequestBody EmployeeAddress employeeAddressDetails){
			EmployeeAddress employeeAddress = employeeAddressService.updateEmployeeAddress(id, employeeAddressDetails);
			return ResponseEntity.ok(employeeAddress);
		}
		
		// delete employee rest api
		@DeleteMapping("/employeeAddress/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployeeAddress(@PathVariable Long id){
			EmployeeAddress employeeAddress = employeeAddressService.deleteEmployeeAddress(id.intValue());
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}	

}
