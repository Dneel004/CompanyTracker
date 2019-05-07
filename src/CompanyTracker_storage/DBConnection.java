/*
 * DBConnection.java
 *
 * Created on April 7, 2008, 11:40 PM
 *
 *
 */

package CompanyTracker_storage;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;


/**
 * @author Luis
 */
public class DBConnection
{
    private static DBConnection instance;
    private final String username = "root";
    private final String password = "scooter123";
    private final String localDb = "jdbc:mysql://localhost:3306/companytracker";
       
    
    // Connect using local host as database address

    /**
     *
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * 
     */
    //prevents the instantiation from any other class.  
    private DBConnection() {
        
    }
    
    //Now we are providing gloabal point of access. 
    public static DBConnection getInstance() throws SQLException, InstantiationException, IllegalAccessException {
        if (instance == null) {
            instance = new DBConnection();
        } 
        return instance;
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException{
            Connection myCon = null;
            Class.forName("com.mysql.jdbc.Driver");
            myCon = DriverManager.getConnection(localDb,username,password);
            return myCon;
    }
    
    //to insert the record into the database
    public int insertJob(int id, String name, String type, int price, int cost_props) throws SQLException{
        Connection c=null;  
        PreparedStatement ps=null;  
        int recordCounter=0;
        
        try {  
            c=this.getConnection();  
            ps=c.prepareStatement("insert into jobs(id,name,type,price,cost_props)values(?,?,?,?,?)");  
            ps.setInt(1, id);  
            ps.setString(2, name); 
            ps.setString(3, type);
            ps.setInt(4, price);
            ps.setInt(5, cost_props);
            recordCounter=ps.executeUpdate();  
        } catch (SQLException | ClassNotFoundException e) {
        } finally{  
            if (ps!=null){  
              ps.close();  
            }if(c!=null){  
              c.close();  
            }   
        }  
        return recordCounter;  
    }
    //to view the data from the database        
    public  void viewAll() throws SQLException  
    {  
        Connection con = null;  
        PreparedStatement ps = null;  
        ResultSet rs = null;  

        try{  
            con=this.getConnection();  
            ps=con.prepareStatement("select * from jobs");  
            rs=ps.executeQuery();  
            while (rs.next()) {  
                System.out.println("ID= "+rs.getInt(1)+"\t" + "Name= "+rs.getString(2)+"\t\t" + "Type= "+rs.getString(3)+"\t" + "Price= "+rs.getInt(4)+"\t" + "Cost of Props= "+rs.getString(5)+"\t");      
            }  
        } catch (SQLException | ClassNotFoundException e) { System.out.println(e);}  
        finally{  
            if(rs!=null){  
                rs.close();  
            }if (ps!=null){  
                ps.close();  
            }if(con!=null){  
                con.close();  
            }   
        }  
    }
    // to update the password for the given username  
    public int update(String oldName, String newName) throws SQLException  {  
        Connection c = null;  
        PreparedStatement ps = null;  
        int recordCounter=0;  
        
        try {  
            c = this.getConnection();  
            ps = c.prepareStatement(" update jobs set Name=? where Name='"+oldName+"'");   
            ps.setString(1, newName); 
            
            recordCounter=ps.executeUpdate();  
        } catch (SQLException | ClassNotFoundException e) {} finally{  
            if (ps!=null){  
                ps.close();  
            }if(c!=null){  
                c.close();  
            }   
        }  
        return recordCounter;  
    }  
            
    // to delete the data from the database   
    public int delete(String name) throws SQLException{  
        Connection c = null;  
        PreparedStatement ps = null;  
        int recordCounter=0;  
        try {  
            c = this.getConnection();  
            ps = c.prepareStatement(" delete from jobs where Name='"+name+"' ");  
            recordCounter = ps.executeUpdate();  
        } catch (SQLException | ClassNotFoundException e) {} finally{  
            if (ps!=null){  
                ps.close();  
            }if(c!=null){  
                c.close();  
            }   
        }  
        return recordCounter;  
    }    
}