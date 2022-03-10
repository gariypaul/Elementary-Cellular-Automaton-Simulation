import java.util.Arrays;

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
	 */
	@Override
	public boolean[] getNeighborhood(int idx, Generation gen) {
		return Arrays.copyOf(super.getNeighborhoodByRadius(idx, 1, gen),super.getNeighborhoodByRadius(idx, 1, gen).length);
	}
	
	@Override
	public boolean evolve(boolean[] neighborhood) {
		
		return false;
	}

	@Override
	public String ruleTableString(char falseSymbol, char trueSymbol) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
