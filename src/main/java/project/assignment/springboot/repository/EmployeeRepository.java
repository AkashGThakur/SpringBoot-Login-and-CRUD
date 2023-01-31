package project.assignment.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.assignment.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	

}
