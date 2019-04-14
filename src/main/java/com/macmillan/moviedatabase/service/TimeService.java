package com.macmillan.moviedatabase.service;

import org.codehaus.jettison.json.JSONException;

public interface TimeService {

	String getTimeOfDay() throws JSONException;

}