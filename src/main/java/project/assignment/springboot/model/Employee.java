package project.assignment.springboot.model;

import java.sql.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	
	private String firstName;
	
	private String lastName;

	private String gender;

	private int age;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;

	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "userid" , referencedColumnName = "userid" )
	private UserList userList;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public UserList getUserList() {
		return userList;
	}
	public void setUserList(UserList userList) {
		this.userList = userList;
	}
	

	public Employee(int empid, String firstName, String lastName, String gender, int age, Date birthdate, UserList userList) {
		super();
		this.empid = empid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.birthdate = birthdate;
		this.userList = userList;
	}

	
	
}
