package ca.ualberta.cs.lonelytwitter.data;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.Summary;
import ca.ualberta.cs.lonelytwitter.Tweet;

public interface IDataManager {
	
	public ArrayList<Tweet> loadTweets();
	
	public void saveTweets(List<Tweet> lts);
	
	public ArrayList<Summary> loadSummary();
	
	public void saveSummary(List<Summary> lts);

}
