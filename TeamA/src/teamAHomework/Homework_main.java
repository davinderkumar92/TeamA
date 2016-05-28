package teamAHomework;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




public class Homework_main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String json = FileReader.loadFileIntoString("json/neer.json","utf-8");

		JSONObject tweets  = JSONObject.fromObject(json);
		JSONArray tweetsArray = tweets.getJSONArray("statuses");




		for(int i= 0; i<tweetsArray.size(); i++){
			JSONObject statuses = tweetsArray.getJSONObject(i);
			String c_date = statuses.getString("created_at");
			String creation_date = Methods.creation_date(c_date);

			System.out.println("Message created on "+creation_date);
			

			String id = Methods.msg_id(statuses);
			System.out.println("The ID of the message is  " + id);
			JSONObject entities = statuses.getJSONObject("entities");

			


			JSONArray hashtags = entities.getJSONArray("hashtags");

			for (int j = 0; j<hashtags.size(); j++){
				JSONObject objectHashtags = hashtags.getJSONObject(j);

				String text = objectHashtags.getString("text");

				System.out.println("The message is "+"\""+  text+"\""  );



				
			}int retweet_count = statuses.getInt("retweet_count");
			System.out.println("The message was retweeted "+retweet_count+" times");
			JSONObject user = statuses.getJSONObject("user");

			String name = Methods.user_name(user);

			System.out.println("The message was written by "+name);

			String createdAt = user.getString("created_at");
			
			System.out.println("Member of tweeter since " +createdAt.substring(createdAt.length()-4));


			String location = Methods.getLocation(user);

			System.out.println("located in "+location);

			for(int k=0; k<hashtags.size() ; k++){

				JSONObject objectHashtags = hashtags.getJSONObject(k);

				JSONArray indices = objectHashtags.getJSONArray("indices");

				System.out.println("hashtag indices");

				System.out.println(indices.getInt(0));

				System.out.println(indices.getInt(1));

			}

		}


	}

}
