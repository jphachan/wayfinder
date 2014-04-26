package com.jccc.cis264.WayFinder.StandAlone1;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Represents a Student's individual courses&#046; Each instance of Section will be uniquely initialized based on that semister's catalog&#046;</br><i>Created by: Term</i>
 * 
 */
@SuppressWarnings("all")
public class Section{

	private String SectionId, SectionTitle, CourseName, CourseDescription, CourseSectionNumber, FirstMeetingDate, LastMeetingDate, Ceus, LearningProvider, LearningProviderSiteId, PrimarySectionId;
	private int Credits, SectionNumber;
	@SuppressWarnings("unused")
	private Boolean IsInstructor, isF2F;
	private MeetingPattern MeetingPattern;
	private ArrayList<Instructor> Instructor = new ArrayList();

	/**
	 * Creates a fully initialized instance of Section.  Also checks to see if a section is online or face-to-face by counting the number of F2F meeting patterns.
	 * @param data JSON data containing section information
	 * @throws JSONException if JSON input data is blank or unreadable
	 * @see MeetingPattern
	 * @See Instructor
	 * @See 
	 */
	public Section(JSONObject data) throws JSONException{
		SectionId = data.getString("sectionId");
		SectionTitle = data.getString("sectionTitle");
		CourseName = data.getString("courseName");
		CourseDescription = data.getString("courseDescription");
		CourseSectionNumber = data.getString("courseSectionNumber");
		FirstMeetingDate = data.getString("firstMeetingDate");
		LastMeetingDate = data.getString("lastMeetingDate");
		Ceus = data.getString("ceus");
		LearningProvider = data.getString("learningProvider");
		LearningProviderSiteId = data.getString("learningProviderSiteId");
		PrimarySectionId = data.getString("primarySectionId");
		Credits = data.getInt("credits");
		IsInstructor = data.getBoolean("isInstructor");

		if(data.getJSONArray("meetingPatterns").length() > 0){
			MeetingPattern = new MeetingPattern(data.getJSONArray("meetingPatterns").getJSONObject(0));
		}else{
			MeetingPattern = null;
		}

		if(data.getJSONArray("instructors").length() > 0){
			for(int i = 0; i < data.getJSONArray("instructors").length(); i++){
				if(data.getJSONArray("instructors").getJSONObject(i).length() > 0){
					Instructor.add(new Instructor(data.getJSONArray("instructors").getJSONObject(i)));
				}
				else{

				}
			}
		}

		if(data.getJSONArray("meetingPatterns").length() == 0){
			isF2F = false;
		}
		else{
			isF2F = true;
		}

	}

	
	/**
	 * gets the section number as listed in the interface. Section numbers are dynamic, and assigned at runtime by {@link #setSectionNumber(int)}
	 * @return the interface section order
	 */
	public int getSectionNumber() {
		return SectionNumber;
	}

	/**
	 * Sets the section
	 * @param sectionNumber
	 */
	public void setSectionNumber(int sectionNumber) {
		SectionNumber = sectionNumber;
	}

	public String getSectionId() {
		return SectionId;
	}

	public String getSectionTitle() {
		return SectionTitle;
	}

	public String getCourseName() {
		return CourseName;
	}

	public String getCourseDescription() {
		return CourseDescription;
	}

	public String getCourseSectionNumber() {
		return CourseSectionNumber;
	}

	public String getFirstMeetingDate() {
		return FirstMeetingDate;
	}

	public String getLastMeetingDate() {
		return LastMeetingDate;
	}

	public String getCeus() {
		return Ceus;
	}

	public String getLearningProvider() {
		return LearningProvider;
	}

	public String getLearningProviderSideId() {
		return LearningProviderSiteId;
	}

	public String getPrimarySectionId() {
		return PrimarySectionId;
	}

	public int getCredits() {
		return Credits;
	}

	public Boolean isInstructor() {
		return IsInstructor;
	}

	public Boolean isOnline() {
		return !isF2F;
	}

	public MeetingPattern getMeetingPattern() {
		return MeetingPattern;
	}

	public Instructor getInstructor( int index) {
		return Instructor.get(index);
	}

}