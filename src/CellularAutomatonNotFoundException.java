/**
 * This is a CellularAutomatonNotFoundException when the when the CellularAutomaton specified in CellularAutomaton enum is unknown
 * @author gariy
 *
 */
public class CellularAutomatonNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	/**
	 * This is an exception thrown when the CellularAutomaton specified in CellularAutomaton enum is unknown
	 * @param s this is the unknown CellularAutomaton that is passed through CellularAutomaton enum
	 */
	public CellularAutomatonNotFoundException(String s) {
		super("Unknown cellular automaton type " + s);
	}
}
