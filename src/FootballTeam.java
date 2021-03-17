/**
 * clasa copil a clasei Team ce defineste
 * o echipa de fotbal
 * @author alexandru
 *
 */
public class FootballTeam extends Team{
	
	/**
	 * constructor ce apeleaza constructorul parinte
	 * @param teamName
	 * @param gender
	 * @param numberOfPlayers
	 */
	public FootballTeam(String teamName, String gender, int numberOfPlayers) {
		super(teamName, gender, numberOfPlayers);
	}

	@Override
	/**
	 * metoda accept al carei corp decide
	 * cand sunt apelate metodele de tip visit
	 * pentru echipele masculine si feminie de fotbal
	 */
	public double accept(TeamVisitor team) {
		if(gender.equals("masculin"))
			return team.visitFootballMale(this);
		else if(gender.equals("feminin"))
			return team.visitFootballFemale(this);
		return -9999;
	}

	@Override
	/**
	 * 
	 */
	public void update(int nr_points) {
		this.score += nr_points;
	}
	
	
}
