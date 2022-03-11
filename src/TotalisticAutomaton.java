import java.io.FileNotFoundException;
/**
 * This is class for a TotalisticAutomaton object
 * @author gariy
 *
 */
public class TotalisticAutomaton extends Automaton {

	protected TotalisticAutomaton(int ruleNum, Generation initial) throws RuleNumException {
		super(ruleNum, initial);
	}
	protected TotalisticAutomaton(String filename) throws FileNotFoundException, RuleNumException {
		super(filename);
	}
	@Override
	protected Rule createRule(int ruleNum) throws RuleNumException {
		// TODO Auto-generated method stub
		return new TotalisticRule(ruleNum);
	}

}
