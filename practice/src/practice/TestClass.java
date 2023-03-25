package practice;

import java.util.*;

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {
    
    if(a == null && b == null){
        return 0;
    }
    
    if(a!= null && b== null){
        return -1;
    }
    
    if(a== null && b!= null){
        return 1;
    }
    
    if(a.score > b.score){
        return -1;
    }
    
    if(a.score < b.score){
        return 1;
    }
    
        String aName = a.name;
        String bName = b.name;
        for(int i=0; i < aName.length() ; i++){
            if(Integer.valueOf(aName.charAt(i)) < Integer.valueOf(bName.charAt(i))){
                return -1;
            } else if(Integer.valueOf(aName.charAt(i)) < Integer.valueOf(bName.charAt(i))){
                return 1;
            }
    }
    return 0;
}
}

public class TestClass {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}