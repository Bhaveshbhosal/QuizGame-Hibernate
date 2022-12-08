package com.quiz.K_Quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.custom_exception.QuizException;
import com.entity.Question;
import com.entity.Student;

import utils.MarksComparator;
import utils.NameComparator;



public class Operations {

	//get session 
	public static Session getSession() {
		Configuration cfg=new Configuration();
		cfg=cfg.configure("hibernate.cfg.xml");

		SessionFactory factory= cfg.buildSessionFactory();

		Session session=factory.openSession();

		return session;
	}

	//add student to db
	public static void insertStudent(Student stud) {

		Session session=getSession();

		session.save(stud);

		session.beginTransaction().commit();
		session.close();


	}

//display student info
	public static void showStudentInfo() {
		Session session = getSession(); 

		Query query = session.createQuery("from Student"); 

		List<Student> studlist = query.list(); 

		if(studlist.isEmpty()) {
			System.out.println("No record in db");

		}
		else {
			//sort by name
			Collections.sort(studlist,new NameComparator());
			
			//display in table format on console
			String s="\t\t";
			System.out.println(s+"-----------------------------------------------------");
			System.out.printf(s+"|%5s  | %-10s | %-10s| %-17s|%n","Id","FirstName","LastName","Email");
			System.out.println(s+"-----------------------------------------------------");
			for (Student stud : studlist) {
				System.out.printf(s+"|%5s  | %-10s | %-10s| %-17s|%n",stud.getId(),stud.getCol1_firstName(),stud.getCol2_lastName(),stud.getCol3_email());
			}
			System.out.println(s+"-----------------------------------------------------\n\n");


		}

	}

	//get questions from db
	public static int displayQuestion(int id) {
		Session session = getSession(); 

		Query query = session.createQuery("from Question"); 

		List<Question> questionList = query.list();

		//shuffling questions 
		Collections.shuffle(questionList);

		int queNo=1; //show question number
		List answer=new ArrayList();
		for (int i=0;i<questionList.size();i++) { 

			System.out.println("\n\t\t\t"+queNo+"] "+questionList.get(i).getCol1_questions());
			System.out.println("\n\t\t\tOptions: "+questionList.get(i).getCol2_options());
			queNo++;
			System.out.print("\n\t\t\tAns>> ");
			
			//get answer from user
			Scanner sc=new Scanner(System.in);

			if(sc.hasNextInt()){
				int ans=sc.nextInt();

				if(ans<=4&&ans>=1) {

					answer.add(ans);

				}else{
					//System.out.println("\t\t\tPlease Select Option Choice From 1-4 !!\n ");
					System.out.println();
					try {

						throw new QuizException("Please Select Option Choice From 1-4 !!");
					}
					catch (QuizException e) {
						System.out.println(e);
					}

					System.out.println();
					//decrement i so that same question shown again
					i--;
					queNo--;

				}

			}else {
				//System.out.println("\n\t\t\tPlease Enter Option Number Only!!\n");

				try {

					throw new QuizException("Please Enter Option Number!!");
				}
				catch (QuizException e) {
					System.out.println(e);
				}

				System.out.println();
				i--;
				queNo--;
			}

		}

		//calculate marks
		int marks=0;
		for(int i=0;i<answer.size();i++) {
			Integer I=Integer.parseInt(questionList.get(i).getCol3_answer());
			if(answer.get(i)==I) {

				marks++;

			}	

		}


		System.out.println("\n\n\t\t\tYour Score is>> "+marks+"\n\n");
		return marks;
	}


	//display student data
	public static void showStudentMarks() {
		Session session = getSession(); 

		Query query = session.createQuery("from Student"); 

		List<Student> studlist = query.list(); 

		if(studlist.isEmpty()) {
			System.out.println("No record in db");

		}
		else {
			//sort by name
			Collections.sort(studlist,new MarksComparator());
			
			//display in table format on console
			String s="\t\t";
			System.out.println(s+"---------------------------------------------------------------------------");
			System.out.printf(s+"|%5s  | %-10s | %-10s| %-20s| %-7s | %-7s |%n","Id","FirstName","LastName","Email","Marks","Grade");
			System.out.println(s+"---------------------------------------------------------------------------");
			for (Student stud : studlist) {
				String grade=setGrade(stud.getMid().getMarks());
				System.out.printf(s+"|%5s  | %-10s | %-10s| %-20s | %-6s | %-6s |%n",stud.getId(),stud.getCol1_firstName(),stud.getCol2_lastName(),stud.getCol3_email(),stud.getMid().getMarks(),grade);
			}
			System.out.println(s+"---------------------------------------------------------------------------\n\n");


		}


	}
	
	
	

	//display student by id 
	public static void showStudentbyId(int id) {

		Session session = getSession(); 

		Student stud =session.get(Student.class, id);



		if(stud==null) {
			System.out.println("\t\t\t\tId not present in db");

		}
		else {
			
			//display in table format on console

			String s="\t\t";
			String grade=setGrade(stud.getMid().getMarks());

			System.out.println(s+"---------------------------------------------------------------------------");
			System.out.printf(s+"|%5s  | %-10s | %-10s| %-20s| %-7s | %-7s |%n","Id","FirstName","LastName","Email","Marks","Grade");
			System.out.println(s+"---------------------------------------------------------------------------");

			System.out.printf(s+"|%5s  | %-10s | %-10s| %-20s | %-6s | %-6s |%n",stud.getId(),stud.getCol1_firstName(),stud.getCol2_lastName(),stud.getCol3_email(),stud.getMid().getMarks(),grade);

			System.out.println(s+"---------------------------------------------------------------------------\n\n");

		}
	}
	
	
	//get grade as per marks
		public static String setGrade(int marks) {
			String grade=null;
			
			if(marks>=8&&marks<=10) {
			 	grade="Class A";
			}else if(marks>=6&&marks<=7) {
				grade="Class B";
			}else if(marks==5) {
				grade="Class C";
			}else {
				grade="Class D";
			}
			
			return grade;
		}

}
