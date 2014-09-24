package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

import ca.ualberta.cs.lonelytwitter.data.GsonFileDataManager;
import ca.ualberta.cs.lonelytwitter.data.IDataManager;
import ca.ualberta.cs.lonelytwitter.data.SummaryDataManager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SummaryActivity extends Activity {
	
	private IDataManager dataManager;

	private TextView tweetCount;
	private TextView avgLatency;
	private TextView avgLength;

	private ArrayList<Summary> summary;

	//private ArrayAdapter<Tweet> summaryViewAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		
		dataManager = new SummaryDataManager(this);

		tweetCount= (EditText) findViewById(R.id.tweetsTotalCount);
		avgLatency = (EditText) findViewById(R.id.avgLatencyText);
		avgLength = (EditText) findViewById(R.id.avgLengthText);
		
		
	}
	
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.summary, menu);
		return true;
	}
	*/
	@Override
	protected void onStart() {
		super.onStart();

		summary = dataManager.loadSummary();
		//summaryViewAdapter = new ArrayAdapter<Summary>(this,
		//		R.layout.list_item, tweets);
		//oldTweetsList.setAdapter(tweetsViewAdapter);
	}
	
	public void save(View v) {

		String text = bodyText.getText().toString();

		Tweet tweet = new Tweet(new Date(), text);
		tweets.add(tweet);

		tweetsViewAdapter.notifyDataSetChanged();

		bodyText.setText("");
		dataManager.saveTweets(tweets);
	}

}
