package com.ds.nour.service;


import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.springframework.stereotype.Service;

import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ObjectFactory;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@Service
public class WhiteTestService {
	

	public WhiteTestResponse foundWhitetTest(StudentRequest request) {
		
	    WhiteTestResponse response = new ObjectFactory().createWhiteTestResponse();

		List<Student> students = new ArrayList<>();
		List<Exam> exams = new ArrayList<>();
		
		List<String> notFoundList = new ArrayList<>();//response.getErrorNotFound();
		
		Student student1= new Student();// new Student(100,"noureddine","ariana");
		student1.setId(100);
		student1.setName("noureddine");
		student1.setAddress("ariana");
		Student student2= new Student();//new Student(200,"oussema","tunis");
		student2.setId(200);
		student2.setName("oussema");
		student2.setAddress("tunis");
		Student student3= new Student(); //new Student(300,"zied","marsa");
		student3.setId(300);
		student3.setName("zied");
		student3.setAddress("marsa");
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
  
		
		Exam exam1= new Exam();//new Exam("1so-808","OCA");
		exam1.setCode("1zo-808");
		exam1.setName("OCA");
		Exam exam2=new Exam();//new Exam("A-909","Azure Fundamental");
		exam2.setCode("A-909");
		exam2.setName("Azure Fundamental");
	    exams.add(exam1);
	    exams.add(exam2);
		
	  
	    if (!(checkStudent(students, request.getStudentId()))) {
	    	
	    	notFoundList.add("wrong student id");
	    	
	    }
	    
	    if (!(checkExam(exams, request.getExamCode())))
	        
	    	notFoundList.add("request exam not found");
	    
	    if(notFoundList.size()==0) {
	    	// I will return here the first student & the first exam
	    	// find the logic to return the right one
	    	response.setStudent(student1);
	    	response.setExam(exam1);
	    	//find how to create a date
	    	//response.setDate();
	    }
	    else {
	    	// try to add this in the xsd
	    	//response.getErrorNotFound();
	    }
	    
		
		return response;
	}
	
	private boolean checkStudent(List<Student> students,int id) {
		return students.stream().anyMatch(std->std.getId()==id);
	}
	
	private boolean checkExam(List<Exam> exams,String code) {
		return exams.stream().anyMatch(exm->exm.getCode().equalsIgnoreCase(code));
	}

}
