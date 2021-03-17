import java.util.*;
import java.io.*;

public class Test {
	public static void main(String args[]) throws FileNotFoundException {
		String task = args[0];
		Scanner input = new Scanner(new File(args[1]));
		PrintWriter print = new PrintWriter(new File(args[3]));
		
		if(task.equals("inscriere")) {
		
			Team team = null;
			String line = "";
			boolean anyNewLine = false; // whether there has been printed any team before
		
			while(input.hasNext() != false) {
				if(anyNewLine != false)
					print.write("\n");
				else 
					anyNewLine = true;
				line = input.nextLine();
				String[] word = line.split(", ");
				String type = word[0];
				//sSystem.out.println(word[0]);
				String teamName = word[1];
				//System.out.println(teamName);
				String gender = word[2];
				//System.out.println(gender);
				int numberOfPlayers = Integer.parseInt(word[3]);
				//System.out.println(numberOfPlayers);
				print.write("{teamName: " + teamName + ", " + "gender: " + gender +
					", numberOfPlayers: " + numberOfPlayers + ", players: [");
				Team.getInstance(type, teamName, gender, numberOfPlayers);
				for(int i = 0; i < numberOfPlayers; i++) {
					print.write("{");
					line = input.nextLine();
					String[] player = line.split(", ");
					String namePlayer = player[0];
					//System.out.println(namePlayer);
					print.write("name: " + namePlayer);
					int scorePlayer = Integer.parseInt(player[1]);
					//System.out.println(", " + scorePlayer);
					print.write(", score: " + scorePlayer);
					Team.populateWithPlayers(new Player(namePlayer, scorePlayer));
					print.write("}");
					if(i != numberOfPlayers - 1)
						print.write(", ");
				}
				print.write("]}");
			}
		
			print.close();
		}
		else if(task.equals("competitie")) {
			Scanner input2 = new Scanner(new File(args[2]));

			Team team = null;
			String line = "";
			boolean anyNewLine = false; // whether there has been printed any team before
			Competition competition = null;
			
			line = input2.nextLine();
			String[] word = line.split(", ");
			String competition_type = word[0];
			String competition_gender = word[1];
			competition = new Competition(competition_type, competition_gender);
			String teamName = "";
			while(input2.hasNext() != false) {
				String competition_teamName = input2.next();
				//System.out.println("competition_teamName " + competition_teamName);
				input = new Scanner(new File(args[1]));
				while(input.hasNext() != false) {
					line = input.nextLine();
					word = line.split(", ");
					String type = word[0];
					//sSystem.out.println(word[0]);
					teamName = word[1];
					//System.out.println(teamName);
					String gender = word[2];
					//System.out.println(gender);
					int numberOfPlayers = Integer.parseInt(word[3]);
					//System.out.println(numberOfPlayers);
					Team.getInstance(type, teamName, gender, numberOfPlayers);
					//System.out.println(Team.getUniqueTeam().teamName);
					for(int i = 0; i < numberOfPlayers; i++) {
						line = input.nextLine();
						String[] player = line.split(", ");
						String namePlayer = player[0];
						//System.out.println(namePlayer);
						int scorePlayer = Integer.parseInt(player[1]);
						//System.out.println(", " + scorePlayer);
						Team.populateWithPlayers(new Player(namePlayer, scorePlayer));
					}
					
					if(teamName.equals(competition_teamName)) {
						if(type.equals(competition_type) && gender.equals(competition_gender)) {
							competition.getTeams().add(Team.getUniqueTeam());
							competition.getClasament().add(Team.getUniqueTeam());
							//System.out.println(Team.getUniqueTeam().teamName);
							break;
						}	
					}
				}
			}
			
			competition.decideClasamentul(print, args[2]);
			print.close();
			
		}
	}
}
