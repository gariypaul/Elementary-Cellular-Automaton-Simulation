import java.util.Arrays;

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

	@Override
	public boolean evolve(boolean[] neighborhood) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String ruleTableString(char falseSymbol, char trueSymbol) {
		// TODO Auto-generated method stub
		return null;
	}

}
