package com.tech.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tech.entity.Employee;

public class EmployeeDao {

    static SessionFactory factory;
    static Scanner sc = new Scanner(System.in);
	static Session session = null;


    static SessionFactory getFactory() {
        if (factory == null) {
            Configuration cfg = new Configuration();
            cfg.configure();
            cfg.addAnnotatedClass(Employee.class);
            factory = cfg.buildSessionFactory();
        }
        return factory;
    }

    public static void insertData() {
        factory = getFactory();

        try {
            session = factory.openSession();
            session.beginTransaction();

            System.out.println("Enter Employee id:");
            int id = sc.nextInt();

            System.out.println("Enter Employee Name:");
            String name = sc.nextLine();

            System.out.println("Enter Employee Department:");
            String dept = sc.nextLine();

            String login = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            Employee emp = new Employee(id, name, dept, login);

            session.save(emp);
            session.getTransaction().commit();
            System.out.println("Data Added Successfully");

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.err.println("Error occurred: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public static void updateData() {
    	   factory = getFactory();
           
    	  session = factory.openSession();
          session.beginTransaction(); // Begin transaction

          System.out.println("Enter Employee Id");
          int id = sc.nextInt();
          sc.nextLine(); // Clear buffer

          // Load the employee object
          Employee employee = session.load(Employee.class, id);

          // Update name
          System.out.println("Enter newName");
          String newName = sc.nextLine();
          employee.setEmpName(newName);

          // Update department
          System.out.println("Enter newDepartment");
          String newDept = sc.nextLine();
          employee.setEmpDepartment(newDept);

          // Update the object in the database 
          session.update(employee);

          // Commit the transaction
          session.getTransaction().commit();
          System.out.println("Data Updated Successfully");
    	
    	
    	
    	
    }

    
    
    public static void closeFactory() {
        if (factory != null) {
            factory.close();
        }
    }

	public static void deleteData() {
		factory = getFactory();
		session = factory.openSession();
		System.out.println("Enter Employee id you want to delete ");
		int id = sc.nextInt();
		
		Employee employee = session.load(Employee.class, id);
		
		session.delete(employee);
		session.beginTransaction().commit();
		System.out.println("deta deleted ");
		
		
	}

	public static void getById() {
		
		factory = getFactory();
		session = factory.openSession();
		
		
		System.out.println("Enter id");
		int id = sc.nextInt();
		
		List<Employee> empList = new ArrayList<>();
		Employee employee = session.load(Employee.class, id);
		
		empList.add(employee);
		
		session.beginTransaction().commit();
		System.out.println(employee);
//		
//		for(Employee emp : empList) {
//			System.out.println(emp.getEmpId());
//			System.out.println(emp.getEmpName());
//			System.out.println(emp.getEmpDepartment());
//			System.out.println(emp.getShiftLogin());
//		}
		
		
	}
}
