package studentSub;
import java.util.ArrayList;
import java.util.Objects;

import interfaceClasses.DisplayInterface;
import partners.*;

public class Student implements DisplayInterface{
	private String stuID;
	private String nameSurname;
	private double cgpa;
	private String eng101Grade;
	private String eng102Grade;
	private double erasmusScore;
	private String semesterToGo;
	private String nationalID;
	private int currentSemester;
	private String phoneNumber;
	private String mailAddress;
	private ArrayList<Course> coursesToTake;
	private Grant grantGiven;
	private Accomodation placeToStay;
	private static final int APPLYLIMIT=5;
	private Erasmus[] appliedPartners;
	
	public Student(String stuID, String nameSurname, double cgpa, String eng101Grade, String eng102Grade,
			String semesterToGo, String nationalID,
			int currentSemester, String phoneNumber, String mailAddress, ArrayList<Course> coursesToTake, Grant grantGiven,
			Accomodation placeToStay,Erasmus[] appliedPartners) {
		this.stuID = stuID;
		this.nameSurname = nameSurname;
		this.cgpa = cgpa;
		this.eng101Grade = eng101Grade;
		this.eng102Grade = eng102Grade;
		this.semesterToGo = semesterToGo;
		this.nationalID = nationalID;
		this.currentSemester = currentSemester;
		this.phoneNumber = phoneNumber;
		this.mailAddress = mailAddress;
		this.coursesToTake = coursesToTake;
		this.grantGiven = grantGiven;
		this.placeToStay = placeToStay;
		this.appliedPartners=appliedPartners;
		
	}

	public void calculateErasmusScores() {
		double erasmus_score, cgpa_score;
		int eng101,eng102;
			
		if(this.getEng101Grade().equalsIgnoreCase("A+"))
			eng101=26;
		else if(this.getEng101Grade().equalsIgnoreCase("A"))
			eng101=25;
		else if(this.getEng101Grade().equalsIgnoreCase("A-"))
			eng101=22;
		else if(this.getEng101Grade().equalsIgnoreCase("B+"))
			eng101=19;
		else if(this.getEng101Grade().equalsIgnoreCase("B"))
			eng101=15;
		else if(this.getEng101Grade().equalsIgnoreCase("B-"))
			eng101=11;
		else if(this.getEng101Grade().equalsIgnoreCase("C+"))
			eng101=6;
		else if(this.getEng101Grade().equalsIgnoreCase("C"))
			eng101=1;
		else
			eng101=0;
		if(this.getEng102Grade().equalsIgnoreCase("A+"))
			eng102=26;
		else if(this.getEng102Grade().equalsIgnoreCase("A"))
			eng102=25;
		else if(this.getEng102Grade().equalsIgnoreCase("A-"))
			eng102=22;
		else if(this.getEng102Grade().equalsIgnoreCase("B+"))
			eng102=19;
		else if(this.getEng102Grade().equalsIgnoreCase("B"))
			eng102=15;
		else if(this.getEng102Grade().equalsIgnoreCase("B-"))
			eng102=11;
		else if(this.getEng102Grade().equalsIgnoreCase("C+"))
			eng102=6;
		else if(this.getEng102Grade().equalsIgnoreCase("C"))
			eng102=1;
		else
			eng102=0;

		if(this.getCgpa()>=2.5) {
			cgpa_score=(100/3.0*(this.getCgpa()-2.5));
			erasmus_score=cgpa_score+eng101+eng102;
		}
		else
			erasmus_score=-1;
		this.setErasmusScore(erasmus_score);
	}
	
	public boolean searchByID(String stuID) {
		if(this.stuID==stuID)
			return true;
		return false;
	}

	public double getErasmusScore() {
		return erasmusScore;
	}

	public void setErasmusScore(double erasmusScore) {
		this.erasmusScore = erasmusScore;
	}

	public String getStuID() {
		return stuID;
	}

	public double getCgpa() {
		return cgpa;
	}

	public String getNameSurname() {
		return nameSurname;
	}

	public String getEng101Grade() {
		return eng101Grade;
	}

	public String getEng102Grade() {
		return eng102Grade;
	}

	public int getCurrentSemester() {
		return currentSemester;
	}

	public static int getApplylimit() {
		return APPLYLIMIT;
	}

	@Override
	public String display() {
		String output="\n\tStudent ID:"+this.stuID+"\n\tStuden Name Surname:"+this.nameSurname+"\n\tCGPA:"+this.cgpa
				+"\n\tErasmus Score:"+this.erasmusScore+"\n\tSemester To Go:"+this.semesterToGo+
				"\n\tNational ID:"+this.nationalID+"\n\tCurrent Semester of Student:"+
				this.currentSemester+"\n\tPhone Number:"+this.phoneNumber+"\n\tMail Address:"
				+this.mailAddress+"\n\nThe Courses student will take:\n";
		
		for (Course coursesToTake  : coursesToTake) {
			output+=coursesToTake.display();
		}
		
			
		int i=1;
		for (Erasmus erasmus : appliedPartners) {
			output+="\n"+(i++)+". Applied University Info:\n"+erasmus.display();
		}
		
		output+="\nStudent's Grant Info:\n"+grantGiven.display();
		
		output+="\nStudent's Accomodation Info:\n"+placeToStay.display();
		
		return output+"\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(mailAddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(mailAddress, other.mailAddress);
	}

	
	
}
