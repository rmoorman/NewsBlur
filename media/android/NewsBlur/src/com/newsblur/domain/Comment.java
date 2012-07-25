package com.newsblur.domain;

import java.io.Serializable;

import android.content.ContentValues;
import android.database.Cursor;

import com.google.gson.annotations.SerializedName;
import com.newsblur.database.DatabaseConstants;

public class Comment implements Serializable {
	private static final long serialVersionUID = -2018705258520565390L;

	public String id;
	
	@SerializedName("comments")
	public String commentText;
	
	@SerializedName("user_id")
	public int userId;
	
	@SerializedName("shared_date")
	public String sharedDate;
	
	@SerializedName("date")
	public String date;
	
	public String storyId;
	
	
	public ContentValues getValues() {
		ContentValues values = new ContentValues();
		values.put(DatabaseConstants.COMMENT_DATE, date);
		values.put(DatabaseConstants.COMMENT_STORYID, storyId);
		values.put(DatabaseConstants.COMMENT_TEXT, commentText);
		values.put(DatabaseConstants.COMMENT_SHAREDDATE, sharedDate);
		values.put(DatabaseConstants.COMMENT_USERID, userId);
		values.put(DatabaseConstants.COMMENT_ID, id);
		return values;
	}
	
	public static Comment fromCursor(final Cursor cursor) {
		Comment comment = new Comment();
		comment.date = cursor.getString(cursor.getColumnIndex(DatabaseConstants.COMMENT_DATE));
		comment.sharedDate = cursor.getString(cursor.getColumnIndex(DatabaseConstants.COMMENT_SHAREDDATE));
		comment.commentText = cursor.getString(cursor.getColumnIndex(DatabaseConstants.COMMENT_TEXT));
		comment.storyId = cursor.getString(cursor.getColumnIndex(DatabaseConstants.COMMENT_STORYID));
		comment.userId = cursor.getInt(cursor.getColumnIndex(DatabaseConstants.COMMENT_USERID));
		comment.id = cursor.getString(cursor.getColumnIndex(DatabaseConstants.COMMENT_ID));
		
		return comment;
	}
	
}