
/**
 * 
 * clasa inglobeaza datele necesare pentru
 * a crea un obiect de tip jucator impreuna 
 * cu metoda compareTo folosita pentru sortarea
 * unui ArrayList cu jucatori
 * @author alexandru
 *
 */
public class Player implements Comparable<Player>{
	private String namePlayer; // numele jucatorului
	private int scorePlayer; // scorul jucatorului
	
	/**
	 * constructorul clasei
	 * @param namePlayer
	 * @param scorePlayer
	 */
	public Player(String namePlayer, int scorePlayer) {
		this.namePlayer = namePlayer;
		this.scorePlayer = scorePlayer;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNamePlayer() {
		return namePlayer;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getScorePlayer() {
		return scorePlayer;
	}

	@Override
	/**
	 * 
	 */
	public int compareTo(Player player) {
		if(this.getScorePlayer() > player.getScorePlayer())
			return -1;
		else if(this.getScorePlayer() < player.getScorePlayer())
			return 1;
		return 0;
	}
}
