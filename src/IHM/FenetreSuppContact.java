/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;
import sources.JabberSmackAPI;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author valentin
 */
public class FenetreSuppContact extends javax.swing.JFrame {

    private JabberSmackAPI api;
    /**
     * Creates new form FenetreSuppContact
     */
    public FenetreSuppContact(JabberSmackAPI api) throws InterruptedException {
        initComponents();
        this.api = api;
        HashMap<String, String> liste = api.getBuddyList();

        Object[] listeContacts = liste.keySet().toArray();
        
        String[] listeDesContacts = new String[listeContacts.length];
        
        for(int i = 0; i< listeContacts.length; i++){
            listeDesContacts[i] = listeContacts[i].toString();
        }
        
        for (int i = 0; i< listeContacts.length; i++){
        comboBoxListeContact.addItem(listeDesContacts[i]);
        }
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

        comboBoxListeContact = new javax.swing.JComboBox();
        buttonSupprimer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        comboBoxListeContact.setMinimumSize(new java.awt.Dimension(300, 24));
        comboBoxListeContact.setPreferredSize(new java.awt.Dimension(300, 24));
        comboBoxListeContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxListeContactActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxListeContact, new java.awt.GridBagConstraints());

        buttonSupprimer.setText("Supprimer");
        buttonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupprimerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(buttonSupprimer, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupprimerActionPerformed
        try {
            supprimerContact();
            try {
                api.mesContacts.majPresence();
            } catch (InterruptedException ex) {
                Logger.getLogger(FenetreAjoutContact.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        } catch (XMPPException ex) {
            Logger.getLogger(FenetreSuppContact.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonSupprimerActionPerformed

    private void comboBoxListeContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxListeContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxListeContactActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSupprimer;
    private javax.swing.JComboBox comboBoxListeContact;
    // End of variables declaration//GEN-END:variables

    private void supprimerContact() throws XMPPException{
      
        String id = (String) comboBoxListeContact.getSelectedItem();
            
        Presence presence = new Presence(Presence.Type.unsubscribe);
        presence.setTo(id);

        try {
            api.roster.removeEntry(api.roster.getEntry(id));
        } catch (XMPPException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    }