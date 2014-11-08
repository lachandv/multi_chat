/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import IHM.Connection;
import javax.swing.UIManager;

/**
 *
 * @author valentin
 */
public class Main {
    
    public static void main(String[] args) {
                    try {
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}                 
    Connection FenetreConnect = new Connection();
    FenetreConnect.setVisible(true);
                        
    }
    
}
