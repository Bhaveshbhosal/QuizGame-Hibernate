package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marks")
public class Marks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mId;
	private int marks;
	
	
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Marks [mId=" + mId + ", marks=" + marks + "]";
	}
	
	
	
	
	
	
}
