package com.jccc.cis264.WayFinder.StandAlone1;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
/**
 * an instance of a Term for a particular student, as defined by the data passed from Student.
 * @see Stdeunt
 */
public class Term {

	private String id, name, startDate, endDate;
	ArrayList<Section> section = new ArrayList();
	
	/**
	 * Creates a fully initialized instance of Instructor when called.</br>Also triggers multiple instances of Section.
	 * @param data the JSON data provided by the student class, as provided by the Banner Mobile API at runtime.
	 * @see Student
	 * @see Section
	 */
	public Term(JSONObject data) throws JSONException {
		id = data.getString("id");
		name = data.getString("name");
		startDate = data.getString("startDate");
		endDate = data.getString("endDate");

		if(data.getJSONArray("sections").length() > 0){
			for(int i = 0; i < data.getJSONArray("sections").length(); i++){
				if(data.getJSONArray("sections").getJSONObject(i).length() > 0){
					section.add(new Section(data.getJSONArray("sections").getJSONObject(i)));
					section.get(i).setSectionNumber(i);
					System.out.println(i);
				}
			}
		}
	}


	/**
	 * gets the campus wide ID of term represented by the current instance
	 * @return the respective term's ID 
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * gets the name  (e.g. Fall 2014) of the term represented by the current instance
	 * @return the respective term's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets the Start Date of the term represented by the current instance
	 * @return the respective term's Start Date
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * gets the End Date of the term represented by the current instance
	 * @return the respective term's End Date
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * returns all of the student's sections contained in this respective term.
	 * @return an ArrayList of type Section
	 * @see Section
	 */
	public ArrayList<Section> getSections() {
		return section;
	}
	
	/**
	 * returns a specific section, based on the provided index, and the Student's Term
	 * @param index the index of the Section to be returned
	 * @return the respective object Section, given the index
	 * @see Section
	 */
	public Section getSection(int index) {
		return section.get(index);
	}
}
