package com.mapping.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mapping.jpa.entity.Result;
import com.mapping.jpa.entity.Student;
import com.mapping.jpa.repository.ResultRepository;
import com.mapping.jpa.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentResult1to1MappintTest {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ResultRepository resultRepository;

	@Test
	public void test_InsertRecords_success() {
		Student student = new Student();
		student.setRoll(1);
		student.setName("Student1");
		student.setMobile("9812345678");

		Result result = new Result();
		result.setId(101);
		result.setSub1(98);
		result.setSub2(89);
		result.setSub3(94);

		result.findResult();
		result.setStd(student);

		student.setResult(result);

		student = studentRepository.save(student);
		assertNotNull(student);

		result = resultRepository.save(result);
		assertNotNull(result);
	}

	@Test
	public void test_showRecord_success() {
		Optional<Student> stdOptional = studentRepository.findById(1);
		assertTrue(stdOptional.isPresent());
		Student student = stdOptional.get();
		System.out.println("Basic Details : " + student.getRoll() + "," + student.getName());
		System.out.println("Check for lazy loading");
		System.out.println("Now fetching result per : " + student.getResult().getPer());
		// System.out.println("Student : " + student.getData());
		assertNotNull(student);
		System.out.println("Loding result data : ");
		Optional<Result> resOptional = resultRepository.findById(101);
		assertTrue(resOptional.isPresent());
		Result result = resOptional.get();
		System.out.println("Result : " + result.getData());
		assertNotNull(result);
	}
}
