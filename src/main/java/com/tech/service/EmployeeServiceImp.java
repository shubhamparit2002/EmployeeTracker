package com.tech.service;

import com.tech.dao.EmployeeDao;

public class EmployeeServiceImp implements EmployeeServiceInterface{

	@Override
	public void insertData() {
		
		EmployeeDao.insertData();
	}

	@Override
	public void deleteData() {
		EmployeeDao.deleteData();
		
	}

	@Override
	public void updateData() {
		EmployeeDao.updateData();
		
	}

	@Override
	public void getById() {
		EmployeeDao.getById();

		
	}

}
