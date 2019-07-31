package com.mapping.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.mapping.jpa.entity.Department;
import com.mapping.jpa.entity.Employee;
import com.mapping.jpa.repository.DeptRepository;
import com.mapping.jpa.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDeptMany2OneTest {

	@Autowired
	private DeptRepository deptRepository;

	@Autowired
	private EmployeeRepository empRepository;

	@Test
	@Transactional
	@Rollback(value = false)
	public void test_emp_dept_save_success() {
		Department dept = new Department();
		dept.setName("Development");

		dept = deptRepository.save(dept);
		assertNotNull(dept);
		assertTrue(dept.getId() > 0);

		List<Employee> empList = new ArrayList<>();
		Employee e1 = new Employee();
		e1.setName("emp1");
		e1.setSalary(1_20_000.0F);
		e1.setDept(dept);
		empList.add(e1);

		Employee e2 = new Employee();
		e2.setName("emp2");
		e2.setSalary(2_20_000.0F);
		e2.setDept(dept);
		empList.add(e2);

		e1 = empRepository.save(e1);
		assertNotNull(e1);
		assertTrue(e1.getId() > 0);

		e2 = empRepository.save(e2);
		assertNotNull(e2);
		assertTrue(e2.getId() > 0);
	}

	@Test
	@Transactional
	public void test_show_records() {
		List<Department> depts = deptRepository.findAll();

		for (Department d : depts) {
			System.out.println(d.getId() + "," + d.getName());
			List<Employee> empList = d.getEmpList();
			System.out.println("Employee List : ");
			for (Employee e : empList) {
				System.out.println(e.getId() + "," + e.getName() + "," + e.getSalary());
			}
		}
		assertNotNull(depts);
	}
	
	@Test
	public void test_xremove() {
		deptRepository.deleteById(1);
		System.out.println("Dept 1 deleted");
		assertTrue(1==1);
	}
}
