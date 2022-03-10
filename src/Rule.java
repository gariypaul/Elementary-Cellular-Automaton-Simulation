
public abstract class Rule{
	private int ruleNum;
	
	protected Rule(int ruleNum) {
		// TODO Auto-generated constructor stub
	}
	public int getRuleNum() {
		return ruleNum;//complete mee
	}
	public abstract boolean[] getNeighborhood(int idx, Generation gen);
	
	public boolean evolve (boolean[] neighborhood) {
		return false;//fix mee
	}
	public Generation evolve(Generation gen) {
		return gen;//fix me
		
	} 
	public String ruleTableString(char falseSymbol, char trueSymbol) {
		return "rule";//fix mee
	}
	public static boolean[] getNeighborhoodByRadius(int idx,int radius,Generation gen) {
		return null;//fix mee
		
	} 
}
