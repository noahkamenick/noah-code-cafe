package cs145.lab7;

//!!!!! Don't Put In Actual Social Security Number !!!!!!!

public class SocSecException extends Exception {

	public SocSecException() {
		
		super("Invalid Social Security Number");
		
	}
	
	public SocSecException(String message) {
		super("Invalid Social Security Number, " + message);
		
	}


}
