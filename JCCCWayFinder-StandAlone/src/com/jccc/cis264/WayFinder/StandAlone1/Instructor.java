package com.jccc.cis264.WayFinder.StandAlone1;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * contains information about the Instructor of the course calling the constructor.
 */
public class Instructor {
	private String FirstName, LastName, MiddleInitial, InstructorId, Primary, FormattedName;
	
	/**
	 * creates a fully initialized instance of Instructor when called
	 * @param data the incoming JSON data
	 * @throws JSONException Thrown if the JSON data is empty, or unreadable
	 */
	public Instructor(JSONObject data) throws JSONException{
		FirstName = data.getString("firstName");
		LastName = data.getString("lastName");
		MiddleInitial = data.getString("middleInitial");
		InstructorId = data.getString("instructorId");
		Primary = data.getString("primary");
		FormattedName = data.getString("formattedName");
	}
	
	/**
	 * gets the First Name of the current instructor
	 * @return the FIRST NAME of the instructor
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * gets the Last Name of the current instructor
	 * @return the LAST NAME of the instructor
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * gets the Middle Initial, or in most cases the middle name, of the current instructor
	 * @return the MIDDLE INITIAL of the instructor
	 */
	public String getMiddleInitial() {
		return MiddleInitial;
	}

	/**
	 * gets the Instructor ID of the current instructor
	 * @return the Instructor id of the instructor
	 */
	public String getInstructorId() {
		return InstructorId;
	}

	/**
	 * returns whether the current instructor is the primary instructor.
	 * @return whether the the instructor is primary
	 */
	public String getPrimary() {
		return Primary;
	}

	/**
	 * gets the formatted string containing the instructors full name 
	 * @return  the formatted name of type strong
	 */
	public String getFormattedName() {
		return FormattedName;
	}

}
