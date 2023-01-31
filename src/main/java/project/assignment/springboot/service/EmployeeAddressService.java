package project.assignment.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import project.assignment.springboot.exception.EmployeeAddressNotFoundException;
import project.assignment.springboot.model.EmployeeAddress;
import project.assignment.springboot.repository.EmployeeAddressRepository;

@Service
public class EmployeeAddressService {
	
	@Autowired
	private EmployeeAddressRepository employeeAddressRepository;

	public List<EmployeeAddress> findAllEmployeeAddress() {
		
		return employeeAddressRepository.findAll();
	}

	public EmployeeAddress saveEmployeeAddress(EmployeeAddress employeeAddress) {
		// TODO Auto-generated method stub
		return employeeAddressRepository.save(employeeAddress);
	}
	
	public EmployeeAddress findById(Integer id) {
		EmployeeAddress employeeAddress = employeeAddressRepository.findById(id)
				.orElseThrow(() -> new EmployeeAddressNotFoundException("Employee not exist with id :" + id));
		return employeeAddress;
	}
	
	public EmployeeAddress updateEmployeeAddress(Integer id, EmployeeAddress employeeAddressDetails) {
		
		EmployeeAddress employeeAddress = employeeAddressRepository.findById(id)
				.orElseThrow(() -> new EmployeeAddressNotFoundException("Employee not exist with id :" + id));
				
		employeeAddress.setHouseNo(employeeAddressDetails.getHouseNo());
		employeeAddress.setStreet(employeeAddressDetails.getStreet());
		employeeAddress.setArea(employeeAddressDetails.getArea());
		employeeAddress.setPincode(employeeAddressDetails.getPincode());
	    EmployeeAddress updatedEmployeeAddress = employeeAddressRepository.save(employeeAddress);
				return updatedEmployeeAddress;
	}
	
	public EmployeeAddress deleteEmployeeAddress(Integer id) {
		EmployeeAddress employeeAddress = employeeAddressRepository.findById(id)
			.orElseThrow(() -> new EmployeeAddressNotFoundException("Employee not exist with id :" + id));
		employeeAddressRepository.delete(employeeAddress);
		return employeeAddress;
	}

}
