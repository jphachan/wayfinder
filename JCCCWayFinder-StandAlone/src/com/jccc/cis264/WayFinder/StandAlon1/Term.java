package com.jccc.cis264.WayFinder.StandAlon1;

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
				}
				else{

				}
			}
		}
		
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public ArrayList<Section> getSections() {
		return section;
	}
	public Section getSection(int index) {
		return section.get(index);
	}
}
