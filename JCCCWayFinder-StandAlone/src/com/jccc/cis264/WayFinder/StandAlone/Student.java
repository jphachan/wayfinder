package com.jccc.cis264.WayFinder.StandAlone;

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

	public String getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}

	public Term getTerm(int index) {
		return term.get(index);
	}
}
