package com.company.model;

import java.util.Random;

import com.company.entity.Employee;

public class LeaveCountSetter {

	public void setLeaveCount(Employee employee) {
	//{----Month leave count is set to random between 1-5 as this is a demo application with restricted functionality----} 
		 Random leaveCountGenerator = new Random();
		 int leaveCount = leaveCountGenerator.nextInt(7) + 1;
		 employee.setMonthLeavesCount(leaveCount);
	}
}
