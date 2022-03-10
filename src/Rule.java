
public abstract class Rule{
	private int ruleNum=0;
	/**
	 * Constructor method that initializes a rule object with the rule number as input
	 * @param ruleNum the rule number that the Rule object is constructed with
	 */
	protected Rule(int ruleNum) {
			this.ruleNum=ruleNum;
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
	/**
	 * Gets the neighborhood of a given index in the generation with a given radius e.g index of radius one [cellStates[idx-1], cellStates[idx], cellStates[idx+1]]
	 * @param idx this is the index that is the center of the neighborhood
	 * @param radius this is the number of indices that are to be found to the left and right of the given index
	 * @param gen this is the generation that contains the cell states 
	 * @return returns a boolean array that contains the given index state at the center and the neighboring cell states to the left and right
	 */
	public static boolean[] getNeighborhoodByRadius(int idx,int radius,Generation gen) {
		boolean[] neighborhoodBool = new boolean[1+(radius*2)];
		if(!(idx==0)&&idx!=gen.size()-1) {
			for(int i=0,j=idx-radius;i<neighborhoodBool.length&&j<idx+radius+1;i++,j++) {
				if(j<0) {
					neighborhoodBool[i]=gen.getState(gen.size()+j);
				}
				else if(j>=gen.size()) {
					neighborhoodBool[i]=gen.getState(j-gen.size());
				}
				else {
					neighborhoodBool[i]=gen.getState(j);
				}
				
			}
		}
		return neighborhoodBool;		
	} 
}
