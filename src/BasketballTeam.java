
/**
 * clasa copil a clasei Team ce defineste
 * o echipa de basket
 * @author alexandru
 *
 */
public class BasketballTeam extends Team{
	
	/**
	 * constructor ce apeleaza constructorul parinte
	 * @param teamName
	 * @param gender
	 * @param numberOfPlayers
	 */
	public BasketballTeam(String teamName, String gender, int numberOfPlayers) {
		super(teamName, gender, numberOfPlayers);
	}

	@Override
	/**
	 * metoda accept al carei corp decide
	 * cand sunt apelate metodele de tip visit
	 * pentru echipele masculine si feminie de basket
	 */
	public double accept(TeamVisitor team) {
		return team.visitBasketball(this);
	}

	@Override
	/**
	 * 
	 */
	public void update(int nr_points) {
		this.score += nr_points;
	}
}
