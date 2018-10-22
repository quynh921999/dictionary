/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2.pkg0;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author quynh
 */
public class AddWord {
    public void addWord(JTextField jTextField2, JTextField jTextField3, JComboBox jComboBox, DBConnection dbc) throws SQLException {
        
        try {
            dbc.ps = dbc.conn.prepareStatement("select word from tbl_edict where word like '" + jTextField2.getText() + "%'");
            dbc.rs = dbc.ps.executeQuery();
            while(dbc.rs.next()) {
                if(dbc.rs.getString("word").equals(jTextField2.getText())){
                    JOptionPane.showMessageDialog(null, "từ đã tồn tại!");
                    //checkWord = true;
                    return;
                }   
            }
        } catch(SQLException e) {
              Logger.getLogger(AddWord.class.getName()).log(Level.SEVERE, null, e);
        }
        
        if(jTextField3.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nhập thông tin không đầy đủ!");
            return;
        }
        try {
            dbc.ps = dbc.conn.prepareStatement("insert into tbl_edict(word, detail)value(?, ?)");
            dbc.ps.setString(1, jTextField2.getText());
            String detail = "< " + (String)jComboBox.getSelectedItem() +" >" + jTextField3.getText();
            dbc.ps.setString(2, detail);
            int check = dbc.ps.executeUpdate();
                System.out.println(check);
            if(check == 1){
                JOptionPane.showMessageDialog(null, "Thêm từ thành công!"); 
            }
        } catch(SQLException e){
                System.out.println(e.getMessage());
            }
        
    }
}
