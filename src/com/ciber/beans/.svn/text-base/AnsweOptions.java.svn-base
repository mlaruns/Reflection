package com.ciber.beans;



public class AnsweOptions {

	public int getAndId() {
		return andId;
	}
	public void setAndId(int andId) {
		this.andId = andId;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	private int andId;
	private String options;
	private String questionType;
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (andId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnsweOptions other = (AnsweOptions) obj;
		if (options != null && other.options != null && options.equals(other.options)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AnsweOptions [andId=").append(andId)
				.append(", options=").append(options)
				.append(", questionType=").append(questionType)
				.append("]");
		return builder.toString();
	}

	
}
