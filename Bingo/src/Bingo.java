import java.util.Random;

public class Bingo {
	protected static Random randGen;
    private String password = "";
    private boolean isOpen;
    private LockBox toPick;
    private int passwordLength;
    
	 public Bingo(int passwordLength){
	    	
//	    	//initialize the static random number generator
//	    	randGen = new Random();
////	    	String password = "";
//	    	//set exception if the length of password is negative or zero
//	    	if(passwordLength <= 0) {
//	    		throw new IllegalArgumentException("Invalid password length");
//	    	}else {
//	    		for(int i = 0; i < passwordLength; i++) {
//	    			
//	    			password = randGen.nextInt(10) + password;
//	    		}
		 	this.passwordLength = passwordLength;
	    	toPick = new LockBox(passwordLength);
	    	
	    	toPick.authenticate(toPick.hackMe());
	    	
	    	System.out.println(toPick.isOpen());
//	    	System.out.println(randGen.nextInt(10));
	    	System.out.println(toPick.isOpen() != true);
//	    	this.password = password;
	    }
	 
	    /** Complexity: O(N^2) */
	    public void bruteForce() {
	    	toPick.reset();
	    	int n = 0;
	    	while(toPick.isOpen() == false) {
	    		toPick.authenticate(generateGuess(n));
	    		n++;
	    		if(n>10000)break;
//	    		System.out.println(toPick.isOpen());
	    		System.out.println(toPick.hackMe());
	    		System.out.println(n);
	    	}
//	    	System.out.println(n);
//	    	System.out.println(toPick.hackMe());
//	    	isOpen = true;
	    }
	    
	    /** Complexity: O(N) */
	    public String generateGuess(int count) {
	    	
	    	String guess = count + "";
	    	
	    	if( guess.length() > passwordLength) {
	    		guess = guess.substring(guess.length()-passwordLength);
	    	}else {
	    		for(int i = guess.length(); i < passwordLength; i++) {
	    			guess = "0" + guess;
	    		}
	    	}
			return guess;	
	    }
	    public static long timeBruteForce(PasswordHacker ph) {
			
			long beforeTime = System.currentTimeMillis();
			
			ph.bruteForce();
			
			long afterTime = System.currentTimeMillis();
			
			return afterTime - beforeTime;
		}
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Random randGen = new Random();
//		String password = "";
////		System.out.println(randGen.nextInt(10));
//		for(int i = 0; i < 4; i++) {
//			password = (randGen.nextInt(100)% 10) + password;
//		}
		Bingo a = new Bingo(4);
		Bingo b = new Bingo(4);
		
		a.bruteForce();
		
//		System.out.println(isOpen);
	}

}
