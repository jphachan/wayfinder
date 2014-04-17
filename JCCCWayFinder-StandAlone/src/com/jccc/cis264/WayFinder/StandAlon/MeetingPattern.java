package com.jccc.cis264.WayFinder.StandAlon;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class MeetingPattern {

	private String InstructionalMethodCode, StartDate, EndDate, StartTime, EndTime, Room, Building, BuildingId, CampusId;
	private ArrayList<Integer> DaysOfWeek = new ArrayList();

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
	}//asdfasdf

	public String getInstructionalMethodCode() {
		return InstructionalMethodCode;
	}

	public String getStartDate() {
		return StartDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public String getStartTime() {
		return StartTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public String getRoom() {
		return Room;
	}

	public String getBuilding() {
		return Building;
	}

	public String getBuildingId() {
		return BuildingId;
	}

	public String getCampusId() {
		return CampusId;
	}

	public ArrayList<Integer> getDaysOfWeek() {
		return DaysOfWeek;
	}

}
