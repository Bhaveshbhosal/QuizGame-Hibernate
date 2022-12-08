package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	private int id;
	@Column(name="firstname")
	private String col1_firstName;
	@Column(name="lastname")
	private String col2_lastName;
	@Column(name="email")
	private String col3_email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="marks_id")
	private Marks mid;




	public Student(int id, String col1_firstName, String col2_lastName, String col3_email, Marks mid) {
		super();
		this.id = id;
		this.col1_firstName = col1_firstName;
		this.col2_lastName = col2_lastName;
		this.col3_email = col3_email;
		this.mid = mid;
	}



	public Student() {
		super();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCol1_firstName() {
		return col1_firstName;
	}

	public void setCol1_firstName(String col1_firstName) {
		this.col1_firstName = col1_firstName;
	}

	public String getCol2_lastName() {
		return col2_lastName;
	}

	public void setCol2_lastName(String col2_lastName) {
		this.col2_lastName = col2_lastName;
	}

	public String getCol3_email() {
		return col3_email;
	}

	public void setCol3_email(String col3_email) {
		this.col3_email = col3_email;
	}

	public Marks getMid() {
		return mid;
	}

	public void setMid(Marks mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", col1_firstName=" + col1_firstName + ", col2_lastName=" + col2_lastName
				+ ", col3_email=" + col3_email + ", mid=" + mid + "]";
	}














}
