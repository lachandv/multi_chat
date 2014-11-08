package sources;

import IHM.Contacts;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterListener;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.filetransfer.FileTransferManager;
import org.jivesoftware.smackx.filetransfer.FileTransferNegotiator;
import org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer;
 
public class JabberSmackAPI implements MessageListener {
    
    private String username;
    private String password;
    private String host;
    private int port;
    public Contacts mesContacts;
    public Roster roster;
 
    public static XMPPConnection connection;

    public JabberSmackAPI(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }
    
    public void setContact(Contacts c){
        this.mesContacts = c;
    }
 
    public void login(String userName, String password, String host, int port) throws XMPPException
    {

    ConnectionConfiguration config = new ConnectionConfiguration(host,port,"work");
    connection = new XMPPConnection(config);
    SASLAuthentication.supportSASLMechanism("PLAIN", 0);
 
    connection.connect();
    connection.login(userName, password, host);
    }
    
    public void sendMessage(String message, String to) throws XMPPException
    {
    Chat chat = connection.getChatManager().createChat(to, this);
    chat.sendMessage(message);
    }
 
    public HashMap<String, String> getBuddyList() throws InterruptedException
    {        
    roster = connection.getRoster();
    HashMap<String, String> resultat = new HashMap<String, String>();
    
    Collection<RosterEntry> entries = roster.getEntries();
 
    for(RosterEntry r:entries)
    {
        if (r.getName() != null){
            if (roster.getPresence(r.getUser()) == null){
            resultat.put(r.getName(), "null");
            }
            else{
                resultat.put(r.getUser(), roster.getPresence(r.getUser()).toString());
            }
        }
    }
    
    return resultat;
    
    }
 
    public void disconnect()
    {
    connection.disconnect();
    }
 
    public void processMessage(Chat chat, Message message)
    {
    if(message.getType() == Message.Type.chat)
        if (message.getBody() != null){
        mesContacts.recoitMessage(chat.getParticipant() , message.getBody());
        }
    }
 
    public void main(String[] args) throws XMPPException, IOException, InterruptedException
    {
    // declare variables
    JabberSmackAPI c = new JabberSmackAPI(username, password, host, port);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
 
    // turn on the enhanced debugger
    //XMPPConnection.DEBUG_ENABLED = true;
    
    c.login(username, password, host, port);
    
    roster = connection.getRoster();
    
    roster.setSubscriptionMode(Roster.SubscriptionMode.accept_all);
    roster.addRosterListener(new RosterListener() {    // Ignored events public void entriesAdded(Collection<String> addresses) {}
    public void entriesDeleted(Collection<String> addresses) {}
    public void entriesUpdated(Collection<String> addresses) {}
    public void presenceChanged(Presence presence) {
        
        System.out.println("Presence changed: " + presence.getFrom() + " " + presence);
        try {
            mesContacts.majPresence();
        } catch (InterruptedException ex) {
            Logger.getLogger(JabberSmackAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        @Override
        public void entriesAdded(Collection<String> clctn) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });
    
     PacketFilter pf = new PacketTypeFilter(Message.class);
     PacketCollector pc = connection.createPacketCollector(pf);
    
    Collection<RosterEntry> entries = roster.getEntries();
    for (RosterEntry entry : entries) {
        System.out.println(entry.getName() + roster.getPresence(entry.getUser()).toString());
    }
 
    System.out.println("-----");
    
    }
    
     public void fileTransfer(String fileName, String destination)
            throws XMPPException {

        // Create the file transfer manager
        // FileTransferManager manager = new FileTransferManager(connection);
        FileTransferNegotiator.setServiceEnabled(connection, true);
        FileTransferManager manager = new FileTransferManager(connection) ;
;
        // Create the outgoing file transfer
        OutgoingFileTransfer transfer = manager.createOutgoingFileTransfer(destination);

        // Send the file
        
        try {
            transfer.sendFile(new File(fileName), "You won't believe this!");
        } catch (Exception e) {
        }
        System.out.println("Status :: " + transfer.getStatus() + " Error :: "
                + transfer.getError() + " Exception :: "
                + transfer.getException());
    }
    
    }

 