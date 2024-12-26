package com.tech.controller;


import java.sql.Date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tech.dao.EmployeeDao;
import com.tech.entity.Employee;

public class EmployeeController {
	
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		int n ;
	
		do {
			System.out.println();
			System.out.println("Enter your Choice ");
			System.out.println("1. For Insert Data");
			System.out.println("2. For Update Data");
			System.out.println("3. For Delete Data");
			System.out.println("0. For Exit");
			
			
			 n = sc.nextInt();
			 
			 switch(n) {
			 case 1:
				 EmployeeDao.insertData();
				 break;
			 case 2:
				 EmployeeDao.updateData();
				 break;
			 case 3:
				 EmployeeDao.deleteData();
				 break;
			 case 4:
				 EmployeeDao.getById();
				 break;
			 case 0:
				 System.out.println("Happy Coding");
				 break;
			 default:
				 System.out.println("Enter Valid choice");
			 }

		}while(n!=0);
			
	}

}
