/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompanyTracker_logic;
import CompanyTracker_storage.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.*;

/**
 *
 * @author Daniel
 */


public class CompanyTracker {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException {
        DBConnection db = DBConnection.getInstance();
        db.delete("Test2");
        db.viewAll();
    }
    
}

/*
try {  
            int i= db.insertJob(2,"ShariTest2","Photoshoot",250,10);  
            if(i>0){  
                System.out.println(" Data has been inserted successfully");  
            }
            else{  
                System.out.println("Data has not been inserted ");      
            }  
        }catch (Exception e){  
            System.out.println(e);  
        }  

*/
