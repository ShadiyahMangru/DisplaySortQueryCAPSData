import java.util.*;
import java.io.*;

///////////////////////////////////////////////////////////////////////////////////////////////////
class HockeyPlayer{
	//fields
	private String lastName;
	private String position;
	private String birthplace;
	private final String[] HPVARS = {"Name", "Position", "Birthplace"};
	
	//constructors
	public HockeyPlayer(String lastName, String position, String birthplace){
		this.lastName = lastName;
		this.position = position;
		this.birthplace = birthplace;
	}
	
	public HockeyPlayer(HockeyPlayer hp){
		this(hp.lastName, hp.position, hp.birthplace);
	}
	
	//setters
	public void setLastName(String lastName){
		this.lastName = lastName;	
	}
	
	public void setPosition(String position){
		this.position = position;	
	}
	
	public void setBirthplace(String birthplace){
		this.birthplace = birthplace;	
	}
	
	//getters
	public String getLastName(){
		return lastName;	
	}
	
	public String getPosition(){
		return position;	
	}
	
	public String getBirthplace(){
		return birthplace;	
	}
	
	public String[] getHPVARS(){
		return HPVARS;	
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////
class Goalies extends HockeyPlayer implements Comparable<Goalies>{
	//fields 
	private int shotsAgainst;
	private int goalsAgainst;
	private int saves;
	private final String[] GOALIEVARS = {"Shots Against", "Goals Against", "Saves"};
	private ArrayList<Goalies> goaliesRoster;
	private ArrayList<String> queryGoaliesBP;
	private static int sortGoaliesBy;
	
	//constructors
	public Goalies(){
		super(" ", " ", " ");
		setGoaliesRoster();	
		setQueryGoaliesBP();
	}
	
	public Goalies(int sortGoaliesBy){
		super(" ", " ", " ");
		setGoaliesRoster();
		this.sortGoaliesBy = sortGoaliesBy;
	}
	
	public Goalies(String lastName, String position, String birthplace, int shotsAgainst, int goalsAgainst, int saves){
		super(lastName, position, birthplace);
		this.shotsAgainst = shotsAgainst;
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;
	}
	
	public Goalies(HockeyPlayer hp, int shotsAgainst, int goalsAgainst, int saves){
		super(hp);
		this.shotsAgainst = shotsAgainst;
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;	
	}
	
	public Goalies(Goalies goalie){
		this(goalie.getLastName(), goalie.getPosition(), goalie.getBirthplace(), goalie.shotsAgainst, goalie.goalsAgainst, goalie.saves);	
	}
	
	/**
	* a method that defines how to sort Goalies numerically by a stat
	* @param Player the player to which we are comparing
	*/
	@Override
    	public int compareTo(Goalies other) {
    	switch(sortGoaliesBy){
    	case 1:
    		if (this.getShotsAgainst() < other.getShotsAgainst()) {
    			return -1;
    		}
    		if (this.getShotsAgainst() == other.getShotsAgainst()) { 
    			return 0;
    		}
    		break;
   	case 2:
    		if (this.getGoalsAgainst() < other.getGoalsAgainst()) {
    			return -1;
    		}
    		if (this.getGoalsAgainst() == other.getGoalsAgainst()) { 
    			return 0;
    		}
    		break;
    	case 3:
    		if (this.getSaves() < other.getSaves()) {
    			return -1;
    		}
    		if (this.getSaves() == other.getSaves()) { 
    			return 0;
    		}
    		break;
    	}
    	return 1;
    	}
	
	//setters
	public void setShotsAgainst(int shotsAgainst){
		this.shotsAgainst = shotsAgainst;	
	}
	
	public void setGoalsAgainst(int goalsAgainst){
		this.goalsAgainst = goalsAgainst;	
	}
	
	public void setSaves(int saves){
		this.saves = saves;	
	}
	
	public void setGoaliesRoster(){
		goaliesRoster = new ArrayList<Goalies>();
		goaliesRoster.add(new Goalies("Holtby", "Goalie", "Canada", 1648, 153, 1495));
		goaliesRoster.add(new Goalies("Grubauer", "Goalie", "Germany", 953, 73, 880));
	}
	
	public void setQueryGoaliesBP(){
		queryGoaliesBP = new ArrayList<String>();
		queryGoaliesBP.add(getGoaliesRoster().get(0).getBirthplace());
		for(int i = 1; i< getGoaliesRoster().size(); i++){
			if(queryGoaliesBP.contains(getGoaliesRoster().get(i).getBirthplace()) == false){
				queryGoaliesBP.add(getGoaliesRoster().get(i).getBirthplace());	
			}
		}
	}
	
	//getters
	public int getShotsAgainst(){
		return shotsAgainst;	
	}
	
	public int getGoalsAgainst(){
		return goalsAgainst;	
	}
	
	public int getSaves(){
		return saves;	
	}
	
	public String[] getGOALIEVARS(){
		return GOALIEVARS;	
	}
	
	public ArrayList<Goalies> getGoaliesRoster(){
		return goaliesRoster;	
	}
	
	public ArrayList<String> getQueryGoaliesBP(){
		return queryGoaliesBP;	
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////
class Skaters extends HockeyPlayer implements Comparable<Skaters>{
	//fields
	private int goals;
	private int assists;
	private int points;
	private int plusMinus;
	private String shoots;
	private final String[] SKATERVARS = {"Goals", "Assists", "Points", "+/-", "Shoots"};
	private ArrayList<Skaters> skatersRoster;
	private ArrayList<String> querySkatersBP;
	private static int sortSkatersBy;
	
	//constructors
	public Skaters(){
		super(" ", " ", " ");	
		skatersRoster = new ArrayList<Skaters>();
		//setQuerySkatersBP();
	}
	
	public Skaters(int sortSkatersBy){
		super(" ", " ", " ");
		skatersRoster = new ArrayList<Skaters>();
		this.sortSkatersBy = sortSkatersBy;
	}
	
	public Skaters(String lastName, String position, String birthplace, int goals, int assists, int points, int plusMinus, String shoots){
		super(lastName, position, birthplace);
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.plusMinus = plusMinus;
	}
	
	public Skaters(HockeyPlayer hp, int goals, int assists, int points, int plusMinus, String shoots){
		super(hp);
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.plusMinus = plusMinus;
		this.shoots = shoots;
	}
	
	public Skaters(Skaters skater){
		this(skater.getLastName(), skater.getPosition(), skater.getBirthplace(), skater.goals, skater.assists, skater.points, skater.plusMinus, skater.shoots);	
	}
	
	/**
	* a method that defines how to sort Skaters numerically by a stat
	* @param Player the player to which we are comparing
	*/
	@Override
    	public int compareTo(Skaters other) {
    	switch(sortSkatersBy){
    	case 1:
    		if (this.getPoints() < other.getPoints()) {
    			return -1;
    		}
    		if (this.getPoints() == other.getPoints()) { 
    			return 0;
    		}
    		break;
   	case 2:
    		if (this.getGoals() < other.getGoals()) {
    			return -1;
    		}
    		if (this.getGoals() == other.getGoals()) { 
    			return 0;
    		}
    		break;
    	case 3:
    		if (this.getAssists() < other.getAssists()) {
    			return -1;
    		}
    		if (this.getAssists() == other.getAssists()) { 
    			return 0;
    		}
    		break;
    	case 4:
    		if (this.getPlusMinus() < other.getPlusMinus()) {
    			return -1;
    		}
    		if (this.getPlusMinus() == other.getPlusMinus()) { 
    			return 0;
    		}
    		break;
    	}
    	return 1;
    	}
	
	//setters
	public void setGoals(int goals){
		this.goals = goals;
	}
	
	public void setAssists(int assists){
		this.assists = assists;	
	}
	
	public void setPoints(int points){
		this.points = points;	
	}
	
	public void setPoints(int goals, int assists){
		points = goals + assists;	
	}
	
	public void setPoints(){
		points = goals + assists;	
	}
	
	public void setPlusMinus(int plusMinus){
		this.plusMinus = plusMinus;	
	}
	
	public void setShoots(String shoots){
		this.shoots = shoots;
	}
	
	public void setSkatersRoster(ArrayList<Skaters> s){
		skatersRoster.addAll(s);
	}
	
	public void setQuerySkatersBP(){
		querySkatersBP = new ArrayList<String>();
		querySkatersBP.add(getSkatersRoster().get(0).getBirthplace());
		for(int i = 1; i< getSkatersRoster().size(); i++){
			if(querySkatersBP.contains(getSkatersRoster().get(i).getBirthplace()) == false){
				querySkatersBP.add(getSkatersRoster().get(i).getBirthplace());	
			}
		}
	}
	
	//getters
	public int getGoals(){
		return goals;	
	}
	
	public int getAssists(){
		return assists;
	}	
	
	public int getPoints(){
		return points;	
	}
	
	public int getPlusMinus(){
		return plusMinus;	
	}
	
	public String getShoots(){
		return shoots;	
	}
	
	public String[] getSKATERVARS(){
		return SKATERVARS;	
	}
	
	public ArrayList<Skaters> getSkatersRoster(){
		return skatersRoster;	
	}
	
	public ArrayList<String> getQuerySkatersBP(){
		return querySkatersBP;	
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////
class Defense extends Skaters{
	//fields
	private ArrayList<Skaters> defenseRoster;
	private ArrayList<String> queryDefenseBP;
	
	//constructors
	public Defense(){
		setDefenseRoster();
		setSkatersRoster(defenseRoster);
		setQuerySkatersBP();
		setQueryDefenseBP();
	}
	
	public Defense(String lastName, String position, String birthplace, int goals, int assists, int points, int plusMinus, String shoots){
		super(lastName, position, birthplace, goals, assists, points, plusMinus, shoots);
	}
	
	public Defense(Skaters skater){
		super(skater);	
	}
	
	//setters
	public void setDefenseRoster(){
		defenseRoster = new ArrayList<Skaters>();
		defenseRoster.add(new Skaters("Carlson", "Defense", "USA", 15, 53, 68, 0, "R"));
		defenseRoster.add(new Skaters("Orlov", "Defense", "Russia", 10, 21, 31, 10, "L"));
		defenseRoster.add(new Skaters("Niskanen", "Defense", "USA", 7, 22, 29, 24, "R"));
		defenseRoster.add(new Skaters("Djoos", "Defense", "Sweden", 3, 11, 14, 13, "L"));
		defenseRoster.add(new Skaters("Bowey", "Defense", "Canada", 0, 12, 12, -3, "R"));
		defenseRoster.add(new Skaters("Orpik", "Defense", "USA", 0, 10, 10, -9, "L"));
		defenseRoster.add(new Skaters("Chorney", "Defense", "Canada", 1, 3, 4, 8, "L"));
		defenseRoster.add(new Skaters("Jerabek", "Defense", "Czech Republic", 1, 3, 4, -1, "L"));
		defenseRoster.add(new Skaters("Kempny", "Defense", "Czech Republic", 2, 1, 3, 1, "L"));
		defenseRoster.add(new Skaters("Ness", "Defense", "USA", 0, 1, 1, 2, "L"));
	}
	
	public void setQueryDefenseBP(){
		queryDefenseBP = new ArrayList<String>();
		queryDefenseBP.add(getDefenseRoster().get(0).getBirthplace());
		for(int i = 1; i< getDefenseRoster().size(); i++){
			if(queryDefenseBP.contains(getDefenseRoster().get(i).getBirthplace()) == false){
				queryDefenseBP.add(getDefenseRoster().get(i).getBirthplace());	
			}
		}
	}
	
	//getter
	public ArrayList<Skaters> getDefenseRoster(){
		return defenseRoster;	
	}
	
	public ArrayList<String> getQueryDefenseBP(){
		return queryDefenseBP;	
	}
	
}

///////////////////////////////////////////////////////////////////////////////////////////////////
class Forward extends Skaters{
	//fields
	String forwardPosition;
	private final String[] FORWARDVARS = {"Forward Position"};
	private ArrayList<Skaters> forwardRoster;
	private ArrayList<String> queryForwardBP;
	
	//constructors
	public Forward(){
		setForwardRoster();
		setSkatersRoster(forwardRoster);
		setQuerySkatersBP();
		setQueryForwardBP();
	}
	
	public Forward(String lastName, String position, String birthplace, int goals, int assists, int points, int plusMinus, String shoots, String forwardPosition){
		super(lastName, position, birthplace, goals, assists, points, plusMinus, shoots);
		this.forwardPosition = forwardPosition;
	}
	
	public Forward(Skaters skater, String forwardPosition){
		super(skater);	
		this.forwardPosition = forwardPosition;
	}
	
	//setters
	public void setForwardPosition(String forwardPosition){
		this.forwardPosition = forwardPosition;	
	}
	
	public void setForwardRoster(){
		forwardRoster = new ArrayList<Skaters>();
		forwardRoster.add(new Skaters("Ovechkin", "Forward, LW", "Russia", 49, 38, 87, 3, "R"));
		forwardRoster.add(new Skaters("Vrana", "Forward, LW", "Czech Republic", 13, 14, 27, 2, "L"));
		forwardRoster.add(new Skaters("Gersich", "Forward, LW", "USA", 0, 1, 1, -1, "L"));
		forwardRoster.add(new Skaters("Walker", "Forward, LW", "Wales", 1, 0, 1, 1, "L"));
		forwardRoster.add(new Skaters("Burakovsky", "Forward, LW", "Austria", 12, 13, 25, 3, "L"));
		forwardRoster.add(new Skaters("Kuznetsov", "Forward, C", "Russia", 27, 56, 83, 3, "L"));
		forwardRoster.add(new Skaters("Backstrom", "Forward, C", "Sweden", 21, 50, 71, 5, "L"));
		forwardRoster.add(new Skaters("Graovac", "Forward, C", "Canada", 0, 0, 0, -3, "L"));
		forwardRoster.add(new Skaters("Boyd", "Forward, C", "USA", 0, 1, 1, 2, "R"));
		forwardRoster.add(new Skaters("O'Brien", "Forward, C", "Canada", 0, 0, 0, 0, "L"));
		forwardRoster.add(new Skaters("Eller", "Forward, C", "Denmark", 18, 20, 38, -6, "L"));
		forwardRoster.add(new Skaters("Stephenson", "Forward, C", "Canada", 6, 12, 18, 13, "L"));
		forwardRoster.add(new Skaters("Beagle", "Forward, C", "Canada", 7, 15, 22, 3, "R"));
		forwardRoster.add(new Skaters("Oshie", "Forward, RW", "USA", 18, 29, 47, 2, "R"));
		forwardRoster.add(new Skaters("Wilson", "Forward, RW", "Canada", 14, 21, 35, 10, "R"));
		forwardRoster.add(new Skaters("Connolly", "Forward, RW", "Canada", 15, 12, 27, -6, "R"));
		forwardRoster.add(new Skaters("Peluso", "Forward, RW", "Canada", 0, 0, 0, 0, "R"));
		forwardRoster.add(new Skaters("Smith-Pelly", "Forward, RW", "Canada", 7, 9, 16, -6, "R"));
		forwardRoster.add(new Skaters("Chiasson", "Forward, RW", "Canada", 9, 9, 18, 1, "R"));
	}
	
	public void setQueryForwardBP(){
		queryForwardBP = new ArrayList<String>();
		queryForwardBP.add(getForwardRoster().get(0).getBirthplace());
		for(int i = 1; i< getForwardRoster().size(); i++){
			if(queryForwardBP.contains(getForwardRoster().get(i).getBirthplace()) == false){
				queryForwardBP.add(getForwardRoster().get(i).getBirthplace());	
			}
		}
	}
	
	//getters
	public String getForwardPosition(){
		return forwardPosition;	
	}
	
	public String[] getFORWARDVARS(){
		return FORWARDVARS;	
	}
	
	public ArrayList<Skaters> getForwardRoster(){
		return forwardRoster;	
	}
	
	public ArrayList<String> getQueryForwardBP(){
		return queryForwardBP;	
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
abstract class Output{
	//gives user option of displaying/sorting/querying stats
	public static int statsWizard(){
		final String [] OPTIONS = {"Display Roster", "Sort Stats", "Query Players"};
		System.out.println("\n**********************************************************************************");
		System.out.println("WELCOME TO 2017-2018 WASHINGTON CAPITALS' (SOME) REGULAR SEASON STATS WIZARD!");
		System.out.println("\nSelect an option: ");
		for(int i = 0; i < OPTIONS.length; i++){
			System.out.println((i+1) + "). " + OPTIONS[i]);	
		}
		System.out.println("\n" + (OPTIONS.length + 1) + "). " + "Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			if(userChoice < (OPTIONS.length + 1)){
				System.out.println("  You selected:  " + OPTIONS[userChoice - 1]);
				return userChoice;
			}
			else if(userChoice == (OPTIONS.length + 1)){
				System.out.print("  You selected: EXIT");
				System.exit(0);
			}
			else{
				Output.statsWizard(); //reload menu bc invalid selection	
			}
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			statsWizard();
		}
		return 1;
	}
	
	public static void mainMenu(){
		int choice = statsWizard();
		if(choice == 1){
			Display.printRosterDetails();
			mainMenu();
		}
		else if(choice == 2){
			Sort.userSortOptions();
			Sort.goalieSortOptions();
			Sort.skaterSortOptions();
			Sort.sortAllSome();
		}
		else{
			System.out.println("QUERY");
			Query.userQueryOptions();
			mainMenu();
		}
	}
	
}

///////////////////////////////////////////////////////////////////////////////////////////////////
class Display{
	//outputs all players and some of their stats in a predetermined order
	public static void printRosterDetails(){
		System.out.println("*****************************************************************************");
		System.out.println("THE 2017-2018 REGULAR SEASON ROSTER AND SOME OF THEIR STATS:\n");
		
		Forward f = new Forward();
		for(Skaters s : f.getSkatersRoster()){
			System.out.println("Position: " + s.getPosition() + "\tGoals: " + s.getGoals() + "\tAssists: " + s.getAssists() + "\tPoints: " + s.getPoints() + "\t+/-: " + s.getPlusMinus() + "\t\tName: " + s.getLastName());	
		}
		
		Defense d = new Defense();
		for(Skaters s : d.getSkatersRoster()){
			System.out.println("Position: " + s.getPosition() + "\tGoals: " + s.getGoals() + "\tAssists: " + s.getAssists() + "\tPoints: " + s.getPoints() + "\t+/-: " + s.getPlusMinus() + "\t\tName: " + s.getLastName());	
		}
		
		Goalies goalies = new Goalies();
		System.out.println();
		for(Goalies g : goalies.getGoaliesRoster()){
			System.out.println("Position: " + g.getPosition() + "\tShots Against: " + g.getShotsAgainst() + "\tGoals Against: " + g.getGoalsAgainst() + "\tSaves: " + g.getSaves() + "\t\tName: " + g.getLastName());	
		}
		
		Output.mainMenu();
	}	
}

///////////////////////////////////////////////////////////////////////////////////////////////////
class Sort{
	//fields
	private static ArrayList<String> goalieSortOptions;
	private static ArrayList<String> skaterSortOptions;
	
	public static void goalieSortOptions(){
		goalieSortOptions = new ArrayList<String>();
		goalieSortOptions.add("Shots Against");
		goalieSortOptions.add("Goals Against");
		goalieSortOptions.add("Saves");
		System.out.println("Select from these options: ");
		for(int i = 0; i<goalieSortOptions.size(); i++){
			System.out.println((i+1) + "). " + goalieSortOptions.get(i));
		}
	}
	
	public static void skaterSortOptions(){
		skaterSortOptions = new ArrayList<String>();
		skaterSortOptions.add("Goals");
		skaterSortOptions.add("Assists");
		skaterSortOptions.add("Points");
		skaterSortOptions.add("+/-");
		System.out.println("Select from these options: ");
		for(int i = 0; i<skaterSortOptions.size(); i++){
			System.out.println((i+1) + "). " + skaterSortOptions.get(i));
		}
	}
	
	/**
	* a method that outputs a menu to select type of sorted stats to display on screen
	*/
	public static void userSortOptions(){
		System.out.println();
		System.out.println("**********************************************************************************");
		System.out.println("\nSelect Stats to Sort:\n1.) Goalie \n2.) Skater\n\n3.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			System.out.println();
				switch(userChoice){
					case 1: System.out.println("  You selected: Sort Washington Capitals' GOALIE Stats");
						goalieSortOptions();
						System.out.print("Enter selection:  ");
						int userGoalieStatSelection = Integer.parseInt(reader.readLine());
						System.out.println("Make a selection: \n1.) Sort " + goalieSortOptions.get(userGoalieStatSelection-1) + " for ALL CAPS goalies.\n2.) Sort " + goalieSortOptions.get(userGoalieStatSelection-1) + " for CAPS goalies from a subset of your choice.");
						System.out.print("Enter selection:  ");
						int userGoalieAllSomeSelection = Integer.parseInt(reader.readLine());
						switch(userGoalieAllSomeSelection){
							case 1: System.out.println("ALL CAPS Goalies sorted by " + goalieSortOptions.get(userGoalieStatSelection-1) + "  WILL BE DISPLAYED HERE");
								break;
							case 2: System.out.println("SOME CAPS Goalies sorted by " + goalieSortOptions.get(userGoalieStatSelection-1) + "  WILL BE DISPLAYED HERE, after you enter a min and max " + goalieSortOptions.get(userGoalieStatSelection-1) + " value of your choice.");
								break;
							default: goalieSortOptions(); //reload menu bc invalid selection
							break;
						}
						break;
					case 2: System.out.println("  You selected: Sort Washington Capitals' SKATER Stats");
						skaterSortOptions();
						int userSkaterStatSelection = Integer.parseInt(reader.readLine());
						System.out.println("Make a selection: \n1.) Sort " + skaterSortOptions.get(userSkaterStatSelection-1) + " for ALL CAPS skaters.\n2.) Sort " + skaterSortOptions.get(userSkaterStatSelection-1) + " for CAPS skaters from a subset of your choice.");
						System.out.print("Enter selection:  ");
						int userSkaterAllSomeSelection = Integer.parseInt(reader.readLine());
						switch(userSkaterAllSomeSelection){
							case 1: System.out.println("ALL CAPS Skaters sorted by " + skaterSortOptions.get(userSkaterStatSelection-1) + "  WILL BE DISPLAYED HERE");
								break;
							case 2: System.out.println("SOME CAPS Skaters sorted by " + skaterSortOptions.get(userSkaterStatSelection-1) + "  WILL BE DISPLAYED HERE, after you enter a min and max " + skaterSortOptions.get(userSkaterStatSelection-1) + " value of your choice.");
								break;
							default: skaterSortOptions(); //reload menu bc invalid selection
							break;
						}
						break;
					case 3: System.out.print("  You selected: EXIT");
						System.exit(0);
						break;
					default: userSortOptions(); //reload menu bc invalid selection
						break;	
				}
				Output.mainMenu();
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		userSortOptions();
		}
	}
	
	public static void sortAllSome(){
		System.out.println("Make a selection: \n1.) Sort All \n2.) Sort a subset");	
	}
	
}

///////////////////////////////////////////////////////////////////////////////////////////////////
class Filter extends Sort{
	
}

///////////////////////////////////////////////////////////////////////////////////////////////////
class Query{
	//fields
	private static ArrayList<String> bpQueryOptions;
	private static ArrayList<String> shootsQueryOptions;
	private static ArrayList<String> positionQueryOptions;
	private static ArrayList<String> forwardQueryOptions;
	
	public static void BPQueryOptions(){
		bpQueryOptions = new ArrayList<String>();
		Defense d = new Defense();
		Forward f = new Forward();
		Goalies qg = new Goalies();
		
		bpQueryOptions = f.getQueryForwardBP();
		for(int i = 0; i<d.getQueryDefenseBP().size(); i++){
			if(bpQueryOptions.contains(d.getQueryDefenseBP().get(i)) == false){
				bpQueryOptions.add(d.getQueryDefenseBP().get(i));	
			}
		}
		
		for(int i = 0; i<qg.getQueryGoaliesBP().size(); i++){
			if(bpQueryOptions.contains(qg.getQueryGoaliesBP().get(i)) == false){
				bpQueryOptions.add(qg.getQueryGoaliesBP().get(i));	
			}
		}
		Collections.sort(bpQueryOptions);
		System.out.println("Select a Birthplace from these options: ");
		for(int i = 0; i<bpQueryOptions.size(); i++){
			System.out.println((i+1) + "). " + bpQueryOptions.get(i));
		}
	}
	
	public static void shootsQueryOptions(){
		shootsQueryOptions = new ArrayList<String>();
		shootsQueryOptions.add("L");
		shootsQueryOptions.add("R");
		System.out.println("Select from these options: ");
		for(int i = 0; i<shootsQueryOptions.size(); i++){
			System.out.println((i+1) + "). " + shootsQueryOptions.get(i));
		}
	}
	
	public static void positionQueryOptions(){
		positionQueryOptions = new ArrayList<String>();
		positionQueryOptions.add("Forwards");
		positionQueryOptions.add("Defense");
		positionQueryOptions.add("Goalies");
		System.out.println("Select from these options: ");
		for(int i = 0; i<positionQueryOptions.size(); i++){
			System.out.println((i+1) + "). " + positionQueryOptions.get(i));
		}
	}
	
	public static void forwardQueryOptions(){
		forwardQueryOptions = new ArrayList<String>();
		forwardQueryOptions.add("All");
		forwardQueryOptions.add("LW");
		forwardQueryOptions.add("C");
		forwardQueryOptions.add("RW");
		System.out.println("Select from these options: ");
		for(int i = 0; i<forwardQueryOptions.size(); i++){
			System.out.println((i+1) + "). " + forwardQueryOptions.get(i));
		}
	}
	
	/**
	* a method that outputs a menu to select which queried detail to display on screen
	*/
	public static void userQueryOptions(){
		System.out.println();
		System.out.println("**********************************************************************************");
		System.out.println("\nSelect a detail to query:\n1.) Birthplace \n2.) Shoots \n3.) Position\n\n4.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			System.out.println();
				switch(userChoice){
					case 1: System.out.println("  You selected: Query Player Birthplace");
						BPQueryOptions();
						System.out.print("Enter selection:  ");
						int userBPSelection = Integer.parseInt(reader.readLine());
						System.out.println("\nResults:\t____ players were born in " + bpQueryOptions.get(userBPSelection-1) + ".  These players are ...");
						break;
					case 2: System.out.println("  You selected: Query Skater Shoots");
						shootsQueryOptions();
						System.out.print("Enter selection:  ");
						int userShootsSelection = Integer.parseInt(reader.readLine());
						System.out.println("_____ skaters shoot " + shootsQueryOptions.get(userShootsSelection - 1) + ".  These skaters are....");
						break;
					case 3: System.out.println("  You selected: Query Player Position");
						positionQueryOptions();
						System.out.print("Enter selection:  ");
						int userPositionSelection = Integer.parseInt(reader.readLine());
						switch(userPositionSelection){
						case 1: System.out.println("  You selected: Query Forwards");
							forwardQueryOptions();
							int userForwardSelection = Integer.parseInt(reader.readLine());
							System.out.println("____ forwards are " + forwardQueryOptions.get(userForwardSelection - 1) + ".  These forwards are...");
							break;
						case 2: System.out.println("___ CAPS players are defense.  The defensemen are...");
							break;
						case 3: System.out.println("___ CAPS players are goalies.  The goalies are...");
							break;
						default: positionQueryOptions(); //reload menu bc invalid selection
						break;
						} 
						break;
					case 4: System.out.print("  You selected: EXIT");
						System.exit(0);
						break;
					default: userQueryOptions(); //reload menu bc invalid selection
						break;	
				}
				Output.mainMenu();
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			userQueryOptions();
		}
	}
}
///////////////////////////////////////////////////////////////////////////////////////////////////
public class HockeyDataSetWizard{
	//main method
	public static void main(String... args){
		Output.mainMenu();
	}
}