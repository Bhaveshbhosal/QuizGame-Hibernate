package utils;

import java.util.Comparator;

import com.entity.Student;


//Marks Comporator class
public class MarksComparator  implements Comparator<Student>{
	@Override
	public int compare(Student stu1, Student stu2) {
		if(stu1.getMid().getMarks()<stu2.getMid().getMarks()) {
			return 1;
		}else if(stu1.getMid().getMarks()>stu2.getMid().getMarks()) {
			return -1;
		}else
			return 0;
	}
}