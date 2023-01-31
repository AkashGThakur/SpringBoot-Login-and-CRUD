package project.assignment.springboot.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private String firstName;

	private String middleName;

	private String lastName;

	private long mobileNo;
	
	@NotEmpty
	@Email
	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	@NotEmpty 
	@Size(min = 8, message = "password should have atleast 8 characters")
	private String password;

	private String gender;

	private String maritalStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userList")
	private Set<Employee> employee = new HashSet<>();
	
	public UserList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	public UserList(int userId, String firstName, String middleName, String lastName, long mobileNo,
			@NotEmpty @Email String email, Date birthDate,
			@NotEmpty @Size(min = 8, message = "password should have atleast 8 characters") String password,
			String gender, String maritalStatus, Set<Employee> employee) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.birthDate = birthDate;
		this.password = password;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.employee = employee;
	}

	
	
}
