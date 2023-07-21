
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("File:");
        String file = scan.nextLine();
        
        System.out.println("Team:");
        String team = scan.nextLine();
        
        try ( Scanner read = new Scanner(Paths.get(file)) ) {
            int games = 0;
            int won = 0;
            int lose = 0;
            
            while(read.hasNextLine()) {
                String game = read.nextLine();
                
                String[] data = game.split(",");
                int homePoints = Integer.valueOf(data[2]);
                int visitPoints = Integer.valueOf(data[3]);
                
                if(team.equals(data[0]) || team.equals(data[1])) {
                    if(team.equals(data[0])) {
                        if(homePoints>visitPoints) {
                            won += 1;
                        } else {
                            lose += 1;
                        }
                    } else {
                        if(visitPoints>homePoints) {
                            won += 1;
                        } else {
                            lose += 1;
                        }
                    }
                    games += 1;
                }
            }
            
            System.out.println("Games: "+games);
            System.out.println("Wins: "+won);
            System.out.println("Losses: "+lose);
        } catch(Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
