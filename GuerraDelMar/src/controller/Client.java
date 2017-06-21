package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Player;
import util.IConstants;

/**
 *
 * @author Nelson
 */
public class Client extends Thread implements IConstants {

    private int port;
    private String ipServer;
    private String instruction;
    private String parameter;
    private String status;
    private ObjectOutputStream enviar;
    private ObjectInputStream recibir;
    private String serverResponse;
    private String[] userList;
    private Player player;
    
    public Client(int pPort, String pIpServer) {
        super("Cliente guerra del mar");
        this.port = pPort;
        this.ipServer = pIpServer;
        this.instruction = "";
        this.parameter = "";
        this.status = "";
        this.userList = new String[100];
    }

    public Client(int pPort, String pIpServer, String pInstruction, String pUserName) {
        super("Cliente guerra del mar");
        this.port = pPort;
        this.ipServer = pIpServer;
        this.instruction = pInstruction;
        this.parameter = pUserName;
        this.status = "";
    }

    public Client(int pPort, String pIpServer, String pInstruction, Player pPlayer) {
        super("Cliente guerra del mar");
        this.port = pPort;
        this.ipServer = pIpServer;
        this.instruction = pInstruction;
        this.status = "";
        this.player = pPlayer;
    }

    @Override
    public void run() {
        try {
            InetAddress direccionIP = InetAddress.getByName(ipServer);
            Socket socket = new Socket(direccionIP, this.port);
            enviar = new ObjectOutputStream(socket.getOutputStream());
            recibir = new ObjectInputStream(socket.getInputStream());
            System.out.println("El servidor me envía: " + recibir.readUnshared());
            serverResponse = recibir.readUnshared().toString();

            if (serverResponse.equals("listo")) {
                if (instruction.equals(VALIDATE_USER)) {
                    enviar.writeUnshared(instruction);
                    enviar.writeUnshared(parameter);
                    status = recibir.readUnshared().toString();
                } else if (instruction.equals(GET_USERS)) {
                    enviar.writeUnshared(instruction);
                    String list = recibir.readUnshared().toString();
                    userList = list.split("#");

                    status = recibir.readUnshared().toString();
                } else if (instruction.equals(SEND_MESSAGE)) {
                    enviar.writeUnshared(instruction);
                    enviar.writeUnshared(parameter);
                    userList = recibir.readUnshared().toString().split("#");
                    String temporalConversation = "";
                    for (int i = 0; i < userList.length; i++) {
                        temporalConversation += userList[i] + "\n";
                    }
                    status = temporalConversation;
                } else if (instruction.equals(UPDATE_CONVERSATION)) {                    
                    status = updateConversation();
                } else if (instruction.equals(USER_OFF)) {
                    enviar.writeUnshared(instruction);
                    enviar.writeUnshared(parameter);

                    status = recibir.readUnshared().toString();
                    System.out.println(status);
                } else if(instruction.equals(CHANGE_READY)){
                    enviar.writeUnshared(CHANGE_READY);
                    enviar.writeUnshared(player);
                    
                    status = recibir.readUnshared().toString();
                } else {
                    enviar.writeUnshared("");
                }
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getUserList() {
        return userList;
    }

    public void setUserList(String[] userList) {
        this.userList = userList;
    }

    public String updateConversation() throws IOException, ClassNotFoundException {
        enviar.writeUnshared(instruction);

        userList = recibir.readUnshared().toString().split("#");
        String temporalConversation = "";
        for (int i = 0; i < userList.length; i++) {
            temporalConversation += userList[i] + "\n";
        }
        return temporalConversation;
    }
}
