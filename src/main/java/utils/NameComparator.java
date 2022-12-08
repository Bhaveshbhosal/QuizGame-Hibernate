package utils;

import java.util.Comparator;


import com.entity.Student;

//Comporator class
public class NameComparator implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getCol1_firstName().compareTo(s2.getCol1_firstName());
	}
}
