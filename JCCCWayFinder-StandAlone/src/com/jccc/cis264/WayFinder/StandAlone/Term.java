package com.jccc.cis264.WayFinder.StandAlone;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class Term {

	private String id, name, startDate, endDate;
	ArrayList<Section> section = new ArrayList();



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
	 * <b>Type: </b>String</br></br>
	 * 
	 *<b> Description:</b></br>
	 * Returns the unique ID of the respective term as defined by the Banner Mobile API.</br></br>
	 * 
	 * <b>Example: </b></br>
	 * Term ID: 80179</br></br>
	 * 
	 * <b>Usage:</b></br>
	 * Student.getTerm(index).getId();</br></br>
	 */
	public String getId() {
		return id;
	}

	
	/**
	 * <b>Type:</b> String</br></br>
	 * 
	 * <b>Description:</b></br>
	 * Returns the NAME of the respective term as defined by the Banner Mobile API.</br></br>
	 * 
	 * <b>Example: </b></br>
	 * Term ID: Fall 2014</br></br>
	 * 
	 * <b>Usage:</b></br>
	 * Student.getTerm(index).getName();</br></br>
	 */
	public String getName() {
		return name;
	}

	/**
	 * <b>Type:</b> String</br></br>
	 * 
	 * <b>Description:</b></br>
	 * Returns the START DATE of the respective term as defined by the Banner Mobile API.</br></br>
	 * 
	 * <b>Example:</b> </br>
	 * Term ID: 08/14/2014</br></br>
	 * 
	 * <b>Usage:</b></br>
	 * Student.getTerm(index).getStartDate();</br></br>
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * <b>Type:</b> String</br></br>
	 * 
	 * <b>Description:</b></br>
	 * Returns the END DATE of the respective term as defined by the Banner Mobile API.</br></br>
	 * 
	 * <b>Example</b>: </br>
	 * Term ID: 12/15/2014</br></br>
	 * 
	 * <b>Usage:</b></br>
	 * Student.getTerm(index).getEndDate();</br></br>
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * <b>Type:</b> ArrayList</br></br>
	 * 
	 * <b>Description:</b></br>
	 * Returns the ALL of a student's actively enrolled courses as defined by the Banner Mobile API.</br></br>
	 * 
	 * <b>Usage:</b></br>
	 * Student.getTerm(index).getSections();</br></br>
	 */
	public ArrayList<Section> getSections() {
		return section;
	}
	
	/**
	 * <b>Type:</b> ArrayList</br></br>
	 * 
	 * <b>Description:</b></br>
	 * Returns a specific course from a student's actively enrolled courses as defined by the user defined index, and the Banner Mobile API.</br></br>
	 * 
	 * <b>Usage:</b></br>
	 * Student.getTerm(index).getSection(index);</br></br>
	 */
	public Section getSection(int index) {
		return section.get(index);
	}
}
