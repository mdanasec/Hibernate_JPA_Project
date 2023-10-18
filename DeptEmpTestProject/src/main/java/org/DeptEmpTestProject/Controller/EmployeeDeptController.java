package org.DeptEmpTestProject.Controller;

import java.util.List;
import java.util.Scanner;

import org.DeptEmpTestProject.Dao.DepartmentDao;
import org.DeptEmpTestProject.Dao.EmployeeDao;
import org.DeptEmpTestProject.Dto.Department;
import org.DeptEmpTestProject.Dto.Employee;

public class EmployeeDeptController {

	static Scanner s = new Scanner(System.in);
	static DepartmentDao deptDao = new DepartmentDao();
	static EmployeeDao empDao = new EmployeeDao();

	public static void saveDept() {
		
		Department d = new Department();
		System.out.println("dept name");
		d.setdName(s.next());
		System.out.println("dept loc");
		d.setLocation(s.next());
		d = deptDao.saveDepartment(d);
		System.out.println("Department saved with Id:" + d.getId());
	}
	
	public static void updateDept() {
		System.out.println("enter dept id to update");
		int id = s.nextInt();
		Department d = new Department();
		d.setId(id);
		System.out.println("Dept name :");
		d.setdName(s.next());
		System.out.println("Location :");
		d.setLocation(s.next());
		d=deptDao.updateDepartment(d);
		System.out.println("Department updated");	
	}
	
	public static void findDeptById() {
		System.out.println("Enter id");
		int id = s.nextInt();
		
		Department d= deptDao.findById(id);
		if(d!=null) {
			System.out.println("dept name :"+ d.getdName());
			System.out.println("Location : " + d.getLocation());
		}
		else
			System.err.println("inavlid id !!");
		 
	}
	
	public static void saveEmp() {
		System.out.println("Enter the department id to add Employee");
		int dept_id = s.nextInt();
		Employee e = new Employee();
		System.out.println("name");
		e.seteName(s.next());

		System.out.println("desgination");
		e.setDesg(s.next());

		System.out.println("salary");
		e.setSalary(s.nextDouble());

		System.out.println("phone");
		e.setPhone(s.nextLong());

		System.out.println("email");
		e.setEmail(s.next());

		System.out.println("password");
		e.setPassword(s.next());

		e = empDao.saveEmploye(e, dept_id);
		if (e != null)
			System.out.println("Employee saved with Id:" + e.getId());
		else
			System.err.println("Invalid Department Id");
	}

	public static void updateEmp() {
		System.out.println("enter the dept id to add employee");
		int dept_id = s.nextInt();
		Employee e = new Employee();

		System.out.println("id");
		e.setId(s.nextInt());

		System.out.println("name");
		e.seteName(s.next());

		System.out.println("desgination");
		e.setDesg(s.next());

		System.out.println("salary");
		e.setSalary(s.nextDouble());

		System.out.println("phone");
		e.setPhone(s.nextLong());

		System.out.println("email");
		e.setEmail(s.next());

		System.out.println("password");
		e.setPassword(s.next());
		e = empDao.updateEmploye(e, dept_id);

		if (e != null)
			System.out.println("Employe saved with id " + e.getId());
		else
			System.err.println("Invalid Department Id");
	}

	public static void findEmpByDeptId() {
		System.out.println("Enter dept id to find employee");
		int dept_id = s.nextInt();

		List<Employee> emps = empDao.findEmpsByDeptId(dept_id);

		if (emps.size() > 0) {
			for (Employee e : emps) {
				System.out.println("Employee Id:" + e.getId());
				System.out.println("Employee name:" + e.geteName());
				System.out.println("Designation:" + e.getDesg());
				System.out.println("Phone Number:" + e.getPhone());
				System.out.println("Email Id:" + e.getEmail());
				System.out.println("------------------------------");
			}
		} else
			System.err.println("invalid id !!");
	}

	public static void findEmpByDeptName() {
		System.out.println("Enter dept name");
		String dName = s.next();
		List<Employee> emps = empDao.findEmpByDeptName(dName);
		if (emps.size() > 0) {
			for (Employee e : emps) {
				System.out.println("Employee Id:" + e.getId());
				System.out.println("Employee name:" + e.geteName());
				System.out.println("Designation:" + e.getDesg());
				System.out.println("Phone Number:" + e.getPhone());
				System.out.println("Email Id:" + e.getEmail());
				System.out.println("------------------------------");
			}
		} else
			System.err.println("invalid name !!");
	}

	public static void verifyEmpById() {
		System.out.println("id :");
		int id = s.nextInt();
		System.out.println("password :");
		String password = s.next();

		Employee e = empDao.verifyEmployee(id, password);
		if (e != null) {
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee name:" + e.geteName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Phone Number:" + e.getPhone());
			System.out.println("Email Id:" + e.getEmail());
		} else
			System.err.println("Invalid Id or password");
	}

	public static void verifyEmpByPhone() {
		System.out.println("phone :");
		long phone = s.nextLong();
		System.out.println("password :");
		String password = s.next();

		Employee e = empDao.verifyEmployee(phone, password);
		if (e != null) {
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee name:" + e.geteName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Phone Number:" + e.getPhone());
			System.out.println("Email Id:" + e.getEmail());
		} else
			System.err.println("Invalid phone or password");
	}

	public static void verifyEmpByEmail() {
		System.out.println("email :");
		String email = s.next();
		System.out.println("password :");
		String password = s.next();

		Employee e = empDao.varifyEmployee(email, password);
		if (e != null) {
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee name:" + e.geteName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Phone Number:" + e.getPhone());
			System.out.println("Email Id:" + e.getEmail());
		} else
			System.err.println("Invalid email or password");
	}

	
	public static void main(String[] args) {

		System.out.println("1.save Depratment");
		System.out.println("2.update Depratment");
		System.out.println("3.save Employee");
		System.out.println("4.update Employee");
		System.out.println("5.Find Employees by Depratment id");
		System.out.println("6.Find Employees by Depratment name");
		System.out.println("7.Verify Employee By Id and password");
		System.out.println("8.Verify Employee By phone and password");
		System.out.println("9.Verify Employee By email and password");
		System.out.println("10.Find Department By Id");

		System.out.println("chose the case ");
		int choise = s.nextInt();

		switch (choise) {
		case 1: {
			saveDept();
			break;
		}
		case 2: {
			updateDept();
			break;
		}
		case 3: {
			saveEmp();
			break;
		}
		case 4: {
			updateEmp();
			break;
		}
		case 5: {
			findEmpByDeptId();
			break;
		}
		case 6: {
			findEmpByDeptName();
			break;
		}
		case 7: {
			verifyEmpById();
			break;
		}

		case 8: {
			verifyEmpByPhone();
			break;
		}

		case 9: {
			verifyEmpByEmail();
			break;
		}
		
		case 10: {
			findDeptById();
			break;
		}
		}

	}

}
