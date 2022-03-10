
public abstract class Rule{
	private int ruleNum=0;
	/**
	 * Constructor method that initializes a rule object with the rule number as input
	 * @param ruleNum the rule number that the Rule object is constructed with
	 */
	protected Rule(int ruleNum) {
		//check if ruleNum is within rule number bounds otherwise set it to closes rule number
		if(ruleNum>=0&&ruleNum<=255){ 
			this.ruleNum=ruleNum;
		}
		else if(ruleNum<0) {
			this.ruleNum=0;
		}
		else {
			this.ruleNum=255;
		}
	}
	public int getRuleNum() {
		return ruleNum;//complete mee
	}
	public abstract boolean[] getNeighborhood(int idx, Generation gen);
	
	public abstract boolean evolve (boolean[] neighborhood);
	
	public Generation evolve(Generation gen) {
		return gen;//fix me
		
	} 
	public abstract String ruleTableString(char falseSymbol, char trueSymbol);

	public static boolean[] getNeighborhoodByRadius(int idx,int radius,Generation gen) {
		return null;//fix mee
		
	} 
}
