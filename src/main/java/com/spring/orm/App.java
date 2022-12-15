package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
//        Student student= new Student(123, "Ritesh","renukoot");
//        int r=studentDao.insert(student);
//        System.out.println("done   "+r);
        boolean go=true;
        while(go) {
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("PRESS 1 for add new Student");
        System.out.println("PRESS 2 for display all Students");
        System.out.println("PRESS 3 for get detail of single student");
        System.out.println("PRESS 4 for delete student");
        System.out.println("PRESS 5 for update student");
        System.out.println("PRESS 6 for exit");
        
        try {
               int input=Integer.parseInt(br.readLine());
               
               
               
               	switch(input){
               		
               	case 1:
               		// add a new student
               		System.out.println("Enter user id : ");
               		int uId=Integer.parseInt(br.readLine());
               		
               		System.out.println("Enter user name : ");
               	    String uName=br.readLine();
               	    
               	    System.out.println("Enter user city : ");
               	    String uCity=br.readLine();
               	    
               	    // creating student object and setting values
               	    Student student = new Student(uId,uName,uCity);
               	    
               	    // saving student object to database by calling insert of studentDao
               	    int r= studentDao.insert(student);
               	    System.out.println(r + " student added ");
               	    System.out.println("****************************************");
               	    System.out.println();
               	    
               	    
               		
               		
               		
               		
               		
               		
               		break;
               	
               	case 2:
               		// display all student
               		System.out.println("*********************************************");
               		List<Student> allStudents = studentDao.getAllStudents();
               		for(Student s:allStudents) {
               			
               			System.out.println("Name : "+s.getStudentName());
               			System.out.println("Id : "+s.getStudentId());
               			System.out.println("City is : "+s.getStudentCity());
               			System.out.println("****************************************");
               			System.out.println();
               		}
               		break;
               		
               	case 3:
               		// get single student data
               		System.out.println("************************************************");
               		System.out.println("Enter user id : ");
               		int userId = Integer.parseInt(br.readLine());
               		Student student1= studentDao.getStudent(userId);
               		System.out.println("Name : "+student1.getStudentName());
           			System.out.println("Id : "+student1.getStudentId());
           			System.out.println("City is : "+student1.getStudentCity());
           			System.out.println("***************************************************");
           			System.out.println();
               		
               		break;
               	case 4:
               		//delete student
               		System.out.println("************************************************");
               		System.out.println("Enter user id : ");
               		int Id = Integer.parseInt(br.readLine());
               		studentDao.deleteStudent(Id);
               		System.out.println("Student deleted...........");
               		System.out.println("************************************************");
               		System.out.println();
               		
               		
               		break;
               		
               	case 5:
               		// update the student
               		System.out.println("************************************************");
               		System.out.println("Enter user id : ");
               		int Id1 = Integer.parseInt(br.readLine());
               		System.out.println("Enter the new Name : ");
               	    String uName1=br.readLine();
               		System.out.println("Enter the new City : ");
               	    String uCity1=br.readLine();
               		Student student12= new Student(Id1,uName1,uCity1);
               		studentDao.updateStudent(student12);
               		System.out.println("Student updated...........");
               		System.out.println("************************************************");
               		System.out.println();
               		break;
               		
               	case 6:
               		// exit
               		go=false;
               		break;
               	}
               		
               		
             
        	
        }
        catch(Exception e) {
        	System.out.println("Invalid Input Try with another one !!");
        	System.out.println(e.getMessage());
        }
        
    }
        System.out.println("Thankyou for using my application");
        System.out.println("See you soon !!");
        }
}
