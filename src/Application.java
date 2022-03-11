/**
 * Application class generates CellularAutomation and evolves the Automation for a specified number of steps
 * @author gariy
 *
 */
public class Application {

	private static final int NUM_EXPECTED_ARGS = 6;

	private static final int IDX_CA = 0;
	private static final int IDX_RULE_NUM = 1;
	private static final int IDX_FALSE_SYMBOL = 2;
	private static final int IDX_TRUE_SYMBOL = 3;
	private static final int IDX_INITIAL_GENERATION = 4;
	private static final int IDX_NUM_EVOLVE = 5;

	private static final String ARG_NAMES = "ca rule-num false-symbol true-symbol initial-generation num-evolutions";
	
	// Source and class file names must match, so Application can be hard-coded
	private static final String USAGE_FMT_STRING_CLASS = "Usage: java Application " + ARG_NAMES;

	// The jar file may be renamed, so this will be varied
	private static final String USAGE_FMT_STRING_JAR = "Usage: java -jar %s " + ARG_NAMES;

	private String[] appArgs;
	/**
	 * This is a constructor to initialize the Application
	 * @param args these are the arguments to be passed into the application
	 */
	public Application(String[] args)  {
		validateNumArgs(args);
		appArgs=args;
	}

	private void validateNumArgs(String[] args) {
		if(args.length!=Application.NUM_EXPECTED_ARGS) {
			throwRuntimeExceptionWithUsageMessage();
		}
	}

	private void throwRuntimeExceptionWithUsageMessage() {
		// Implementation provided
		if (runningAsJar()) {
			// Get the path to the executing file
			String path = Application.class
					.getProtectionDomain()
					.getCodeSource()
					.getLocation()
					.getPath();
			// Only take path after last slash (to get file name).
			// A hard-coded slash is fine since Java URLs use /
			String file = path.substring(path.lastIndexOf("/") + 1);
			throw new RuntimeException(String.format(USAGE_FMT_STRING_JAR, file));
		} else {
			throw new RuntimeException(String.format(USAGE_FMT_STRING_CLASS));
		}
	}

	private boolean runningAsJar() {
		// Implementation provided
		return Application.class
				.getResource("Application.class")
				.toString()
				.startsWith("jar");
	}

	private void parseArgs(String[] args){
		try {
			
			String cellularautomaton = args[0];
			CellularAutomaton ca = CellularAutomaton.parse(cellularautomaton);
			String states = args[4];
			char trueSymbol = args[3].charAt(0);
			char falseSymbol = args[2].charAt(0);
			int numEvolutions = Integer.parseInt(args[5]);
			int ruleNum = Integer.parseInt(args[1]);
			
		
		Generation AppGen = new Generation(states,trueSymbol);
		
		
			Automaton automaton;
			automaton = Automaton.createAutomaton(ca, ruleNum, AppGen);
			automaton.falseSymbol=falseSymbol;
			automaton.trueSymbol=trueSymbol;
			automaton.evolve(numEvolutions);
			System.out.println(automaton.toString());
		} catch (RuntimeException | RuleNumException | CellularAutomatonNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	/**
	 * This method runs the application using the arguments passed through Application
	 */
	public void run() {
		parseArgs(appArgs);
	}
	/**
	 * This is the main method to Application class
	 * @param args these are the arguments to be passed through to the Application
	 */
	public static void main(String[] args) {
		try{
			Application mainApp = new Application(args);
			mainApp.run();
		}
		catch(RuntimeException e){
			System.err.println(e.getMessage());
		}
		
	}
}
