package studentSub;

import interfaceClasses.DisplayInterface;

public class Course implements DisplayInterface{
	private String courseName;
	private double courseCredit;
	private static double totalCredits=0;
	
	public Course(String courseName,double courseCredit) {
		this.courseName=courseName;
		this.courseCredit=courseCredit;
		totalCredits+=courseCredit;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public static double getTotalCredits() {
		return totalCredits;
	}
	
	public static void setTotalCredits(double totalCredits) {
		Course.totalCredits = totalCredits;
	}

	@Override
	public String display() {
		return "\tCourse Name:"+this.courseName+"\n\tCourse Credit:"+this.courseCredit+"\n";
	}
	
	

}
