package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.custom_exception.QuizException;

public class ValidationRules {

	// Email Validation Method
		public static String emailValidation(String email) throws QuizException {
			String pattern = "^[\\w-\\.]+@([\\w-]+\\.)+(com|org)$";
			
			if (email.matches(pattern)) {
				return email;
			} else {
				throw new QuizException("Invalid Email Id:Please Enter Valid Email:: Example>John@gmail.com ");
				
			}
		}

		
		//name validation
		public static String nameValidation(String name) throws QuizException {
			String pattern="^[A-Za-z]\\w{2,9}$";
			if (name.matches(pattern)) {
				return name;
			} else {
				throw new QuizException("Invalid Name:Enter name with characters 3-10 Example:John  ");
				
			}
		}
	
	
}
