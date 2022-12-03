package cbinetsheriff_garnettgrant_comp228_lab5;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {


    public  static List<Game> games = new ArrayList<Game>();
    public static List<Player> players = new ArrayList<Player>();
    public static List<GameStat> stats = new ArrayList<GameStat>();

    //Database variables;
    static String myDriver = "com.mysql.jdbc.Driver";
    static String myUrl = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
    static Connection conn ;

    public static void InsertPlayer(Player newPlayer) {
        try {
            int id = 0;
            OpenDatabaseConnection();

            Statement st = conn.createStatement();

            // Old Query Statement
            String query = String.format("Insert into player (first_name, last_name, address, postal_code, province, phone_number) values ('%s', '%s')", newPlayer.getFirstName(), newPlayer.getLastName(), newPlayer.getAddress(), newPlayer.getPostal_Code(), newPlayer.getProvince(), newPlayer.getPhone());

            // New Prepared  Query Statement
            PreparedStatement pst = conn.prepareStatement("Insert into player (player_id, first_name, last_name, address, postal_code, province, phone_number) values (?,?,?,?,?,?,?)");
            pst.setString(1, String.valueOf(id));
            pst.setString(2, newPlayer.getFirstName());
            pst.setString(3, newPlayer.getLastName());
            pst.setString(4, newPlayer.getAddress());
            pst.setString(5, newPlayer.getPostal_Code());
            pst.setString(6, newPlayer.getProvince());
            pst.setString(7, newPlayer.getPhone());

            int i = pst.executeUpdate();

            CloseDatabaseConnection();

            UpdatePlayersList();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }

    public static void UpdatePlayer(Player updatePlayer){

        try {
            OpenDatabaseConnection();

            Statement st = conn.createStatement();

            String query = String.format("UPDATE player set first_name = '%s', last_name = '%s', address = '%s', postal_code = '%s', province = '%s', phone_number = '%s' WHERE player_id = %d", updatePlayer.getFirstName(), updatePlayer.getLastName(), updatePlayer.getAddress(), updatePlayer.getPostal_Code(), updatePlayer.getProvince(), updatePlayer.getPhone(), updatePlayer.getID());

            st.executeUpdate(query);

            CloseDatabaseConnection();

            UpdatePlayersList();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }

    }

    public static void InsertStat(GameStat newStat) {
        try {
            OpenDatabaseConnection();

            Statement st = conn.createStatement();

            String query = String.format("Insert into playerandgame (game_id, player_id, playing_date, score) values (%d, %d, '%s', %s )", newStat.getGameID(), newStat.getPlayerID(), newStat.getPlayDate().toString(), Double.toString(newStat.getScore()));
            // execute the query, and get a java result set
            st.executeUpdate(query);

            CloseDatabaseConnection();

            UpdateGameStatsList();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }

    public static void UpdateStat(GameStat stat){
        try{
            OpenDatabaseConnection();

            Statement st = conn.createStatement();

            String query = String.format("UPDATE playerandgame SET score = %f WHERE player_game_id = %d", stat.getScore(), stat.getStatID());
            System.out.println(query);

            st.executeUpdate(query);

            CloseDatabaseConnection();

            UpdateGameStatsList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void DeleteStat(GameStat stat){
        try{
            OpenDatabaseConnection();

            Statement st = conn.createStatement();

            String query = String.format("DELETE FROM playerandgame WHERE player_game_id = %d", stat.getStatID());
            System.out.println(query);

            st.executeUpdate(query);

            CloseDatabaseConnection();

            UpdateGameStatsList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void InitialDataFetch(){

    }

    public static void testFetch(){
        UpdateGamesList();
        UpdatePlayersList();
        UpdateGameStatsList();
    }


    public static void OpenDatabaseConnection(){
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(myUrl, "COMP228_m22_sl_14", "password");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void CloseDatabaseConnection(){
        try{
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void UpdateGamesList(){

        games = UpdateList("select * from game", DatabaseTypes.game);

    }

    public static void UpdatePlayersList(){
        players = UpdateList("select * from player", DatabaseTypes.player);
    }

    public static void UpdateGameStatsList(){
        stats = UpdateList("select * from playerandgame", DatabaseTypes.stats);

    }


    //method that returns generic list by fetching the database
    public static List UpdateList(String query, DatabaseTypes type){

        List databaseObjects = new ArrayList();

        try {

            OpenDatabaseConnection();


            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);

            // Create object and add to array list
            while (rs.next()) {

                switch (type){
                    case game:
                        Game newGame = new Game(rs.getInt("game_id"), rs.getString("game_title"));
                        databaseObjects.add(newGame);
                        break;
                    case player:
                        Player newPlayer = new Player(rs.getInt("player_id"), rs.getString("first_name"), rs.getString("last_name"),rs.getString("address"),rs.getString("postal_code"),rs.getString("province"),rs.getString("phone_number"));
                        databaseObjects.add(newPlayer);
                        break;
                    case stats:
                        GameStat newStat = new GameStat(rs.getInt("player_game_id"), rs.getInt("player_id"), rs.getInt("game_id"), new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("playing_date")) , rs.getDouble("score"));
                        databaseObjects.add(newStat);
                        break;
                }
            }

            //close statement and result set
            rs.close();
            st.close();

            // close database connection
            CloseDatabaseConnection();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //return list of objects
        return databaseObjects;
    }

}

