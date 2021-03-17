import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * clasa Competiton folosita pentru rezolvarea taskului 2
 * 
 * @author alexandru
 *
 */
public class Competition {
	private String type;
	private String gender;
	private ArrayList<Team> teams; 
	private ArrayList<Team> clasament;
	
	/**
	 * 
	 * @param type
	 * @param gender
	 */
	public Competition(String type, String gender) {
		this.type = type;
		this.gender = gender;
		teams = new ArrayList<Team>();
		clasament = new ArrayList<Team>();
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Team> getTeams(){
		return teams;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Team> getClasament(){
		return clasament;
	}
	
	/**
	 * metoda care foloste design pattern ul 
	 * Observer pentru a construi clasamentul
	 * in urma jucarii meciurilor
	 * 
	 * @param print
	 * @param args
	 * @throws FileNotFoundException
	 */
	public void decideClasamentul(PrintWriter print, String args) throws FileNotFoundException {
		double score1 = 0, score2 = 0;
		
		//doua foruri pentru ca fiecare echipa sa joace impotriva celorlalte doar odata
		for(int i = 0; i < clasament.size() - 1; i++) {
			for(int j = i + 1; j < clasament.size(); j++) {
				score1 = clasament.get(i).accept(new TeamVisitorImpl());
				score2 = clasament.get(j).accept(new TeamVisitorImpl());
				if(score1 > score2) {
					clasament.get(i).update(3);
					//teams.get(j).score += 0;
				}
				else if(score1 == score2) {
					clasament.get(i).update(1);
					clasament.get(j).update(1);
				}
				else if(score1 < score2) {
					//teams.get(i).score += 0;
					clasament.get(j).update(3);
				}
			}
		}
		
		Comparator<Team> c = null;
		clasament.sort(c);
		
		//afiseaza podiumul
		print.write(clasament.get(0).teamName + "\n" + clasament.get(1).teamName + "\n" + clasament.get(2).teamName);
		
		Scanner input = new Scanner(new File(args));
		
		input.next();
		//se reia fisierul de intrare cu echipele pentru a determina pozitia
		//fiecareia in clasament
		while(input.hasNext() != false) {
			String competition_teamName = input.next();
			for(int i = 0; i < clasament.size(); i++) {
				if(competition_teamName.equals(clasament.get(i).teamName)) {
					print.write("\nEchipa " + competition_teamName + " a ocupat locul " + (i + 1));
				}
			}
		}
		print.write("\n\n");
		
	}
}
