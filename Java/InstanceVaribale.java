import java.util.*;
class InstanceVaribale{
	
	public String name;
	private double salary;
	
	public InstanceVaribale(String empName){
		name=empName;
	}
	public void setSalary(double empSal){
		salary=empSal; 
	}
	public void printEmp(){
		System.out.println("name :" + name);
		System.out.println("salary :" + salary);
	}

	public static void main(String args[]){
 		InstanceVaribale instanceVaribale = new InstanceVaribale("imran");
		instanceVaribale.setSalary(1000);
		instanceVaribale.printEmp();
	}	
}