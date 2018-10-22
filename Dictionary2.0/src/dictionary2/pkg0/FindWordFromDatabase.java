/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2.pkg0;

import java.sql.SQLException;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
 

/**
 *
 * @author quynh
 */
public class FindWordFromDatabase {
    public void findWord(String wordFind, JTable jTable1, DBConnection dbc) throws SQLException{
        try {
            dbc.ps = dbc.conn.prepareStatement("select word from tbl_edict where word like '" + wordFind + "%'");
            dbc.rs = dbc.ps.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(dbc.rs));
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
