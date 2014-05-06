package com.jccc.cis264.WayFinder.StandAlone1;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Contains information about the meeting patterns of a particular course&#046; </br><i>Created By: Section</i>
 */
@SuppressWarnings("all")
public class MeetingPattern {

	private String InstructionalMethodCode, StartDate, EndDate, StartTime, EndTime, Room, Building, BuildingId, CampusId;
	private ArrayList<Integer> DaysOfWeek = new ArrayList();

	/**
	 * Creates a fully initialized instance of a MeetingPattern.
	 * @param data the input JSON data provided by Section
	 * @throws JSONException if the input JSON data is blank or otherwise unreadable
	 */
	public MeetingPattern(JSONObject data) throws JSONException{
		InstructionalMethodCode = data.getString("instructionalMethodCode");
		StartDate = data.getString("startDate");
		EndDate = data.getString("endDate");
		StartTime = data.getString("startTime");
		EndTime = data.getString("endTime");
		Room = data.getString("room");
		Building = data.getString("building");
		BuildingId = data.getString("buildingId");
		CampusId = data.getString("campusId");
		 

		if(data.getJSONArray("daysOfWeek").length() > 0){
			for(int i = 0; i < data.getJSONArray("daysOfWeek").length(); i++){
				DaysOfWeek.add(data.getJSONArray("daysOfWeek").getInt(i));
			}
		}
	}

	/**
	 * Gets the instructional method code of the course represented by the Section creating this object.
	 * @return the Instructional Method Code (e.g. F2F)
	 */
	public String getInstructionalMethodCode() {
		return InstructionalMethodCode;
	}

	/**
	 * Gets the start date of the course represented by the Section creating this object.
	 * @return course start date
	 * @
	 */
	public String getStartDate() {
		return StartDate;
	}

	/**
	 * Gets the end date of the course represented by the Section creating this object.
	 * @return course end date
	 */
	public String getEndDate() {
		return EndDate;
	}

	/**
	 * Gets the start time of the course represented by the Section creating this object.
	 * @return the time of day the course starts
	 */
	public String getStartTime() {
		return StartTime;
	}

	/**
	 * Gets the end time of the course represented by the Section creating this object.
	 * @return the time of day the course ends
	 */
	public String getEndTime() {
		return EndTime;
	}

	/**
	 * The room of a particular building the course represented by the Section creating this object is held in.
	 * @return the room number
	 */
	public String getRoom() {
		return Room;
	}

	/**
	 * The building name the course represented by the Section creating this object is held in.
	 * @return the building name
	 */
	public String getBuilding() {
		return Building;
	}

	/**
	 * The building ID the course represented by the Section creating this object is held in.
	 * @return the building ID
	 */
	public String getBuildingId() {
		return BuildingId;
	}

	/**
	 * The ID of the campus the course represented by the Section creating this object is held on.
	 * @return the campus ID of the constructing section
	 */
	public String getCampusId() {
		return CampusId;
	}

	/**
	 * Returns an ArrayList of day codes representing the days of the week the course is offered on.
	 * @return an ArrayList of type Integer containing the day codes.
	 */
	public ArrayList<Integer> getDaysOfWeek() {
		return DaysOfWeek;
	}

}
