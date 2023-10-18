package org.DeptEmpTestProject.Dao;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.DeptEmpTestProject.Dto.Department;
import org.DeptEmpTestProject.Dto.Employee;

public class EmployeeDao {

	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public Employee saveEmploye(Employee employee, int dept_id) {

		Department d = manager.find(Department.class, dept_id);
		if (d != null) {
			employee.setDept(d);// Assigning Department for Employee
			d.getEmps().add(employee);
			EntityTransaction transaction = manager.getTransaction();
			manager.persist(employee);
			transaction.begin();
			transaction.commit();
			return employee;
		}
		return null;
	}

//	Update employee
	
	public Employee updateEmploye(Employee employee, int dept_id) {

		Department d = manager.find(Department.class, dept_id);

		if (d != null) {
			employee.setDept(d);// Assigning Department for Employee
			d.getEmps().add(employee);
			EntityTransaction transaction = manager.getTransaction();
			manager.merge(employee);
			transaction.begin();
			transaction.commit();
			return employee;
		}
		return null;
	}
	
	public List<Employee> findEmpsByDeptId(int id) {
		String qry = "select d.emps from Department d where d.id=?1";
		Query query = manager.createQuery(qry);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	
	public List<Employee> findEmpByDeptName(String dName){
		String qry = "select d.emps from Department d where d.dName=?1";
		Query query = manager.createQuery(qry);
		query.setParameter(1, dName);
		return query.getResultList();	
	}
	
//	here used method over loading 
	public Employee verifyEmployee(int id , String password) {
		String qry = "select e from Employee e where e.id=?1 and e.password=?2";
		Query query = manager.createQuery(qry);
		query.setParameter(1, id);
		query.setParameter(2, password);
		try {
			return (Employee) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}	
	}
	
	public Employee verifyEmployee(long phone , String password) {
		String qry = "select e from Employee e where e.phone=?1 and e.password=?2";
		Query query = manager.createQuery(qry);
		query.setParameter(1, phone);
		query.setParameter(2, password);
		try {
			return (Employee) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}	
	}
	
	public Employee varifyEmployee(String email , String password) {
		String qry = "select e from Employee e where e.email=?1 and e.password=?2";
		Query query = manager.createQuery(qry);
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			return (Employee) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}	
	}
	

}
