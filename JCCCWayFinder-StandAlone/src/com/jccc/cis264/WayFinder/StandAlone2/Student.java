package com.jccc.cis264.WayFinder.StandAlone2;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class Student {

	private String Id, Name;
	ArrayList<Term> term;
	
	public void CurrentStudent(JSONObject data) throws JSONException{
		Id = data.getJSONObject("person").getString("id");
		Name = data.getJSONObject("person").getString("name");
	}

	public String getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}

	public ArrayList<Term> getTerm() {
		return term;
	}
}
