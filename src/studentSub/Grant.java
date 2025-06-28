package studentSub;

import interfaceClasses.DisplayInterface;

public class Grant implements DisplayInterface{
	private boolean isTakeGrant;
	private double grantAmount;
	private double transportationHelp;
	
	public Grant(boolean isTakeGrant,double grantAmount,double transportationHelp) {
		this.grantAmount=grantAmount;
		this.isTakeGrant=isTakeGrant;
		this.transportationHelp=transportationHelp;
	}

	@Override
	public String display() {
		String output="";
		
		if(this.isTakeGrant) {
			output="\tGrant Amount:"+this.grantAmount+"\n\tTransportation Help Amount:"+this.transportationHelp+"\n";
		}
		else {
			output="The student is not taking any grant!\n";
		}
		
		return output;
	}
	
	

}
