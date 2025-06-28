package partners;

public class Internship extends Erasmus{

	private boolean isInsurance;
	private int countryGroup;
	
	
	public Internship(String country, String companyName, boolean isInsurance, int countryGroup){
		
		super(country,companyName);
		this.isInsurance = isInsurance;
		this.countryGroup = countryGroup;
	}
	
	@Override
	public String display() {
		return super.display()+"\n\tIs Internship has Insurance:"+this.isInsurance+
				"\n\tWhich Group of the Country:"+this.countryGroup+"\n";
	}
	
	@Override
	public boolean isAvailable() {
		return this.isInsurance;
	}
}
