import java.util.ArrayList;
import java.util.List;

public class Game {

    private String name;
    private int maxPlayers;
    private List<Player> players;
    TextUI ui = new TextUI();

    public Game(String name, int maxPlayers){
        this.name = name;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>();
    }

    public void registerPlayers(){
        //boolean
        while(this.players.size() <= this.maxPlayers) {

            String playerName = ui.promptText("Tast spiller navn");
            this.createPlayer(playerName, 0);
        }
    }


    private void createPlayer(String name, int score){
        Player p = new Player(name, score);
        players.add(p);
    }
    public void displayPlayers(){
        for(Player p:players){
            System.out.println(p);
        }

    }
}