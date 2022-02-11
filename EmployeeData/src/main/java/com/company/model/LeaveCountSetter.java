package com.company.model;

import java.util.Random;
import org.apache.log4j.*;

import com.company.entity.Employee;

public class LeaveCountSetter {

	public void setLeaveCount(Employee employee) {
		final Logger logger = Logger.getLogger(LeaveCountSetter.class.getName());
		logger.info("****Entering the Leave Count Setter****");
		
	//{----Month leave count is set to random between 1-5 as this is a demo application with restricted functionality----} 
		 Random leaveCountGenerator = new Random();
		 int leaveCount = leaveCountGenerator.nextInt(7) + 1;
		 employee.setMonthLeavesCount(leaveCount);
		 logger.info("****Exiting the Leave Count Setter****");
	}
}
