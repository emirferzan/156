// employee 
package com.cinco.payroll;

public abstract class Employee implements Payable {

	private final String id;
	private final String firstName;
	private final String lastName;
	private final String title;
	
	public Employee(String id, String firstName, String lastName, String title) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
	}
	
	

	public String toString() {
		return String.format("%s, %s",firstName, lastName);
	}



	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTitle() {
		return title;
	}
	
	
	public double getNetPay() {
		return this.getGrossPay() - this.getTaxes();
	}
	
	public abstract double getGrossPay();
	
	public abstract double getTaxes();
	
	public abstract String getType();
	
}

// hourly employee

package com.cinco.payroll;

public abstract class HourlyEmployee extends Employee {

	private final double hourlyPayRate;
	private final double hoursWorked;
	
	public HourlyEmployee(String id, String firstName, String lastName, String title, double hourlyPayRate,
			double hoursWorked) {
		super(id, firstName, lastName, title);
		this.hourlyPayRate = hourlyPayRate;
		this.hoursWorked = hoursWorked;
	}

	public double getHourlyPayRate() {
		return hourlyPayRate;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}
	
	public double getGrossPay() {
		return (hourlyPayRate * hoursWorked);
	}
	
  // payable 
  
  package com.cinco.payroll;

public interface Payable {

	public double getNetPay();
	
}

}


// salasry employee

package com.cinco.payroll;

public class SalaryEmployee extends Employee {
	
	private final double annualSalary;

	public SalaryEmployee(String id, String firstName, String lastName, String title, double annualSalary) {
		super(id, firstName, lastName, title);
		this.annualSalary = annualSalary;
	}

	@Override
	public double getNetPay() {
		return (getGrossPay() - getTaxes() + 100);
	}

	@Override
	public double getGrossPay() {
		return this.annualSalary / 52.0;
	}

	@Override
	public double getTaxes() {
		 return getGrossPay() * 0.20;
	}

	@Override
	public String getType() {
		return "Salary";
	}
	
	

}

//staff

package com.cinco.payroll;

public class Staff extends HourlyEmployee {

	private static final double TAX_RATE = 0.15;
	
	public Staff(String id, String firstName, String lastName, String title, double hourlyPayRate, double hoursWorked) {
		super(id, firstName, lastName, title, hourlyPayRate, hoursWorked);
	
	}
	
	public double getTaxes() {
		return this.getGrossPay() * TAX_RATE;
	}
	
	public String getType() {
		return "Staff";
	}
		
	
}

// temporary

package com.cinco.payroll;

public class Temporary extends HourlyEmployee {
	
	public Temporary(String id, String firstName, String lastName, String title, double hourlyPayRate,
			double hoursWorked) {
		super(id, firstName, lastName, title, hourlyPayRate, hoursWorked);
	}

	@Override
	public double getTaxes() {
		return 0;
	}

	@Override
	public String getType() {
		return "Temporary";
	}

}

//supplier
package com.cinco.payroll;

public class Supplier implements Payable {

	private final String companyName;
	private final double amountDue;
	
	
	public Supplier(String companyName, double amountDue) {
		this.companyName = companyName;
		this.amountDue = amountDue;
	}
	
	
	public double getNetPay() {
		return this.amountDue;
	}
	
	
}



