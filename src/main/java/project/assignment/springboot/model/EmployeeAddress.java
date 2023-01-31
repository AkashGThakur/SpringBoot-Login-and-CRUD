package project.assignment.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class EmployeeAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;

	private int houseNo;

	private String street;

	private String area;

	private int pincode;
	
	public EmployeeAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeAddress(int houseNo, String street, String area, int pincode) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.area = area;
		this.pincode = pincode;
	}


	public int getEmpId() {
		return empid;
	}

	public void setEmpId(int empid) {
		this.empid = empid;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
