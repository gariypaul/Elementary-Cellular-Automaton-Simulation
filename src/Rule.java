import java.lang.Math;
/**
 * This is an abstract class for Rule Object subclasses
 * @author gariy
 *
 */
public abstract class Rule{
	private int ruleNum=0;
	
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
	/**
	 * This is an abstract method to get the neighborhood states to an index
	 * @param idx this is the index the neighborhood is to be found 
	 * @param gen this is the generation from which the states are got
	 * @return returns a boolean array of the states
	 */
	public abstract boolean[] getNeighborhood(int idx, Generation gen);
	/**
	 * This is an abstract method to change an index under a given rule with regards to its state and those of its neighbors
	 * @param neighborhood the states of the neighborhood in a boolean array
	 * @return returns the boolean state which the index should have after evolution
	 */
	public abstract boolean evolve (boolean[] neighborhood);
	/**
	 * This is an abstract method that returns a string representation of the elementary rule changes to a state
	 * @param falseSymbol this is the character to be used as the false state representation
	 * @param trueSymbol this is the character to be used as the true state representation
	 * @return returns the string representation of elementary rule
	 */
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
		for(int i=0,j=idx-radius;i<neighborhoodBool.length&&j<idx+radius+1;i++,j++) {
				int index =Math.floorMod(j, gen.size());
				neighborhoodBool[i]=gen.getState(index);
		}
		return neighborhoodBool;		
	} 
}
