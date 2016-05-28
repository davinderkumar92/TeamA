package teamAHomework;

import net.sf.json.JSONObject;

public class Methods {

	static String user_name(JSONObject user) {
		String name = user.getString("name");
		return name;
	}

	static String msg_id(JSONObject statuses) {
		String id = statuses.getString("id_str");
		return id;
	}

	static String creation_date(String c_date) {
		String creation_date = c_date.substring(4, 10)+","+ c_date.substring(c_date.length()-4);
		return creation_date;
	}

	static String getLocation(JSONObject user) {
		String location = user.getString("location");
		return location;
	}

}
