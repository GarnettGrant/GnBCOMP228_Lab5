package cbinetsheriff_garnettgrant_comp228_lab5;

public class GameStat {

    public int StatID;
    public int PlayerID;
    public int GameID;
    public double Score;
    public String PlayDate;

    public Game GameObject;


    //Getters and Setters
    public int getStatID() {
        return StatID;
    }

    public void setStatID(int statID) {
        StatID = statID;
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(int playerID) {
        PlayerID = playerID;
    }

    public int getGameID() {
        return GameID;
    }

    public void setGameID(int gameID) {
        GameID = gameID;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }

    public String getPlayDate() {
        return PlayDate;
    }

    public void setPlayDate(String playDate) {
        PlayDate = playDate;
    }


    //Constructor for creating stat object from database
    public GameStat(int statID, int playerID, int gameID, String playDate, double score){
        System.out.print(statID);
        StatID = statID;
        PlayerID = playerID;
        GameID = gameID;
        PlayDate = playDate;
        Score = score;

        for (Game g : DatabaseController.games
             ) {
            if(g.ID == GameID){
                GameObject = g;
            }
        }

    }


    //Constructor for creating stat object before inserting into database
    public GameStat(int playerID, int gameID, String playDate, double score){
        PlayerID = playerID;
        GameID = gameID;
        PlayDate = playDate;
        Score = score;
    }

    @Override
    public String toString() {
        return GameObject.getTitle();
    }
}
