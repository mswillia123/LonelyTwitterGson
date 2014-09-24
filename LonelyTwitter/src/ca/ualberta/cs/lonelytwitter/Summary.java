package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.Date;

public class Summary implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int summaryTotalTweets;
	private float summaryLatency;
	private int summaryLength;
	
	public Summary() {
		super();
	}
	
	public Summary(	 int summaryTotalTweet,float summaryLatency, int summaryLength){
	
		this.summaryTotalTweets = summaryTotalTweets;
		this.summaryLatency = summaryLatency;
		this.summaryLength = summaryLength;
		
	}

	public int getSummaryTotalTweets() {
		return summaryTotalTweets;
	}

	public void setSummaryTotalTweets(int summaryTotalTweets) {
		this.summaryTotalTweets = summaryTotalTweets;
	}

	public float getSummaryLatency() {
		return summaryLatency;
	}

	public void setSummaryLatency(float summaryLatency) {
		this.summaryLatency = summaryLatency;
	}

	public int getSummaryLength() {
		return summaryLength;
	}

	public void setSummaryLength(int summaryLength) {
		this.summaryLength = summaryLength;
	}


	

}

/*
 public class Tweet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date tweetDate;
	private String tweetBody;
	
	public Tweet() { //constructor base
		super();
	}

	public Tweet(Date tweetDate, String tweetBody) { // another constructor
		this.tweetDate = tweetDate;
		this.tweetBody = tweetBody;
	}

	public Date getTweetDate() {
		return tweetDate;
	}

	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	@Override
	public String toString() {
		return tweetDate + " | " + tweetBody;
	}
}
 */
