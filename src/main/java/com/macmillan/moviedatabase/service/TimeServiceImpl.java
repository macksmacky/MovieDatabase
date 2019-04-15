package com.macmillan.moviedatabase.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {

	@SuppressWarnings("unchecked")
	@Override
	public String getTimeOfDay() {

		JSONObject timeObject = new JSONObject();
		timeObject.put("timeOfDay", formatTimeOfDay());

		return timeObject.toString();

	}

	/**
	 * @return Formatted Time String in 12 hour format
	 */
	public String formatTimeOfDay() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		return dateFormat.format(date);
	}
}
