import java.util.Arrays;
import java.util.StringJoiner;

public class ElementaryRule extends Rule{
	/**
	 * Constructor for new ElementaryRule Object
	 * @param ruleNum this is the rule number to be set
	 */
	protected ElementaryRule(int ruleNum) {
		super(ruleNum);
	}
	/**
	 * This method returns a boolean array with the state of the index specified and the neighbors to a radius one on the left and right
	 * @param  idx index of state to get neighborhood of
	 * @param  gen generation that contains the states to be used
	 * @return boolean array of neighborhood states
	 *
	 */
	@Override
	public boolean[] getNeighborhood(int idx, Generation gen) {
		return Arrays.copyOf(super.getNeighborhoodByRadius(idx, 1, gen),super.getNeighborhoodByRadius(idx, 1, gen).length);
	}
	/**
	 * Method to change an index under a given rule with regards to its state and those of its neighbors
	 * @param neighborhood the states of the neighborhood in a boolean array
	 * @return returns the boolean state which the index should have after evolution
	 */
	@Override
	public boolean evolve(boolean[] neighborhood) {
		//Initialize arrays to represent possible states
		boolean[] zero = {true,true,true};
		boolean[] one = {true, true, false};
		boolean[] two = {true, false, true};
		boolean[] three = {true, false, false};
		boolean[] four= {false, true, true};
		boolean[] five = {false, true, false};
		boolean[] six = {false, false, true};
		// boolean[] seven = {false,false,false};  not needed.
						
		// Initialize a string to represent the rule number in string binary
		String ruleNum = String.format("%8s", Integer.toBinaryString(super.getRuleNum())).replace(' ','0');
		// use string binary to generate a state array in generation object that will hold results for the states
		Generation generator = new Generation(ruleNum,'1');
						
		//return corresponding state to the rule number and neighborhood state
		if(Arrays.equals(neighborhood, zero)){
			return generator.getState(0);
		}
		else if(Arrays.equals(neighborhood, one)) {
			return generator.getState(1);
		}
		else if(Arrays.equals(neighborhood, two)){
			return generator.getState(2);
		}
		else if(Arrays.equals(neighborhood, three)) {
			return generator.getState(3);
		}
		else if(Arrays.equals(neighborhood, four)) {
			return generator.getState(4);
		}
		else if(Arrays.equals(neighborhood, five)){
			return generator.getState(5);
		}
		else if(Arrays.equals(neighborhood, six)){
			return generator.getState(6);
		}
		else {
			return generator.getState(7);
		}
	}
	/**
	 * This method returns a string representation of the elementary rule changes to a state
	 * @param falseSymbol this is the character to be used as the false state representation
	 * @param trueSymbol this is the character to be used as the true state representation
	 * @return returns the string representation of elementary rule
	 */
	@Override
	public String ruleTableString(char falseSymbol, char trueSymbol) {
		StringJoiner sj= new StringJoiner(" ");
		StringJoiner sj2 = new StringJoiner("   "," "," ");
		String ruleNum = String.format("%8s", Integer.toBinaryString(super.getRuleNum())).replace(' ','0');
		Generation generator = new Generation(ruleNum,'1');

		//add the eight possible states to string joiner
		sj.add(""+trueSymbol+trueSymbol+trueSymbol);
		sj.add(""+trueSymbol+trueSymbol+falseSymbol);
		sj.add(""+trueSymbol+falseSymbol+trueSymbol);
		sj.add(""+trueSymbol+falseSymbol+falseSymbol);
		sj.add(""+falseSymbol+trueSymbol+trueSymbol);
		sj.add(""+falseSymbol+trueSymbol+falseSymbol);
		sj.add(""+falseSymbol+falseSymbol+trueSymbol);
		sj.add(""+falseSymbol+falseSymbol+falseSymbol);
		
		//add the states to the other string joiner
		for(int i=0;i<8;i++) {
			if(generator.getState(i)==false){
				sj2.add(""+falseSymbol);
			}
			else {
				sj2.add(""+trueSymbol);
			}
		}
		return sj.toString()+System.lineSeparator()+sj2.toString();
	}
	
}
