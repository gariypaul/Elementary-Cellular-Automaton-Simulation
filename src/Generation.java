import java.util.Arrays;
//Code copied from Project one Implementation
/**
 * This is the class for the Generation object
 * @author gariy
 *
 */
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
	/**
	 * Returns array of states
	 * @return array that contains the boolean states 
	 */
	public boolean[] getStates() {
		return Arrays.copyOf(this.cellStates, this.cellStates.length);
		
	}
	/**
	 * Returns string of states with specified characters to represent boolean states 
	 * @param falseSymbol input to represent boolean false in string
	 * @param trueSymbol input to represent boolean true in string
	 * @return string returned with specified boolean states representative chars
	 */
	public String getStates(char falseSymbol, char trueSymbol) {
		String cellStates="";
		for(int i=0; i<this.cellStates.length; ++i){
			
			if(this.cellStates[i]==true){
				cellStates= cellStates+Character.toString(trueSymbol);
			}
			else{
				cellStates = cellStates+Character.toString(falseSymbol);
			}
		}
		return cellStates;
	}

	/**
	 * Returns size of the states array
	 * @return returns an integer number that is the length of the states array
	 */
	public int size(){
		return this.cellStates.length;
	}

}
