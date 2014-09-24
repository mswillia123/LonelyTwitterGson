package ca.ualberta.cs.lonelytwitter.data;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.content.Context;
import android.util.Log;
import ca.ualberta.cs.lonelytwitter.Tweet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonFileDataManager implements IDataManager {

	private Gson gson;
	private static final String FILENAME = "gsonfile2.sav";

	private Context ctx; // copied from FileDataManager

	public GsonFileDataManager(Context ctx) {// copied from FileDataManager
		this.ctx = ctx;// copied from FileDataManager
		gson = new Gson();
	}

	public ArrayList<Tweet> loadTweets() { // copied from FileDataManager
		ArrayList<Tweet> lts = new ArrayList<Tweet>();

		try {
			BufferedReader fis = new BufferedReader(new InputStreamReader(
					ctx.openFileInput(FILENAME))); // renamed//ctx is a
													// context//content of file
													// is stored in filecontent,
													// use buffer to make more
													// efficient
			String line;// new
			StringBuffer fileContent = new StringBuffer();// new

			while ((line = fis.readLine()) != null) { // reading lines, find end
														// of file
				fileContent.append(line); // different representation of the
											// string
			}

			Type collectionType = new TypeToken<Collection<Tweet>>() {
			}.getType(); // translate the objects of that type
			lts = gson.fromJson(fileContent.toString(), collectionType);

		} catch (Exception e) {
			Log.i("LonelyTwitter", "Error casting");
			e.printStackTrace();
		}

		return lts;
	}

	public void saveTweets(List<Tweet> lts) {
		try{
			FileOutputStream fos = ctx.openFileOutput(FILENAME, Context.MODE_PRIVATE);
			String json = gson.toJson(lts); //get object and write it to a string
			fos.write(json.getBytes());
			fos.close();
			
			Log.i("Persistence", "Saved:" +json);
			
			
		} catch (Exception e){ 
			e.printStackTrace();
		}

	}
}
