package Comparator;

import java.util.Comparator;

import studentSub.Student;

public class ComparatorErasmusScore implements Comparator<Student>{
	
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getErasmusScore()<o2.getErasmusScore()) {
			return 1;
		}
		else if(o1.getErasmusScore()>o2.getErasmusScore()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
