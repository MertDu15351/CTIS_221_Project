package partners;

import interfaceClasses.DisplayInterface;

public  abstract class Erasmus implements DisplayInterface{
	private String country;
	private String partnerName;
	
	public Erasmus(String country, String name){
		this.country=country;
		this.partnerName=name;
	}
	
	public String display() {
		return "\tCountry of Partner:"+this.country+"\n\tName of Partner:"+this.partnerName;
	}
	
	public String getPartnerName() {
		return partnerName;
	}

	public abstract boolean isAvailable();
}
