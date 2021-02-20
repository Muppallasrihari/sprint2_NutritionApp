package com.cg.healthify.service;

import org.springframework.stereotype.Service;

import com.cg.healthify.beans.CaloriesLog;

@Service
public interface CaloriesLogService {

	CaloriesLog addCaloriesLog(CaloriesLog calorieslog);

	CaloriesLog findCaloriesLogByIdentifier(String caloriesLogIdentifier);

	CaloriesLog deleteCaloriesLogByIdentifier(String caloriesLogIdentifier);

	Iterable<CaloriesLog> showAllCaloriesLog();

}
