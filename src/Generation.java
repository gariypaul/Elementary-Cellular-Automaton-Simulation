import java.util.Arrays;

public class Generation {
	private boolean[] cellStates= new boolean[1];
	/**
	 * Generates status array from specified boolean states
	 * @param states the states that are specified by user of method
	 */
	public Generation (boolean... states){
		if(states!=null&&states.length>0) {
			this.cellStates=Arrays.copyOf(states, states.length);
		}
		else{
			this.cellStates[0]=false;
		}
	}
	
	public Generation(boolean[] states, char trueSymbol) {
		
	}
	public boolean getState (int idx) {
		return false;//Fix mee
		
	}
	public boolean getStates() {
		return false;//Fix mee
		
	}
	public String getStates(char falseSymbol,char trueSymbol) {
		return null;//Fix mee
		
	}
	public int size() {
		return 0;//Fix mee
		
	}
}
