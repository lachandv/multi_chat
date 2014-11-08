/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

/**
 *
 * @author valentin
 */
public class Connection extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Connection() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGoogleTalk = new javax.swing.JButton();
        buttonXMPP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        buttonGoogleTalk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Google-Talk.png"))); // NOI18N
        buttonGoogleTalk.setText("Google talk");
        buttonGoogleTalk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGoogleTalkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(buttonGoogleTalk, gridBagConstraints);

        buttonXMPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/XMPP.png"))); // NOI18N
        buttonXMPP.setText("XMPP Générique");
        buttonXMPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXMPPActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(buttonXMPP, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGoogleTalkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGoogleTalkActionPerformed
        InfoCompte gmail = new InfoCompte("talk.google.com", 5222, Session.Gmail);
        gmail.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonGoogleTalkActionPerformed

    private void buttonXMPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXMPPActionPerformed
       XMPPInfo info = new XMPPInfo();
        info.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonXMPPActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGoogleTalk;
    private javax.swing.JButton buttonXMPP;
    // End of variables declaration//GEN-END:variables
}
