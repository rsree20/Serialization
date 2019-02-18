package com.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	    // serialize() ;
		deSerialize() ;
	}
	
	static void deSerialize() throws IOException, ClassNotFoundException {
		FileInputStream fs = new FileInputStream("F:\\Serialize\\testObject.txt");
		ObjectInputStream ofs = new ObjectInputStream(fs);
		Employee emp1 = (Employee) ofs.readObject();
		
		System.out.println(emp1.getEmpId()+" "+emp1.getEmpName()+" "+emp1.getEmpSal()+" "+emp1.getEmpCompany());
		Passport pp = emp1.getPassport();
		System.out.println(pp.getPid()+" "+pp.getpLocation()+" "+pp.getpNumber());
		
		System.out.println("Successfully de-serialized to the File ");

	}

	
	static void serialize() throws IOException {
		Employee emp1 = new Employee(1001, "Naresh", "40K", "CTS");
		Passport pp1 = new Passport(50, "ZZZ112", "Hyderabad");
		emp1.setPassport(pp1);
		
		FileOutputStream fs = new FileOutputStream("F:\\Serialize\\testObject.txt");
		ObjectOutputStream ofs = new ObjectOutputStream(fs);
		ofs.writeObject(emp1);
		System.out.println("Successfully serialized to the File ");

	}
}



class Employee implements Serializable{
	
	
	
	public Employee(Integer empId, String empName, String empSal, String empCompany) {
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empCompany = empCompany;
	}
	private Integer empId;
	private String empName;
	private String empSal;
	private final String empCompany;
	private String empLocation;
	
	
	public String getEmpLocation() {
		return empLocation;
	}
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	private Passport passport;
	
	
	
	
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSal() {
		return empSal;
	}
	public void setEmpSal(String empSal) {
		this.empSal = empSal;
	}
	public String getEmpCompany() {
		return empCompany;
	}
	
	
}

class Passport  implements Serializable{
	
	
	public Passport(Integer pid, String pNumber, String pLocation) {
		super();
		this.pid = pid;
		this.pNumber = pNumber;
		this.pLocation = pLocation;
	}
	private Integer pid;
	private String pNumber;
	private String pLocation;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getpNumber() {
		return pNumber;
	}
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}
	public String getpLocation() {
		return pLocation;
	}
	public void setpLocation(String pLocation) {
		this.pLocation = pLocation;
	}
	
	
}