import java.util.ArrayList;

public abstract class Team extends ObserverClass implements Comparable<Team>{
	protected String teamName = ""; //numele echipei
	protected String gender = ""; //genul echipei
	protected int numberOfPlayers = 0; //numarul de jucatori
	protected ArrayList<Player> players = new ArrayList<Player>(); //lista cu jucatori
	protected int score = 0; //scorul echipei(el va fi mereu calculat folosind designPatternul de tip Visitor)
	
	protected static Team uniqueTeam = null; // variabila folosita pentru implementarea design pattern ului Singleton
		
	/**
	 * constructorul clasei Team
	 * @param teamName
	 * @param gender
	 * @param numberOfPlayers
	 */
	protected Team(String teamName, String gender, int numberOfPlayers) {
		this.teamName = teamName;
		this.gender = gender;
		this.numberOfPlayers = numberOfPlayers;
	}
	
	/**
	 * metoda care mereu suprascrie campul uniqueTeam folosind in acelasi timp si design patternul Factory
	 * @param type
	 * @param teamName
	 * @param gender
	 * @param numberOfPlayers
	 * @return
	 */
	public static Team getInstance(String type, String teamName, String gender, int numberOfPlayers) {
		//factory design patter 
		uniqueTeam = null;
		if(uniqueTeam == null) {
			if(type.equals("football"))
				uniqueTeam = new FootballTeam(teamName, gender, numberOfPlayers);
			else if(type.equals("basketball"))
				uniqueTeam = new BasketballTeam(teamName, gender, numberOfPlayers);
			else if(type.equals("handball"))
				uniqueTeam = new HandballTeam(teamName, gender, numberOfPlayers);
			
		}
		return uniqueTeam;
	}
	
	/**
	 * metoda care populeaza lista de jucatori din campul players
	 * @param player
	 */
	public static void populateWithPlayers(Player player) {
		if(uniqueTeam != null) {
			//uniqueTeam.players = new ArrayList<Player>();			
			//if(uniqueTeam.players.isEmpty())
				uniqueTeam.players.add(player);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static Team getUniqueTeam() {
		return uniqueTeam;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getScore() {
		return score;
	}
	
	/**
	 * metoda accept folosita pentru implementarea desing pattern ului Visitor 
	 * Ea este suprascrisa in fiecare clasa copil
	 * @param team
	 * @return
	 */
	public abstract double accept(TeamVisitor team);
	
	/**
	 * metoda folosita pentru sortarea echipelor
	 */
	@Override
	public int compareTo(Team team) {
		if(this.getScore() < team.getScore())
			return 1;
		if(this.getScore() > team.getScore())
			return -1;
		return 0;
	}
}
