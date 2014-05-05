package com.jccc.cis264.WayFinder.StandAlone;

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
	 * Sets the section number of the current instance&#046 Dynamically called at runtime&#046
	 * @param sectionNumber sets the Section number
	 */
	public void setSectionNumber(int sectionNumber) {
		SectionNumber = sectionNumber;
	}

	/**
	 * gets the CRN Section ID of the course represented by the current instance.
	 * @return the section ID
	 */
	public String getSectionId() {
		return SectionId;
	}

	/**
	 * gets the title of the course represented by the current instance
	 * @return the course's section title
	 */
	public String getSectionTitle() {
		return SectionTitle;
	}

	/**
	 * gets the name of the course represented by the current instance.
	 * @return the course name
	 */
	public String getCourseName() {
		return CourseName;
	}

	/**
	 * gets the description of the course represented by the current instance.
	 * @return the course description
	 */
	public String getCourseDescription() {
		return CourseDescription;
	}

	/**
	 * gets the campus assigned course section number of the course represented by the current instance.
	 * @return campus section number
	 */
	public String getCourseSectionNumber() {
		return CourseSectionNumber;
	}

	/**
	 * gets the date of the first class session of the course represented by the current instance.
	 * @return the first meeting date as a String
	 */
	public String getFirstMeetingDate() {
		return FirstMeetingDate;
	}

	/**
	 * gets the date of the last class session of the course represented by the current instance.
	 * @return the last meeting date as a String
	 */
	public String getLastMeetingDate() {
		return LastMeetingDate;
	}

	/**
	 * 
	 * @return
	 */
	public String getCeus() {
		return Ceus;
	}

	/**
	 * 
	 * @return
	 */
	public String getLearningProvider() {
		return LearningProvider;
	}

	/**
	 * 
	 * @return
	 */
	public String getLearningProviderSideId() {
		return LearningProviderSiteId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPrimarySectionId() {
		return PrimarySectionId;
	}

	/**
	 * gets the total credit hours for the course, as defined by the campus.
	 * @return course credit hours
	 */
	public int getCredits() {
		return Credits;
	}

	/**
	 * gets whether or not the current data is infact an instructor, rather than a student
	 * @return returns whether the student is an instructor as Boolean
	 */
	public Boolean isInstructor() {
		return IsInstructor;
	}

	/**
	 * gets whether or not the current section is an online course.
	 * @return Boolean whether the course is online
	 */
	public Boolean isOnline() {
		return !isF2F;
	}

	/**
	 * returns the primary meeting pattern of the course represented by the current instance
	 * @return MeetingPattern 0 from JSON input data
	 * @see MeetingPattern
	 */
	public MeetingPattern getMeetingPattern() {
		return MeetingPattern;
	}

	/**
	 * returns the instructor specified by the index (primary instructor is 0)
	 * @param index - the index of the instructor you wish to view
	 * @return the Instructor specified by the index
	 * @see Instructor
	 */
	public Instructor getInstructor( int index) {
		return Instructor.get(index);
	}

}
