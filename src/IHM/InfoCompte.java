/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import org.jivesoftware.smack.XMPPException;

import javax.swing.*;
import java.io.IOException;

/**
 *
 * @author valentin
 */
public class InfoCompte extends javax.swing.JFrame {

    private String serveur;
    private int port;
    private Session session;
    /**
     * Creates new form InfoCompte
     */
    public InfoCompte(String serveur, int port, Session session) {
        this.serveur = serveur;
        this.port = port;
        this.session = session;
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

        labelIdCompte = new javax.swing.JLabel();
        textFieldIdCompte = new javax.swing.JTextField();
        labelMDP = new javax.swing.JLabel();
        passwordFieldMDP = new javax.swing.JPasswordField();
        buttonConnection = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        labelIdCompte.setText("Nom du compte :");
        getContentPane().add(labelIdCompte, new java.awt.GridBagConstraints());

        textFieldIdCompte.setText("nom compte");
        textFieldIdCompte.setMinimumSize(new java.awt.Dimension(100, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(textFieldIdCompte, gridBagConstraints);

        labelMDP.setText("Mot de passe :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(labelMDP, gridBagConstraints);

        passwordFieldMDP.setText("password");
        passwordFieldMDP.setMinimumSize(new java.awt.Dimension(100, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        getContentPane().add(passwordFieldMDP, gridBagConstraints);

        buttonConnection.setText("Connection");
        buttonConnection.setMaximumSize(new java.awt.Dimension(100, 25));
        buttonConnection.setMinimumSize(new java.awt.Dimension(100, 25));
        buttonConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        getContentPane().add(buttonConnection, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnectionActionPerformed
        String nom = textFieldIdCompte.getText();
        
        if (session.equals(Session.Gmail)){
            System.out.println(nom.indexOf("@gmail.com"));
            if (!nom.contains("@gmail.com")){
                nom = nom + "@gmail.com";
            }
        }
        
        else if (session.equals(Session.Facebook)){
            if (!nom.contains("@chat.facebook.com")){
                nom = nom + "@chat.facebook.com";
            }
        }
        
        char[] tabMdp = passwordFieldMDP.getPassword();
        String mdp = "";
        for(int i = 0; i< tabMdp.length; i++){
            mdp = mdp + (Character.toString(tabMdp[i]));
        }
        
        Contacts FenetreContact;
        try {
            FenetreContact = new Contacts(nom, mdp, serveur, port, session);
            FenetreContact.setVisible(true);
            this.dispose();
        } catch (XMPPException | IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(this,"Le couple identifiant/mot de passe \n"
                    + "ne correspond à aucun compte.","Erreur identification",
    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_buttonConnectionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConnection;
    private javax.swing.JLabel labelIdCompte;
    private javax.swing.JLabel labelMDP;
    private javax.swing.JPasswordField passwordFieldMDP;
    private javax.swing.JTextField textFieldIdCompte;
    // End of variables declaration//GEN-END:variables
}