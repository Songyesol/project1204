package stream;

public class Employee implements Comparable<Employee> {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private int salary;
	private int departmentId;
	
	
	
	public Employee() {
	}
	
	public Employee(int employeeId, String firstName, String lastName, String email, int salary,
			int departmentId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
		this.departmentId = departmentId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public void showEmpInfo() {
		System.out.println("사원번호: " + employeeId +", firstName: " + firstName+
				", lastName: "+ lastName + ",이메일: "+email+", 월급: "+ salary);
	}
	
	public void showEmpInfo1() {
		System.out.println("사원번호: " + employeeId + 
				", lastName: "+ lastName + ",이메일: "+email+", 월급: "+ salary + ", 부서번호" + departmentId);
	}

	@Override
	public int compareTo(Employee o) {
		if(this.getFirstName() !=null)
			return this.firstName.compareTo(o.firstName);
		else 
			return 0;
	}
	


}
