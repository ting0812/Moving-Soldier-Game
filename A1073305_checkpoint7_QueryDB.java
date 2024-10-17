import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class A1073305_checkpoint7_QueryDB {
    //Description : the driver description of mysql
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //Description : the protocol description of mysql
    private static final String PROTOCOL = "jdbc:mysql:";
    //Description : the obstacle set queried from database.
    private static ArrayList<Integer[]> data;
    //Description : the filename of obstacle image queried from database.
    private static HashMap<Integer, String> typeChar;
    //Description : the ID of the map in database;
    private static String mapID;
    //Description : the sand set queried from database.
    private static ArrayList<Integer[]> sands;
    private static int WIDTH=0;
    private static int HEIGHT=0;
    public A1073305_checkpoint7_QueryDB(String mapID){
        this.data  = new ArrayList<Integer[]>();
        this.sands = new ArrayList<Integer[]>();
        this.typeChar = new HashMap<Integer, String>();
        this.mapID = mapID;
        queryData(this.data, this.typeChar);
        querySand(this.sands);
    }

    private static void queryData(ArrayList<Integer[]> data,HashMap<Integer, String> typeChar) {
    /*********************************The Past TODO (Checkpoint2)********************************
     * 
     * TODO(Past) Querying the barrier location from the server, and set it into Arraylist.
     * 
     * TODO(Past) Querying the bar_type and the corresponding file_name from the server, and set it into HashMap.
     * 
     * Hint:  for ckp2 to after, you need replace querying  column "file_name" with querying  column "display". 
     * 
     **********************************The End of the TODO***************************************/

     /********************************************************************************************
     START OF YOUR CODE
     ********************************************************************************************/
    String url = "jdbc:mysql://140.127.220.220:3306/CHECKPOINT";
    String user="checkpoint";
    String password = "ckppwd";
    Connection conn = null;
    try{
        Class.forName(DRIVER);
        conn =DriverManager.getConnection(url,user, password);
        if(conn != null && !conn.isClosed()) {
            Statement s= conn.createStatement();
            ResultSet rs = null;
            String sql = "select * from map where map_id="+mapID+";";
            rs = s.executeQuery(sql);
            while(rs.next()){
                HEIGHT=rs.getInt("height");
                WIDTH=rs.getInt("width");
            }
            rs.close();
            //String sql2= "select * from barrier, barrier_type, map where barrier.map_id="+mapID+" and barrier.bar_type=barrier_type.bar_type and barrier.row_idx <= map.height and barrier.column_idx <= map.width;";
            String sql2= "select * from barrier, barrier_type, map where barrier.map_id="+mapID+" and barrier.bar_type=barrier_type.bar_type ;";
            rs = s.executeQuery(sql2);
            while (rs.next()){
                //if(HEIGHT>=rs.getInt("row_idx") && WIDTH>=rs.getInt("column_idx")){
                    Integer[] bra_location_type = {rs.getInt("row_idx"),rs.getInt("column_idx"),rs.getInt("bar_type")};
                    data.add(bra_location_type);
                  //}
            }
            rs.close();
            String sql3="select barrier_type.bar_type, barrier_type.file_name from barrier_type ;";
            rs = s.executeQuery(sql3);
            while (rs.next()){
                int key=rs.getInt("bar_type");
                String value=rs.getString("file_name");
                typeChar.put(key,value);
            }
            rs.close();
        }
       conn.close();
    }
    catch (Exception err){
             System.err.println("Can't find driver!");
             err.printStackTrace(System.err);
             System.exit(0);
        }
    /********************************************************************************************
     END OF YOUR CODE
     ********************************************************************************************/
    }
    private static void querySand(ArrayList<Integer[]> sands) {
    /*********************************The TODO This Time (Checkpoint7)***************************
     * 
     * TODO(1) Querying the map size and the sand location from the server, and set it into Arraylist.
     * 
     **********************************The End of the TODO***************************************/
    String url = "jdbc:mysql://140.127.220.220:3306/CHECKPOINT";
    String user="checkpoint";
     String password = "ckppwd";
     Connection conn = null;
     try{
         Class.forName(DRIVER);
         conn =DriverManager.getConnection(url,user, password);
         if(conn != null && !conn.isClosed()) {
             Statement s= conn.createStatement();
             ResultSet rs = null;
             String sql4 = "select sand.row_idx, sand.column_idx from sand where sand.map_id="+mapID+";";
             rs = s.executeQuery(sql4);
             while (rs.next()){
                    Integer[] sands_location = {rs.getInt("row_idx"),rs.getInt("column_idx")};
                    sands.add(sands_location);
            }
             rs.close();
         }
         conn.close();
     }catch (Exception err){
           System.err.println("Can't find driver!");
           err.printStackTrace(System.err);
           System.exit(0);
      }
     /********************************************************************************************
     START OF YOUR CODE
     ********************************************************************************************/
    
    /********************************************************************************************
     END OF YOUR CODE
    ********************************************************************************************/
    }
    public ArrayList getObstacle(){
        return this.data;
    }
    public void setObstacle(ArrayList<Integer[]> data){
        this.data = data;
    }
    public String getMapID(){
        return this.mapID;
    }
    public void setMapID(String mapID){
        this.mapID = mapID;
    }
    public HashMap getObstacleImg(){
        return this.typeChar;
    }
    public void setObstacleImg(HashMap<Integer, String> typeChar){
        this.typeChar = typeChar;
    }
    public ArrayList getSands(){
        return this.sands;
    }
    public void setSands(ArrayList<Integer[]> sands){
        this.sands = sands;
    }
}
