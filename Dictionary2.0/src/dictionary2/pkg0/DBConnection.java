/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2.pkg0;

import java.sql.*;

/**
 *
 * @author quynh
 */
public class DBConnection {
    ResultSet rs;
    Statement st;
    PreparedStatement ps;
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/dictionary";
    String user = "root";
    String password = "12345";
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null)
                System.out.println("Ket noi thanh cong!");
            //conn.close();
        }   catch (ClassNotFoundException ex) {
            System.out.println("load driver khong thanh cong");
            //Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            catch (SQLException ex) {
                System.out.println("Loi: " +ex.getMessage());
              //  Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }    
    }
}
