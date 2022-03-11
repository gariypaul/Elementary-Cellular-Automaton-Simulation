import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Automaton {
	private Rule rule;
	private ArrayList <Generation> generations= new ArrayList<Generation>();
	public char falseSymbol = '0';
	public char trueSymbol = '1';
	
	protected Automaton(int ruleNum, Generation initial) {
		createRule(ruleNum);
		generations.add(initial);
	}
	protected Automaton(String filename) throws FileNotFoundException {
		//scanning file to construct the Automation with
		Scanner scnr = new Scanner(new File(filename));
		int ruleNum = scnr.nextInt();
		this.falseSymbol=scnr.next().charAt(0);
		this.trueSymbol=scnr.next().charAt(0);
		String states = scnr.next();
		scnr.close();
		
		//initializing values and generation 
		createRule(ruleNum);
		Generation gen = new Generation(states,this.trueSymbol);
		generations.add(gen);
	}
	/**
	 * This method evolves the Automaton for a specific number of steps
	 * @param numSteps this is the number of steps that the Automaton is to be evolved by
	 * @return returns the number of steps that the Automaton has been evolved for
	 */
	public int evolve (int numSteps) {
		int stepsDone =0;
		if (!(numSteps<=0)){
			while(numSteps!=stepsDone){
				generations.add(rule.evolve(getCurrentGeneration()));
				stepsDone++;
			}
		}
		return stepsDone;
		
	}
	/**
	 * This method gets and returns the current method
	 * @return returns the last method in the Automaton
	 */
	public Generation getCurrentGeneration() {
		return generations.get(generations.size()-1);
	}
	/**
	 * This method gets the Generation that was evolved at a certain step number in the Automaton
	 * @param stepNum this is the step number to be acquired
	 * @return this is the Generation that was evolved at the specified step number
	 */
	public Generation getGeneration(int stepNum) {
		if(stepNum>generations.size()) {
			evolve((stepNum+1)-generations.size());
		}
			
		return generations.get(stepNum);
		
	}
	/**
	 * This gets the rule number of the Automaton
	 * @return this is the Rule number of the Automaton
	 */
	public int getRuleNum() {
		return this.rule.getRuleNum();		
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
