package com.jccc.cis264.WayFinder.StandAlon1;

import org.json.JSONException;
import org.json.JSONObject;

public class Instructor {
	private String FirstName, LastName, MiddleInitial, InstructorId, Primary, FormattedName;
	
	public Instructor(JSONObject data) throws JSONException{
		FirstName = data.getString("firstName");
		LastName = data.getString("lastName");
		MiddleInitial = data.getString("middleInitial");
		InstructorId = data.getString("instructorId");
		Primary = data.getString("primary");
		FormattedName = data.getString("formattedName");
	}
	
	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getMiddleInitial() {
		return MiddleInitial;
	}

	public String getInstructorId() {
		return InstructorId;
	}

	public String getPrimary() {
		return Primary;
	}

	public String getFormattedName() {
		return FormattedName;
	}

}
