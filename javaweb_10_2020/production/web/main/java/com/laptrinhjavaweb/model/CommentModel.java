package com.laptrinhjavaweb.model;

public class CommentModel extends AbstractModel<CommentModel>{

	private String content;
	private Long userID;
	private Long newID;
	
	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Long getUserID() {
		return userID;
	}


	public void setUserID(Long userID) {
		this.userID = userID;
	}


	public Long getNewID() {
		return newID;
	}


	public void setNewID(Long newID) {
		this.newID = newID;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
