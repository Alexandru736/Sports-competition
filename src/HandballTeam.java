
/**
 * clasa copil a clasei Team ce defineste
 * o echipa de handball
 * @author alexandru
 *
 */
public class HandballTeam extends Team{
	
	/**
	 * constructor ce apeleaza constructorul parinte
	 * @param teamName
	 * @param gender
	 * @param numberOfPlayers
	 */
	public HandballTeam(String teamName, String gender, int numberOfPlayers) {
		super(teamName, gender, numberOfPlayers);
	}

	@Override
	/**
	 * metoda accept al carei corp decide
	 * cand sunt apelate metodele de tip visit
	 * pentru echipele masculine si feminie
	 */
	public double accept(TeamVisitor team) {
		if(gender.equals("masculin"))
			return team.visitHandballMale(this);
		else if(gender.equals("feminin"))
			return team.visitHandballFemale(this);
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
