package studentSub;

import interfaceClasses.DisplayInterface;

public class Accomodation implements DisplayInterface{
	private String place;
	private double rent;
	
	public Accomodation(String place,double rent) {
		this.place=place;
		this.rent=rent;
	}
	
	@Override
	public String display() {
		return "\tPlace To Stay:"+this.place+"\n\tRent of the Place:"+this.rent+"\n";
	}

	
}
