/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2.pkg0;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author quynh
 */
public class ShowMean {
    public void showWordMean(JTable jTable1, JTextArea jTextArea1, DBConnection dbc, JTextField jTextField1) throws SQLException {
        int row = jTable1.getSelectedRow();
        String s = (jTable1.getModel().getValueAt(row, 0)).toString();
        jTextField1.setText(s);
            try {
            dbc.ps = dbc.conn.prepareStatement("select * from tbl_edict where word = '" + s + "'");
            } catch (SQLException ex) {
                Logger.getLogger(ShowMean.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                dbc.rs = dbc.ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(ShowMean.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(dbc.rs.next()){
                String stringOut = dbc.rs.getString("detail");
                String[] temp = stringOut.split("<br />");
                String out = "";
                for(int i = 0; i < temp.length; i++){
                    out += temp[i];
                    out +="\n";
                }
                jTextArea1.setText(out);
                jTextArea1.setEditable(false);
            }          
        }
} 

