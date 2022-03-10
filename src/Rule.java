
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
	
	/**
	 * Returns the current RuleNum
	 * @return returns the integer form of the rule number
	 */
	public int getRuleNum() {
		return this.ruleNum;
	}
	
	public abstract boolean[] getNeighborhood(int idx, Generation gen);
	
	public abstract boolean evolve (boolean[] neighborhood);
	
	public abstract String ruleTableString(char falseSymbol, char trueSymbol);

	
	/**
	 * This method evolves a generation and generates a new Generation object with an evolved state array
	 * @param gen this is a Generation passed as an argument to be evolved
	 * @return this is the new Generation object that is evolved
	 */
	public Generation evolve(Generation gen){
		boolean[] states = new boolean [gen.size()];
		for(int i=0;i<gen.size();i++){
			boolean[] neighborhood = getNeighborhood(i,gen);
			states[i]=evolve(neighborhood);
		}
		Generation newGen = new Generation(states);
		return newGen;
	}
	
	public static boolean[] getNeighborhoodByRadius(int idx,int radius,Generation gen) {
		return null;//fix mee
		
	} 
}
