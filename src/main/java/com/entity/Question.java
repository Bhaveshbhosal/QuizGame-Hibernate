package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {

	@Id
	private int qid;
	@Column(name="questions")
	private String col1_questions;
	@Column(name="options")
	private String col2_options;
	@Column(name="answer")
	private String col3_answer;
	
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getCol1_questions() {
		return col1_questions;
	}
	public void setCol1_questions(String col1_questions) {
		this.col1_questions = col1_questions;
	}
	public String getCol2_options() {
		return col2_options;
	}
	public void setCol2_options(String col2_options) {
		this.col2_options = col2_options;
	}
	public String getCol3_answer() {
		return col3_answer;
	}
	public void setCol3_answer(String col3_answer) {
		this.col3_answer = col3_answer;
	}
	@Override
	public String toString() {
		return "Question [qid=" + qid + ", col1_questions=" + col1_questions + ", col2_options=" + col2_options
				+ ", col3_answer=" + col3_answer + "]";
	}
	
	
	
}
