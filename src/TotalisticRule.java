
public class TotalisticRule extends Rule {

	protected TotalisticRule(int ruleNum) throws RuleNumException {
		super(ruleNum);
		if(ruleNum<0||ruleNum>63) {
			throw new RuleNumException(0, 63);
		}
	}

	@Override
	public boolean[] getNeighborhood(int idx, Generation gen) {
		// TODO Auto-generated method stub
		return null;
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
