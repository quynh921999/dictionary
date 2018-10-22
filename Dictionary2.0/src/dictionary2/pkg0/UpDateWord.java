/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2.pkg0;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quynh
 */
public class UpDateWord {
    public void UpDate(JTable jTable1, JTextField jTextField2, JTextField jTextField3 , DBConnection dbc){
        // delete word
        DefaultTableModel model =  (DefaultTableModel) jTable1.getModel();
        try {
            PreparedStatement ps = dbc.conn.prepareStatement("delete from tbl_edict where word = ?");
            ps.setString(1, jTextField2.getText());
            int rs = ps.executeUpdate();
            if(rs == 0)
                JOptionPane.showMessageDialog(null, "Bạn hãy nhập lại từ cần sửa!");
            model.removeRow(jTable1.getSelectedRow());
        } catch (SQLException ex) {
            Logger.getLogger(DeleteWord.class.getName()).log(Level.SEVERE, null, ex);
        }
        // add new word
         try {
            dbc.ps = dbc.conn.prepareStatement("insert into tbl_edict(word, detail)value(?, ?)");
            dbc.ps.setString(1, jTextField2.getText());
            String detail =  jTextField3.getText();
            dbc.ps.setString(2, detail);
            int check = dbc.ps.executeUpdate();
            if(check != 0)
                JOptionPane.showMessageDialog(null, "Thay đổi từ thành công!");
            else
                JOptionPane.showMessageDialog(null, "Bạn hãy nhập đầy đủ thông tin!");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
