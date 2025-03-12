public class Player {
    private String name;
    private int score;
    
    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString(){

        return name + ", "+ score;
    }


    public void addScore(int points) {

        this.score+= points;
    }
}
