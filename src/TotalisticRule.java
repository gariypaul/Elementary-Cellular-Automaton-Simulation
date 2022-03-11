import java.util.Arrays;
import java.util.StringJoiner;

public class TotalisticRule extends Rule {
	
	protected TotalisticRule(int ruleNum) throws RuleNumException {
		super(ruleNum);
		if(ruleNum<0||ruleNum>63) {
			throw new RuleNumException(0, 63);
		}
	}
	/**
	 * Gets the neighborhood states of an index to radius of 2 states to the left and right
	 * @param idx this is the index to get the neighbors of
	 * @param gen this is the generation to get the states from 
	 * @return this is the boolean array containing the neighborhood states including the state at index idx
	 */
	@Override
	public boolean[] getNeighborhood(int idx, Generation gen) {
		return Arrays.copyOf(super.getNeighborhoodByRadius(idx, 2, gen), super.getNeighborhoodByRadius(idx, 2, gen).length);
	}
	/**
	 * Method to change an index under a given rule with regards to its state and those of its neighbors
	 * @param neighborhood the states of the neighborhood in a boolean array
	 * @return returns the boolean state which the index should have after evolution
	 */
	@Override
	public boolean evolve(boolean[] neighborhood) {
		int numberTrue = 0;
		for(int i=0;i<neighborhood.length;i++) {
			if(neighborhood[i]==true) {
				numberTrue++;
			}
		}
		String ruleNum = String.format("%6s", Integer.toBinaryString(super.getRuleNum())).replace(' ','0');
		Generation generator = new Generation(ruleNum,'1');
		if(numberTrue==5){
			return generator.getState(0);
		}
		else if (numberTrue==4){
			return generator.getState(1);
		}
		else if(numberTrue==3) {
			return generator.getState(2);
		}
		else if(numberTrue==2) {
			return generator.getState(3);
		}
		else if(numberTrue==1) {
			return generator.getState(4);
		}
		else {
			return generator.getState(5);
		}
	}
	/**
	 * This method returns the rule table for the set rule in String format
	 * @param falseSymbol this is the character to be used in place of a false state
	 * @param trueSymbol this is the character to be used in place of a true state
	 * @return returns string form of the rule table
	 */
	@Override
	public String ruleTableString(char falseSymbol, char trueSymbol) {
		StringJoiner sj = new StringJoiner(" ");
		String rules = "5 4 3 2 1 0";
		String ruleNum = String.format("%6s", Integer.toBinaryString(super.getRuleNum())).replace(' ','0');
		Generation generator = new Generation(ruleNum,'1');
		for(int i=0;i<generator.size();i++) {
			if(generator.getState(i)==true) {
				sj.add(""+trueSymbol);
			}
			else {
				sj.add(""+falseSymbol);
			}
		}
		return rules+System.lineSeparator()+sj.toString();
	}

}
