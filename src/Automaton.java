import java.util.ArrayList;

public abstract class Automaton {
	private Rule rule;
	private ArrayList <Generation> generations= new ArrayList<Generation>();
	public char falseSymbol = '0';
	public char trueSymbol = '1';
	
	protected Automaton(int ruleNum, Generation initial) {
		createRule(ruleNum);
		generations.add(initial);
	}
	protected Automaton(String filename) {
		
	}
	public int evolve (int numSteps) {
		return numSteps;//fix mee
		
	}
	public Generation getGeneration(int stepNum) {
		return null;//fix mee
		
	}
	public int getRuleNum() {
		return 1;//fixmee
		
	}
	public int getTotalSteps() {
		return 0;//fix mee
	}
	public void saveEvolution() {
		
	}
	@Override
	public String toString() {
		return "Automaton";//fix mee
	}
	public String ruleTableString() {
		return "Automaton";//fix mee
	}
	protected abstract Rule createRule(int ruleNum);
	
	public static Automaton createAutomaton(CellularAutomaton ca, int ruleNum, Generation initial) {
		return null;//fix mee
		
	}
}
