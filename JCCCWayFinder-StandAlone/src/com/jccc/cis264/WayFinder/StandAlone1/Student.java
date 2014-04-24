package com.jccc.cis264.WayFinder.StandAlone1;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class Student {

	private String Id, Name;
	ArrayList<Term> term = new ArrayList();
	
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
	 * <b>Type: </b>String</br></br>
	 * 
	 * <b> Description:</b></br>
	 * Returns the unique ID of the respective student as defined by the Banner Mobile API.</br></br>
	 * 
	 * <b>Example: </b></br>
	 * Student ID: 007801792</br></br>
	 * 
	 * <b>Usage:</b></br>
	 * Student.getId();</br></br>
	 */
	public String getId() {
		return Id;
	}

	/**
	 * <b>Type: </b>String</br></br>
	 * 
	 *<b> Description:</b></br>
	 * Returns the name of the respective student as defined by the Banner Mobile API.</br></br>
	 * 
	 * <b>Example: </b></br>
	 * Name: Ardvark, Alvin
	 * 
	 * <b>Usage:</b></br>
	 * Student.getName();</br></br>
	 */
	public String getName() {
		return Name;
	}

	/**
	 * <b>Type: </b>String</br></br>
	 * 
	 *<b> Description:</b></br>
	 * Returns the a specific term of the respective student as defined by INDEX, and the Banner Mobile API.</br></br>
	 * 
	 * <b>Example: </b></br>
	 * Term ID: 80179</br></br>
	 * 
	 * <b>Usage:</b></br>
	 * Student.getTerm(index);</br></br>
	 * 
	 * @param index the index of the term requested. Current term is 0.
	 * @see Term
	 */
	public Term getTerm(int index) {
		return term.get(index);
	}
}
