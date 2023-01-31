package project.assignment.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import project.assignment.springboot.exception.EmployeeNotFoundException;
import project.assignment.springboot.model.Employee;
import project.assignment.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findAllEmployee() {
		
		return employeeRepository.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
	
	public Employee findById(Integer id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id :" + id));
		return employee;
	}
	
	public Employee updateEmployee(Integer id, Employee employeeDetails) {
		
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id :" + id));
				
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setGender(employeeDetails.getGender());
		employee.setAge(employeeDetails.getAge());
		employee.setBirthdate(employeeDetails.getBirthdate());
		
	    Employee updatedEmployee = employeeRepository.save(employee);
				return updatedEmployee;
	}
	
	public Employee deleteEmployee(Integer id) {
		Employee employee = employeeRepository.findById(id)
			.orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id :" + id));
		employeeRepository.delete(employee);
		return employee;
	}
}
