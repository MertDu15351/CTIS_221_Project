package studentSub;
import java.io.*;
import java.util.*;

import partners.*;
import Comparator.*;
public class StudentSys {
	private static int studentApplied=0;
	private static int eligibleStudents=0;
	private static Set<Student> students = new LinkedHashSet<Student>();
	private static ArrayList<Erasmus> partnersList = new ArrayList<Erasmus>();
	private static Set<Student> sorted = new TreeSet<Student>();
	
	//Fill the partners ArrayList. It will be used as database of partner universities
	public static void initializePartners() throws FileNotFoundException {
		
		File fp = new File("erasmus.txt");
		Scanner sc = new Scanner(fp);
		if(!fp.exists())
			System.out.println("File can not be found!!");
		else
		{
			Scanner input = null;
			String[] all, takenCourses;
			EuropePartner ep;
			while(sc.hasNextLine()) {
				all = sc.nextLine().split("\\*");
				boolean temp;
				if(all[3].equalsIgnoreCase("true"))
					 temp=true;
				else
					 temp=false;
				ep = new EuropePartner(all[0], all[1], Integer.parseInt(all[2]), temp,all[4],Integer.parseInt(all[5]));
				partnersList.add(ep);
			}
				
		}
	
		
	}
	
	public static ArrayList<Erasmus> getPartnersList() {
		return partnersList;
	}

	public static boolean checkId(String id) {
		for (Student student : students) {
			if(student.getStuID().equalsIgnoreCase(id))
				return true;
		}
		return false;
	}
	
	public static boolean addStudent(Student stu) {
		if(!students.contains(stu)) {
			students.add(stu);
			studentApplied++;
			if(stu.getErasmusScore()!=-1)
				eligibleStudents++;
			return true;
		}
		return false;
	}
	public static Student searchStu(String id) {
		Student search=null;
		
		for (Student student : students) {
			if(student.getStuID().equalsIgnoreCase(id)) {
				search=student;
			}
		}
		return search;
	}
	
	public static String displayAll() {
		String res="";
		int i=0;
	
		for (Student student : students) {
			if(student.getErasmusScore()==-1)
				res+=((i++)+1)+". Student's application is not valid since s/he's cgpa is under 2.5!!!\n";
			else
				res+=((i++)+1)+". Student's Infos:"+student.display()+"\n";
				
		}
		
		return res;
	}
	
	
	public static boolean deleteStu(String id) {
		
		for (Student student : students) {
			if(student.getStuID().equalsIgnoreCase(id)) {
				students.remove(student);
				studentApplied--;
				return true;
			}
		}
		
		return false;
	}

	public static Set<Student> getStudents() {
		return students;
	}
	
	public static String sortStu() {
		
		TreeSet<Student> sortedErasmusScore = new TreeSet(new ComparatorErasmusScore());
		sortedErasmusScore.addAll(students);
		
		String output="";
		
		for (Student student:students) {
			if(student.getErasmusScore()!=-1)
				output+="Name Surname:"+student.getNameSurname()+" Erasmus Score:"+student.getErasmusScore()+"\n";
		}
		
		return output;
		
	}
	
	public static int getStudentApplied() {
		return studentApplied;
	}
	
	public static String[] getPartner() {
		int i = 0;
		String[] partnerName = new String[partnersList.size()];
		for (Erasmus partners : partnersList) {
			partnerName[i] = partners.getPartnerName() + "";
			i++;
		}
		
		return partnerName;
	}

	public static int getEligibleStudents() {
		return eligibleStudents;
	}
	
}
