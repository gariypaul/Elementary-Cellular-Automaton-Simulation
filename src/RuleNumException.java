
public class RuleNumException extends Exception{

	
	private static final long serialVersionUID = 1L;
	/**
	 * Sets the exception message using a given range
	 * @param min minimum value of range
	 * @param max maximum value of range
	 */
	public RuleNumException(int min,int max){
	 super("ruleNum is outside the range [" + min +", "+ max+"].");
	}

}
