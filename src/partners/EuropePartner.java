package partners;

public class EuropePartner extends Erasmus{

	private int universityCapacity;
	private boolean isHaveDormitory;
	private String language;
	private int countryGroup;
	private int currentStudents=0;//In further updates, accepted students of that semester can be counted and the method isAvailable become meaningful
	
	public EuropePartner(String country, String universityName, int universityCapacity, boolean isHaveDormitory, String language, int countryGroup){
		
		super(country,universityName);
		this.universityCapacity = universityCapacity;
		this.isHaveDormitory = isHaveDormitory;
		this.language = language;
		this.countryGroup = countryGroup;
	}
	
	@Override
	public String display() {
		return super.display()+"\n\tCapacity of University:"+this.universityCapacity+
				"\n\tDoes University has Dormitory:"+this.isHaveDormitory+"\n\tThe Language of University:"+this.language+
				"\n\tWhich Group of the Country:"+this.countryGroup+"\n";
	}
	
	@Override
	public boolean isAvailable() {
		if(this.universityCapacity>this.currentStudents)
			return true;
		else
			return false;
	}
	
}