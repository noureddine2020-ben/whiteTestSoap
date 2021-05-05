package com.ds.nour.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

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
		
		List<String> notFoundList = response.getErrorNotFound();
		
		Student student1= new Student(100,"noureddine","ariana");
		Student student2= new Student(200,"oussema","tunis");
		Student student3= new Student(300,"zied","marsa");
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
  
		
		Exam exam1=new Exam("1so-808","OCA");
		Exam exam2=new Exam("A-909","Azure Fundamental");
		
	    exams.add(exam1);
	    exams.add(exam2);
		
	  
	    if (!(students.contains(request.getStudentId()))) {
	    	
	    	notFoundList.add("wrong student id");
	    	
	    }
	    
	    if (!(exams.contains(request.getExamCode())))
	        
	    	notFoundList.add("request exam not found");
	    
	    if(notFoundList.size()==0) {
	    	
	    	response.getStudent().getName();
	    	response.getStudent().getAddress();
	    	response.getExam().getCode();
	    	response.getExam().getName();
	    	response.getDate().toXMLFormat();
	    }
	    else {
	    	response.getErrorNotFound();
	    }
	    
		
		return response;
	}

}
