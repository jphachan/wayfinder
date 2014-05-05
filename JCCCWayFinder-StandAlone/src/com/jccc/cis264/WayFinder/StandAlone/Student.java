package com.jccc.cis264.WayFinder.StandAlone;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * Represents a physical student&#046; Prompts all other objects in the hierarchy to be created&#046;</br><i>Created by: Programmer/User</i>
 * 
 */
@SuppressWarnings("all")
public class Student {

	private String Id, Name;
	ArrayList<Term> term = new ArrayList();
	
	/**
	 * Creates a fully initialized instance of a Student, and prompts an array of Terms to be created, as defined by data provided by the Banner Mobile API.
	 * @param data The full JSON data returned from BANNER MOBILE API
	 * @throws JSONException if JSON data is unreadable or empty
	 * @see Term
	 */
	public Student(JSONObject data) throws JSONException{
		Id = data.getJSONObject("person").getString("id");
		Name = data.getJSONObject("person").getString("name");
		
		if(data.getJSONArray("terms").length() > 0){
			for(int i = 0; i < data.getJSONArray("terms").length(); i++){
				if(data.getJSONArray("terms").getJSONObject(i).length() > 0){
					term.add(new Term(data.getJSONArray("terms").getJSONObject(i)));
				}
				else{

				}
			}
		}
	}
	
	/**
	 * Gets the student ID of the student represented by the current instance
	 * @return the ID of the Student
	 */
	public String getId() {
		return Id;
	}

	/**
	 * Gets the name of the student represented by the current instance
	 * @return the NAME of the student
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Returns a specific term for the student, as specified by the Banner Mobile API, and the programmer specified index.
	 * @param index
	 * @return the specified Term ovject, given the JSON data, and the specified index.
	 * @see Term
	 */
	public Term getTerm(int index) {
		return term.get(index);
	}
}
