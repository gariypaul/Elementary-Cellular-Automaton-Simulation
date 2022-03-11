import java.io.FileNotFoundException;

public class ElementaryAutomaton extends Automaton {

	protected ElementaryAutomaton(int ruleNum, Generation initial) throws RuleNumException {
		super(ruleNum, initial);
	}
	
	protected ElementaryAutomaton(String filename) throws RuleNumException, FileNotFoundException{
		super(filename);
	}
	@Override
	protected Rule createRule(int ruleNum) throws RuleNumException {
		return new ElementaryRule(ruleNum);
	}

}
