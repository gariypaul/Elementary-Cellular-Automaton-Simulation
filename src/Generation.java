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
	
	/**
	 * Generates status array from specified string with defined symbol to represent true
	 * @param states string with the status 
	 * @param trueSymbol symbol in the string that represents true
	 */
	public Generation (String states, char trueSymbol){
		if(!(states==null)){
			if (states.equals("")) {
				boolean[] init = new boolean[states.length()+1];
				this.cellStates=Arrays.copyOf(init, init.length);
			}
			else {
				boolean[] init = new boolean[states.length()];
				this.cellStates=Arrays.copyOf(init, init.length);
			}
			for(int i=0;i<states.length();i++){
				if(states.charAt(i)==trueSymbol){
					this.cellStates[i]=true;
				}
				else{
					this.cellStates[i]=false;
				}
			}
			
		}
		else {
			
			this.cellStates[0]=false;
		}
			
	}
	
	/**
	 * Gets a state at a specified index
	 * @param idx specified index
	 * @return state returned in boolean form 
	 */
	public boolean getState(int idx) {
		
		return this.cellStates[idx];
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
