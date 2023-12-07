/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appchat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Server {
    private static final int PORT = 9999;
    private List<ClientHandler> clients = new ArrayList<>();
    
    public void startServer(){
        try {
            ServerSocket svSocket = new ServerSocket(PORT);
            System.out.println("Server started with PORT: "+PORT);
            
            while(true){
                Socket clientSocket = svSocket.accept();
                System.out.println("1 ng connected: "+clientSocket.getInetAddress().getHostAddress());
                
                ClientHandler clientHandler = new ClientHandler(clientSocket, System.currentTimeMillis()+"", this);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (Exception e) {
        }
    }
    
    public void broadcastMessage(String userName, String mess){
        for(ClientHandler client : clients){
            if(!client.getUserName().equals(userName))
                client.sendMess(mess);
        }
    }
    
    public static void main(String[] args) {
        Server sv = new Server();
        sv.startServer();
    }
}
