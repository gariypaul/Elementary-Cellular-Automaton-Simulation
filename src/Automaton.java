import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public abstract class Automaton {
	private Rule rule;
	private ArrayList <Generation> generations= new ArrayList<Generation>();
	public char falseSymbol = '0';
	public char trueSymbol = '1';
	
	protected Automaton(int ruleNum, Generation initial) {
		rule = createRule(ruleNum);
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
	/**
	 * This method returns the total number of steps that have been taken to evolve the Automaton
	 * @return this is the integer value of the total number of steps that have been taken to evolve the Automaton
	 */
	public int getTotalSteps() {
		return (generations.size()-1);
	}
	/**
	 * This method saves the String format of the Automaton in a specified file
	 * @param fileName this is the name of the file to be written
	 */
	public void saveEvolution(String fileName) throws IOException{
		FileWriter writer = new FileWriter(new File(fileName));
		writer.write(toString());
		writer.close();
	}
	/**
	 * This method return the String format of the Automaton
	 * @return this is the String format of the Automaton
	 */
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(System.lineSeparator());
		for(int i=0; i<generations.size();i++) {
			sj.add(generations.get(i).getStates(this.falseSymbol,this.trueSymbol));
		}
		return sj.toString();
	}
	/**
	 * This method returns a string representation of the table that depicts the rule governing the automaton.
	 * @return this is the String representation of the rule table.
	 */
	public String ruleTableString() {
		return rule.ruleTableString(falseSymbol, trueSymbol);
	}
	
	protected abstract Rule createRule(int ruleNum);
	/**
	 * This method creates an Automaton that corresponds to the type of CellularAutomaton that is provided (Elementary(ECA) or Totalistic(TCA))
	 * @param ca this is the type of CellularAutomaton that is to be created
	 * @param ruleNum this is the rule number to be used in the Automaton
	 * @param initial this is the initial Generation in the Automaton
	 * @return this is the Automaton that is created
	 */
	public static Automaton createAutomaton(CellularAutomaton ca, int ruleNum, Generation initial) {
		Automaton automaton;
		if(ca.equals(CellularAutomaton.ECA)){
			automaton = new ElementaryAutomaton(ruleNum,initial);
		}
		else {
			automaton = new TotalisticAutomaton(ruleNum,initial);
		}
		return automaton;
		
	}
}
