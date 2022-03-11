
public enum CellularAutomaton {

	ECA,
	TCA;
	/**
	 * This returns the type of CellularAtomaton that is to be used to generate an Automaton object
	 * @param s this contains the type of Automaton i.e "ECA" or "TCA"
	 * @return it returns the type of Automaton to be used
	 * @throws CellularAutomatonNotFoundException this is thrown when the CellularAutomaton is not either "ECA" or "TCA"
	 */
	public static CellularAutomaton parse(String s) throws CellularAutomatonNotFoundException {
		if (s.equalsIgnoreCase("ECA")) { 
			return ECA;
		}
		else if (s.equalsIgnoreCase("TCA")) {
			return TCA;
		}
		else {
			throw new CellularAutomatonNotFoundException(s);
		}
	}
}
