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

    public void endSession()
    {
        // Create a list to hold player data as strings
        ArrayList<String> playerData = new ArrayList<>();

        // Loop through all players
        for (Player p : players)
        {
            // Add each player's string representation to the list
            playerData.add(p.toString());
        }

        // Define the path where the player data CSV file will be saved
        String path = "data/playerData.csv";

        // Define the header line for the CSV file
        String header = "Name, Score";

        // Save the player data list to the file with the specified header
        io.saveData(playerData, path, header);
    }


    FileIO io = new FileIO();

    public void startSession()
    {
        // Read data from the CSV file into a list of strings
        ArrayList<String> data = io.readData("data/playerData.csv");

        // If the data list is not empty
        if (!data.isEmpty())
        {
            // Loop through each string line in the data
            for (String s : data)
            {
                // Split the string by comma to separate name and score
                String[] values = s.split(",");
                // Extract the player name
                String name = values[0];
                // Parse the score string to an integer, trimming spaces
                int score = Integer.parseInt(values[1].trim());

                // Create a new Player instance with name and score
                Player p = new Player(name, score);
                // Add the player to the players list
                players.add(p);
            }
        } else
        {
            // If no data found, register players manually
            registerPlayers();
        }
    }

}