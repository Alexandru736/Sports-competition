import java.util.Comparator;
/**
 * clasa ce implementeaza metodele visit declarate
 * in interfata TeamVisitor
 * @author alexandru
 *
 */
public class TeamVisitorImpl implements TeamVisitor{

	@Override
	/**
	 * metoda ce implementeaza calcularea 
	 * scorului unei echipe masculine de fotbal
	 */
	public double visitFootballMale(FootballTeam team) {
		double score = 0; // scorul echipei
		Comparator<? super Player> c = null;
		
		team.players.sort(c);
		for(Player i : team.players)
			score += i.getScorePlayer();
		score += team.players.get(team.players.size() - 1).getScorePlayer();
		return score;
	}

	@Override
	/**
	 * metoda ce implementeaza calcularea 
	 * scorului unei echipe feminine de fotbal
	 */
	public double visitFootballFemale(FootballTeam team) {
		double score = 0; // scorul echipei
		Comparator<? super Player> c = null;
		
		team.players.sort(c);
		for(Player i : team.players)
			score += i.getScorePlayer();
		score += team.players.get(0).getScorePlayer();
		return score;
	}

	@Override
	/**
	 * metoda ce implementeaza calcularea 
	 * scorului unei echipe de basket
	 */
	public double visitBasketball(BasketballTeam team) {
		double score = 0;
		for(Player i : team.players)
			score += i.getScorePlayer();
		return score / team.players.size();
	}

	@Override
	/**
	 * metoda ce implementeaza calcularea 
	 * scorului unei echipe masculine de handball
	 */
	public double visitHandballMale(HandballTeam team) {
		double score = 0;
		for(Player i : team.players)
			score += i.getScorePlayer();
		return score; 
	}

	@Override
	/**
	 * metoda ce implementeaza calcularea 
	 * scorului unei echipe feminine de handball
	 */
	public double visitHandballFemale(HandballTeam team) {
		double score = 1;
		for(Player i : team.players)
			score *= i.getScorePlayer();
		return score; 
	}

}
