package com.macmillan.moviedatabase.service;

import java.util.Calendar;

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
	private String formatTimeOfDay() {

		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		String minute = String.valueOf(calendar.get(Calendar.MINUTE));
		String period = "AM";
		// We have a single digit minute
		if (minute.length() == 1) {
			minute = "0" + minute;
		}

		//It's PM 
		if (hour > 12) {
			hour = hour - 12;
			period = "PM";
		} else if(hour == 0) {
			//12 am returns as zero
			hour = 12;
		}

		return hour + ":" + minute + " " + period;
	}
}
