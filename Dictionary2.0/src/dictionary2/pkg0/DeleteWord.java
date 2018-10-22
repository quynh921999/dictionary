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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quynh
 */
public class DeleteWord {
    public void deleteWord(JTable jTable1, String wordFind, DBConnection dbc){
        DefaultTableModel model =  (DefaultTableModel) jTable1.getModel();
        try {
            PreparedStatement ps = dbc.conn.prepareStatement("delete from tbl_edict where word = ?");
            ps.setString(1, wordFind);
            int rs = ps.executeUpdate();
            if(rs != 0)
                JOptionPane.showMessageDialog(null,"Xoa tu thanh cong");
            else 
                JOptionPane.showMessageDialog(null, "Chon tu can xoa");
            model.removeRow(jTable1.getSelectedRow());
        } catch (SQLException ex) {
            Logger.getLogger(DeleteWord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
