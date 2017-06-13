package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import util.IConstants;

/**
 *
 * @author Nelson
 */
public class Client extends Thread implements IConstants{
    public int port;
    public String ipServer;
    public String instruction;
    public String parameter;
    public String status;
    private PrintStream enviar;
    private BufferedReader recibir;
    private String serverResponse;
    private String[] userList;
    
    public Client (int pPort, String pIpServer){
        super("Cliente guerra del mar");
        this.port = pPort;
        this.ipServer = pIpServer;
        this.instruction = "";
        this.parameter = "";
        this.status = "";        
        this.userList = new String[100];
    }
    
    public Client (int pPort, String pIpServer, String pInstruction, String pUserName){
        super("Cliente guerra del mar");
        this.port = pPort;
        this.ipServer = pIpServer;
        this.instruction = pInstruction;
        this.parameter = pUserName;
        this.status = "";
    }
    
    @Override
    public void run(){        
        try {
            InetAddress direccionIP = InetAddress.getByName(ipServer);
            Socket socket = new Socket(direccionIP, this.port);
            enviar = new PrintStream(socket.getOutputStream());
            recibir = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("El servidor me envía: " + recibir.readLine());
            serverResponse = recibir.readLine();
            
            if(serverResponse.equals("listo")){
                if(instruction.equals(VALIDATE_USER)){
                    enviar.println(instruction);
                    enviar.println(parameter);
                    status = recibir.readLine();
                }else if(instruction.equals(GET_USERS)){
                    enviar.println(instruction);
                    String list = recibir.readLine();
                    userList = list.split("#");
                    
                    status = recibir.readLine();
                }else if(instruction.equals(SEND_MESSAGE)) {
                    enviar.println(instruction);
                    enviar.println(parameter);      
                    userList = recibir.readLine().split("#");
                    String temporalConversation = "";
                    for (int i = 0; i < userList.length; i++) {
                        temporalConversation += userList[i] + "\n";
                    }
                    status = temporalConversation;
                    System.out.println(status);
                }else if(instruction.equals(UPDATE_CONVERSATION)) {
                    enviar.println(instruction);
   
                    userList = recibir.readLine().split("#");
                    String temporalConversation = "";
                    for (int i = 0; i < userList.length; i++) {
                        temporalConversation += userList[i] + "\n";
                    }
                    status = temporalConversation;
                }else {
                    enviar.println();                   
                }
            }            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
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
}
