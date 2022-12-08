package com.quiz.K_Quiz;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.custom_exception.QuizException;
import com.entity.Marks;
import com.entity.Student;

import utils.ValidationRules;

public class App 
{

	static int choice=0;

	public static void main( String[] args )
	
	{
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		//Operations.getSession();



		while(choice!=5) {

			System.out.println("\n\n\t\t\t\t-----Choose an option------\n\t\t\t\t1.Play quiz\n\t\t\t\t2.Show Student Information\n\t\t\t\t3.Display marks of all students \n\t\t\t\t4.Display marks by student id\n\t\t\t\t5.Exit\n");

			try {

				Scanner sc1 = new Scanner(System.in);
				System.out.print("\t\t\t\t");
				choice=sc1.nextInt();

			}catch(InputMismatchException e) {

				System.out.println("\n\t\t\t\tPlease enter number option from (1-4)!!\n");
				choice=0;

				continue;

			}


			switch(choice) {

			case 1: 

				Scanner sc = new Scanner(System.in);
				String fname=null;
				String lname=null;

				System.out.println("\t\t\t\tRegister Student details :-");
				System.out.println("\n\t\t\t\tEnter First Name");
				System.out.print("\t\t\t\t");

				try {
					fname=ValidationRules.nameValidation(sc.next());


					System.out.println("\t\t\t\tEnter Last Name");
					System.out.print("\t\t\t\t");
					lname=ValidationRules.nameValidation(sc.next());

				} catch (QuizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					continue;
				}



				System.out.println("\t\t\t\tEnter Student Id");
				System.out.print("\t\t\t\t");
				int id=0;
				if(sc.hasNextInt()) {
					id=sc.nextInt();
				}else {
					try {
						throw new QuizException("Invalid id: Enter number only!");
					} catch (QuizException e) {
						e.printStackTrace();
						continue;
					}
				}

				System.out.print("\t\t\t\t");
				System.out.println("Enter email id-");
				Logger.getLogger("org.hibernate").setLevel(Level.OFF);
				String email=null;
				try {
					System.out.print("\t\t\t\t");
					email = ValidationRules.emailValidation(sc.next());
				} catch (QuizException e) {
					e.printStackTrace();
					continue;
				}

				System.out.println();

				//quiz code
				System.out.println("\n\t\t\t\tQuiz Started!!\n");
				Marks marks=new Marks();
				int m=Operations.displayQuestion(id);
				marks.setMarks(m);


				Operations.insertStudent(new Student(id,fname,lname,email,marks));

				break;

			case 2:
				System.out.println("\n\t\t\t\tDisplay Student Info: Namewise");

				Operations.showStudentInfo();

				break;


			case 3:
				System.out.println("\n\t\t\t\tDisplay marks of all students");

				Operations.showStudentMarks();

				break;

			case 4: 
				System.out.println("\n\t\t\t\tDisplay marks of students by id");
				System.out.print("\t\t\t\tEnter Id>>");
				Scanner sc3=new Scanner(System.in);

				int getId=0;
				if(sc3.hasNextInt()) {
					getId=sc3.nextInt();
					Operations.showStudentbyId(getId);

				}else {
					try {
						throw new QuizException("Invalid id");
					} catch (QuizException e) {
						e.printStackTrace();
						continue;
					}
				}

				break;

			case 5://exit
				System.out.println("\t\t\t\tThanks for Playing!!");
				break;

			default :
				System.out.println("\n\t\t\t\tPlease select choice from (1-4)!!\n");
				break;

			}
		}
	}
}
